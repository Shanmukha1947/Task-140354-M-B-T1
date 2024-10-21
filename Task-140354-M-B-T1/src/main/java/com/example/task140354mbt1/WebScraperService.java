package com.example.task140354mbt1;

import com.google.common.util.concurrent.RateLimiter;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class WebScraperService {

    @Cacheable(value = "webScraperCache", key = "#url", condition = "#rateLimiter.acquire()")
    public String scrapeWebsite(String url, RateLimiter rateLimiter) {
        // Simulate web scraping logic
        return "Webpage scraped from " + url;
    }
}
