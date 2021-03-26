package com.devcenter.apptest.service;

import com.devcenter.apptest.client.LogClient;
import com.devcenter.apptest.data.entity.Car;
import com.devcenter.apptest.data.model.LogModel;
import com.devcenter.apptest.data.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private LogClient client;

    public List<Car> getCar(Long id){
        return carRepository.findCarByIdAndDate();
    }

    public List<Car> getCarFilter(String filter){
        return carRepository.findAllByCarFilter(filter);
    }

    public void saveLog(LogModel model){
        client.addLog(model);
    }

    public List<LogModel> getLog(){
        return client.getAll();
    }
}
