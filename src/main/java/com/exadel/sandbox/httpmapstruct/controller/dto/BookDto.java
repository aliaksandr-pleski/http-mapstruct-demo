package com.exadel.sandbox.httpmapstruct.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;
    private String writer;
    private String title;
    private String text;
}
