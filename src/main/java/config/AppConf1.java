package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.MemberDao;
import spring.MemberPrinter;

@Configuration		
@Import (AppConf2.class)      // 두 개 이상의 설정 클래스를 지정 ⇒ @Import({ AppConf2.class, AppConf3.class })
public class AppConf1 {
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	//@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
}








 