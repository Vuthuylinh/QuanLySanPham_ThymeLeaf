package linhVu.model;


public class Product {
    private Integer id;
    private String image;
    private String name;
    private Integer price;


    public Product() {
    }

    public Product(Integer id, String image, String name, Integer price) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
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
