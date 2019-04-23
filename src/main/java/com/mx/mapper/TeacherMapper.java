package com.mx.mapper;

import com.mx.bean.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mx on 2019/2/13.
 */
public interface TeacherMapper {

    /**
     * 增加教师
     * @param teacher
     * @return
     */

    int addTeacher(Teacher teacher);

    /**
     * 删除教师
     * @param id
     * @return
     */
    int deleteTeacher(int id);

    /**
     * 修改教师
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 查询所有教师
     * @return
     */
    List<Teacher> findAllTeacher();


    /**
     * 根据id查询教师
     * @return
     */
    Teacher querryTeacherById(int id);



    Teacher querryTeacherByTid(String tid);

    /**
     * 批量删除教师
     * @param ids
     * @return
     */
    int deleteTeacherByIds(List<Integer> ids);

    /**
     * 查询教师数量
     * @return
     */
    @Select("select count(*) from teacher_info")
    int selectTeacherCount();

    /**
     * 根据姓名搜索教师
     * @param tname
     * @return
     */
    List<Teacher> selectTeacherByName(String tname);

    @Select("select max(id) from teacher_info")
    int selectTeacherMaxId();
}
