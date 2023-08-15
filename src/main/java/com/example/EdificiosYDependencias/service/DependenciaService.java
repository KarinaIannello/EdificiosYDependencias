package com.example.EdificiosYDependencias.service;

import com.example.EdificiosYDependencias.entity.Dependencia;
import com.example.EdificiosYDependencias.entity.Edificio;
import com.example.EdificiosYDependencias.repository.IDependenciaRepository;
import com.example.EdificiosYDependencias.repository.IEdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DependenciaService {

    @Autowired
    private IDependenciaRepository dependenciaRepository;

    @Autowired
    private IEdificioRepository edificioRepository;

    public List<Dependencia> listarPorEdificio(Long id) throws Exception {

        Optional<Edificio> edificio = edificioRepository.findById(id);
        if(edificio.isEmpty()) {
            throw new Exception("No se encontró el edificio");
        }

        List<Dependencia> dependencias = dependenciaRepository.findByEdificioId(id);

        return dependencias;
    }

    public List<Dependencia> consultarDependencias() {
        List<Dependencia> dependencias = dependenciaRepository.findAll();

        return dependencias;
    }

    public Dependencia registrar(Dependencia d) throws Exception {
        // SI intento registrar una dependencia sin indicarle a que edificio pertenece
        if(d.getEdificio() == null) {
            throw new Exception("Debe indicar a que edificio pertenece");
        }

        // SI intento registrar una dependencia en un edificio que no esta registrado aun
        Edificio e = d.getEdificio();
        Optional<Edificio> edificio = edificioRepository.findById(e.getId());

        if(edificio.isEmpty()) {
            throw new Exception("El edificio especificado no esta registrado aún");
        }

        Dependencia dependencia = dependenciaRepository.save(d);
        return dependencia;
    }
}
