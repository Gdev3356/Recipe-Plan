package br.com.fiap.recipeplan.service;

import br.com.fiap.recipeplan.model.Recipe;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    private final ChatClient chatClient;

    public RecipeService(ChatClient.Builder builder) {
        this.chatClient = builder
                .defaultSystem("""
                        Você é um chef de cozinha. Crie receitas em português do Brasil,
                        com nome, descrição curta, lista de ingredientes (nome, quantidade e unidade)
                        e instruções de preparo em um único parágrafo.
                        """)
                .build();
    }

    public Recipe getRecipe(String request) {
        return chatClient.prompt()
                .user(request)
                .call()
                .entity(Recipe.class);
    }
}