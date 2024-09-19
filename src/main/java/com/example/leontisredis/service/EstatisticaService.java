package com.example.leontisredis.service;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class EstatisticaService {

    private final RedisTemplate<String, Object> redisTemplate;

    public EstatisticaService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Incrementar contadores de visualizações
    public void adicionarVisualizaçãoObra(String obraId) {
        redisTemplate.opsForValue().increment("obra:view:" + obraId);
    }

    // Incrementar contadores de comentários
    public void adicionarComentario(String obraId) {
        redisTemplate.opsForValue().increment("obra:comment:" + obraId);
    }

    // Incrementar contadores de avaliações
    public void adicionarNota(String obraId) {
        redisTemplate.opsForValue().increment("obra:rating:" + obraId);
    }

    // Obter contador de visualizações
    public Integer buscarVisualizaçãoObra(String obraId) {
        String countStr = (String) redisTemplate.opsForValue().get("obra:view:" + obraId);
        Integer count = countStr != null ? Integer.valueOf(countStr) : 0;
        return count;
    }

    // Obter contador de comentários
    public Integer buscarComentario(String obraId) {
        String countStr = (String) redisTemplate.opsForValue().get("obra:comment:" + obraId);
        Integer count = countStr != null ? Integer.valueOf(countStr) : 0;
        return count;
    }

    // Obter contador de avaliações
    public Integer buscarNota(String obraId) {
        String countStr = (String) redisTemplate.opsForValue().get("obra:rating:" + obraId);
        Integer count = countStr != null ? Integer.valueOf(countStr) : 0;
        return count;
    }
}
