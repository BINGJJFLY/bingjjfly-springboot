package com.wjz.springboot.configuration.impt;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 普通类对象注入IOC容器，当前类 @Configuration 必须要有
 */
@Configuration
@Import(IBean.class)
public class GeneralClassImport {
}
