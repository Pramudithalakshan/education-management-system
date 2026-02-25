package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Attendance {
    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Date date;
    private enum  Status {
        ABSENT,
        PRESENT
    }
    private Status status;

}
