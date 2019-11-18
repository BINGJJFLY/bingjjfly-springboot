package com.wjz.springboot.configuration.scan;

import com.wjz.springboot.configuration.scan.filter.ITypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * 参考：https://www.jianshu.com/p/64aac6461d5b
 */
//@ComponentScan(value = "com.wjz.springboot.configuration.scan", includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class), excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class), useDefaultFilters = false)
//@ComponentScan(value = "com.wjz.springboot.configuration.scan", includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, value = ITypeFilter.class))
@ComponentScans({@ComponentScan(value = "com.wjz.springboot.configuration.scan.include"), @ComponentScan(value = "com.wjz.springboot.configuration.scan.exclude")})
@Configuration
public class BeanScan {
}
