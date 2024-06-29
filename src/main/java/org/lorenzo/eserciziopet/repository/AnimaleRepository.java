package org.lorenzo.eserciziopet.repository;

import org.lorenzo.eserciziopet.model.Animale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimaleRepository extends JpaRepository<Animale, Long> {
}