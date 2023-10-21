package com.example.product.utils;

import com.example.product.model.Product;
import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVLoader {
    @Getter
    static List<Product> productList = new ArrayList<>();

    static {
        init();
    }

    private static void init() {
        InputStream inputStream = CSVLoader.class.getClassLoader().getResourceAsStream("products.csv");
        if (inputStream == null) {
            System.out.println("Error: Could not find products.csv");
            return;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Product product = new Product();
                product.setId(Integer.parseInt(values[0]));
                product.setTitle(values[1].trim());
                product.setDescription(values[2].trim());
                productList.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product findProductById(int id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
