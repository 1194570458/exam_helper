package com.kason.app.controller;

import com.kason.app.entity.Result;
import com.kason.app.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/upload")
public class FileController {

    static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @ResponseBody
    @PostMapping("/img")
    public Result imgUpload(@RequestParam("file") MultipartFile file) throws FileNotFoundException {
        if (file.isEmpty()) {
            return ResultUtil.error(-1, "上传文件不存在");
        }
        String fileName = file.getOriginalFilename();
        int indexOf = fileName.lastIndexOf(".");
        String extension = fileName.substring(indexOf, fileName.length());
        logger.info("后缀extension " + extension);
        fileName = (System.currentTimeMillis() + new Random(1000).nextInt()) + extension;
        int size = (int) file.getSize();
        logger.info("--------uploadImgFile--------");
        logger.info(fileName + "-->" + size);
        String classPath = ResourceUtils.getURL("classpath:").getPath() + "static/upload/";
        classPath = classPath.replace("file:", "");
        logger.info("classPath -->" + classPath);
        File uploadPath = new File(classPath);
        logger.info("uploadImgPath -->" + uploadPath.getAbsolutePath());
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        try {
            File file1 = new File(uploadPath.getAbsolutePath() + "/" + fileName);
            logger.info("file path -->" + file1.getAbsolutePath());
            file.transferTo(file1); //保存文件
            String imgurl = "/upload/" + fileName;
            Map<String, Object> map = new HashMap<>();
            map.put("url", imgurl);
            return ResultUtil.success(map);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return ResultUtil.error(-1, e.getStackTrace().toString());
        } catch (IOException e) {
            e.printStackTrace();
            return ResultUtil.error(-1, e.getStackTrace().toString());
        }
    }
}