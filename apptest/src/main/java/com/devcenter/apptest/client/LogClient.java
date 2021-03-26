package com.devcenter.apptest.client;

import com.devcenter.apptest.data.model.LogModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient( name = "logClient", url = "${api.log.url}")
public interface LogClient {

    @PostMapping("log")
    public void addLog(@RequestBody LogModel request);

    @GetMapping("/log")
    public List<LogModel> getAll();
}
