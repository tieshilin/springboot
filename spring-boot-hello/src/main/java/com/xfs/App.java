package com.xfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 在这里我们使用@SpringBootApplication指定这是一个 spring boot的应用程序.
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 
 */
//extends WebMvcConfigurerAdapter
@SpringBootApplication
public class App {
	
/*public class App extends WebMvcConfigurerAdapter{//配置fastjon的第一种方式：
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		
		*//**
		 * 1、需要先定义一个 convert 转换消息的对象;
		 * 2、添加 fastJson 的配置信息，比如：是否要格式化返回的json数据;
		 * 3、在convert 中添加配置信息;
		 * 4、将convert添加到converters当中;
		 *//*
		
		//1、需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        
        //2、添加 fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat
        );
        
        //3、在convert 中添加配置信息;
        fastConverter.setFastJsonConfig(fastJsonConfig);
		
        //4、将convert添加到converters当中;
    	converters.add(fastConverter);
	}*/
	
	/**
	 * 配置fastjon的第二种方式：
	 * 在这里我们使用@Bean注入 fastJsonHttpMesageConvert
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1、需要先定义一个 convert 转换消息的对象;
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		
		// 2、添加fastJson的配置信息，比如：是否要格式化返回的json数据;
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		// 3、在convert中添加配置信息;
		fastConverter.setFastJsonConfig(fastJsonConfig);
		
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
	
	/**
	 * 这是springloader的配置方式：-javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
	 * @param args
	 */
	public static void main(String[] args) {
		
		// devtools自动重启不起作用
		//System.setProperty("spring.devtools.restart.enabled","false"); 
		
		/*
		 * 在main方法进行启动我们的应用程序.
		 */
		SpringApplication.run(App.class, args);
		
	}
}
