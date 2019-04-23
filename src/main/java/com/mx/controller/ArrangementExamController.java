package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.*;
import com.mx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

/**
 * Created by mx on 2019/3/1.
 */
@Controller
public class ArrangementExamController {

    @Autowired
    StudentClassService studentClassService;
    @Autowired
    ExamSubjectService examSubjectService;
    @Autowired
    ArrangementExamService arrangementExamService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassRoomService classRoomService;
    @Autowired
    ExamService examService;

    @GetMapping("/arrangementExam")
    public String toArrangementExam(Model model){
        PageInfo<StudentClass> pageInfo = studentClassService.selectStudentClass(1, studentClassService.selectStudentClassCount());
        List<StudentClass> list = pageInfo.getList();
        model.addAttribute("studentclass",list);
        PageInfo<Examsubject> pageInfo1 = examSubjectService.selectExamsubject(1, examSubjectService.selectExamsubjectCount());
        model.addAttribute("examsubject",pageInfo1.getList());
        return "arrangementExam/arrangementExam";
    }

    @ResponseBody
    @PostMapping("/arrangementExam")
    public Map<String , Object> getArrangementExam(ArrangementExam arrangementExam ,
                                     Model model) throws ParseException {
        Map<String,Object> data = new HashMap<>();
        List<Exam> datalist = new ArrayList<>();
        //拿到排考的教室
        Map<String, Object> map = arrangementExamService.addExam(arrangementExam);

        if (map != null){
            //有空余教室

            String date = (String) map.get("date");
            List<Integer> finalClassId = (List<Integer>) map.get("finalClassId");
            for (int finalclassid :finalClassId) {
                Exam exam = new Exam();
                List<Integer> invigilator = arrangementExamService.getInvigilator();
                System.out.println("监考教师");
                StringBuffer sb = new StringBuffer();
                for (int i = 0;i<invigilator.size();i++){
                    if (i == (invigilator.size()-1)){
                        sb.append(teacherService.selectTeacherById(invigilator.get(i)).getTname());
                    }else {
                        sb.append(teacherService.selectTeacherById(invigilator.get(i)).getTname()+",");
                    }
                }
                String s = sb.toString();
                String[] split = s.split(",");
                for (String a :split
                     ) {
                    System.out.println(a);
                }
                exam.setInvigilator(s);
                exam.setExamtime(date);
                exam.setClassroom("教" + classRoomService.selectClassRoomById(finalclassid).getTeachbuilding()+classRoomService.selectClassRoomById(finalclassid).getClassroomnum());
                System.out.println("考试日期："+date);
                System.out.println("考试所在教室: ");
                    System.out.print("教" + classRoomService.selectClassRoomById(finalclassid).getTeachbuilding()+classRoomService.selectClassRoomById(finalclassid).getClassroomnum() + "    ");
                System.out.println("当前教室所坐班级：");
                exam.setExamsubject(examSubjectService.selectExamsubjectById(arrangementExam.getSubjectId().get(0)).getSubjectname());
                List<Integer> list = (List<Integer>) map.get(String.valueOf(finalclassid));
                StringBuffer ss = new StringBuffer();
                for (int i = 0;i<list.size();i++){
                    if (i == (list.size()-1)){
                        ss.append(studentClassService.selectStudentClassById(list.get(i)).getClassname());
                    }else {
                        ss.append(studentClassService.selectStudentClassById(list.get(i)).getClassname() + ",");
                    }
                }
                exam.setExamclass(ss.toString());
                for (int i :(List<Integer>)map.get(String.valueOf(finalclassid))) {
                    System.out.print(studentClassService.selectStudentClassById(i) + "    ");
                }
                System.out.println("------------------分割线--------------------");
                System.out.println(exam);
                datalist.add(exam);
                examService.addExam(exam);
            }
        }else{
            //没有空余教室
            data.put("code",100);
            data.put("msg","没有空余教室");
            return data;
        }
        data.put("code",200);
        data.put("total",datalist.size());
        data.put("data",datalist);

        System.out.println(data.values());

        return data;
    }


}
