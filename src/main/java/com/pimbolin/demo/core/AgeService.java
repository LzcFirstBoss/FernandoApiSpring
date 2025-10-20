package com.pimbolin.demo.core;

import com.pimbolin.demo.dto.AgeRequest;
import com.pimbolin.demo.dto.AgeResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

@Service
public class AgeService {

    private static final ZoneId ZONE = ZoneId.of("America/Araguaina");
    public AgeResponse calcular(AgeRequest req) {
        LocalDate nascimento = req.getDataNascimento();
        LocalDate hoje = LocalDate.now(ZONE);

        if (nascimento.isAfter(hoje)) {
            throw new IllegalArgumentException("A data de nascimento não pode estar no futuro.");
        }

        Period p = Period.between(nascimento, hoje);
        String nomeCompleto = montarNomeCompleto(req.getNome(), req.getSobrenome());

        return new AgeResponse(nomeCompleto, p.getYears(), p.getMonths(), p.getDays());
    }

    private String montarNomeCompleto(String nome, String sobrenome) {
        if (sobrenome == null || sobrenome.isBlank()) return nome.trim();
        return (nome + " " + sobrenome).trim();
    }
}
