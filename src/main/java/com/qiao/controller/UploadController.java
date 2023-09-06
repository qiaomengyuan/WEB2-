package com.qiao.controller;

import com.qiao.pojo.Result;
import com.qiao.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.geom.RectangularShape;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    //本地存储文件
    @Autowired
    private AliOSSUtils aliOSSUtils;
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传：{}，{}，{}",username,age,image);
//        String originalFilename = image.getOriginalFilename();
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        image.transferTo(new File("D:\\images\\"+newFileName));
//        return  Result.success();
//    }

    //云储存文件
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成，文件访问的url为{}",url);
        return Result.success(url);

    }
}
