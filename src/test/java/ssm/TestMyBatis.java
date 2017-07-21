package ssm;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.core.entity.Users;
import ssm.core.service.UsersService;

import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })
public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	@Resource
	private UsersService userService = null;

//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (UsersService) ac.getBean("userService");
//	}

	@Test
	public void test1() {
		int uid = 1;
		Users user = userService.getUserById(uid);
		 System.out.println(user.getUserName());
		logger.info(JSON.toJSONString(user));
	}

}
