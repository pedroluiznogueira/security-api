package com.github.pedroluiznogueira.securityapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SecurityApiApplicationTests {

	@Test
	void testPasswordEncoder() {
		System.out.println(new BCryptPasswordEncoder().encode("password"));
	}
}
