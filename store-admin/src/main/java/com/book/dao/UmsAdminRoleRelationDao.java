package com.book.dao;

import com.book.model.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户与角色关系系统自定义Dao
 *
 * @author nndmw
 * @date 2022/02/26
 */
public interface UmsAdminRoleRelationDao {


    /**
     * 获取用户所有权限（包括+-权限）
     *
     * @param adminId 管理员id
     * @return {@link List}<{@link UmsPermission}>
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
