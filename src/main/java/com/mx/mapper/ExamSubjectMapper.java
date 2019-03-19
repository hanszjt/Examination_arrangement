package com.mx.mapper;

import com.mx.bean.Examsubject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mx on 2019/2/28.
 */
public interface ExamSubjectMapper {
    /**
     * 增加科目
     * @param examsubject
     * @return
     */

    int addExamsubject(Examsubject examsubject);

    /**
     * 删除科目
     * @param id
     * @return
     */
    int deleteExamsubject(int id);

    /**
     * 修改科目
     * @param examsubject
     * @return
     */
    int updateExamsubject(Examsubject examsubject);

    /**
     * 查询所有科目
     * @return
     */
    List<Examsubject> findAllExamsubject();


    /**
     * 根据id查询科目
     * @return
     */
    Examsubject querryExamsubjectById(int id);

    /**
     * 批量删除科目
     * @param ids
     * @return
     */
    int deleteExamsubjectByIds(List<Integer> ids);

    /**
     * 查询科目数量
     * @return
     */
    @Select("select count(*) from Exam_subject")
    int selectExamsubjectCount();

    /**
     * 根据姓名搜索科目
     * @param subjectname
     * @return
     */
    List<Examsubject> selectExamsubjectByName(String subjectname);
}
