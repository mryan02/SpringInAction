package com.ryan.mifsud.taco_cloud.application;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ryan.mifsud.taco_cloud.domain.DTO.Ingredient;
import com.ryan.mifsud.taco_cloud.domain.DTO.Ingredient.Type;

import jakarta.validation.Valid;

import com.ryan.mifsud.taco_cloud.domain.DTO.Taco;
import com.ryan.mifsud.taco_cloud.domain.DTO.TacoOrder;
import com.ryan.mifsud.taco_cloud.infrastructure.IngredientRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;
    

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        log.info("Adding ingredients to model");
        
        final List<Ingredient> ingredients = ingredientRepository.findAll();

        final Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    
    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if(errors.hasErrors()) {
            log.info("Processing taco with errors: " + errors);
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: " + taco);
        return "redirect:/orders/current";
    }
    

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
            .filter(x -> x.getType().equals(type))
            .toList();
    }
    

}
