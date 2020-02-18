package me.yu.dao;

import me.yu.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    @Results(id = "roleMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "rname",column = "rname"),
            @Result(property = "users",column = "id",many = @Many(select = "me.yu.dao.UserMapper.findUserByRid",fetchType = FetchType.LAZY))
    })
    @Select("select * from roles where id=#{rid}")
    Role findByRid(Integer rid);

    @Select("select * from roles r,users_roles ur where ur.uid=#{uid} and r.id=ur.rid")
    List<Role> findByUid(Integer uid);
    /*给用户中间表添加角色*/
    /*添加角色*/
    /*修改角色名*/
    /*删除角色*/
}
