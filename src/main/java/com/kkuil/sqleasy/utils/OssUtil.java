package com.kkuil.sqleasy.utils;

import com.aliyun.oss.*;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.model.LifecycleRule;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyun.oss.model.SetBucketLifecycleRequest;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Kkuil
 * @Date 2023/9/8 11:43
 * @Description 阿里云OSS工具类
 */
@Slf4j
public class OssUtil {

    /**
     * 终端
     */
    private final static String ENDPOINT = "https://oss-cn-hangzhou.aliyuncs.com";

    /**
     * 桶名
     */
    private final static String BUCKET_NAME = "sql-easy";

    /**
     * 上传文件
     *
     * @param objectName 文件路径 + 文件名
     * @throws com.aliyuncs.exceptions.ClientException 异常
     */
    public static String uploadFile(
            @NotBlank(message = "保存路径不能为空") String objectName,
            @NotBlank(message = "文件内容不能为空") ByteArrayOutputStream outputStream
    ) throws com.aliyuncs.exceptions.ClientException {
        // 设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ENDPOINT, credentialsProvider);

        try {
            // 上传文件
            PutObjectResult uploadResult = ossClient.putObject(
                    BUCKET_NAME,
                    objectName,
                    new ByteArrayInputStream(outputStream.toByteArray())
            );
            String excelUrl = "https://" + BUCKET_NAME + "." + "oss-cn-hangzhou.aliyuncs.com" + "/" + objectName;
            log.info("excelUrl: {}", excelUrl);
            return excelUrl;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }
}
