package com.lhy.demo.Entity;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by pc on 2018/9/5.
 */
public class Photo {

    private Integer photo_id;

    private String photo_name;

    private Integer photo_user_id;

    private Integer photo_category_id;

    private String upload_time;

    public Integer getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(Integer photo_id) {
        this.photo_id = photo_id;
    }

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name;
    }

    public Integer getPhoto_user_id() {
        return photo_user_id;
    }

    public void setPhoto_user_id(Integer photo_user_id) {
        this.photo_user_id = photo_user_id;
    }

    public Integer getPhoto_category_id() {
        return photo_category_id;
    }

    public void setPhoto_category_id(Integer photo_category_id) {
        this.photo_category_id = photo_category_id;
    }

    public String getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(String upload_time) {
        this.upload_time = upload_time;
    }
}
