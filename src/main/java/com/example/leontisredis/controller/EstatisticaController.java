package com.example.leontisredis.controller;

import com.example.leontisredis.service.EstatisticaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/estatisticas")
public class EstatisticaController {

    private final EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService) {
        this.estatisticaService = estatisticaService;
    }

    @PostMapping("/visualizacao/{obraId}")
    @Operation(summary = "Incrementar contagem de visualizações", description = "Incrementa a contagem de visualizações de uma obra.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contagem de visualizações incrementada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<String> adicionarVisualizacaoObra(@PathVariable @Parameter(description = "ID da obra") String obraId) {
        try {
            estatisticaService.adicionarVisualizaçãoObra(obraId);
            return ResponseEntity.ok("Visualização incrementada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao incrementar visualização.");
        }
    }

    @PostMapping("/comentario/{obraId}")
    @Operation(summary = "Incrementar contagem de comentários", description = "Incrementa a contagem de comentários de uma obra.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contagem de comentários incrementada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<String> adicionarComentario(@PathVariable @Parameter(description = "ID da obra") String obraId) {
        try {
            estatisticaService.adicionarComentario(obraId);
            return ResponseEntity.ok("Comentário incrementado com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao incrementar comentário.");
        }
    }

    @PostMapping("/nota/{obraId}")
    @Operation(summary = "Incrementar contagem de avaliações", description = "Incrementa a contagem de avaliações de uma obra.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contagem de avaliações incrementada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<String> adicionarNota(@PathVariable @Parameter(description = "ID da obra") String obraId) {
        try {
            estatisticaService.adicionarNota(obraId);
            return ResponseEntity.ok("Nota incrementada com sucesso.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao incrementar nota.");
        }
    }

    @GetMapping("/visualizacao/{obraId}")
    @Operation(summary = "Obter contagem de visualizações", description = "Retorna a contagem de visualizações de uma obra.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contagem de visualizações obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<?> buscarVisualizacaoObra(@PathVariable @Parameter(description = "ID da obra") String obraId) {
        try {
            Integer count = estatisticaService.buscarVisualizaçãoObra(obraId);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar contagem de visualizações.");
        }
    }

    @GetMapping("/comentario/{obraId}")
    @Operation(summary = "Obter contagem de comentários", description = "Retorna a contagem de comentários de uma obra.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contagem de comentários obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<?> buscarComentario(@PathVariable @Parameter(description = "ID da obra") String obraId) {
        try {
            Integer count = estatisticaService.buscarComentario(obraId);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar contagem de comentários.");
        }
    }

    @GetMapping("/nota/{obraId}")
    @Operation(summary = "Obter contagem de avaliações", description = "Retorna a contagem de avaliações de uma obra.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Contagem de avaliações obtida com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<?> buscarNota(@PathVariable @Parameter(description = "ID da obra") String obraId) {
        try {
            Integer count = estatisticaService.buscarNota(obraId);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar contagem de avaliações.");
        }
    }
}
