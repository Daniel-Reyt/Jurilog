package fr.lightning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@SpringBootApplication
@EnableSwagger2
public class Orm_JuriLog {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Orm_JuriLog.class, args);
		System.out.println("ORM démarrer");
	}
}
