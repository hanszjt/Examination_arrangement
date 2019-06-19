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

    /**
     * 进入自动排考页面查询班级列表和考试科目列表并返回页面
     * @param model
     * @return
     */
    @GetMapping("/arrangementExam")
    public String toArrangementExam(Model model){
        PageInfo<StudentClass> pageInfo = studentClassService.selectStudentClass(1, studentClassService.selectStudentClassCount());
        List<StudentClass> list = pageInfo.getList();
        model.addAttribute("studentclass",list);
        PageInfo<Examsubject> pageInfo1 = examSubjectService.selectExamsubject(1, examSubjectService.selectExamsubjectCount());
        model.addAttribute("examsubject",pageInfo1.getList());
        return "arrangementExam/arrangementExam";
    }

    /**
     * 自动排考逻辑
     * @param arrangementExam
     * @param model
     * @return
     * @throws ParseException
     */
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
            //将空教室拿出来
            List<Integer> finalClassId = (List<Integer>) map.get("finalClassId");
            //遍历空教室
            for (int finalclassid :finalClassId) {
                Exam exam = new Exam();
                //每个考场4个监考，将监考教师返回
                List<Integer> invigilator = arrangementExamService.getInvigilator();
                System.out.println("监考教师");
                //将监考教师姓名拼成字符串，准备存入数据库
                StringBuffer sb = new StringBuffer();
                for (int i = 0;i<invigilator.size();i++){
                    //判断是否为最后一个，为最后一个就不拼接逗号，不是最后一个就拼接一个逗号。
                    if (i == (invigilator.size()-1)){
                        sb.append(teacherService.selectTeacherById(invigilator.get(i)).getTname());
                    }else {
                        sb.append(teacherService.selectTeacherById(invigilator.get(i)).getTname()+",");
                    }
                }
                String s = sb.toString();
                //测试打印监考教师信息
                String[] split = s.split(",");
                for (String a :split
                     ) {
                    System.out.println(a);
                }
                //将监考教师存入实体exam中
                exam.setInvigilator(s);
                //将考试时间存入实体exam中
                exam.setExamtime(date);
                //将考试教师信息拼成字符串存入实体exam中
                exam.setClassroom("教" + classRoomService.selectClassRoomById(finalclassid).getTeachbuilding()+classRoomService.selectClassRoomById(finalclassid).getClassroomnum());
                //测试打印
                System.out.println("考试日期："+date);
                System.out.println("考试所在教室: ");
                System.out.print("教" + classRoomService.selectClassRoomById(finalclassid).getTeachbuilding()+classRoomService.selectClassRoomById(finalclassid).getClassroomnum() + "    ");
                System.out.println("当前教室所坐班级：");
                //将考试科目名称存入exam实体中
                exam.setExamsubject(examSubjectService.selectExamsubjectById(arrangementExam.getSubjectId().get(0)).getSubjectname());
                //拿到该教室中的班级id
                List<Integer> list = (List<Integer>) map.get(String.valueOf(finalclassid));
                //将班级名称进行拼串处理
                StringBuffer ss = new StringBuffer();
                for (int i = 0;i<list.size();i++){
                    //判断是否为最后一个班级，是就不拼接逗号不是就拼接一个逗号。
                    if (i == (list.size()-1)){
                        ss.append(studentClassService.selectStudentClassById(list.get(i)).getClassname());
                    }else {
                        ss.append(studentClassService.selectStudentClassById(list.get(i)).getClassname() + ",");
                    }
                }
                //将拼接好的班级字符串存入实体exam中
                exam.setExamclass(ss.toString());
                //测试打印
                for (int i :(List<Integer>)map.get(String.valueOf(finalclassid))) {
                    System.out.print(studentClassService.selectStudentClassById(i) + "    ");
                }
                System.out.println("------------------分割线--------------------");
                System.out.println(exam);
                datalist.add(exam);
                //将exam实体存入数据库中
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
