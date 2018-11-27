package com.lhy.demo.Mapper;

import com.lhy.demo.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by pc on 2018/9/5.
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where user_name = #{name} and user_password = #{password}")
    public User findUserByNameAndPassword(@Param("name") String name,@Param("password") String password);

    @Insert("insert into user values(null,#{user_name},#{user_password})")
    public Integer addUser(User user);

    @Select("select user_id from user where user_name = #{name}")
    public Integer findUserId(@Param("name") String name);
}
