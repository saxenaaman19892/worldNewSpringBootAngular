package com.newsproject.worldnew.service;

import com.newsproject.worldnew.constants.APIConstants;
import com.newsproject.worldnew.documents.MediaStackDataDocument;
import com.newsproject.worldnew.documents.MediaStackDocument;
import com.newsproject.worldnew.dto.MediaStackData;
import com.newsproject.worldnew.dto.MediaStackDto;
import com.newsproject.worldnew.repository.MediaStackDocumentRepository;
import com.newsproject.worldnew.repository.MediaStackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MediaStackService {

    private final WebClient webClient;

    private final MediaStackMapper mapper;

    private final MediaStackRepository repository;

    private final MediaStackDocumentRepository documentRepository;

    @Autowired
    public MediaStackService (WebClient client, MediaStackMapper mapper, MediaStackRepository repository,
                              MediaStackDocumentRepository documentRepository) {
        this.webClient = client;
        this.mapper = mapper;
        this.repository = repository;
        this.documentRepository = documentRepository;
    }

    public Mono<MediaStackDto> getLatestMediaStackNews(int offset) {
        String url = APIConstants.MEDIA_STACK_URL + "?access_key="+APIConstants.MEDIA_STACK_API_KEY + "&countries=in&offset="+offset;
        Mono<MediaStackDto> returnDto = webClient.get().uri(url).retrieve().bodyToMono(MediaStackDto.class);
        returnDto.subscribe(dto -> {
            MediaStackDocument document = mapper.getDocmentFromDto(dto);
            repository.save(document).subscribe(doc -> {
                System.out.println("Document saved to DB, id = " + doc.getId());
            }, error -> {
                System.out.println("Document not saved, error = " + error.getMessage());
                error.printStackTrace();
            });
        }, error -> {
            System.out.println("error -> " + error.getMessage());
        }, () -> {
            System.out.println("Completed request");
        });
        return returnDto;
    }

    public Flux<MediaStackData> getByCategory(String category) {
        Flux<MediaStackDataDocument> dataByCategory = documentRepository.findByCategory(category);
        return dataByCategory.map(data -> mapper.getMediaStackDtoFromEntity(data));
    }
}
