package com.wjz.configuration.impt;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 配置类对象注入IOC容器，目标类对象不需用 @Configuration 修饰
 */
@Configuration
@Import(IBeanConfig.class)
public class ConfigurationImport {
}
