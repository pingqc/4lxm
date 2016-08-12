package com.pingqc.exls.forlxm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by pingqc on 16/4/11.
 */
@Component
public class TestService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String testConnectMysql() {
        try {
            jdbcTemplate.execute("SELECT  1");
            return "success";
        } catch (Exception e) {
            return "failed";
        }
    }

}
