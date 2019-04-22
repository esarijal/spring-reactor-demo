package com.erm.spring.reactordemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataLoader {

    @LocalServerPort
    private int randomServerPort;

    @Test(expected = HttpClientErrorException.NotFound.class)
    public void exampleTest(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(
                "http://localhost:"+randomServerPort+"/startNotification/10", String.class
        );
    }
}
