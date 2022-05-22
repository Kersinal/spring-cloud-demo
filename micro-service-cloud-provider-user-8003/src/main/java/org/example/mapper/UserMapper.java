package org.example.mapper;

import org.apache.ibatis.annotations.*;
import org.example.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert("insert user(username,password) value(#{username},#{password})")
    public int insertUser(User user);

    @Delete("delete from user where username = #{username}")
    public int deleteByUsername(String username);

    @Update("update user set username = #{username},password = #{password} where username = #{username}")
    public int updateUser(User user);

    @Select("select * from user")
    public List<User> selectAll();

    @Select("select * from user where username = #{username}")
    public User selectByUsername(String username);
}
