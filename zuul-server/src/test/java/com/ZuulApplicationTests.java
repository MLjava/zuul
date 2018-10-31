package com;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author：linma
 * @date: 2018/10/30 16:22
 * @email: linma@homeinns.com
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ZuulApplicationTests {

    @Test
    public void contexts() {
        System.out.println("Welcome zuul!");
    }

}
