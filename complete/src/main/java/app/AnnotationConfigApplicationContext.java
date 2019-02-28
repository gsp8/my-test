package app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class AnnotationConfigApplicationContext {
	@Configuration
	@ComponentScan("app.*")
	public class AppConfig {}
}
