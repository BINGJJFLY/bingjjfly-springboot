package com.wjz.springboot.configuration.impt;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 返回需要导入的组件的全类名数组
 */
public class ISelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{IBean.class.getName()};
    }
}
