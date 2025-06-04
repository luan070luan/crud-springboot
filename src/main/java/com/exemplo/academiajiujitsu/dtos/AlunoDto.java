package com.exemplo.academiajiujitsu.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public record AlunoDto(
    UUID id,
    String nome,
    BigDecimal idade,
    String faixa
) {}