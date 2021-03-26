package com.devcenter.logtest.service;

import com.devcenter.logtest.data.Log;
import com.devcenter.logtest.data.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void save(Log log){
        logRepository.save(log);
    }

    public List<Log> getAll(){
        return  logRepository.findAll();
    }
}
