package com.mx.controller;

import com.github.pagehelper.PageInfo;
import com.mx.bean.*;
import com.mx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public String getArrangementExam(ArrangementExam arrangementExam ,
                                     Model model) throws ParseException {
        //拿到排考的教室
        Map<String, Object> map = arrangementExamService.addExam(arrangementExam);
        if (map != null){
            //有空余教室
            Exam exam = new Exam();
            String date = (String) map.get("date");
            List<Integer> finalClassId = (List<Integer>) map.get("finalClassId");
            for (int finalclassid :finalClassId) {
                List<Integer> invigilator = arrangementExamService.getInvigilator();
                System.out.println("监考教师");
                StringBuffer sb = new StringBuffer();
                for (int i:invigilator) {
                    sb.append(teacherService.selectTeacherById(i).getTname()+",");
                }
                String s = sb.toString();
                String[] split = s.split(",");
                for (String a :split
                     ) {
                    System.out.println(a);
                }

                System.out.println("考试日期："+date);
                System.out.println("考试所在教室: ");
                    System.out.print("教" + classRoomService.selectClassRoomById(finalclassid).getTeacherbuilding()+classRoomService.selectClassRoomById(finalclassid).getClassroomnum() + "    ");
                System.out.println("当前教室所坐班级：");
                for (int i :(List<Integer>)map.get(String.valueOf(finalclassid))) {
                    System.out.print(studentClassService.selectStudentClassById(i) + "    ");
                }
                System.out.println("------------------分割线--------------------");
            }



        }else{
            //没有空余教室
        }


        return "arrangementExam/arrangementExam";
    }
}
