package com.payment.solution;

import com.payment.solution.enums.AccountType;
import com.payment.solution.model.Account;
import com.payment.solution.repositories.AccountRepository;
import com.payment.solution.services.PaymentService;
import com.payment.solution.services.PaymentServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SolutionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
	}

    /**
     * Adds CommandLineRunner to populate accounts table on boot
     * @param repository
     * @return
     */
	@Bean
	public CommandLineRunner bootAccounts(AccountRepository repository) {
        return (args) -> {
            for(int x = 0; x < 20; x++) {
                final Account account = new Account();
                account.setAccountNumber(10000000 + x);
                account.setAccountType(AccountType.CASH);
                if( x < 10 ) {
                    account.setSortCode("00-00-0" + String.valueOf(x));
                } else {
                    account.setSortCode("00-00-" + String.valueOf(x));
                }
                Random r = new Random();
                account.setCurrentBalance(Math.round((10 + (1000 - 10) * r.nextDouble()) * 100d) / 100d);
                repository.save(account);
            }

        };
    }

    /**
     * Add CORS configuration, because, CORS is a bitch.
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/rest/").allowedOrigins("*");
            }
        };
    }

    @Bean
    public PaymentService paymentService() {
        return new PaymentServiceImpl();
    }

}
