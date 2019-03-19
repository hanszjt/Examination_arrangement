package com.mx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mx.bean.ClassRoom;
import com.mx.mapper.ClassRoomMapper;
import com.mx.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mx on 2019/3/6.
 */
@Service
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    ClassRoomMapper classRoomMapper;

    @Override
    public int addClassRoom(ClassRoom classRoom) {
        int i = classRoomMapper.addClassRoom(classRoom);
        return i;
    }

    @Override
    public int removeClassRoom(int id) {
        int i = classRoomMapper.deleteClassRoom(id);
        return i;
    }

    @Override
    public int updateClassRoom(ClassRoom classRoom) {
        int i = classRoomMapper.updateClassRoom(classRoom);
        return i;
    }

    @Override
    public PageInfo<ClassRoom> selectClassRoom(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ClassRoom> allClassRoom = classRoomMapper.findAllClassRoom();
        PageInfo<ClassRoom> pageInfo = new PageInfo<>(allClassRoom);
        return pageInfo;
    }

    @Override
    public ClassRoom selectClassRoomById(int id) {
        ClassRoom classRoom = classRoomMapper.querryClassRoomById(id);
        return classRoom;
    }

    @Override
    public int deleteClassRoomByIds(List<Integer> ids) {
        int i = classRoomMapper.deleteClassRoomByIds(ids);
        return i;
    }

    @Override
    public int selectClassRoomCount() {
        int i = classRoomMapper.selectClassRoomCount();
        return i;
    }

    @Override
    public PageInfo<ClassRoom> selectClassRoomByName(int pageNo, int pageSize, String classname) {
        PageHelper.startPage(pageNo,pageSize);
        List<ClassRoom> classRooms = classRoomMapper.selectClassRoomByName(classname);
        PageInfo<ClassRoom> pageInfo = new PageInfo<>(classRooms);
        return pageInfo;
    }
}
