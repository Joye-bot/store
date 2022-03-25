package com.book.utils;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.book.config.OssConfig;

/**
 * 阿里云 oss 工具类
 *
 * @author nndmw
 * @date 2022/03/04
 */
public class OssUtil {

    public OssUtil() {
    }

    /**
     * oss 工具客户端
     */
    private volatile static OSSClient ossClient = null;

    /**
     * 初始化 oss 客户端
     *
     * @param ossConfig ossConfig
     * @return {@link OSSClient}
     */
    private static OSSClient initOSS(OssConfig ossConfig) {
        if (ossClient == null) {
            synchronized (OssUtil.class) {
                if (ossClient == null) {
                    ossClient = new OSSClient(ossConfig.getEndpoint(),
                            new DefaultCredentialProvider(ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret()),
                            new ClientConfiguration());
                }
            }
        }
        return ossClient;
    }
}
