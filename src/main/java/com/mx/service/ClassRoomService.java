package com.mx.service;

import com.github.pagehelper.PageInfo;
import com.mx.bean.ClassRoom;

import java.util.List;

/**
 * Created by mx on 2019/3/6.
 */
public interface ClassRoomService {

    int addClassRoom(ClassRoom classRoom);

    int removeClassRoom(int id);

    int updateClassRoom(ClassRoom classRoom);

    PageInfo<ClassRoom> selectClassRoom(int pageNo , int pageSize);

    ClassRoom selectClassRoomById(int id);

    int deleteClassRoomByIds(List<Integer> ids);

    int selectClassRoomCount();

    PageInfo<ClassRoom> selectClassRoomByName(int pageNo,int pageSize,String classname);
}
