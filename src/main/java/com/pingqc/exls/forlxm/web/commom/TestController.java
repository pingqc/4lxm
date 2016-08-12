package com.pingqc.exls.forlxm.web.commom;

import com.pingqc.exls.forlxm.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pingqc on 16/4/11.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/testConnectMysql")
    public String testConnectMysql() {
        return testService.testConnectMysql();
    }

}
