package com.devcenter.apptest.rest.controller;

import com.devcenter.apptest.data.entity.Car;
import com.devcenter.apptest.data.enumerated.ServiceEnum;
import com.devcenter.apptest.data.model.LogModel;
import com.devcenter.apptest.rest.response.CarResponse;
import com.devcenter.apptest.service.CarService;
import com.devcenter.apptest.service.RequestService;
import com.devcenter.apptest.util.DateUtil;
import com.devcenter.apptest.util.UtilExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/car")
public class CarContoller {


    @Autowired
    private CarService carService;

    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<CarResponse> getCar(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "applicationDate", required = false) String applicationDate, HttpServletRequest request){

        LogModel model = prepareData(request, ServiceEnum.SERVICIO1);
        carService.saveLog(model);
        return carService.getCar(id).stream().map(CarResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/busqueda")
    public List<CarResponse> getCarFilter(@RequestParam(value = "filter", required = false) String filter, HttpServletRequest request){
        LogModel model = prepareData(request, ServiceEnum.SERVICIO2);
        carService.saveLog(model);
        return carService.getCarFilter(filter).stream().map(CarResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=cars_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Car> listUsers = carService.getCar(1l);

        UtilExcel excelExporter = new UtilExcel(listUsers);

        excelExporter.export(response);
    }

    private LogModel prepareData(HttpServletRequest request, ServiceEnum service){
        String ip = requestService.getClientIp(request);
        LogModel model = new LogModel();
        model.setIp(ip);
        model.setServiceEnum(service.toString());
        model.setDateTime(DateUtil.toString(LocalDateTime.now()));
        return model;
    }
}
