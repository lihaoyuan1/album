package com.lhy.demo.Service;

import com.lhy.demo.Entity.Category;
import com.lhy.demo.Entity.Photo;
import com.lhy.demo.Mapper.CategoryMapper;
import com.lhy.demo.Mapper.PhotoMapper;
import com.lhy.demo.Mapper.UserMapper;
import com.sun.javafx.geom.AreaOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by pc on 2018/9/5.
 */
@Service
public class HomeService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private PhotoMapper photoMapper;

    public List<Integer> getCategoryIdByUserId(Integer user_id){
        return categoryMapper.findCategoryIdByUserId(user_id);
    }

    public List<Category> getCategoryByUserId(Integer user_id){
        return categoryMapper.findCategoryByUserId(user_id);
    }

    public List<String> getCategoryNameByUserId(Integer user_id){
        return categoryMapper.findCategoryNameByUserId(user_id);
    }

    public List<List<String>> findAllPhotosByUserId(Integer user_id){
        List<List<String>> photosList = new ArrayList<List<String>>();
        List<Integer> categoryList = getCategoryIdByUserId(user_id);
        for (int i=0; i<categoryList.size(); i++){
            List<String> photos = photoMapper.findNameByCategoryAndUser(categoryList.get(i), user_id);
            if (photos.size() != 0)
                photosList.add(photos);
        }
        return photosList;
    }

    public void upLoad(Integer user_id, MultipartFile[] files, String filePath, String category) throws IOException {
        File targetFile = new File(filePath);
        if(!targetFile.exists())
            targetFile.mkdirs();
        for (int i=0; i<files.length; i++){
            UUID uuid = UUID.randomUUID();
            String str = uuid.toString();
            String fileName = str + ".jpg";
            FileOutputStream out = new FileOutputStream(filePath + fileName);
            out.write(files[i].getBytes());
            out.flush();
            out.close();

            Integer category_id = categoryMapper.findCategoryIdByNameAndId(category, user_id);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = df.format(new Date());

            Photo photo = new Photo();

            photo.setPhoto_id(null);
            photo.setPhoto_name(str);
            photo.setPhoto_user_id(user_id);
            photo.setPhoto_category_id(category_id);
            photo.setUpload_time(date);

            categoryMapper.updateCountByCategoryId(1, category_id);
            photoMapper.addPhoto(photo);
        }
    }

    public boolean newAlbum(String album, Integer user_id){
        Category category = new Category();
        category.setCategory_id(null);
        category.setCategory_name(album);
        category.setUser_id(user_id);
        category.setPhoto_count(0);
        if (categoryMapper.addCategory(category) > 0)
            return true;
        return false;
    }

    public List<String> getAlbum(String category, Integer user_id){
        Integer categoryId = categoryMapper.findCategoryIdByNameAndId(category, user_id);
        List<String> photo = photoMapper.findNameByCategoryAndUser(categoryId, user_id);
        return photo;
    }

    public boolean move(String photo_name, String album_name, String oldAlbum, Integer user_id){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        Integer category_id = categoryMapper.findCategoryIdByNameAndId(album_name, 1);
        categoryMapper.updateCountByNameAndUser(-1, oldAlbum, user_id);
        categoryMapper.updateCountByNameAndUser(1, album_name, user_id);
        if (photoMapper.move(photo_name, date, category_id) > 0)
            return true;
        return false;
    }

    public boolean delete(String photo_name, String album_name, String filePath, Integer user_id){
        File file=new File(filePath + photo_name + ".jpg");
        if (file.exists())
            file.delete();
        categoryMapper.updateCountByNameAndUser(-1, album_name, user_id);
        if ( photoMapper.delete(photo_name) > 0)
            return true;
        return false;
    }

    public boolean deleteAlbum(String albumName, String filePath, Integer user_id){
        Integer album_id = categoryMapper.findCategoryIdByNameAndId(albumName, user_id);
        categoryMapper.delete(albumName, user_id);

        List<String> fileNames = photoMapper.findNameByCategoryAndUser(album_id, user_id);
        for (int i=0; i<fileNames.size(); i++){
            File file=new File(filePath + fileNames.get(i) + ".jpg");
            if (file.exists())
                file.delete();
        }
        photoMapper.delete1(album_id, user_id);
        return true;
    }

    public boolean reset(String oldAlbum, String newAlbum, Integer user_id){
        if (categoryMapper.updateName(newAlbum, oldAlbum, user_id) > 0)
            return true;
        return false;
    }
}
