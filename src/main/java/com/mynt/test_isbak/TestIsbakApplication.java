package com.mynt.test_isbak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestIsbakApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestIsbakApplication.class, args);

		System.out.println("""
				.___  __ /\\        __________                    .__                   _____                                   \s
				|   |/  |)/ ______ \\______   \\__ __  ____   ____ |__| ____    ____   _/ ____\\___________    ____   ______  _  __
				|   \\   __\\/  ___/  |       _/  |  \\/    \\ /    \\|  |/    \\  / ___\\  \\   __\\/  _ \\_  __ \\  /    \\ /  _ \\ \\/ \\/ /
				|   ||  |  \\___ \\   |    |   \\  |  /   |  \\   |  \\  |   |  \\/ /_/  >  |  | (  <_> )  | \\/ |   |  (  <_> )     /\s
				|___||__| /____  >  |____|_  /____/|___|  /___|  /__|___|  /\\___  /   |__|  \\____/|__|    |___|  /\\____/ \\/\\_/ \s
				               \\/          \\/           \\/     \\/        \\//_____/                             \\/              \s
				""");
	}

}
