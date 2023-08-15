package com.example.EdificiosYDependencias.controller;

import com.example.EdificiosYDependencias.entity.Dependencia;
import com.example.EdificiosYDependencias.entity.Edificio;
import com.example.EdificiosYDependencias.service.DependenciaService;
import com.example.EdificiosYDependencias.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/edificios")
public class EdificioController {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private DependenciaService dependenciaService;

    @GetMapping
    public ResponseEntity<List<Edificio>> listarTodos(){
        return new ResponseEntity<>(edificioService.consultarEdificios(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Edificio> crear(@RequestBody Edificio edificio) {
        return new ResponseEntity<>(edificioService.registrar(edificio), HttpStatus.CREATED);
    }

    @GetMapping("/buscar")
    public ResponseEntity<Edificio> buscar(@RequestParam Long id) throws Exception {
        Optional<Edificio> edificioOptional = edificioService.buscar(id);

        Edificio edificioEncontrado = edificioOptional.get();
        return new ResponseEntity<>(edificioEncontrado, HttpStatus.OK);
    }


}
