package com.mertdev.test.dataAccess.abstracts;

import com.mertdev.test.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);
}
