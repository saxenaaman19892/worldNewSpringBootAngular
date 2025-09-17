package com.newsproject.worldnew.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "media_stack")
public class MediaStackDocument {

    @Id
    private String id;

    private MediaStackPaginationDocument pagination;

    private List<MediaStackDataDocument> dataDocuments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MediaStackPaginationDocument getPagination() {
        return pagination;
    }

    public void setPagination(MediaStackPaginationDocument pagination) {
        this.pagination = pagination;
    }

    public List<MediaStackDataDocument> getDataDocuments() {
        return dataDocuments;
    }

    public void setDataDocuments(List<MediaStackDataDocument> dataDocuments) {
        this.dataDocuments = dataDocuments;
    }
}
