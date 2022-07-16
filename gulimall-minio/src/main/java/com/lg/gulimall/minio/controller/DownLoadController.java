package com.lg.gulimall.minio.controller;

import com.lg.gulimall.common.utils.R;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.extern.slf4j.Slf4j;
import okhttp3.HttpUrl;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * 下载
 *
 * @author amazfit
 * @date 2022-07-02 下午5:25
 **/
@Slf4j
@RestController
@RequestMapping("minio/download")
public class DownLoadController {

    @Autowired
    private MinioClient minioClient;

    @Value("${minio.bucketName}")
    private String bucketName;

    public static void main(String[] args) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(HttpUrl.parse("http://localhost:9000"))
                .credentials("minioadmin", "minioadmin")
                .build();

        String bucketName = "gulimall";

        minioClient.downloadObject(
                DownloadObjectArgs.builder()
                        .bucket(bucketName)
                        .object("fox.jpg")
                        .filename("C:\\Users\\amazfit\\Pictures\\uToolsWallpapers\\11111.jpg")
                        .build()
        );
    }

    @RequestMapping("/download/{fileName}")
    public void download(HttpServletResponse response, @PathVariable("fileName") String fileName) throws Exception {
        InputStream inputStream = null;
        try {
            StatObjectResponse stat = minioClient.statObject(
                    StatObjectArgs.builder().bucket(bucketName).object(fileName).build()
            );
            response.setContentType(stat.contentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            //文件下载
            inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(bucketName).object(fileName).build());
            IOUtils.copy(inputStream, response.getOutputStream());
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

    /**
     * 生成预览地址
     *
     * @param fileName
     * @return
     */
    @GetMapping("/getPreviewFileUrl")
    public R getPreviewFileUrl(@RequestParam String fileName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String url = minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .object(fileName)
                        .expiry(1, TimeUnit.DAYS)
                        .method(Method.GET)
                        .build()
        );
        return R.ok().put("url", url);
    }
}
