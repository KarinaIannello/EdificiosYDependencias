package com.example.EdificiosYDependencias.repository;

import com.example.EdificiosYDependencias.entity.Dependencia;
import com.example.EdificiosYDependencias.entity.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDependenciaRepository extends JpaRepository<Dependencia, Long> {
    List<Dependencia> findByEdificioId(Long id);
}
