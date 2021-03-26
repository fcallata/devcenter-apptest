package com.devcenter.logtest.data;

import com.devcenter.logtest.data.enumerated.ServiceEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter @Setter
@Document
public class Log {

    @Id
    private String id;
    private String ip;
    private LocalDateTime dateTime;
    private ServiceEnum serviceEnum;
}
