package com.devcenter.logtest.rest.response;

import com.devcenter.logtest.data.Log;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
public class LogResponse {

    private String ip;
    private String dateTime;
    private String serviceEnum;

    public LogResponse(Log log) {
        ip =log.getIp();
        dateTime = log.getDateTime().toString();
        serviceEnum = log.getServiceEnum().toString();
    }
}
