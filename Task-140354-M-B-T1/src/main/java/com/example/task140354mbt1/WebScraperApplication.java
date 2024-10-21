package com.example.task140354mbt1;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebScraperApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebScraperApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(WebScraperService webScraperService) {
        return args -> {
            RateLimiter rateLimiter = RateLimiter.create(10.0); // Allows 10 requests per second
            String url = "https://example.com"; // Replace with the target URL

            String result = webScraperService.scrapeWebsite(url, rateLimiter);
            System.out.println(result);
        };
    }
}

