package com.example.EdificiosYDependencias.repository;

import com.example.EdificiosYDependencias.entity.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEdificioRepository extends JpaRepository<Edificio, Long> {
}
