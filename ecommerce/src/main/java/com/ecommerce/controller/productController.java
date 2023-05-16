package com.ecommerce.controller;

import com.ecommerce.Model.MyCart;
import com.ecommerce.Model.Product;
import com.ecommerce.dao.MyCartRespository;
import com.ecommerce.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class productController {

    @Autowired
    private ProductRepository productRepository ;


    @Autowired
    private MyCartRespository myCartRespository ;

    @GetMapping("/getProducts/{category}")
    public ResponseEntity<?> getProducts(@PathVariable("category") String category){

//        System.out.println("came to get products");
        if(category.equals("allProducts")){
            List<Product> result = this.productRepository.findAll() ;
            return  ResponseEntity.ok(result) ;
        }

        List<Product> result = this.productRepository.getProductByCategory(category) ;


        return ResponseEntity.ok(result) ;
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable("id") String id){

        try {
            Product product = this.productRepository.findById(Integer.parseInt(id)).get();
            return product ;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null ;
    }

    @GetMapping("/addInCart/{id}")
    public ResponseEntity<String> addToCart(@PathVariable("id") String id){

        try {

            this.myCartRespository.save(new MyCart(Integer.parseInt(id), 1)) ; // be default quantity is 1
            return ResponseEntity.ok("Added") ;

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok("Somethings wrong!") ;
    }

    @GetMapping("/updateInCart/{id}/{quantity}")
    public ResponseEntity<String> updateInCart(@PathVariable("id") String id, @PathVariable("quantity") String quantity){

        try {

            List<MyCart> cart_items = this.myCartRespository.findAll() ;

            for(MyCart cart : cart_items){
                if (cart.getId() == Integer.parseInt(id)){
                    cart.setQuantity(Integer.parseInt(quantity));
                    this.myCartRespository.save(cart);
                    break;
                }
            }


            return ResponseEntity.ok("updated") ;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.ok("Somethings wrong!") ;
    }


}
