package com.newsproject.worldnew.controller;

import com.newsproject.worldnew.dto.MediaStackDto;
import com.newsproject.worldnew.service.MediaStackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/mediaStack")
public class MediaStackController {

    private MediaStackService service;

    @Autowired
    public MediaStackController (MediaStackService mediaStackService) {
        this.service = mediaStackService;
    }

    @GetMapping("/latest")
    public Mono<MediaStackDto> getMediaStackNews() {
        return service.getLatestMediaStackNews();
    }
}
