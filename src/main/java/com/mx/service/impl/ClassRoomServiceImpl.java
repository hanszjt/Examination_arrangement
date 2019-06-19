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

    /**
     * 添加教室
     * @param classRoom
     * @return
     */
    @Override
    public int addClassRoom(ClassRoom classRoom) {
        int i = classRoomMapper.addClassRoom(classRoom);
        return i;
    }

    /**
     * 删除教室
     * @param id
     * @return
     */
    @Override
    public int removeClassRoom(int id) {
        int i = classRoomMapper.deleteClassRoom(id);
        return i;
    }

    /**
     * 修改教室信息
     * @param classRoom
     * @return
     */
    @Override
    public int updateClassRoom(ClassRoom classRoom) {
        int i = classRoomMapper.updateClassRoom(classRoom);
        return i;
    }

    /**
     * 查询教室
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<ClassRoom> selectClassRoom(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        List<ClassRoom> allClassRoom = classRoomMapper.findAllClassRoom();
        PageInfo<ClassRoom> pageInfo = new PageInfo<>(allClassRoom);
        return pageInfo;
    }

    /**
     * 通过id查询教室信息
     * @param id
     * @return
     */
    @Override
    public ClassRoom selectClassRoomById(int id) {
        ClassRoom classRoom = classRoomMapper.querryClassRoomById(id);
        return classRoom;
    }

    /**
     * 通过id来批量删除教室信息
     * @param ids
     * @return
     */
    @Override
    public int deleteClassRoomByIds(List<Integer> ids) {
        int i = classRoomMapper.deleteClassRoomByIds(ids);
        return i;
    }

    /**
     * 查询教室中的数量
     * @return
     */
    @Override
    public int selectClassRoomCount() {
        int i = classRoomMapper.selectClassRoomCount();
        return i;
    }

    /**
     * 通过班级名字来查询教室信息
     * @param pageNo
     * @param pageSize
     * @param classname
     * @return
     */
    @Override
    public PageInfo<ClassRoom> selectClassRoomByName(int pageNo, int pageSize, String classname) {
        PageHelper.startPage(pageNo,pageSize);
        List<ClassRoom> classRooms = classRoomMapper.selectClassRoomByName(classname);
        PageInfo<ClassRoom> pageInfo = new PageInfo<>(classRooms);
        return pageInfo;
    }
}
