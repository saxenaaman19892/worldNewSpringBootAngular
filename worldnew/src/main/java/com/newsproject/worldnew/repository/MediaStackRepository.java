package com.newsproject.worldnew.repository;

import com.newsproject.worldnew.documents.MediaStackDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaStackRepository extends ReactiveMongoRepository<MediaStackDocument, String> {
}
