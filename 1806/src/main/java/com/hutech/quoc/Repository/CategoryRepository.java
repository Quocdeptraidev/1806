package com.hutech.quoc.Repository;

import com.hutech.quoc.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
