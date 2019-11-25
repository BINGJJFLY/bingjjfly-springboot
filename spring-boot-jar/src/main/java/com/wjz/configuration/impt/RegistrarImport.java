package com.wjz.configuration.impt;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Bean定义注入IOC容器
 */
@Configuration
@Import(IRegistrar.class)
public class RegistrarImport {
}
