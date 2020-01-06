package com.imooc.diveinspringboot.annotation;

import com.imooc.diveinspringboot.configuration.HelloworldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{HelloworldConfiguration.class.getName()};
    }
}