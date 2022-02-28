package com.book.store.service;

import com.book.store.mbg.model.UmsAdmin;
import com.book.store.mbg.model.UmsPermission;

import java.util.List;

/**
 * 后台用户管理业务逻辑层
 *
 * @author nndmw
 * @date 2022/02/25
 */
public interface UmsAdminService {

    /**
     * 根据用户名获取后台管理员
     *
     * @param username 用户名
     * @return {@link UmsAdmin}
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     *
     * @param umsAdminParam 无人机舱管理参数
     * @return {@link UmsAdmin}
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return {@link String}
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限+-权限）
     *
     * @param adminId 管理员id
     * @return {@link List}<{@link UmsPermission}>
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
