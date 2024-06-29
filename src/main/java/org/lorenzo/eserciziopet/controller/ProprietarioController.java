package org.lorenzo.eserciziopet.controller;


import org.lorenzo.eserciziopet.model.Proprietario;
import org.lorenzo.eserciziopet.repository.ProprietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/proprietari")
public class ProprietarioController {

    private static final Logger logger = LoggerFactory.getLogger(ProprietarioController.class);

    private final ProprietarioRepository proprietarioRepository;

    @Autowired
    public ProprietarioController(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    /**
     * Retrieve all proprietari.
     *
     * @return a list of all proprietari.
     */
    @GetMapping
    public ResponseEntity<List<Proprietario>> getAllProprietari() {
        logger.info("Fetching all proprietari");
        List<Proprietario> proprietari = proprietarioRepository.findAll();
        return ResponseEntity.ok(proprietari);
    }

    /**
     * Create a new proprietario.
     *
     * @param proprietario the proprietario to create.
     * @return the created proprietario.
     */
    @PostMapping
    public ResponseEntity<Proprietario> createProprietario(@RequestBody Proprietario proprietario) {
        logger.info("Creating new proprietario with name: {} {}", proprietario.getNome(), proprietario.getCognome());
        Proprietario createdProprietario = proprietarioRepository.save(proprietario);
        return ResponseEntity.ok(createdProprietario);
    }

    /**
     * Retrieve a proprietario by their ID.
     *
     * @param id the ID of the proprietario to retrieve.
     * @return the proprietario with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> getProprietarioById(@PathVariable Long id) {
        logger.info("Fetching proprietario with ID: {}", id);
        Proprietario proprietario = proprietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietario not found with id " + id));
        return ResponseEntity.ok(proprietario);
    }

    /**
     * Update an existing proprietario.
     *
     * @param id the ID of the proprietario to update.
     * @param proprietarioDetails the updated details of the proprietario.
     * @return the updated proprietario.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> updateProprietario(@PathVariable Long id, @RequestBody Proprietario proprietarioDetails) {
        logger.info("Updating proprietario with ID: {}", id);
        Proprietario proprietario = proprietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietario not found with id " + id));

        proprietario.setNome(proprietarioDetails.getNome());
        proprietario.setCognome(proprietarioDetails.getCognome());

        Proprietario updatedProprietario = proprietarioRepository.save(proprietario);
        return ResponseEntity.ok(updatedProprietario);
    }

    /**
     * Delete a proprietario by their ID.
     *
     * @param id the ID of the proprietario to delete.
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProprietario(@PathVariable Long id) {
        logger.info("Deleting proprietario with ID: {}", id);
        Proprietario proprietario = proprietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietario not found with id " + id));
        proprietarioRepository.delete(proprietario);
        return ResponseEntity.noContent().build();
    }
}