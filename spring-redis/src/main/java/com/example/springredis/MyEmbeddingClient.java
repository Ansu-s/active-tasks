package com.example.springredis;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MyEmbeddingClient implements EmbeddingClient {


        @Bean
        public EmbeddingClient embeddingClient()  {

            return new MyEmbeddingClient();
        }

    @Override
    public EmbeddingResponse call(EmbeddingRequest request) {
        return null;
    }

    @Override
    public List<Double> embed(String text) {
        return EmbeddingClient.super.embed(text);
    }

    @Override
    public List<Double> embed(Document document) {
        return null;
    }

    @Override
    public List<List<Double>> embed(List<String> texts) {
        return EmbeddingClient.super.embed(texts);
    }

    @Override
    public EmbeddingResponse embedForResponse(List<String> texts) {
        return EmbeddingClient.super.embedForResponse(texts);
    }

    @Override
    public int dimensions() {
        return EmbeddingClient.super.dimensions();
    }
}
