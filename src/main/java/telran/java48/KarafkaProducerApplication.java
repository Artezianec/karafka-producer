package telran.java48;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import telran.java48.model.Message;

@SpringBootApplication
public class KarafkaProducerApplication {
    Random random = new Random();

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(KarafkaProducerApplication.class, args);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ctx.close();
        }
    }

    @Bean
    public Supplier<Message> sendData() {
        return () -> new Message("Test Message#" + random.nextInt(10));
    }

}