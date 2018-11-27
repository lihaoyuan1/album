package com.lhy.demo.Controller;

import com.lhy.demo.Entity.Category;
import com.lhy.demo.Entity.Photo;
import com.lhy.demo.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by pc on 2018/9/5.
 */
@Controller
@RequestMapping(value = "/album")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping(value = "/ShowPicture/{id}")
    public String show(@PathVariable("id") String id, HttpSession session) {
        session.setAttribute("id", id);
        return "index";
    }

    @GetMapping(value = "/home")
    public String home(HttpSession session){
        Integer userId = (Integer) session.getAttribute("user");
        List<List<String>> photoList = homeService.findAllPhotosByUserId(userId);
        List<Category> categoryList = homeService.getCategoryByUserId(userId);
        session.setAttribute("photos", photoList);
        session.setAttribute("categories", categoryList);
        return "home";
    }

    @PostMapping(value = "/upload")
    public String upload(@RequestParam("picture") MultipartFile[] picture,HttpServletRequest request, HttpSession session
                         ) throws IOException {
        Integer userId = (Integer) session.getAttribute("user");
        String category = request.getParameter("category");
        String filePath = request.getSession().getServletContext().getRealPath("images/photos/");
        homeService.upLoad(userId, picture, filePath, category);
        return "redirect:/album/home";
    }

    @PostMapping(value = "/album")
    public String album(HttpServletRequest request, HttpSession session){
        Integer userId = (Integer) session.getAttribute("user");
        String album = request.getParameter("album");
        homeService.newAlbum(album, userId);
        return "redirect:/album/home";
    }

    @GetMapping(value = "/more/{category}")
    public String more(@PathVariable("category") String msg, HttpSession session){
        Integer userId = (Integer) session.getAttribute("user");
        String category = msg.split("_")[0];
        Integer id = Integer.parseInt(msg.split("_")[1]);
        List<String> photo = homeService.getAlbum(category, userId);
        List<String> categoryName = homeService.getCategoryNameByUserId(userId);
        session.setAttribute("album", photo);
        session.setAttribute("albumName", category);
        session.setAttribute("categoryName", categoryName);
        session.setAttribute("id", id);
        return "more";
    }

    @PostMapping(value = "/move")
    public String move(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
        Integer userId = (Integer) session.getAttribute("user");
        String newAlbum = request.getParameter("category");
        String oldAlbum = request.getParameter("album_name");
        String photo_name = request.getParameter("photo_name");
        homeService.move(photo_name, newAlbum, oldAlbum, userId);
        return "redirect:/album/more/" + URLEncoder.encode(oldAlbum, "UTF-8") + "_0";
    }

    @PostMapping(value = "/delete")
    public String delete(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
        Integer userId = (Integer) session.getAttribute("user");
        String photo_name = request.getParameter("photo_name");
        String album_name = request.getParameter("album_name");
        String filePath = request.getSession().getServletContext().getRealPath("images/photos/");
        homeService.delete(photo_name, album_name, filePath, userId);
        return "redirect:/album/more/" + URLEncoder.encode(album_name, "UTF-8") + "_0";
    }

    @PostMapping(value = "/deleteAlbum")
    public String deleteAlbum(HttpServletRequest request, HttpSession session){
        Integer userId = (Integer) session.getAttribute("user");
        String album_name = request.getParameter("album_name");
        String filePath = request.getSession().getServletContext().getRealPath("images/photos/");
        homeService.deleteAlbum(album_name, filePath, userId);
        return "redirect:/album/home";
    }

    @PostMapping(value = "/reset")
    public String reset(HttpServletRequest request, HttpSession session){
        Integer userId = (Integer) session.getAttribute("user");
        String oldAlbum = request.getParameter("album1");
        String newAlbum = request.getParameter("album2");
        homeService.reset(oldAlbum, newAlbum, userId);
        return "redirect:/album/home";
    }
}
