package org.myharvest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootStart.class)
public class BaseTest {

    @Test
    public void test(){
        System.out.println("test demo");
    }

}
