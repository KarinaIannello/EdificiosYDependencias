package com.example.EdificiosYDependencias.service;

import com.example.EdificiosYDependencias.entity.Edificio;
import com.example.EdificiosYDependencias.repository.IEdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EdificioService {

    @Autowired
    private IEdificioRepository edificioRepository;

    public Edificio registrar(Edificio e) {
        Edificio edificio = edificioRepository.save(e);
        return edificio;
    }

    public List<Edificio> consultarEdificios() {
        List<Edificio> edificios = edificioRepository.findAll();
        return edificios;
    }

    public Edificio modificar(Edificio e) throws Exception {
        Optional<Edificio> edi = edificioRepository.findById(e.getId());

        if (edi.isEmpty()) {
            throw new Exception("No se encontró el edificio que quiere modiifcar");
        }

        Edificio edificio = edificioRepository.save(e);
        return edificio;
    }

    public Optional<Edificio> buscar(Long id) throws Exception {
        Optional<Edificio> edi = edificioRepository.findById(id);

        if(edi.isEmpty()){
            throw new Exception("No hay resultado para su búsqueda");
        }

        return edi;
    }

}
