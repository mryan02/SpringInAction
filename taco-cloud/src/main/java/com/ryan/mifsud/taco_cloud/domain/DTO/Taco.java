package com.ryan.mifsud.taco_cloud.domain.DTO;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco implements java.io.Serializable {
    @Id
    private long id;

    @NotNull
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @NotEmpty(message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    private Date createdAt = new Date();
}
