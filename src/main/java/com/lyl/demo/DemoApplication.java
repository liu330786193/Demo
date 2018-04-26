package com.lyl.demo;

import com.lyl.demo.entity.Account;
import com.lyl.demo.kafka.Config;
import com.lyl.demo.kafka.Data;
import com.lyl.demo.kafka.KafkaReceiver;
import com.lyl.demo.kafka.KafkaSender;
import com.lyl.demo.service.AccountService;
import org.apache.kafka.clients.producer.ProducerRecord;
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

	@GetMapping("/send")
	@ResponseBody
	public int sendKafka(){
		Data d = new Data();
		d.setAltitude(1);
		d.setDataTime("2017-12-17 16:21:44");
		d.setGpsStatus(1);
		d.setLat(39.123);
		d.setLon(120.112);
		d.setDirection(30.2F);
		d.setId(100L);
//		KafkaSender.getInstance().send(new ProducerRecord<String, Data>(Config.Kafka.TOPIC, d));
		return 1;
	}

	@GetMapping("/receive")
	@ResponseBody
	public int receiveKafka(){
		KafkaReceiver.getInstance().getMsgFromKafka();
		return 1;
	}

}
