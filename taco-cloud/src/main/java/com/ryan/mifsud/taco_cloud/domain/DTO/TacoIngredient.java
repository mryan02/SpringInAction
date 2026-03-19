package com.ryan.mifsud.taco_cloud.domain.DTO;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Table("TACO_INGREDIENT")
public class TacoIngredient {
    @Id
    private final String ingredientId;
    private final long tacoId;
    private final long sequence;
}
