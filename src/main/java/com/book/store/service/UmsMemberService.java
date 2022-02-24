package com.book.store.service;

import com.book.store.api.CommonResult;

/**
 * 会员管理业务逻辑层
 *
 * @author nndmw
 * @date 2022/02/24
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     *
     * @param telephone 电话
     * @return {@link CommonResult}
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码合手机号码是否匹配
     *
     * @param telephone 电话
     * @param authCode  身份验证代码
     * @return {@link CommonResult}
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
