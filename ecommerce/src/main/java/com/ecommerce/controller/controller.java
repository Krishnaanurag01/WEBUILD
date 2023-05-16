package com.ecommerce.controller;

import com.ecommerce.Model.Message;
import com.ecommerce.Model.Product;
import com.ecommerce.Model.User;
import com.ecommerce.dao.ProductRepository;
import com.ecommerce.dao.UserRespository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class controller {

    @Autowired
    private UserRespository userRespository ;

    @Autowired
    private ProductRepository productRepository ;

    @GetMapping("/")
    public String home(HttpSession session){

        if(session.getAttribute("loggedIn_user") != null){
            System.out.println("already logged in");
            return "redirect:/loggedIn/products" ;
        }

//        productRepository.save( new Product("Black Marble Self Adhesive Wall Stickers", "https://rukminim1.flixcart.com/image/416/416/xif0q/sticker/p/y/6/medium-marble-aluminum-foil-kitchen-waterproof-self-adhesive-original-imagggazsqrwfhbb.jpeg?q=70", "They are recommended for bedroom, study, dining room, living room, kitchen, bathroom renovation or decoration, notebook, dishwasher ,refrigerator ,countertop, backsplashes, photo backdrop, wardrobe?closet, bookshelf , desk, bar table, cupboard, doors, mirror, window where smooth and flat are all available. there have measure-and-cut grid on backing paper ,very easy to install, no extra glue needed, no experience needed : cut the right size - peel off the backing paper - paste carefully. itchen self stickers sheet Lift time : Safe for walls, peel off the wallpaper without sticky residue, if any questions, it is our honor to offer services and products, we offer lift-time product service. Multipurpose use and: great for covering any size kitchen cabinet, dresser drawer, craft projects, nightstand, bookcase, shelf, door and even wall. Self-adhesive and removable: peel off the adhesive backing paper and stick to any dry flat surface. Pvc material, waterproof, dust-proof and moisture-proof wipes clean with a damp cloth or sponge. Quality :- Matte smooth finish vinyl, self adhesive wallpaper, peel and stick wallpaper, easy to apply, waterproof and durable material. We use green guard certified inks safe for kids, humidity resistant.", "220", "interiorDesign")) ;
//        productRepository.save( new Product("Black Marble Self Adhesive Wall Stickers", "https://rukminim1.flixcart.com/image/416/416/xif0q/sticker/p/y/6/medium-marble-aluminum-foil-kitchen-waterproof-self-adhesive-original-imagggazsqrwfhbb.jpeg?q=70", "They are recommended for bedroom, study, dining room, living room, kitchen, bathroom renovation or decoration, notebook, dishwasher ,refrigerator ,countertop, backsplashes, photo backdrop, wardrobe?closet, bookshelf , desk, bar table, cupboard, doors, mirror, window where smooth and flat are all available. there have measure-and-cut grid on backing paper ,very easy to install, no extra glue needed, no experience needed : cut the right size - peel off the backing paper - paste carefully. itchen self stickers sheet Lift time : Safe for walls, peel off the wallpaper without sticky residue, if any questions, it is our honor to offer services and products, we offer lift-time product service. Multipurpose use and: great for covering any size kitchen cabinet, dresser drawer, craft projects, nightstand, bookcase, shelf, door and even wall. Self-adhesive and removable: peel off the adhesive backing paper and stick to any dry flat surface. Pvc material, waterproof, dust-proof and moisture-proof wipes clean with a damp cloth or sponge. Quality :- Matte smooth finish vinyl, self adhesive wallpaper, peel and stick wallpaper, easy to apply, waterproof and durable material. We use green guard certified inks safe for kids, humidity resistant.", "220", "homeDecor")) ;
//
//        productRepository.save( new Product("Black Marble Self Adhesive Wall Stickers", "https://rukminim1.flixcart.com/image/416/416/xif0q/sticker/p/y/6/medium-marble-aluminum-foil-kitchen-waterproof-self-adhesive-original-imagggazsqrwfhbb.jpeg?q=70", "They are recommended for bedroom, study, dining room, living room, kitchen, bathroom renovation or decoration, notebook, dishwasher ,refrigerator ,countertop, backsplashes, photo backdrop, wardrobe?closet, bookshelf , desk, bar table, cupboard, doors, mirror, window where smooth and flat are all available. there have measure-and-cut grid on backing paper ,very easy to install, no extra glue needed, no experience needed : cut the right size - peel off the backing paper - paste carefully. itchen self stickers sheet Lift time : Safe for walls, peel off the wallpaper without sticky residue, if any questions, it is our honor to offer services and products, we offer lift-time product service. Multipurpose use and: great for covering any size kitchen cabinet, dresser drawer, craft projects, nightstand, bookcase, shelf, door and even wall. Self-adhesive and removable: peel off the adhesive backing paper and stick to any dry flat surface. Pvc material, waterproof, dust-proof and moisture-proof wipes clean with a damp cloth or sponge. Quality :- Matte smooth finish vinyl, self adhesive wallpaper, peel and stick wallpaper, easy to apply, waterproof and durable material. We use green guard certified inks safe for kids, humidity resistant.", "220", "hardwares")) ;
//        productRepository.save( new Product("Black Marble Self Adhesive Wall Stickers", "https://rukminim1.flixcart.com/image/416/416/xif0q/sticker/p/y/6/medium-marble-aluminum-foil-kitchen-waterproof-self-adhesive-original-imagggazsqrwfhbb.jpeg?q=70", "They are recommended for bedroom, study, dining room, living room, kitchen, bathroom renovation or decoration, notebook, dishwasher ,refrigerator ,countertop, backsplashes, photo backdrop, wardrobe?closet, bookshelf , desk, bar table, cupboard, doors, mirror, window where smooth and flat are all available. there have measure-and-cut grid on backing paper ,very easy to install, no extra glue needed, no experience needed : cut the right size - peel off the backing paper - paste carefully. itchen self stickers sheet Lift time : Safe for walls, peel off the wallpaper without sticky residue, if any questions, it is our honor to offer services and products, we offer lift-time product service. Multipurpose use and: great for covering any size kitchen cabinet, dresser drawer, craft projects, nightstand, bookcase, shelf, door and even wall. Self-adhesive and removable: peel off the adhesive backing paper and stick to any dry flat surface. Pvc material, waterproof, dust-proof and moisture-proof wipes clean with a damp cloth or sponge. Quality :- Matte smooth finish vinyl, self adhesive wallpaper, peel and stick wallpaper, easy to apply, waterproof and durable material. We use green guard certified inks safe for kids, humidity resistant.", "220", "constructionMaterial")) ;
//
//        productRepository.save( new Product("Black Marble Self Adhesive Wall Stickers", "https://rukminim1.flixcart.com/image/416/416/xif0q/sticker/p/y/6/medium-marble-aluminum-foil-kitchen-waterproof-self-adhesive-original-imagggazsqrwfhbb.jpeg?q=70", "They are recommended for bedroom, study, dining room, living room, kitchen, bathroom renovation or decoration, notebook, dishwasher ,refrigerator ,countertop, backsplashes, photo backdrop, wardrobe?closet, bookshelf , desk, bar table, cupboard, doors, mirror, window where smooth and flat are all available. there have measure-and-cut grid on backing paper ,very easy to install, no extra glue needed, no experience needed : cut the right size - peel off the backing paper - paste carefully. itchen self stickers sheet Lift time : Safe for walls, peel off the wallpaper without sticky residue, if any questions, it is our honor to offer services and products, we offer lift-time product service. Multipurpose use and: great for covering any size kitchen cabinet, dresser drawer, craft projects, nightstand, bookcase, shelf, door and even wall. Self-adhesive and removable: peel off the adhesive backing paper and stick to any dry flat surface. Pvc material, waterproof, dust-proof and moisture-proof wipes clean with a damp cloth or sponge. Quality :- Matte smooth finish vinyl, self adhesive wallpaper, peel and stick wallpaper, easy to apply, waterproof and durable material. We use green guard certified inks safe for kids, humidity resistant.", "220", "homeDecor")) ;
//        productRepository.save( new Product("Black Marble Self Adhesive Wall Stickers", "https://rukminim1.flixcart.com/image/416/416/xif0q/sticker/p/y/6/medium-marble-aluminum-foil-kitchen-waterproof-self-adhesive-original-imagggazsqrwfhbb.jpeg?q=70", "They are recommended for bedroom, study, dining room, living room, kitchen, bathroom renovation or decoration, notebook, dishwasher ,refrigerator ,countertop, backsplashes, photo backdrop, wardrobe?closet, bookshelf , desk, bar table, cupboard, doors, mirror, window where smooth and flat are all available. there have measure-and-cut grid on backing paper ,very easy to install, no extra glue needed, no experience needed : cut the right size - peel off the backing paper - paste carefully. itchen self stickers sheet Lift time : Safe for walls, peel off the wallpaper without sticky residue, if any questions, it is our honor to offer services and products, we offer lift-time product service. Multipurpose use and: great for covering any size kitchen cabinet, dresser drawer, craft projects, nightstand, bookcase, shelf, door and even wall. Self-adhesive and removable: peel off the adhesive backing paper and stick to any dry flat surface. Pvc material, waterproof, dust-proof and moisture-proof wipes clean with a damp cloth or sponge. Quality :- Matte smooth finish vinyl, self adhesive wallpaper, peel and stick wallpaper, easy to apply, waterproof and durable material. We use green guard certified inks safe for kids, humidity resistant.", "220", "constructionMaterial")) ;
//
//        productRepository.save( new Product("Black Marble Self Adhesive Wall Stickers", "https://rukminim1.flixcart.com/image/416/416/xif0q/sticker/p/y/6/medium-marble-aluminum-foil-kitchen-waterproof-self-adhesive-original-imagggazsqrwfhbb.jpeg?q=70", "They are recommended for bedroom, study, dining room, living room, kitchen, bathroom renovation or decoration, notebook, dishwasher ,refrigerator ,countertop, backsplashes, photo backdrop, wardrobe?closet, bookshelf , desk, bar table, cupboard, doors, mirror, window where smooth and flat are all available. there have measure-and-cut grid on backing paper ,very easy to install, no extra glue needed, no experience needed : cut the right size - peel off the backing paper - paste carefully. itchen self stickers sheet Lift time : Safe for walls, peel off the wallpaper without sticky residue, if any questions, it is our honor to offer services and products, we offer lift-time product service. Multipurpose use and: great for covering any size kitchen cabinet, dresser drawer, craft projects, nightstand, bookcase, shelf, door and even wall. Self-adhesive and removable: peel off the adhesive backing paper and stick to any dry flat surface. Pvc material, waterproof, dust-proof and moisture-proof wipes clean with a damp cloth or sponge. Quality :- Matte smooth finish vinyl, self adhesive wallpaper, peel and stick wallpaper, easy to apply, waterproof and durable material. We use green guard certified inks safe for kids, humidity resistant.", "220", "constructionMaterial")) ;
//        productRepository.save( new Product("Black Marble Self Adhesive Wall Stickers", "https://rukminim1.flixcart.com/image/416/416/xif0q/sticker/p/y/6/medium-marble-aluminum-foil-kitchen-waterproof-self-adhesive-original-imagggazsqrwfhbb.jpeg?q=70", "They are recommended for bedroom, study, dining room, living room, kitchen, bathroom renovation or decoration, notebook, dishwasher ,refrigerator ,countertop, backsplashes, photo backdrop, wardrobe?closet, bookshelf , desk, bar table, cupboard, doors, mirror, window where smooth and flat are all available. there have measure-and-cut grid on backing paper ,very easy to install, no extra glue needed, no experience needed : cut the right size - peel off the backing paper - paste carefully. itchen self stickers sheet Lift time : Safe for walls, peel off the wallpaper without sticky residue, if any questions, it is our honor to offer services and products, we offer lift-time product service. Multipurpose use and: great for covering any size kitchen cabinet, dresser drawer, craft projects, nightstand, bookcase, shelf, door and even wall. Self-adhesive and removable: peel off the adhesive backing paper and stick to any dry flat surface. Pvc material, waterproof, dust-proof and moisture-proof wipes clean with a damp cloth or sponge. Quality :- Matte smooth finish vinyl, self adhesive wallpaper, peel and stick wallpaper, easy to apply, waterproof and durable material. We use green guard certified inks safe for kids, humidity resistant.", "220", "homeDecor")) ;




        return "index" ;
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model){

        User user = this.userRespository.getUserByUsername(email) ;

        if(user != null){
            Message msg = new Message("Account already exist", "alert-danger") ;
            session.setAttribute("message", msg) ;
            return "redirect:/" ;
        }

        try{
            User newUser = new User(email,password,"none","na","na","na","na") ;
            this.userRespository.save(newUser) ;
            session.setAttribute("loggedIn_user", newUser) ;
            model.addAttribute("loggedIn_user", newUser) ;
            return "redirect:/loggedIn/products" ;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/" ;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model){

        try{
            if(email.equals("webuild.admin02@admin.com") ){
                if(password.equals("admin@9842")) {
                    session.setAttribute("admin_live",true);
                    return "redirect:/admin/dashboard";
                }
            }

            User user = this.userRespository.getUserByUsername(email) ;
            if(user == null){
                Message msg = new Message("Account does not exist", "alert-danger") ;
                session.setAttribute("message", msg) ;
                return "redirect:/" ;
            }
            else if(user.getPassword().equals(password) == false){
                Message msg = new Message("Wrong password!", "alert-danger") ;
                session.setAttribute("message", msg) ;
                return "redirect:/" ;
            }
            model.addAttribute("loggedIn_user", user) ;
            session.setAttribute("loggedIn_user", user) ;

        }
        catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/loggedIn/products" ;
    }

}
