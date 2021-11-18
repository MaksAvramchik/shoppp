package by.shop.shop.controller;

import by.shop.shop.entyty.Product;
import by.shop.shop.entyty.ProductType;
import by.shop.shop.repository.ProductRepository;
import by.shop.shop.repository.ProductTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DefaultController {

    private static Logger logger = LoggerFactory.getLogger(DefaultController.class);


    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductRepository productRepository;



    @GetMapping("/")
    public String index(Model model) {
        logger.info("Home page запущена");
        Iterable<ProductType> types = productTypeRepository.findAll();
        Map<ProductType, List<Product>> map = new HashMap<>();
        types.forEach(type -> map.put(type, productRepository.findByProductType(type)));
        model.addAttribute("map", map);
        logger.info("index");
        return "index";

    }


    // @GetMapping("/product/{productId}")

// public String product(@PathVariable("productId") long id, Model model) {

// Product product = productRepository.findById(id).orElse(null);

// model.addAttribute("product", product);

// return "product";

// }

    @GetMapping("/product")

    public String product(@RequestParam("id") Long id, Model model) {

        Product product = productRepository.findById(id).orElse(null);

        model.addAttribute("product", product);

        return "product";

    }

    @GetMapping("/productTypeList")

    public String productTypeList(Model model) {

        Iterable<ProductType> types = productTypeRepository.findAll();

        model.addAttribute("types", types);

        return "productTypeList";

    }

    @GetMapping("/korzina")

    public String korzina(Model model) {

        Iterable<ProductType> types = productTypeRepository.findAll();

        model.addAttribute("types", types);

        return "korzina";

    }

    @GetMapping("productTypeList/add")

    public String productTypeListAdd(Model model) {

        ProductType productType = new ProductType();

        model.addAttribute("productType", productType);

        return "productTypeForm";

    }

    @PostMapping("productTypeList/add")

    public String productTypeListAddSubmit(@ModelAttribute ProductType productType, Model model){

        productTypeRepository.save(productType);

        model.addAttribute("types", productTypeRepository.findAll());

        return "productTypeList";

    }

    @GetMapping("/productTypeList/delete/{productTypeId}")

    public String productTypeListDelete(@PathVariable("productTypeId") long id, Model model) {

        productTypeRepository.deleteById(id);

        model.addAttribute("types", productTypeRepository.findAll());

        return "productTypeList";

    }

    @GetMapping("/productTypeList/edit/{productTypeId}")

    public String productTypeListEdit(@PathVariable("productTypeId") long id, Model model) {

        ProductType productType = productTypeRepository.findById(id).orElse(null);

        model.addAttribute("productType", productType);

        return "productTypeForm";

    }

}

