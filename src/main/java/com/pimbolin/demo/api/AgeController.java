package com.pimbolin
.demo.api;

import com.pimbolin
.demo.core.AgeService;
import com.pimbolin
.demo.dto.AgeRequest;
import com.pimbolin
.demo.dto.AgeResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class AgeController {

    private final AgeService ageService;

    public AgeController(AgeService ageService) {
        this.ageService = ageService;
    }

    // POST: recebe JSON
    @PostMapping("/age")
    @ResponseStatus(HttpStatus.OK)
    public AgeResponse calcular(@Valid @RequestBody AgeRequest request) {
        return ageService.calcular(request);
    }

    // GET: query params (facilita testar no navegador)
    // Ex.: /api/age?nome=Lazaro&sobrenome=Neto&dataNascimento=1999-10-05
    @GetMapping("/age")
    public AgeResponse calcularViaQuery(
            @RequestParam String nome,
            @RequestParam(required = false) String sobrenome,
            @RequestParam LocalDate dataNascimento
    ) {
        AgeRequest req = new AgeRequest();
        req.setNome(nome);
        req.setSobrenome(sobrenome);
        req.setDataNascimento(dataNascimento);
        return ageService.calcular(req);
    }
}
