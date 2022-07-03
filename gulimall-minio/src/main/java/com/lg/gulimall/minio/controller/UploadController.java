package com.lg.gulimall.minio.controller;

import com.alibaba.fastjson.JSON;
import io.minio.*;
import io.minio.errors.*;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author amazfit
 * @date 2022-07-02 下午5:13
 **/
@Slf4j
@RestController
@RequestMapping("minio/upload")
public class UploadController {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    /**
     * 获取 bucket 下面的文件列表
     * @return
     */
    @RequestMapping("/list")
    public List<Object> list() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
        Iterator<Result<Item>> iterator = results.iterator();
        List<Object> items = new ArrayList<>();
        String format = "{'fileName':'%s','fileSize':'%s'}";
        while (iterator.hasNext()){
            Item item = iterator.next().get();
            items.add(JSON.parse(String.format(format,item.objectName(),item.size())));
        }

        return items;
    }

    /**
     * 删除文件
     * @param fileName
     * @return
     */
    @DeleteMapping("/delete/{fileName}")
    public Object delete(@PathVariable("fileName")String fileName){
        try{
            minioClient.removeObject(
                    RemoveObjectArgs.builder().bucket(bucketName).object(fileName).build()
            );
        }catch (Exception e){
            log.error(e.getMessage());
            return "删除失败";
        }
        return "删除成功";
    }

    @PostMapping("/upload")
    public Object upload(@RequestParam(name="file",required = false)MultipartFile[] files){
        if (files == null || files.length==0){
            return "上传文件不能为null";
        }
        List<String> originalFileNameList = new ArrayList<>(files.length);
        for (MultipartFile file : files){
            String originalFileName = file.getOriginalFilename();
            originalFileNameList.add(originalFileName);
            try{
                InputStream inputStream = file.getInputStream();
                minioClient.putObject(
                        PutObjectArgs.builder().bucket(bucketName).object(originalFileName)
                                .stream(
                                        inputStream,file.getSize(),-1
                                )
                                .contentType(file.getContentType())
                                .build()
                );
                inputStream.close();
            }catch (Exception e){
                log.error(e.getMessage());
                return "上传失败";
            }
        }
        return "上传成功";
    }



    public static void main(String[] args)throws Exception {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(HttpUrl.parse("http://localhost:9000"))
                .credentials("minioadmin","minioadmin")
                .build();

        String bucketName = "gulimall";
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!found){
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }

        minioClient.uploadObject(UploadObjectArgs.builder()
                .bucket(bucketName)
                .object("fox.jpg")
                .filename("C:\\Users\\amazfit\\Pictures\\uToolsWallpapers\\wallhaven-wyl956.jpg").build());
    }
}
