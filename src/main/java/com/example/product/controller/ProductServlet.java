package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.utils.CSVLoader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductList")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = CSVLoader.getProductList();
        System.out.println(products);
        request.setAttribute("productList", products);
        request.getRequestDispatcher("product-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedProductId = request.getParameterValues("selectedProducts");

        if (selectedProductId != null) {
            List<Product> selectedProducts = new ArrayList<>();
            for (String id : selectedProductId) {
                Product product = CSVLoader.findProductById(Integer.parseInt(id));
                if (product != null) selectedProducts.add(product);
            }
            HttpSession session = request.getSession();
            session.setAttribute("selectedProducts", selectedProducts);
        }
        response.sendRedirect("cart.jsp");
    }

}