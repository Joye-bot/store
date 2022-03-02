package com.book.store.dao;

import com.book.store.nosql.elasticsearch.document.EsProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索系统中的商品管理自定义Dao
 *
 * @author nndmw
 * @date 2022/03/01
 */
public interface EsProductDao {

    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
