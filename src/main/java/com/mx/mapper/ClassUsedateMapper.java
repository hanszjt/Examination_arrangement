package com.mx.mapper;

import com.mx.bean.ClassUsedate;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mx on 2019/3/4.
 */
public interface ClassUsedateMapper {
    /**
     * 增加使用时间
     * @param classUsedate
     * @return
     */

    int addClassUsedate(ClassUsedate classUsedate);

    /**
     * 删除使用时间
     * @param id
     * @return
     */
    int deleteClassUsedate(int id);

    /**
     * 修改使用时间
     * @param classUsedate
     * @return
     */
    int updateClassUsedate(ClassUsedate classUsedate);

    /**
     * 查询所有使用时间
     * @return
     */
    List<ClassUsedate> findAllClassUsedate();


    /**
     * 根据id查询使用时间
     * @return
     */
    ClassUsedate querryClassUsedateById(int id);

    /**
     * 批量删除使用时间
     * @param ids
     * @return
     */
    int deleteClassUsedateByIds(List<Integer> ids);

    /**
     * 查询使用时间数量
     * @return
     */
    @Select("select count(*) from classroom_info")
    int selectClassUsedateCount();

    /**
     * 根据时间搜索班级
     * @param time
     * @return
     */
    List<ClassUsedate> selectClassUsedateByName(String time);
}
