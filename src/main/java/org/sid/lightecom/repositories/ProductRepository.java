package org.sid.lightecom.repositories;

import org.sid.lightecom.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin("*")
public interface ProductRepository extends JpaRepository<Product,Long> {
    @RestResource(path = "/selectedProducts")
    public List<Product> findBySelectedIsTrue();

    @RestResource(path = "/promotedProducts")
    public List<Product> findByPromotionIsTrue();

    @RestResource(path = "/availableProducts")
    public List<Product> findByAvailableIsTrue();

    @RestResource(path = "/productsByKeyword")
    public List<Product> findByNameContains(@Param("mc") String mc);

   // @RestResource(path = "/productsByKeyword/{}")
   // @Query("select p from Product p where p.name like :x")
   // public List<Product> chercher(@Param("x") String mc);

}
