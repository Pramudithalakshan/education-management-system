package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exam {
    private Integer id;
    private String name;
    private Integer courseId;
    private Integer examTypeId;
    private Date date;
}
