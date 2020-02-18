package me.yu.dao;

import me.yu.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Results(id = "userMap",value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "profile",column = "profile"),
            @Result(property = "photo",column = "photo"),
            @Result(property = "save",column = "save"),
            @Result(property = "roles",column = "id",many = @Many(select = "me.yu.dao.RoleMapper.findByUid",fetchType = FetchType.LAZY)),
            @Result(property = "transfers",column = "id",many = @Many(select = "me.yu.dao.TransferMapper.findByUid",fetchType = FetchType.LAZY))
    })
    @Select("select * from users where id=#{id}")
    User findUserAllByUid(Integer uid);
    @Select("select * from users u,users_roles ur where ur.rid=#{rid} and u.id=ur.uid")
    List<User> findUserByRid(Integer rid);
    @Select("select * from users")
    List<User> findAllUsers();
    @Update("update users set username=#{username},password=#{password},profile=#{profile},photo=#{photo},save=#{save} where id=#{id}")
    void updateUser(User user);
    @Insert("insert into users (id,username,password,profile,photo,save) values (#{id},#{username},#{password},#{profile},#{photo},#{save})")
    void insertUser(User user);
    @Delete("delete from users where id=#{uid}")
    void deleteUser(Integer uid);
    @Update("update users set save=save+#{param2} where id=#{param1}")
    void updateSave(Integer uid,Double save);
}
