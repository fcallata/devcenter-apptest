package com.devcenter.apptest.data.repository;

import com.devcenter.apptest.data.entity.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepository extends CrudRepository<Brand, Long> {
}
