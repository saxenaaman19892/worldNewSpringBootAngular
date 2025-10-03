package com.newsproject.worldnew.repository;

import com.newsproject.worldnew.documents.MediaStackDataDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MediaStackDocumentRepository extends ReactiveMongoRepository<MediaStackDataDocument, String> {

    Flux<MediaStackDataDocument> findByCategory(String category);
}
