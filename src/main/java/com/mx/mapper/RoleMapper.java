package com.mx.mapper;

import com.mx.bean.Role;
import org.apache.ibatis.annotations.Select;

/**
 * Created by mx on 2019/2/21.
 */
public interface RoleMapper {

    @Select("select * from role")
    Role querryAllRole();

}
