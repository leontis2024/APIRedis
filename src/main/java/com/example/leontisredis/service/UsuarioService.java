package com.example.leontisredis.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final RedisTemplate<String, Object> redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Incrementar a atividade do usuário
    public void incrementaUserActivity() {
        redisTemplate.opsForValue().increment("atividade");
    }

    // Decrementar a atividade do usuário
    public void decrementaUserActivity() {
        Long valor = Long.parseLong(redisTemplate.opsForValue().get("atividade").toString()) ;
        if (valor > 0){
            redisTemplate.opsForValue().decrement("atividade");
        }else {
            throw new NullPointerException();
        }
    }

    public Integer buscartUserActivity() {
        try {
            String countStr = (String) redisTemplate.opsForValue().get("atividade");
            Integer count = countStr != null ? Integer.valueOf(countStr) : 0;
            logger.info("Contagem de atividade obtida com sucesso: {}", count);
            return count;
        } catch (NumberFormatException e) {
            logger.error("Erro ao converter a contagem de atividade", e);
            throw new RuntimeException("Erro ao converter a contagem de atividade", e);
        } catch (Exception e) {
            logger.error("Erro ao buscar contagem de atividade do usuário", e);
            throw e;
        }
    }
}
