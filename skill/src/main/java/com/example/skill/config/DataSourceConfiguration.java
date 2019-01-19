package com.example.skill.config;

import com.example.skill.common.utils.EnCrypt_And_deCryptUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/1/19 22:15
 **/
@Configuration
public class DataSourceConfiguration implements InitializingBean {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Override
    public void afterPropertiesSet() throws Exception {
        String pass = dataSourceProperties.getPassword();
        String realPass = EnCrypt_And_deCryptUtil.decrypt_Base64(pass);
        dataSourceProperties.setPassword(realPass);
    }
}
