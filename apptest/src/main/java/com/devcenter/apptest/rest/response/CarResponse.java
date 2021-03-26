package com.devcenter.apptest.rest.response;

import com.devcenter.apptest.data.entity.Car;
import com.devcenter.apptest.data.entity.Price;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class CarResponse {

    private Long idCar;
    private Long idBrand;
    private List<Price> cost;

    public CarResponse(Car car) {
        idCar = car.getId();
        idBrand = car.getBrand().getId();
        cost = car.getPrice();
    }
}
