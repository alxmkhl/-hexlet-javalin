package org.example.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class Course {
    private String id;

    @ToString.Include
    private String name;
    private String description;

    public Course(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}