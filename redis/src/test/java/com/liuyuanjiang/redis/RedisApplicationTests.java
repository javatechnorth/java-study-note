package com.liuyuanjiang.redis;

import com.liuyuanjiang.redis.service.RedisService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.liuyuanjiang.redis.bean.User;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisApplicationTests {

    private static Logger logger= LoggerFactory.getLogger(FileUtils.class);

	@Autowired
	private RedisService redisService;

	@Test
	public void contextLoads() {

//		redisService.set("Black Rock","贝莱德");

		String black_rock = redisService.exists("black")?redisService.get("black"):"key not exist!";
		System.out.println(black_rock);
	}





	@Test
	public void testRedisService(){
		User user3 = new User(2,"xiaoxiaoping",16);
		redisService.set("user3", user3, 1000*60l);
		User userV3 = redisService.get("user3",User.class);
        logger.info("userV3====="+userV3.toString());
	}

}
