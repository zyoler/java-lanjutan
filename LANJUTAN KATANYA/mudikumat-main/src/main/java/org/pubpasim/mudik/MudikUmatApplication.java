package org.pubpasim.mudik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MudikUmatApplication {
	public static int periode = 2020;

	public static void main(String[] args) {
		SpringApplication.run(MudikUmatApplication.class, args);
	}

}
