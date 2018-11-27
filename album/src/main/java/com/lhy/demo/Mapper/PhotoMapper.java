package com.lhy.demo.Mapper;

import com.lhy.demo.Entity.Photo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by pc on 2018/9/5.
 */
@Mapper
public interface PhotoMapper {

    @Select("select photo_name from photo where photo_category_id = #{category} and photo_user_id = #{user} order by upload_time DESC")
    public List<String> findNameByCategoryAndUser(@Param("category") Integer category,@Param("user") Integer user);

    @Insert("insert into photo values(null,#{photo_name}, #{photo_user_id}, #{photo_category_id}, #{upload_time})")
    public Integer addPhoto(Photo photo);

    @Update("update photo set photo_category_id = #{id}, upload_time = #{time} where photo_name = #{name}")
    public Integer move(@Param("name") String name, @Param("time") String time, @Param("id") Integer id);

    @Delete("delete from photo where photo_name = #{name}")
    public Integer delete(@Param("name") String name);

    @Delete("delete from photo where photo_category_id = #{id1} and photo_user_id = #{id2}")
    public Integer delete1(@Param("id1") Integer id1, @Param("id2") Integer id2);
}
