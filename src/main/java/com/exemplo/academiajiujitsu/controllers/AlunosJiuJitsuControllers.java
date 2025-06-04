package com.exemplo.academiajiujitsu.controllers;

import com.exemplo.academiajiujitsu.dtos.AlunoDto;
import com.exemplo.academiajiujitsu.models.AlunosModels;
import com.exemplo.academiajiujitsu.repositories.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunosJiuJitsuControllers {

    @Autowired
    private AlunosRepository alunosRepository;

    @PostMapping
    public ResponseEntity<AlunosModels> criarAluno(@RequestBody AlunoDto dto) {
        AlunosModels novoAluno = new AlunosModels();
        novoAluno.setNome(dto.nome());
        novoAluno.setIdade(dto.idade());
        novoAluno.setFaixa(dto.faixa());
        AlunosModels salvo = alunosRepository.save(novoAluno);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<AlunosModels>> listarAlunos() {
        List<AlunosModels> alunos = alunosRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunosModels> buscarPorId(@PathVariable UUID id) {
        Optional<AlunosModels> aluno = alunosRepository.findById(id);
        return aluno.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunosModels> atualizarAluno(@PathVariable UUID id, @RequestBody AlunoDto dto) {
        Optional<AlunosModels> optionalAluno = alunosRepository.findById(id);
        if (optionalAluno.isPresent()) {
            AlunosModels aluno = optionalAluno.get();
            aluno.setNome(dto.nome());
            aluno.setIdade(dto.idade());
            aluno.setFaixa(dto.faixa());
            AlunosModels atualizado = alunosRepository.save(aluno);
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable UUID id) {
        if (alunosRepository.existsById(id)) {
            alunosRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}