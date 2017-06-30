package org.anuj.resource.controller;

import org.anuj.resource.domain.Product;
import org.anuj.resource.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequestMapping(value = "/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @PreAuthorize("hasRole('ADMIN')")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findOne(id);
    }
}
