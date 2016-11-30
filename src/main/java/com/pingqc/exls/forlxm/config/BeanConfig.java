package com.pingqc.exls.forlxm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pingqc.exls.forlxm.util.QiniuClient;

/**
 * Created by pingqc on 16/9/6.
 */
@Configuration
public class BeanConfig {

    @Bean
    QiniuClient qiniuClient() {
        return new QiniuClient();
    }

}
