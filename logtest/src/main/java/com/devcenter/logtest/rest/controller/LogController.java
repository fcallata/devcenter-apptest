package com.devcenter.logtest.rest.controller;

import com.devcenter.logtest.data.Log;
import com.devcenter.logtest.rest.request.LogRequest;
import com.devcenter.logtest.rest.response.LogResponse;
import com.devcenter.logtest.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public void addLog(@RequestBody LogRequest request) {
        logService.save(request.toDocument(new Log()));
    }

    @GetMapping
    public List<LogResponse> getAll(){
        return logService.getAll().stream().map(LogResponse::new).collect(Collectors.toList());
    }
}
