package org.lorenzo.eserciziopet.controller;

import org.lorenzo.eserciziopet.model.Animale;
import org.lorenzo.eserciziopet.repository.AnimaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animali")
public class AnimaleController {

    private static final Logger logger = LoggerFactory.getLogger(AnimaleController.class);

    private final AnimaleRepository animaleRepository;

    @Autowired
    public AnimaleController(AnimaleRepository animaleRepository) {
        this.animaleRepository = animaleRepository;
    }

    /**
     * Retrieve all animali.
     *
     * @return a list of all animali.
     */

    @GetMapping
    public ResponseEntity<List<Animale>> getAllAnimali() {
        logger.info("Fetching all animali");
        List<Animale> animali = animaleRepository.findAll();
        return ResponseEntity.ok(animali);
    }

    /**
     * Create a new animale.
     *
     * @param animale the animale to create.
     * @return the created animale.
     */

    @PostMapping
    public ResponseEntity<Animale> createAnimale(@RequestBody Animale animale) {
        logger.info("Creating new animale with name: {}", animale.getNome());
        Animale createdAnimale = animaleRepository.save(animale);
        return ResponseEntity.ok(createdAnimale);
    }

    /**
     * Retrieve an animale by its ID.
     *
     * @param id the ID of the animale to retrieve.
     * @return the animale with the specified ID.
     */

    @GetMapping("/{id}")
    public ResponseEntity<Animale> getAnimaleById(@PathVariable Long id) {
        logger.info("Fetching animale with ID: {}", id);
        Animale animale = animaleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animale not found with id " + id));
        return ResponseEntity.ok(animale);
    }

    /**
     * Update an existing animale.
     *
     * @param id the ID of the animale to update.
     * @param animaleDetails the updated details of the animale.
     * @return the updated animale.
     */

    @PutMapping("/{id}")
    public ResponseEntity<Animale> updateAnimale(@PathVariable Long id, @RequestBody Animale animaleDetails) {
        logger.info("Updating animale with ID: {}", id);
        Animale animale = animaleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animale not found with id " + id));

        animale.setNome(animaleDetails.getNome());
        animale.setRazza(animaleDetails.getRazza());
        animale.setSesso(animaleDetails.getSesso());
        animale.setDataNascita(animaleDetails.getDataNascita());

        Animale updatedAnimale = animaleRepository.save(animale);
        return ResponseEntity.ok(updatedAnimale);
    }

    /**
     * Delete an animale by its ID.
     *
     * @param id the ID of the animale to delete.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimale(@PathVariable Long id) {
        logger.info("Deleting animale with ID: {}", id);
        Animale animale = animaleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animale not found with id " + id));
        animaleRepository.delete(animale);
        return ResponseEntity.noContent().build();
    }
}
