package com.github.pedroluiznogueira.securityapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class SecurityApiApplicationTests {

	@Test
	void testPasswordEncoder() {
		System.out.println(new BCryptPasswordEncoder().encode("password"));
		System.out.println(new Pbkdf2PasswordEncoder().encode("password"));
		System.out.println(new SCryptPasswordEncoder().encode("password"));
	}
}
