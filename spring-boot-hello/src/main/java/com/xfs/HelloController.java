package com.xfs;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在这里我们使用RestController  （等待于 @Controller 和 @RequestBody）
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2016年12月10日
 */
@RestController
public class HelloController {
	
	/**
	 * 在这里我们使用@RequestMapping 建立请求映射:
	 * http://127.0.0.1:8080/hello
	 * @return
	 */
	@RequestMapping("/hello")
	public String hello(){
		return "hello hahaaa!";
	}
	
	/**
	 * Spring Boot 默认使用的json解析框架是jackson
	 * @return
	 */
	@RequestMapping("/demo")
	public Demo getDemo(){
		Demo demo = new Demo();
		demo.setId(111);
		demo.setName("demo111");
		demo.setCreatetime(new Date());
		demo.setRemarks("这是备注信息！~");
		return demo;
	}
	
	
	@RequestMapping("/demo2")
	public Demo getDemo2(){
		Demo demo = new Demo();
		demo.setId(22);
		demo.setName("demo22");
		demo.setCreatetime(new Date());
		demo.setRemarks("这是备注信息！~");
		return demo;
	}
	
	@RequestMapping("/demo3")
	public Demo getDemo3(){
		Demo demo = new Demo();
		demo.setId(333);
		demo.setName("demo333");
		demo.setCreatetime(new Date());
		demo.setRemarks("这是备注信息！~");
		return demo;
	}
}
