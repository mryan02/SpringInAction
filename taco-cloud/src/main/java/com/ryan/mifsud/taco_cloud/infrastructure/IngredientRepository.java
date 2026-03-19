package com.ryan.mifsud.taco_cloud.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ryan.mifsud.taco_cloud.domain.DTO.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
  
}
