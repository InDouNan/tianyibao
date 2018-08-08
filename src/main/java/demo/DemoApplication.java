package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAsync
@Controller
@SpringBootApplication
@ServletComponentScan
@Configuration
public class DemoApplication  extends SpringBootServletInitializer {

@Bean
public SpringUtil springUtil2(){return new SpringUtil();}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		try {
//			new GetAccessTokenServlet().init();
//		}catch (Exception e){e.printStackTrace();}

		return application.sources(DemoApplication.class);
	}

	public static void main(String[] args) {


	SpringApplication.run(DemoApplication.class, args);
//		ConfigurableApplicationContext context=SpringApplication.run(DemoApplication.class, args);
//		GetAccessTokenServlet asyncTaskService =context.getBean(GetAccessTokenServlet.class);
//		try {
//			asyncTaskService.init();
//		}catch (Exception e){e.printStackTrace();}

	}
	@RequestMapping("/")
	public String index() {
		return "/index.html";
	}

}
