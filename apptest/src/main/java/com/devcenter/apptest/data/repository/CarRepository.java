package com.devcenter.apptest.data.repository;

import com.devcenter.apptest.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT c FROM Car c WHERE c.id = 1")
    public List<Car> findCarByIdAndDate();

    @Query(value = "SELECT * FROM car INNER JOIN brand ON car.id_brand = brand.id WHERE brand.name like ?1", nativeQuery = true)
    public List<Car> findAllByCarFilter(String filter);
}
