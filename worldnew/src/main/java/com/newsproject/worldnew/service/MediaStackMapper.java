package com.newsproject.worldnew.service;

import com.newsproject.worldnew.documents.MediaStackDataDocument;
import com.newsproject.worldnew.documents.MediaStackDocument;
import com.newsproject.worldnew.documents.MediaStackPaginationDocument;
import com.newsproject.worldnew.dto.MediaStackData;
import com.newsproject.worldnew.dto.MediaStackDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MediaStackMapper {

    public MediaStackDocument getDocmentFromDto(MediaStackDto dto) {
        MediaStackDocument document = new MediaStackDocument();

        MediaStackPaginationDocument paginationDocument = new MediaStackPaginationDocument();
        paginationDocument.setCount(dto.getPagination().getCount());
        paginationDocument.setLimit(dto.getPagination().getLimit());
        paginationDocument.setOffset(dto.getPagination().getOffset());
        paginationDocument.setTotal(dto.getPagination().getTotal());

        document.setPagination(paginationDocument);

        List<MediaStackDataDocument> dataDocuments = dto.getData().stream().map(data -> {
            MediaStackDataDocument dataDocument = new MediaStackDataDocument();
            dataDocument.setAuthor(data.getAuthor());
            dataDocument.setCategory(data.getCategory());
            dataDocument.setCountry(data.getCategory());
            dataDocument.setDescription(data.getDescription());
            dataDocument.setImage(data.getImage());
            dataDocument.setUrl(data.getUrl());
            dataDocument.setTitle(data.getTitle());
            dataDocument.setSource(data.getSource());
            dataDocument.setLanguage(data.getLanguage());
            dataDocument.setPublishedAt(data.getPublishedAt());
            return dataDocument;
        }).toList();

        document.setDataDocuments(dataDocuments);

        return document;
    }

    public MediaStackData getMediaStackDtoFromEntity(MediaStackDataDocument document) {
        MediaStackData data = new MediaStackData();

        data.setAuthor(document.getAuthor());
        data.setCategory(document.getCategory());
        data.setCountry(document.getCountry());
        data.setDescription(document.getDescription());
        data.setImage(document.getImage());
        data.setUrl(document.getUrl());
        data.setTitle(document.getTitle());
        data.setSource(document.getSource());
        data.setLanguage(document.getLanguage());
        data.setPublishedAt(document.getPublishedAt());

        return data;
    }
}
