package com.chenxudong.utilackage;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class FileUploadUtils {
    //读取前台上传的文件
    public static String loadFile(MultipartFile file,HttpServletRequest request) throws IOException {
        //上传文件保存目录
    	String savePath = request.getSession().getServletContext().getRealPath("upload")+"\\";
    	UUID uuid = UUID.randomUUID();
    	long id = uuid.getMostSignificantBits();
        String parentPath = savePath;
        if(file.getSize() == 0){
            System.out.println("file is null");
            return null;
        }else {
            String time = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
            String filename = parentPath + time + id+".jpg";
            File fl = new File(filename);
            file.transferTo(fl);
            return "\\upload\\"+time +  id+".jpg";
        }
    }
}
