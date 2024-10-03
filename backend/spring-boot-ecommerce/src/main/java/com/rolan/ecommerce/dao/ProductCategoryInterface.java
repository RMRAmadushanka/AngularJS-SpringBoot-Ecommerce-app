package com.rolan.ecommerce.dao;

import com.rolan.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryInterface extends JpaRepository<ProductCategory, Integer> {
}
