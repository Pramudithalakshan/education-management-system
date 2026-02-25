package org.dreamdevzone.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Library {
    private Integer id;
    private String title;
    private String author;
    private String isbn;
    private Integer quantity;
}
