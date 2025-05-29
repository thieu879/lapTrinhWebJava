package com.data.ss15.model.bt6;

public class Review {
    private String idReview;
    private String idUser;
    private String idProduct;
    private String comment;
    private int rating;

    public Review() {}

    public Review(String idReview, String idUser, String idProduct, String comment, int rating) {
        this.idReview = idReview;
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.comment = comment;
        this.rating = rating;
    }

    public String getIdReview() { return idReview; }
    public void setIdReview(String idReview) { this.idReview = idReview; }

    public String getIdUser() { return idUser; }
    public void setIdUser(String idUser) { this.idUser = idUser; }

    public String getIdProduct() { return idProduct; }
    public void setIdProduct(String idProduct) { this.idProduct = idProduct; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}


