package com.mx.mapper;

import com.mx.bean.StudentClass;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mx on 2019/2/28.
 */
public interface StudentClassMapper {
    /**
     * 增加科目
     * @param studentClass
     * @return
     */

    int addStudentClass(StudentClass studentClass);

    /**
     * 删除科目
     * @param id
     * @return
     */
    int deleteStudentClass(int id);

    /**
     * 修改科目
     * @param studentClass
     * @return
     */
    int updateStudentClass(StudentClass studentClass);

    /**
     * 查询所有科目
     * @return
     */
    List<StudentClass> findAllStudentClass();


    /**
     * 根据id查询科目
     * @return
     */
    StudentClass querryStudentClassById(int id);

    /**
     * 批量删除科目
     * @param ids
     * @return
     */
    int deleteStudentClassByIds(List<Integer> ids);

    /**
     * 查询科目数量
     * @return
     */
    @Select("select count(*) from studentclass_info")
    int selectStudentClassCount();

    /**
     * 根据姓名搜索科目
     * @param classname
     * @return
     */
    List<StudentClass> selectStudentClassByName(String classname);
}
