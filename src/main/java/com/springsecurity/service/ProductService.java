package com.springsecurity.service;

import com.springsecurity.entity.UserInfo;
import com.springsecurity.model.Products;
import com.springsecurity.respository.UserInfoRepositity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    List<Products> products;

    @Autowired
    private UserInfoRepositity userInfoRepositity;

    @PostConstruct
    public void loadProductFromDB() {

        products = IntStream.rangeClosed(0, 100)
                .mapToObj(i -> Products.builder()
                        .productId(i)
                        .productName("product " + i)
                        .productQuantity(new Random().nextInt(10))
                        .productPrice(new Random().nextInt(5000))
                        .build())
                .toList();
    }

    public List<Products> getProducts(){
        return products;
    }

    public Products productsById(int id){
        return products.stream()
                .filter(product -> product.getProductId()==id)
                .findAny()
                .orElseThrow(()-> new RuntimeException("Product " +id+" not found"));
    }

    public String saveUserDetail(UserInfo urserInfo){
        userInfoRepositity.save(urserInfo);
        return "user saved successfully";
    }
}
