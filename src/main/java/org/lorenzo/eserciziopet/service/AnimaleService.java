package org.lorenzo.eserciziopet.service;

import org.lorenzo.eserciziopet.model.Animale;
import org.lorenzo.eserciziopet.repository.AnimaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AnimaleService {

    private static final Logger logger = LoggerFactory.getLogger(AnimaleService.class);

    private final AnimaleRepository animaleRepository;

    @Autowired
    public AnimaleService(AnimaleRepository animaleRepository) {
        this.animaleRepository = animaleRepository;
    }

    /**
     * Retrieve all animali.
     *
     * @return a list of all animali.
     */
    public List<Animale> getAllAnimali() {
        logger.info("Fetching all animali");
        return animaleRepository.findAll();
    }

    /**
     * Create a new animale.
     *
     * @param animale the animale to create.
     * @return the created animale.
     */
    public Animale createAnimale(Animale animale) {
        logger.info("Creating new animale with name: {}", animale.getNome());
        return animaleRepository.save(animale);
    }

    /**
     * Retrieve an animale by its ID.
     *
     * @param id the ID of the animale to retrieve.
     * @return the animale with the specified ID, if present.
     * @throws ResourceNotFoundException if the animale with the given ID is not found.
     */
    public Animale getAnimaleById(Long id) {
        logger.info("Fetching animale with ID: {}", id);
        return animaleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animale not found with id " + id));
    }

    /**
     * Update an existing animale.
     *
     * @param id the ID of the animale to update.
     * @param animaleDetails the updated details of the animale.
     * @return the updated animale.
     * @throws ResourceNotFoundException if the animale with the given ID is not found.
     */
    public Animale updateAnimale(Long id, Animale animaleDetails) {
        logger.info("Updating animale with ID: {}", id);
        Animale animale = animaleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animale not found with id " + id));

        animale.setNome(animaleDetails.getNome());
        animale.setRazza(animaleDetails.getRazza());
        animale.setSesso(animaleDetails.getSesso());
        animale.setDataNascita(animaleDetails.getDataNascita());

        return animaleRepository.save(animale);
    }

    /**
     * Delete an animale by its ID.
     *
     * @param id the ID of the animale to delete.
     * @throws ResourceNotFoundException if the animale with the given ID is not found.
     */
    public void deleteAnimale(Long id) {
        logger.info("Deleting animale with ID: {}", id);
        Animale animale = animaleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animale not found with id " + id));
        animaleRepository.delete(animale);
    }
}
