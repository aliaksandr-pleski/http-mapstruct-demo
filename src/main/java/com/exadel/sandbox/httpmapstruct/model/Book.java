package com.exadel.sandbox.httpmapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private String id;
    private String author;
    private String title;
    private String text;
    private int version;
}
