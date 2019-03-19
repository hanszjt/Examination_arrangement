package com.mx.service.impl;

import com.mx.bean.ArrangementExam;
import com.mx.bean.ClassRoom;
import com.mx.bean.ClassUsedate;
import com.mx.bean.StudentClass;
import com.mx.mapper.*;
import com.mx.service.ArrangementExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mx on 2019/3/4.
 */
@Service
public class ArrangementExamServiceImpl implements ArrangementExamService {
    @Autowired
    ClassUsedateMapper classUsedateMapper;
    @Autowired
    ClassRoomMapper classRoomMapper;
    @Autowired
    StudentClassMapper studentClassMapper;
    @Autowired
    LastTeacherIdMapper lastTeacherIdMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Map<String,Object> addExam(ArrangementExam arrangementExam) throws ParseException {
        String starttime = arrangementExam.getStart();
        String endtime = arrangementExam.getEnd();
        List<Integer> finalClassId = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        do {
            finalClassId.clear();
            //获取某一天中已经排考的教室
            List<ClassUsedate> classId = classUsedateMapper.selectClassUsedateByName(starttime);
            List<Integer> idsm = new ArrayList<>();
            List<Integer> idsa = new ArrayList<>();
            for (ClassUsedate ci: classId) {
                if(ci.getUsetime() == 0)
                    idsm.add(ci.getClass_id());
                if(ci.getUsetime() == 1)
                    idsa.add(ci.getClass_id());

            }
            //预设一个总人数的变量
            int examPerson = 0;


            //获取排考班级的id
            List<Integer> studentClassId = arrangementExam.getClassId();
            //获取未排考的教室的id
            List<ClassRoom> classRooms;
            if(idsm.size() == 0){
                classRooms = classRoomMapper.findAllClassRoom();
            }else {
             classRooms = classRoomMapper.selectClassRoomDistIds(idsm);
            }
            //判断如果没有未排考的班级，则当天不能排考，进行日期加一运算
            //有未排考的教室，进行排考操作
            if (classRooms != null){
                //查询需要排考的人数
                for (int i :studentClassId) {
                    StudentClass studentClass = studentClassMapper.querryStudentClassById(i);
                    examPerson += studentClass.getStudentnum();
                }

                int classroomcount;
                //对人数进行排考分析，教室的选择
                //如果教室人数大于当前总人数，证明全部人数已经排完
                int count= 0;
                a:for (ClassRoom cr:classRooms) {
                    count++;
                    //获取当前教室的能排考人数
                    classroomcount = cr.getClassroomcount();
                    //存放教室对应班级的集合
                    List<Integer> classRoomStudentClass = new ArrayList<>();
                    Iterator<Integer> iterator = studentClassId.iterator();
                    //遍历当前需要排考的班级
                    while (iterator.hasNext()){
                        Integer integer = iterator.next();

                        //拿到班级信息
                        StudentClass studentClass = studentClassMapper.querryStudentClassById(integer);
                        //判断当前班级能否放到该教室
                        if (classroomcount - studentClass.getStudentnum() >= 0){
                            //减去放进去的班级人数
                            classroomcount -=studentClass.getStudentnum();
                            //将当前班级存入集合
                            classRoomStudentClass.add(integer);
                            //移除当前教室
                            iterator.remove();
                        }else{
                            if(count == classRooms.size()){
                                starttime = addDay(starttime);
                                break a;
                            }
                            break;
                        }
                    }
                    finalClassId.add(cr.getId());
                    map.put(String.valueOf(cr.getId()),classRoomStudentClass);
                    if (studentClassId.size() == 0){
                        map.put("finalClassId",finalClassId);
                        map.put("date",starttime);
                        ClassUsedate cu = new ClassUsedate();
                        cu.setUsedate(starttime);
                        cu.setUsetime(0);
                        for (int finalclassid :finalClassId) {
                            cu.setClass_id(finalclassid);
                            classUsedateMapper.addClassUsedate(cu);
                        }
                        return map;
                    }


                    /*if (cr.getClassroomcount() - examPerson >= 0) {
                        finalClassId.add(cr.getId());
                        map.put("finalClassId", finalClassId);
                        map.put("date", starttime);
                        return map;
                        //如果不大于当前人数，则将总人数进行递减，然后继续选择教室
                    } else {
                        examPerson = examPerson - cr.getClassroomcount();
                        finalClassId.add(cr.getId());

                    }*/
                }
                //没有未排考的班级，进行日期加一
            }else{
                starttime = addDay(starttime);

            }
        }while(starttime.equals(endtime));

        return null;
    }

    @Override
    public List<Integer> getInvigilator() {
        int lastid = lastTeacherIdMapper.selectLastId();
        int maxId = teacherMapper.selectTeacherMaxId();
        List<Integer> list = new ArrayList<>();
        while (list.size() < 4){
            if(lastid<maxId){
                lastid += 1;
                list.add(teacherMapper.querryTeacherById(lastid).getId());
                if(lastid == maxId)
                    lastid = 0;
            }else if (lastid == maxId){
                lastid = 0;
            }
        }
        lastTeacherIdMapper.updateLastId(list.get(3));
        return list;
    }

    public String addDay(String start) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(start);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR,1);
        return simpleDateFormat.format(calendar.getTime());
    }


}
