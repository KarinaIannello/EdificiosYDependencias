package com.example.EdificiosYDependencias.controller;

import com.example.EdificiosYDependencias.entity.Dependencia;
import com.example.EdificiosYDependencias.service.DependenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dependencias")
public class DependenciaController {
    @Autowired
    private DependenciaService dependenciaService;

    @GetMapping("/porEdificio")
    public ResponseEntity<List<Dependencia>> listarDependenciasPorEdificio(@RequestParam Long id) throws Exception {
        List<Dependencia> dependencias = dependenciaService.listarPorEdificio(id);

        return new ResponseEntity<>(dependencias, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Dependencia>> listarTodas(){
        return new ResponseEntity<>(dependenciaService.consultarDependencias(), HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Dependencia> crear(@RequestBody Dependencia d) throws Exception {
        return new ResponseEntity<>(dependenciaService.registrar(d), HttpStatus.CREATED);
    }
}
