package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.BeneficioDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link io.github.jhipster.application.domain.Beneficio}.
 */
public interface BeneficioService {

    /**
     * Save a beneficio.
     *
     * @param beneficioDTO the entity to save.
     * @return the persisted entity.
     */
    BeneficioDTO save(BeneficioDTO beneficioDTO);

    /**
     * Get all the beneficios.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BeneficioDTO> findAll(Pageable pageable);


    /**
     * Get the "id" beneficio.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BeneficioDTO> findOne(Long id);

    /**
     * Delete the "id" beneficio.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the beneficio corresponding to the query.
     *
     * @param query the query of the search.
     * 
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<BeneficioDTO> search(String query, Pageable pageable);
}