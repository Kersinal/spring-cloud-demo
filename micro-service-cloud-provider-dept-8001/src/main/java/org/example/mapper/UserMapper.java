package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.entity.User;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    public List<User> getAll();

    @Select("select * from user where username = #{username}")
    public User selectByUsername(String username);

    @Update("update user set username = #{username},password = #{password} where username = #{username}")
    public void updateUser(User user);

    @Insert("insert user (username,password) value (#{username},#{password}")
    public int insertUser(User user);

    @Delete("delete from user where username = #{username}")
    public void deleteUser(String username);
}
