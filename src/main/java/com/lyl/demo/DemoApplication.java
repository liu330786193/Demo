package com.lyl.demo;

import com.lyl.demo.dao.AccountDao;
import com.lyl.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.java2d.pipe.SpanIterator;

@Controller
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private AccountDao accountDao;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping
	@ResponseBody
	@RequestMapping("/insert")
	int insert(){
		Account account = new Account();
		account.setAge(11);
		account.setUsername("lyl");
		account.setPassword("123456");
		return accountDao.insert(account);
	}

	@RequestMapping("/truncate")
	int truncate(){
		return accountDao.truncateAccount();
	}

	public void test(){
		System.out.println("测试内部方法");
	}

}
