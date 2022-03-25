package com.book.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis相关配置
 *
 * @author nndmw
 * @date 2022/02/21
 */
@Configuration
@MapperScan({"com.book.mapper", "com.book.dao"})
public class MyBatisConfig {
}
