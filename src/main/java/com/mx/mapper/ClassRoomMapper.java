package com.mx.mapper;

import com.mx.bean.ClassRoom;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by mx on 2019/3/4.
 */
public interface ClassRoomMapper {
    /**
     * 增加教室
     * @param classRoom
     * @return
     */

    int addClassRoom(ClassRoom classRoom);

    /**
     * 删除教室
     * @param id
     * @return
     */
    int deleteClassRoom(int id);

    /**
     * 修改教室
     * @param classRoom
     * @return
     */
    int updateClassRoom(ClassRoom classRoom);

    /**
     * 查询所有教室
     * @return
     */
    List<ClassRoom> findAllClassRoom();


    /**
     * 根据id查询教室
     * @return
     */
    ClassRoom querryClassRoomById(int id);

    /**
     * 批量删除教室
     * @param ids
     * @return
     */
    int deleteClassRoomByIds(List<Integer> ids);

    /**
     * 查询教室数量
     * @return
     */
    @Select("select count(*) from classroom_info")
    int selectClassRoomCount();

    /**
     * 根据姓名搜索教室
     * @param classname
     * @return
     */
    List<ClassRoom> selectClassRoomByName(String classname);

    List<ClassRoom> selectClassRoomDistIds(List<Integer> ids);
}
