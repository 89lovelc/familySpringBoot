package com.hjh.cn;

import com.hjh.cn.po.CameraPo;
import com.hjh.cn.po.EquipmentPo;
import com.hjh.cn.po.RaspberryPo;
import com.hjh.cn.po.ScenePo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by 89lovelc on 2017/5/10.
 */
@Configuration
public class SpringDataRestConfig {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(
                    RepositoryRestConfiguration config) {
                config.exposeIdsFor(RaspberryPo.class, CameraPo.class, EquipmentPo.class,ScenePo.class);
            }
        };
    }

}