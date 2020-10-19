package ssm_maven;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.entity.User;
import com.ssm.service.IUserService;
import com.ssm.service.impl.UserServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTest01 {
	
	
	@Resource
	private IUserService userService;
	
	@Test
	public void demo01(){
		 
		List<User> users = userService.queryAllUser();
		for(User user:users){
			System.out.print(user.getUsername()+",");
		}
	}
	

}
