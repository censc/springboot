package com.iamzhangx.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileController {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private String defaultDir = "";
    
    @PostMapping("/upload")
    public String fileUpload(MultipartFile upFile , HttpServletRequest req){
        String realPath = defaultDir;
        String format = sdf.format(new Date());
        File folder = new File(realPath + "/" + format);
        
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        

        String oldName = upFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() +
                oldName.substring(oldName.lastIndexOf(".") , oldName.length());
        
        try{
            upFile.transferTo(new File(folder,newName));
            //String filePath = realPath + "/" + format + "/" + newName;
            String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload/" +
                    format + "/" + newName;
            return filePath;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
        return "error";
    }
    
    @PostMapping("/uploads")
    public String fileUpload(MultipartFile[] upFiles , HttpServletRequest req){
        
        String realPath = defaultDir;
        String format = sdf.format(new Date());
        File folder = new File(realPath + "/" + format);
        
        if(!folder.isDirectory()){
            folder.mkdirs();
        }
        
        String oldName = "";
        String newName = "";
        String filePathStr = "";
        int length = upFiles.length;
        
        for(MultipartFile upFile : upFiles){
            
            oldName = upFile.getOriginalFilename();
            newName = UUID.randomUUID().toString() +
                    oldName.substring(oldName.lastIndexOf(".") , oldName.length());
            
            try{
                upFile.transferTo(new File(folder,newName));
                //String filePath = realPath + "/" + format + "/" + newName;
                String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/upload/" +
                        format + "/" + newName;
                filePathStr += filePath + "||";
            }catch (Exception e){
                System.out.println(e.getMessage());
                return "error";
            }
            
        }
        return filePathStr;
        
        
    }
}
