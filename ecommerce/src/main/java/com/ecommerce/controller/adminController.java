package com.ecommerce.controller;

import com.ecommerce.Model.*;
import com.ecommerce.dao.MyCartRespository;
import com.ecommerce.dao.OrderRepository;
import com.ecommerce.dao.ProductRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class adminController {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MyCartRespository myCartRespository ;

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/dashboard")
    public String getAdmin(HttpSession session){

        boolean isAdmin = (boolean)session.getAttribute("admin_live") ;
        if(isAdmin == false ){
            return "redirct:/" ;
        }

        return "admin" ;
    }

    @GetMapping("/logout")
    public String returnToUser(HttpSession session){
        session.removeAttribute("admin_live");

        return "redirect:/" ;
    }

    @GetMapping("/show_orders")
    public String show_orders(Model model, HttpSession session){

        boolean isAdmin = (boolean)session.getAttribute("admin_live") ;
        if(isAdmin == false ){
            return "redirct:/" ;
        }

        try{
            List<myOrder> myorders = this.orderRepository.findAll() ;
            model.addAttribute("all_orders", myorders) ;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "show_orders" ;
    }






    @PostMapping("/add_product")
    public String add_product(Product product, HttpSession session, Model model){

        boolean isAdmin = (boolean)session.getAttribute("admin_live") ;
        if(isAdmin == false ){
            return "redirct:/" ;
        }

//        System.out.println(product);

        try{
            this.productRepository.save(product) ;
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/admin/dashboard" ;
    }

}
