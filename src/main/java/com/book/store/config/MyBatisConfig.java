package com.book.store.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 *
 * @author nndmw
 * @date 2022/02/21
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.book.store.mbg.mapper")
public class MyBatisConfig {
}
