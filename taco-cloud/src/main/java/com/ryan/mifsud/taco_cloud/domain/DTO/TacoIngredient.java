package com.ryan.mifsud.taco_cloud.domain.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity(name="TACO_INGREDIENT")
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE, force = true)
public class TacoIngredient {
    @Id
    private final String ingredientId;
    private final long tacoId;
    private final long sequence;
}
