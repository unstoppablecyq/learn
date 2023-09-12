package icu.cccccyq.controller;

import icu.cccccyq.pojo.Result;
import icu.cccccyq.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author cccccyq
 */
@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    /**
     * 本地存储文件
     */
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("文件上传:{},{},{}", username, age, image);
//        String originalFilename = image.getOriginalFilename();
//        //唯一文件名
//        int index = originalFilename.lastIndexOf(".");
//        String extname = originalFilename.substring(index);
//        String newFileName = UUID.randomUUID().toString() + extname;
//        log.info("new name:{}", newFileName);
////        放到本地硬盘
//        image.transferTo(new File("C:\\Users\\cccccyq\\Desktop\\GitHub\\learn\\Java\\framework\\IDEAprojs\\learn_project_001\\filess\\"+newFileName));
//        return Result.success();
//    }
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("upload:name:{}",image);
        String url = aliOSSUtils.upload(image);
        log.info("upload ok!,url:{}", url);
        return Result.success(url);
    }
}