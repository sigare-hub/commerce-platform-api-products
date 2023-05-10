package com.commerceplatform.api.stock.repositories;

import com.commerceplatform.api.stock.models.CategoryModel;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    @Query("SELECT COUNT(c) > 0 FROM CategoryModel c WHERE LOWER(c.name) = LOWER(:name)")
    boolean existsByNameIgnoreCaseAndWithoutAccent(@Param("name") String name);
}
