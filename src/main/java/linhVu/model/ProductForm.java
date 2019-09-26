package linhVu.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class ProductForm {
    private Integer id;
    private MultipartFile image;
    private String name;
    private Integer price;


    public ProductForm() {
    }

    public ProductForm(Integer id, MultipartFile image, String name, Integer price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
