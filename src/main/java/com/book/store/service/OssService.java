package com.book.store.service;

import com.book.store.dto.OssCallbackResult;
import com.book.store.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * oss上传管理Service层
 *
 * @author nndmw
 * @date 2022/03/03
 */
public interface OssService {

    /**
     * oss上传策略生成
     *
     * @return {@link OssPolicyResult}
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     *
     * @param request 请求
     * @return {@link OssCallbackResult}
     */
    OssCallbackResult callback(HttpServletRequest request);
}
