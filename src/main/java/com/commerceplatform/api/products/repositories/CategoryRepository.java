package com.commerceplatform.api.products.repositories;

import com.commerceplatform.api.products.models.CategoryModel;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    @Query("SELECT COUNT(c) > 0 FROM CategoryModel c WHERE LOWER(c.name) = LOWER(:name)")
    boolean existsByNameIgnoreCaseAndWithoutAccent(@Param("name") String name);
}
