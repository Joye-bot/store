package com.book.store.service;

import com.book.store.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * es产品服务
 *
 * @author nndmw
 * @date 2022/03/01
 */
public interface EsProductService {

    /**
     * 导入所有
     *
     * @return int
     */
    int importAll();

    /**
     * 删除
     *
     * @param id id
     */
    void delete(Long id);

    /**
     * 创建
     *
     * @param id id
     * @return {@link EsProduct}
     */
    EsProduct create(Long id);

    /**
     * 删除
     *
     * @param ids id
     */
    void delete(List<Long> ids);

    /**
     * 搜索
     *
     * @param keyword  关键字
     * @param pageNum  页面num
     * @param pageSize 页面大小
     * @return {@link Page}<{@link EsProduct}>
     */
    Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize);
}
