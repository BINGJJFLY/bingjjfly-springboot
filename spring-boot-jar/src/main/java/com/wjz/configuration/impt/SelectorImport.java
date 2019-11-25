package com.wjz.configuration.impt;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 全类名数组对象注入IOC容器
 */
@Configuration
@Import(ISelector.class)
public class SelectorImport {
}
