package com.book.controller;

import com.book.api.CommonResult;
import com.book.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录注册管理控制器
 *
 * @author nndmw
 * @date 2022/02/24
 */
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@Controller
@RequestMapping(value = "/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;

    /**
     * 获得身份验证代码
     *
     * @param telephone 电话
     * @return {@link CommonResult}
     */
    @ApiOperation("获取验证码")
    @GetMapping(value = "/getAuthCode")
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    /**
     * 判断验证码是否正确
     *
     * @param telephone 电话
     * @param authCode  身份验证代码
     * @return {@link CommonResult}
     */
    @ApiOperation("判断验证码是否正确")
    @PostMapping(value = "/verifyAuthCode")
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }
}
