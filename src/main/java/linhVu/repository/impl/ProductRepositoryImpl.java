package linhVu.repository.impl;

import linhVu.model.Product;
import linhVu.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository{
    private static Map<Integer, Product> products = new HashMap<>();
    static {
        products.put(1,new Product(1,"phone1.jpg","Iphone7",17));
        products.put(2,new Product(2,"phone2.jpg","Iphone8",18));
        products.put(3,new Product(3,"phone3.jpg","IphoneX",19));
        products.put(4,new Product(4,"phone4.jpg","SamSung",20));
        products.put(5,new Product(5,"phone5.jpg","Nokia",10));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());

    }

    @Override
    public Product findById(int id) {
        return products.get(id);

    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList= findAll();
        List<Product> productSearchResponse = new ArrayList<>();
        String searchNameToLowerCase= name.toLowerCase().trim();
        for(Product product: productList){
            String productNameToLowerCase=product.getName().toLowerCase().trim();
            if(productNameToLowerCase.contains(searchNameToLowerCase)){
                productSearchResponse.add(product);
            }
        }
        return productSearchResponse;
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);

    }

    @Override
    public void update(int id, Product product) {
    products.put(id, product);
    }

    @Override
    public void remove(int id) {
    products.remove(id);
    }
}
