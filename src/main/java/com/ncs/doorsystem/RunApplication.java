package com.ncs.doorsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan({"com.ncs.doorsystem","com.ncs.doorsystem.engineerdashboard"})
@EnableJpaRepositories({"com.ncs.doorsystem","com.ncs.doorsystem.engineerdashboard"})
@SpringBootApplication
public class RunApplication extends SpringBootServletInitializer
{
	
	@Autowired
	Runnable MessageListener;
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RunApplication.class);
	}
		 
	public static void main(String[] args) {
		
        SpringApplication.run(RunApplication.class, args);
    }
	
	@Bean 
	public CommandLineRunner schedulingRunner(TaskExecutor executor) {
	    return new CommandLineRunner() {
	        public void run(String... args) throws Exception {
	            executor.execute(MessageListener);
	        }
	    };
	}
}