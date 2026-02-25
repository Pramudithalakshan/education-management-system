package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BorrowedBook {
    private Integer id;
    private Integer studentId;
    private Integer libraryId;
    private Date borrowDate;
    private Date returnDate;
}
