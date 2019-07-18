package com.intdv.newsly.model;

public class NewsArticle {

    private String title;
    private String description;
    private String url;
    private String imageUrl;



    public String getTitle() {
        return "Breaking news test title";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return "This is a long descriptionThis is a long descriptionThis is a long descriptionThis is a long descriptionThis is a long description";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return "https://cdn.cnn.com/cnnnext/dam/assets/190718132701-netflix-reed-hastings-rome-file-super-tease.jpg";
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
