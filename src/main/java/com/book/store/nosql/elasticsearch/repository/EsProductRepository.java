package com.book.store.nosql.elasticsearch.repository;

import com.book.store.nosql.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 商品ES操作类
 *
 * @author nndmw
 * @date 2022/03/01
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {

    /**
     * 搜索查询
     *
     * @param name     商品名字
     * @param subTitle 商品标题
     * @param keywords 商品关键字
     * @param page     分页页面
     * @return {@link Page}<{@link EsProduct}>
     */
    Page<EsProduct> findByNameOrSubTitleOrKeywords(String name, String subTitle, String keywords, Pageable page);
}
