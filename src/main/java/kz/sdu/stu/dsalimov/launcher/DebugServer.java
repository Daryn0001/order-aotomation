package kz.sdu.stu.dsalimov.launcher;

import kz.sdu.stu.dsalimov.bean_containers.BeanConfigForDebugServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BeanConfigForDebugServer.class)
public class DebugServer {

	public static void main(String[] args) {
		SpringApplication.run(DebugServer.class, args);
	}

}
