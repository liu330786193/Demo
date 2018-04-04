package com.lyl.demo;

import com.lyl.demo.entity.Account;
import com.lyl.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private AccountService accountService;

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
		return accountService.insert(account);
	}

	@RequestMapping("/truncate")
	int truncate(){
		return accountService.truncateAccount();
	}

	public void test(){
		System.out.println("测试内部方法");
	}

}
