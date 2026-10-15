package br.com.fiap.recipeplan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.UUID;

@Data
public class Ingredient {
    @JsonIgnore
    private final UUID id = UUID.randomUUID();
    private String name;
    private String quantity;
    private String unit;
}
