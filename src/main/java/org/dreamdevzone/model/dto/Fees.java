package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Fees {
    private Integer id;
    private Integer studentId;
    private Double fee;
    private Date dueDate;
    private Date paidDate;
}
