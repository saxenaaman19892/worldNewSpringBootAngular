package com.newsproject.worldnew.scheduler;

import com.newsproject.worldnew.dto.MediaStackDto;
import com.newsproject.worldnew.service.MediaStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class Schedulers {

    private final MediaStackService mediaStackService;

    @Autowired
    public Schedulers(MediaStackService service) {
        this.mediaStackService = service;
    }

    @Scheduled(cron = "0 0 6 * * *")
    public void runDailyTaskAt6AM() {
        int offset = 0;
        for (int i = 1; i <= 3; i++) {
            System.out.println("i = " + i + ", offset = " + offset);
            Mono<MediaStackDto> returnDto = mediaStackService.getLatestMediaStackNews(offset);
            offset = offset + 26;

        }
    }
}
