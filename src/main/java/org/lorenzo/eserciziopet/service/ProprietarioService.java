package org.lorenzo.eserciziopet.service;

import org.lorenzo.eserciziopet.model.Proprietario;
import org.lorenzo.eserciziopet.repository.ProprietarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProprietarioService {

    private static final Logger logger = LoggerFactory.getLogger(ProprietarioService.class);

    private final ProprietarioRepository proprietarioRepository;

    @Autowired
    public ProprietarioService(ProprietarioRepository proprietarioRepository) {
        this.proprietarioRepository = proprietarioRepository;
    }

    /**
     * Retrieve all proprietari.
     *
     * @return a list of all proprietari.
     */
    public List<Proprietario> getAllProprietari() {
        logger.info("Fetching all proprietari");
        return proprietarioRepository.findAll();
    }

    /**
     * Create a new proprietario.
     *
     * @param proprietario the proprietario to create.
     * @return the created proprietario.
     */
    public Proprietario createProprietario(Proprietario proprietario) {
        logger.info("Creating new proprietario with name: {} {}", proprietario.getNome(), proprietario.getCognome());
        return proprietarioRepository.save(proprietario);
    }

    /**
     * Retrieve a proprietario by its ID.
     *
     * @param id the ID of the proprietario to retrieve.
     * @return the proprietario with the specified ID, if present.
     * @throws ResourceNotFoundException if the proprietario with the given ID is not found.
     */
    public Proprietario getProprietarioById(Long id) {
        logger.info("Fetching proprietario with ID: {}", id);
        return proprietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietario not found with id " + id));
    }

    /**
     * Update an existing proprietario.
     *
     * @param id the ID of the proprietario to update.
     * @param proprietarioDetails the updated details of the proprietario.
     * @return the updated proprietario.
     * @throws ResourceNotFoundException if the proprietario with the given ID is not found.
     */
    public Proprietario updateProprietario(Long id, Proprietario proprietarioDetails) {
        logger.info("Updating proprietario with ID: {}", id);
        Proprietario proprietario = proprietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietario not found with id " + id));

        proprietario.setNome(proprietarioDetails.getNome());
        proprietario.setCognome(proprietarioDetails.getCognome());

        return proprietarioRepository.save(proprietario);
    }

    /**
     * Delete a proprietario by its ID.
     *
     * @param id the ID of the proprietario to delete.
     * @throws ResourceNotFoundException if the proprietario with the given ID is not found.
     */
    public void deleteProprietario(Long id) {
        logger.info("Deleting proprietario with ID: {}", id);
        Proprietario proprietario = proprietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proprietario not found with id " + id));
        proprietarioRepository.delete(proprietario);
    }
}
