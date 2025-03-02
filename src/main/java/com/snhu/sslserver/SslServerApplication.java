package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.nio.charset.StandardCharsets;
import java.security.*;


@SpringBootApplication
public class SslServerApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SslServerApplication.class, args);
	}
}

@RestController
class HashController {
	public static String calculateHash(String data) throws Exception {
		final MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

		StringBuilder hexString = new StringBuilder();
		System.out.println(hash);
		for (int i = 0; i < hash.length; i++) {
            final String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) { 
            	hexString.append('0');
            	}
            hexString.append(hex);
           }
		return hexString.toString();
	}
	
	@RequestMapping("/hash")
	public String myHash() throws Exception {
		String data = "Hello World Check Sum!";
		String hash = calculateHash(data);
		System.out.println(hash);
		return "<p>Name: Alexander P</p>" + "<p>Data: " + data + "</p>" + "<p>Cipher Algorithm: SHA-256</p>" + "<p>Checksum value: " + hash + "</p>";
	}
}

//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";