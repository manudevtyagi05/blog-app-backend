package com.blogapp.repository;

import com.blogapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // Extra query methods (if needed) can go here
}
