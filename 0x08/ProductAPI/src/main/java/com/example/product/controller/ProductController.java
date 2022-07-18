package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Product;
import com.example.product.model.ProductRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository products;
    
    
    @ApiOperation("- Responsável por adicionar um produto.")
    @ApiResponses(value = {
        @ApiResponse(code = 10, message = "Required fields not informed.")
    })
    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product p) {
        products.addProduct(p);
    }

    
    @ApiOperation("- Responsável por retornar uma lista de produtos.")
    @ApiResponses(value = {
        @ApiResponse(code = 11, message = "Warning - the process returned more than 1000 products.")
    })
    @GetMapping("/allProducts")
    @ResponseBody
    public List<Product> allProducts() {
        return products.getAllProducts();
    }

    
    @ApiOperation("- Responsável por retornar um produto pelo id.")
    @ApiResponses(value = {
        @ApiResponse(code = 12, message = "The field id not informed. This information is required.")
    })
    @GetMapping("/findProductById/{id}")
    @ResponseBody
    public Product findProductById(@PathVariable(value = "id") int id) {
        return products.getProductById(id);
    }

    
    @ApiOperation("- Responsável por remover um produto.")
    @ApiResponses(value = {
        @ApiResponse(code = 13, message = "User not allowed to remove a product from this category.")
    })
    @DeleteMapping("/removeProduct")
    public void removeProduct(@RequestBody Product p) {
        products.removeProduct(p);
    }

    
    @ApiOperation("- Responsável por atualizar um produto.")
    @ApiResponses(value = {
        @ApiResponse(code = 14, message = "No information has been updated. The new information is the same as recorded in the database.")
    })
    @PutMapping("/updateProduct")
    public void updateProduct(@RequestBody Product p) {
        products.updateProduct(p);
    }

    
    @GetMapping("/welcome")
    @ResponseBody
    @ApiOperation("- Responsável por retornar uma mensagem de boas-vindas.")
    public String welcome() {
        return "Welcome to the Products API!!!";
    }

}
