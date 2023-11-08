package telran.java48;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KarafkaProducerApplication {
	Random random = new Random();

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(KarafkaProducerApplication.class, args);
		try {
			Thread.sleep(30_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ctx.close();
		}
	}

	@Bean
	public Supplier<String> sendData() {
		return () -> "data%" + random.nextInt(10) + " " + System.currentTimeMillis();
	}

}
