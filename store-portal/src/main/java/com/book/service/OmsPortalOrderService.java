package com.book.service;

import com.book.api.CommonResult;
import com.book.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 前台订单管理Service层
 *
 * @author nndmw
 * @date 2022/03/03
 */
public interface OmsPortalOrderService {

    /**
     * 根据提交信息生成定都就
     *
     * @param orderParam 命令参数
     * @return {@link CommonResult}
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消超时订单
     *
     * @param orderId 订单id
     */
    @Transactional
    void cancelOrder(Long orderId);
}
