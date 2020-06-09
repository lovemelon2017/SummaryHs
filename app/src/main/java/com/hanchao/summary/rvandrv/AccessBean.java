package com.hanchao.summary.rvandrv;

import java.util.List;

public class AccessBean {
    private String title;
    private List<String> images;
    private int ratingNum1;//商家评分
    private int ratingNum2;//服务评分


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getRatingNum1() {
        return ratingNum1;
    }

    public void setRatingNum1(int ratingNum1) {
        this.ratingNum1 = ratingNum1;
    }

    public int getRatingNum2() {
        return ratingNum2;
    }

    public void setRatingNum2(int ratingNum2) {
        this.ratingNum2 = ratingNum2;
    }

}
