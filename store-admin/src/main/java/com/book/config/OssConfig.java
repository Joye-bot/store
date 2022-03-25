package com.book.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * oss配置
 *
 * @author nndmw
 * @date 2022/03/03
 */
@Data
@Configuration
public class OssConfig implements Serializable {

    private static final long serialVersionUID = 1926674496834548819L;

    /**
     * 阿里云 oss 站点
     */
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;

    /**
     * 阿里云 oss 资源访问 url
     */
    @Value("${aliyun.oss.url}")
    private String url;

    /**
     * 阿里云 oss 公钥
     */
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;

    /**
     * 阿里云 oss 私钥
     */
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;

    /**
     * 阿里云 oss 文件根目录
     */
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

    @Bean("oss")
    public OSS initOssClient() {
        return new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }
}
