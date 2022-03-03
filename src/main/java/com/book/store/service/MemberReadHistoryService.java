package com.book.store.service;

import com.book.store.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览记录管理Service层
 *
 * @author nndmw
 * @date 2022/03/02
 */
public interface MemberReadHistoryService {

    /**
     * 生成浏览记录
     *
     * @param memberReadHistory 成员阅读历史
     * @return int
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     *
     * @param ids id
     * @return int
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     *
     * @param memberId 成员身份
     * @return {@link List}<{@link MemberReadHistory}>
     */
    List<MemberReadHistory> list(Long memberId);
}
