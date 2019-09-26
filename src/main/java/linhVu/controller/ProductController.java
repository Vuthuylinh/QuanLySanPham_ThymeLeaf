package linhVu.controller;

import linhVu.model.Product;
import linhVu.model.ProductForm;
import linhVu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String listProduct(Model model){
        List<Product> productList= productService.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/create-product")
    public String createProductForm(Model model){
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/save-product")
    public ModelAndView createProduct(@ModelAttribute ProductForm productForm, BindingResult result){
        productForm.setId((int)(Math.random()*100));
        String fileName=productService.uploadFile(productForm,result);
        Product productObject= new Product(productForm.getId(),fileName,productForm.getName(),productForm.getPrice());
        productService.save(productObject);
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", productObject);
        modelAndView.addObject("success","A product is created successfully!");
        return modelAndView;
    }

    @GetMapping("product/{id}/edit")
    public String editProductForm(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/product/update")
    public ModelAndView updateProduct(ProductForm productForm, BindingResult result){

        Product productObject= productService.findById(productForm.getId());
        String fileName=productService.uploadFile(productForm,result);
        if(!fileName.equals("")){
            productObject.setImage(fileName);
        }
        productObject.setName(productForm.getName());
        productObject.setPrice(productForm.getPrice());
        productService.save(productObject);
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", productObject);
        modelAndView.addObject("success","Product is updated successfully!");
        return modelAndView;
    }

    @GetMapping("/product/{id}/delete")
    public String deleteForm(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/delete";
    }

    @PostMapping("/product/delete")
    public String deleteProduct(Product product){
        productService.remove(product.getId());
        return "redirect:/";

    }
    @RequestMapping("product/{id}/view")
    public String viewDetailProduct(@PathVariable int id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "product/view";
    }


    @GetMapping("/search-product")
    public  String searchProduct(){
        return "product/searchForm";
    }
    @PostMapping("/searchProductResult")
    public ModelAndView searchProductResult(@RequestParam("search-by-name") String name){
        List<Product> productSearchList= productService.findByName(name);
        ModelAndView modelAndView = new ModelAndView("product/searchResult");
        modelAndView.addObject("productSearchList", productSearchList);
        return modelAndView ;
    }

}
