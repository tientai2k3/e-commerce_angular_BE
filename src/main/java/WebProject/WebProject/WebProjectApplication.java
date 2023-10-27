package WebProject.WebProject;

import java.util.HashMap;
import java.util.Map;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;


@SpringBootApplication
public class WebProjectApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(WebProjectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}
	@Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dy1hmpdtw",
				"api_key", "557494677828744",
				"api_secret", "u5GKvqx8SQILrIxH0-wxqN4vJkI"));
		return cloudinary;
	}
}
