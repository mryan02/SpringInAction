package com.ryan.mifsud.taco_cloud.domain.DTO;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "TACO")
@NoArgsConstructor
public class Taco implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private TacoOrder order;

    @NotNull
    @Size(min=3, message="Name must be at least 3 characters long")
    private String name;

    @NotEmpty(message="You must choose at least 1 ingredient")
    @ManyToMany
    private List<Ingredient> ingredients;

    private Date createdAt = new Date();
}
