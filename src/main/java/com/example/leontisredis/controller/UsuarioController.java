package com.example.leontisredis.controller;

import com.example.leontisredis.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/atividade/incrementar")
    @Operation(summary = "Incrementar atividade do usuário", description = "Incrementa a atividade do usuário.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Atividade do usuário incrementada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<String> incrementarAtividade() {
        try {
            usuarioService.incrementaUserActivity();
            return ResponseEntity.ok("Atividade do usuário incrementada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao incrementar atividade do usuário.");
        }
    }

    @PostMapping("/atividade/decrementar")
    @Operation(summary = "Decrementar atividade do usuário", description = "Decrementa a atividade do usuário.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Atividade do usuário decrementada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<String> decrementarAtividade() {
        try {
            usuarioService.decrementaUserActivity();
            return ResponseEntity.ok("Atividade do usuário decrementada com sucesso.");
        } catch (NullPointerException ne) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível decrementar a atividade. A atividade já está zerada.");
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao decrementar atividade do usuário.");
        }
    }

    @GetMapping("/atividade")
    @Operation(summary = "Obter contagem de atividade do usuário", description = "Retorna a contagem de atividade do usuário.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contagem de atividade obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<?> obterAtividade() {
        try {
            Integer count = usuarioService.buscartUserActivity();
            return ResponseEntity.ok(count);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar contagem de atividade do usuário.");
        }
    }


}
