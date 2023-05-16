package com.ecommerce.controller;

import com.ecommerce.Model.*;

import com.ecommerce.dao.*;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("loggedIn")
public class loggedController {

    @Autowired
    ProductRepository productRepository ;
    @Autowired
    MyCartRespository myCartRespository ;

    @Autowired
    UserRespository userRespository ;

    @Autowired
    OrderRepository orderRepository ;

    @ModelAttribute
    public void commonData(Model model, HttpSession session){
        if(session.getAttribute("loggedIn_user") != null){
            model.addAttribute("loggedIn_user", session.getAttribute("loggedIn_user")) ;
        }
    }

    @GetMapping("/products")
    public String productPage(Model model, HttpSession session){

        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }

        User user = (User)session.getAttribute("loggedIn_user") ;
        model.addAttribute("loggedIn_user", user) ;

//        System.out.println("model user - " + model.getAttribute("loggedIn_user"));
//        System.out.println("session object - " + session.getAttribute("loggedIn_user"));

        List<Product> result = this.productRepository.findAll() ;
        model.addAttribute("all_products",result);



        return "/login/products" ;
    }


    @GetMapping("/about")
    public String about(HttpSession session){
        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }

        return "/login/about" ;
    }


    @GetMapping("/contact")
    public String contact(HttpSession session){

        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }

        return "/login/contact" ;
    }


    @GetMapping("/pricing")
    public String pricing(HttpSession session){
        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }
        return "/login/pricing" ;
    }


    @GetMapping("/projects")
    public String projects(HttpSession session){
        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }

        return "/login/projects" ;
    }


    @GetMapping("/services")
    public String services(HttpSession session){
        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }

        return "/login/services" ;
    }

    @GetMapping("/mycart")
    public String mycart(Model m, HttpSession session){
//        System.out.println(m.getAttribute("loggedIn_user"));
        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }



        try{
            List<MyCart> cart = this.myCartRespository.findAll() ;
            List<Product> cart_products = new ArrayList<>( );
            int totalSum = 0 ;

            for(MyCart myCart : cart){
                Product product= this.productRepository.findById(myCart.getProduct_id()).get();
                cart_products.add(product) ;
                totalSum += Integer.parseInt(product.getPrice()) ;
            }

            m.addAttribute("cart_products",cart_products) ;
            m.addAttribute("cart_products_sum", totalSum);



        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "/login/mycart" ;
    }


    @GetMapping("/profile")
//    @ResponseBody
    public String profile(Model model, HttpSession session){

        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }


        User user = (User) session.getAttribute("loggedIn_user") ;

        model.addAttribute("loggedIn_user", user ) ;

//        System.out.println( "profile model" + model.getAttribute("loggedIn_user"));

        return "/login/profile" ;
    }

    @GetMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable("id") String id, Model model, HttpSession session){

        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }


        System.out.println("remove Product called");
        try{
            List<MyCart> result = this.myCartRespository.findAll() ;

            for(MyCart c : result){
                if(c.getProduct_id() == Integer.parseInt(id)){
                  this.myCartRespository.delete(c);
                  id = "#" ;
                }
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

        return "redirect:/loggedIn/mycart";
    }

    @GetMapping("/ordernow/{price}")
    public String orderNow(@PathVariable("price") String price, Model model, HttpSession session){

        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }


        User user = (User) session.getAttribute("loggedIn_user") ;

        model.addAttribute("loggedIn_user", new User() ) ;
        model.addAttribute("total_price", price) ;

//        System.out.println( "order model" + model.getAttribute("loggedIn_user"));

        return "/login/orderNow" ;
    }

    @PostMapping("/updateProfile")
    public String updateProfile( User user, Model m, HttpSession session){

        if(session.getAttribute("loggedIn_user") == null){
            return "redirect:/" ;
        }


        System.out.println("update profile "+  user);

        User original_user = this.userRespository.getUserByUsername(user.getEmail()) ;

        original_user.setCity(user.getCity());
        original_user.setName(user.getName());
        original_user.setPincode(user.getPincode());
        original_user.setLocalAddress(user.getLocalAddress());
        original_user.setState(user.getState());

        this.userRespository.save(original_user) ;

        m.addAttribute("loggedIn_user",original_user);
        session.setAttribute("loggedIn_user",original_user);


        return "redirect:/loggedIn/profile" ;
    }


    // create payment
    @PostMapping("/create_order")
    @ResponseBody
    public String createOrder(@RequestBody Map<String, Object> map) throws Exception {
//        System.out.println(map);
        int amount = Integer.parseInt(map.get("amount").toString());
        var client = new RazorpayClient("rzp_test_ngFOPthVp93pWx", "hOfFbqDFz825JmoeLUaWWLOI");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount", amount*100);
        jsonObject.put("currency", "INR");
        jsonObject.put("receipt", "txn_123456");

        Order order = client.orders.create(jsonObject);
        System.out.println(order.toString());

        return order.toString();
    }

     @GetMapping("/logout")
    public String logoutUser(HttpSession session, Model model){

        session.removeAttribute(("loggedIn_user"));

        return "redirect:/" ;
     }




     @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(@RequestBody Map<String,Object> data, HttpSession session){

        try{
            Map<String,Integer> order_details = new HashMap<>() ; // storing product_id and it's quantity
            List<MyCart> cartList = this.myCartRespository.findAll();

            for(MyCart cart : cartList){
                order_details.put("product_"+cart.getProduct_id(), order_details.getOrDefault("product_"+cart.getProduct_id(),0)+ cart.getQuantity()) ;
            }

            StringBuilder ordered_products_sb = new StringBuilder() ;
            for(String product: order_details.keySet()){
                ordered_products_sb.append(product + " : " + order_details.get(product)+" , ") ;
            }

            String ordered_products_summary = ordered_products_sb.toString() ;

//            System.out.println(data);

            myOrder order = new myOrder() ;

            String orderId = data.get("orderId") != null ? data.get("orderId").toString() : "null" ;
            String paymentId = data.get("paymentId") != null ? data.get("paymentId").toString() : "null" ;
            String orderAddress = data.get("orderAddress") != null ? data.get("orderAddress").toString() : "null" ;
            String orderAmount = data.get("orderAmount") != null ? data.get("orderAmount").toString() : "null" ;

            order.setDetails(ordered_products_summary);
            order.setOrderId(orderId);
            order.setPaymentId(paymentId);
            order.setAddress(orderAddress);
            order.setAmount(orderAmount);


            this.orderRepository.save(order) ;
//            System.out.println(order);
            this.myCartRespository.deleteAll();  // deleting everything from my cart after placing order

        }
        catch (Exception e) {
            e.printStackTrace();
        }


        return ResponseEntity.ok(Map.of("msg","updated")) ;
     }
}
