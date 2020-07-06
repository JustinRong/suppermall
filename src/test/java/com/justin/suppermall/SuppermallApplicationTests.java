package com.justin.suppermall;

import cn.hutool.http.HttpRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SuppermallApplicationTests {

    @Test
    void contextLoads() {
        Map<String, Object> param = new HashMap<>();
        param.put("username", "admin");
        String body = HttpRequest.post("http://localhost:8081/suppermall/login")
                .form(param)
                .execute()
                .body();
        System.out.println("---->" + body);


    }

}
