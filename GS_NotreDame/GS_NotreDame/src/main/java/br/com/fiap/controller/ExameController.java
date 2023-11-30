package br.com.fiap.controller;

import br.com.fiap.controller.dto.ExameDTO;
import br.com.fiap.entity.Beneficiario;
import br.com.fiap.entity.Exame;
import br.com.fiap.service.ExameService;
import br.com.fiap.service.mapper.ExameMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exame")
@Tag(name = "Exame", description = "CRUD do Exame")
public class ExameController {

        @Autowired
        private ExameService exameService;

        @GetMapping("/{id}")
        public ResponseEntity<ExameDTO> buscarExame(@PathVariable Long id) {
            Exame exame = exameService.buscarExameID(id);
            return ResponseEntity.ok(ExameMapper.toDTO(exame));
        }

        @GetMapping
        public ResponseEntity<List<ExameDTO>> listarExame() {
            List<ExameDTO> listarExame = exameService.procurarExame().stream().map(ExameMapper::toDTO).toList();
            return ResponseEntity.ok(listarExame);
        }
        @PostMapping
        public ResponseEntity<ExameDTO> criarExame(@Valid @RequestBody ExameDTO exameDTO) {
            Exame respostaExame = exameService.criarExame(ExameMapper.toEntity(exameDTO));
            return ResponseEntity.ok(ExameMapper.toDTO(respostaExame));
        }

        @PutMapping("/{id}")
        public ResponseEntity<ExameDTO> atualizarExame(@PathVariable Long id, @Valid @RequestBody ExameDTO exameDTO) {
            Exame respostaExame = exameService.atualizarExame(id, ExameMapper.toEntity(exameDTO));
            return ResponseEntity.ok(ExameMapper.toDTO(respostaExame));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deletarExame(@PathVariable Long id) {
            exameService.deletarExame(id);
            return ResponseEntity.noContent().build();
        }

}
