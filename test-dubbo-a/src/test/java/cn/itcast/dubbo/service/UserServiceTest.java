/**  
 * <p>Title: UserServiceTest.java</p>  
 * <p>Description: </p>   
 * @author shianliang  
 * @date 2018年7月8日  
 * @version 1.0  
 */ 
package cn.itcast.dubbo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.dubbo.pojo.User;

/**  
 * <p>Title: UserServiceTest</p>  
 * <p>Description: </p>  
 * @author shianliang 
 * @date 2018年2月8日  
 */
public class UserServiceTest {

	private UserService userService;
	/**
	 * <p>Description: </p> 
	 * @author shianliang  
	 * @date 2018年2月8日  
	 * @version 1.0
	 * @throws java.lang.Exception   
	 */
	@Before
	public void setUp() throws Exception {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:dubbo/dubbo-*.xml");
		
		userService=(UserService) ac.getBean("userService");
		
	}

	/**
	 * Test method for {@link cn.itcast.dubbo.service.UserService#queryAll()}.
	 */
	@Test
	public void testQueryAll() {
		for (int i = 0; i < 500; i++) {

			List<User> users = userService.queryAll();
			for (User user : users) {
				System.out.println(user);
			}
			try {
				Thread.sleep(i*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
