package com.book.service;

import com.book.model.PmsBrand;

import java.util.List;

/**
 * 商品品牌管理业务逻辑层
 *
 * @author nndmw
 * @date 2022/02/18
 */
public interface PmsBrandService {

    /**
     * 获取所有品牌
     *
     * @return {@link List}<{@link PmsBrand}>
     */
    List<PmsBrand> listAllBrand();

    /**
     * 创建品牌
     *
     * @param brand 品牌
     * @return int
     */
    int createBrand(PmsBrand brand);

    /**
     * 更新品牌
     *
     * @param id    id
     * @param brand 品牌
     * @return int
     */
    int updateBrand(Long id, PmsBrand brand);

    /**
     * 删除品牌
     *
     * @param id id
     * @return int
     */
    int deleteBrand(Long id);

    /**
     * 分页查询品牌
     *
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @return {@link List}<{@link PmsBrand}>
     */
    List<PmsBrand> listBrand(int pageNum, int pageSize);

    /**
     * 获取品牌详情
     *
     * @param id id
     * @return {@link PmsBrand}
     */
    PmsBrand getBrand(Long id);
}
