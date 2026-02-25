package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExamResultsDto {
    private Integer id;
    private Integer studentId;
    private Integer examId;
    private Double score;
}
