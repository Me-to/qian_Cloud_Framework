package com.example.qian.selector;

import com.example.qian.configure.QianAuthExceptionConfigure;
import com.example.qian.configure.QianOAuth2FeignConfigure;
import com.example.qian.configure.QianServerProtectConfigure;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class QianCloudApplicationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                QianAuthExceptionConfigure.class.getName(),
                QianOAuth2FeignConfigure.class.getName(),
                QianServerProtectConfigure.class.getName()
        };
    }
}