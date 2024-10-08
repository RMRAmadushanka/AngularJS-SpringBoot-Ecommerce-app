package com.rolan.ecommerce.config;


import com.rolan.ecommerce.entity.Product;
import com.rolan.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
        //disable HTTP methods for Product PUT and  DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
        
        //disable HTTP methods for Product category PUT and  DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));

    }
}
