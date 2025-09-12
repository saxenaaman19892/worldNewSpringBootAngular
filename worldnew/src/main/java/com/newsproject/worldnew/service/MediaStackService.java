package com.newsproject.worldnew.service;

import com.newsproject.worldnew.constants.APIConstants;
import com.newsproject.worldnew.dto.MediaStackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MediaStackService {

    private WebClient webClient;

    @Autowired
    public MediaStackService (WebClient client) {
        this.webClient = client;
    }

    public Mono<MediaStackDto> getLatestMediaStackNews() {
        String url = APIConstants.MEDIA_STACK_URL + "?access_key="+APIConstants.MEDIA_STACK_API_KEY;
        return webClient.get().uri(url).retrieve().bodyToMono(MediaStackDto.class);
    }
}
