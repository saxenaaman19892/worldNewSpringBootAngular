package com.newsproject.worldnew.dto;

import java.util.List;

public class MediaStackDto {

    private MediaStackPagination pagination;

    private List<MediaStackData> data;

    public MediaStackPagination getPagination() {
        return pagination;
    }

    public void setPagination(MediaStackPagination pagination) {
        this.pagination = pagination;
    }

    public List<MediaStackData> getData() {
        return data;
    }

    public void setData(List<MediaStackData> data) {
        this.data = data;
    }
}
