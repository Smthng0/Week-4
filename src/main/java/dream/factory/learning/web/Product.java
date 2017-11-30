package dream.factory.learning.web;

import com.google.gson.annotations.SerializedName;
import com.univocity.parsers.annotations.Parsed;

public class Product {
    @Parsed
    private String title;
    @Parsed
    private String url;
    @Parsed
    private int id;
    @Parsed
    private float price;
    @Parsed
    private String category;
    @Parsed
    @SerializedName("image_url")
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

