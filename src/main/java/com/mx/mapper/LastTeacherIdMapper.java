package com.mx.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by mx on 2019/3/5.
 */
public interface LastTeacherIdMapper {

    @Select("select lastid from last_teacher")
    int selectLastId();

    @Update("update last_teacher set lastid = #{lastid}")
    int updateLastId(int lastid);

}
