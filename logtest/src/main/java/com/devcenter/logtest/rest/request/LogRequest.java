package com.devcenter.logtest.rest.request;

import com.devcenter.logtest.data.Log;
import com.devcenter.logtest.data.enumerated.ServiceEnum;
import com.devcenter.logtest.util.DateUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class LogRequest {

    private String ip;
    private String dateTime;
    private String serviceEnum;

    public Log toDocument(Log log){
        log.setIp(ip);
        log.setDateTime(DateUtil.toLocalDateTime(dateTime));
        log.setServiceEnum(ServiceEnum.valueOf(serviceEnum));
        return log;
    }
}
