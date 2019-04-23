package com.mx.mapper;

import com.mx.bean.Exam;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mx on 2019/3/8.
 */
public interface ExamMapper {

    /**
     * 添加考试信息
     * @param exam
     * @return
     */
    int addExam(Exam exam);

    /**
     * 删除考试
     * @param id
     * @return
     */
    int deleteExam(int id);

    /**
     * 修改考试
     * @param exam
     * @return
     */
    int updateExam(Exam exam);

    /**
     * 查询所有考试
     * @return
     */
    List<Exam> findAllExam();


    /**
     * 根据id查询考试
     * @return
     */
    Exam querryExamById(int id);

    /**
     * 根据date查询考试数量
     * @return
     */
    @Select("select count(*) from exam_info where examtime = #{date}")
    int querryExamByDate(String date);

    /**
     * 批量删除考试
     * @param ids
     * @return
     */
    int deleteExamByIds(List<Integer> ids);

    /**
     * 查询考试数量
     * @return
     */
    @Select("select count(*) from exam_info")
    int selectExamCount();

    /**
     * 根据教师姓名搜索考试
     * @param invigilator
     * @return
     */
    List<Exam> selectExamByName(String invigilator);

}
