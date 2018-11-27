package com.lhy.demo.Mapper;

import com.lhy.demo.Entity.Category;
import org.apache.ibatis.annotations.*;
import org.omg.CORBA.INTERNAL;

import java.util.List;


/**
 * Created by
 * pc on 2018/9/5.
 */
@Mapper
public interface CategoryMapper {

    @Select("select category_id from category where category_name = #{name} and user_id = #{id}")
    public Integer findCategoryIdByNameAndId(@Param("name") String name,@Param("id") Integer id);

    @Select("select category_id from category where user_id = #{user_id}")
    public List<Integer> findCategoryIdByUserId(@Param("user_id") Integer user_id);

    @Insert("insert into category values(null,#{category_name},#{user_id},#{photo_count})")
    public Integer addCategory(Category category);

    @Select("select * from category where user_id = #{user_id}")
    public List<Category> findCategoryByUserId(@Param("user_id") Integer user_id);

    @Select("select category_name from category where user_id = #{user_id}")
    public List<String> findCategoryNameByUserId(@Param("user_id") Integer user_id);

    @Update("update category set photo_count = photo_count + #{count} where category_name = #{name} and user_id = #{id}")
    public Integer updateCountByNameAndUser(@Param("count") Integer count, @Param("name") String name, @Param("id") Integer id);

    @Update("update category set photo_count = photo_count + #{count} where category_id = #{id}")
    public Integer updateCountByCategoryId(@Param("count") Integer count, @Param("id") Integer id);

    @Delete("delete from category where category_name = #{name} and user_id = #{id}")
    public Integer delete(@Param("name") String name, @Param("id") Integer id);

    @Update("update category set category_name = #{name} where category_name = #{oldname} and user_id = #{id}")
    public Integer updateName(@Param("name") String name, @Param("oldname") String oldname, @Param("id") Integer id);
}
