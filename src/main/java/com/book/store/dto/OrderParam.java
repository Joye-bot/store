package com.book.store.dto;

/**
 * 生成订单传入的参数
 *
 * @author nndmw
 * @date 2022/03/03
 */
public class OrderParam {

    /**
     * 收获地址id
     */
    private Long memberReceiveAddressIdi;

    /**
     * 优惠券id
     */
    private Long couponId;

    /**
     * 使用的积分数
     */
    private Integer useIntegration;

    /**
     * 支付方式
     */
    private Integer payType;

    public Long getMemberReceiveAddressIdi() {
        return memberReceiveAddressIdi;
    }

    public void setMemberReceiveAddressIdi(Long memberReceiveAddressIdi) {
        this.memberReceiveAddressIdi = memberReceiveAddressIdi;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Integer getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(Integer useIntegration) {
        this.useIntegration = useIntegration;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }
}
