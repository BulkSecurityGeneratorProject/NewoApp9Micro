package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.MargenNewoBlogService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.service.dto.MargenNewoBlogDTO;
import io.github.jhipster.application.service.dto.MargenNewoBlogCriteria;
import io.github.jhipster.application.service.MargenNewoBlogQueryService;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing {@link io.github.jhipster.application.domain.MargenNewoBlog}.
 */
@RestController
@RequestMapping("/api")
public class MargenNewoBlogResource {

    private final Logger log = LoggerFactory.getLogger(MargenNewoBlogResource.class);

    private static final String ENTITY_NAME = "margenNewoBlog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MargenNewoBlogService margenNewoBlogService;

    private final MargenNewoBlogQueryService margenNewoBlogQueryService;

    public MargenNewoBlogResource(MargenNewoBlogService margenNewoBlogService, MargenNewoBlogQueryService margenNewoBlogQueryService) {
        this.margenNewoBlogService = margenNewoBlogService;
        this.margenNewoBlogQueryService = margenNewoBlogQueryService;
    }

    /**
     * {@code POST  /margen-newo-blogs} : Create a new margenNewoBlog.
     *
     * @param margenNewoBlogDTO the margenNewoBlogDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new margenNewoBlogDTO, or with status {@code 400 (Bad Request)} if the margenNewoBlog has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/margen-newo-blogs")
    public ResponseEntity<MargenNewoBlogDTO> createMargenNewoBlog(@RequestBody MargenNewoBlogDTO margenNewoBlogDTO) throws URISyntaxException {
        log.debug("REST request to save MargenNewoBlog : {}", margenNewoBlogDTO);
        if (margenNewoBlogDTO.getId() != null) {
            throw new BadRequestAlertException("A new margenNewoBlog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MargenNewoBlogDTO result = margenNewoBlogService.save(margenNewoBlogDTO);
        return ResponseEntity.created(new URI("/api/margen-newo-blogs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /margen-newo-blogs} : Updates an existing margenNewoBlog.
     *
     * @param margenNewoBlogDTO the margenNewoBlogDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated margenNewoBlogDTO,
     * or with status {@code 400 (Bad Request)} if the margenNewoBlogDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the margenNewoBlogDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/margen-newo-blogs")
    public ResponseEntity<MargenNewoBlogDTO> updateMargenNewoBlog(@RequestBody MargenNewoBlogDTO margenNewoBlogDTO) throws URISyntaxException {
        log.debug("REST request to update MargenNewoBlog : {}", margenNewoBlogDTO);
        if (margenNewoBlogDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MargenNewoBlogDTO result = margenNewoBlogService.save(margenNewoBlogDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, margenNewoBlogDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /margen-newo-blogs} : get all the margenNewoBlogs.
     *
     * @param pageable the pagination information.
     * @param queryParams a {@link MultiValueMap} query parameters.
     * @param uriBuilder a {@link UriComponentsBuilder} URI builder.
     * @param criteria the criteria which the requested entities should match.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of margenNewoBlogs in body.
     */
    @GetMapping("/margen-newo-blogs")
    public ResponseEntity<List<MargenNewoBlogDTO>> getAllMargenNewoBlogs(MargenNewoBlogCriteria criteria, Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to get MargenNewoBlogs by criteria: {}", criteria);
        Page<MargenNewoBlogDTO> page = margenNewoBlogQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
    * {@code GET  /margen-newo-blogs/count} : count all the margenNewoBlogs.
    *
    * @param criteria the criteria which the requested entities should match.
    * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the count in body.
    */
    @GetMapping("/margen-newo-blogs/count")
    public ResponseEntity<Long> countMargenNewoBlogs(MargenNewoBlogCriteria criteria) {
        log.debug("REST request to count MargenNewoBlogs by criteria: {}", criteria);
        return ResponseEntity.ok().body(margenNewoBlogQueryService.countByCriteria(criteria));
    }

    /**
     * {@code GET  /margen-newo-blogs/:id} : get the "id" margenNewoBlog.
     *
     * @param id the id of the margenNewoBlogDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the margenNewoBlogDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/margen-newo-blogs/{id}")
    public ResponseEntity<MargenNewoBlogDTO> getMargenNewoBlog(@PathVariable Long id) {
        log.debug("REST request to get MargenNewoBlog : {}", id);
        Optional<MargenNewoBlogDTO> margenNewoBlogDTO = margenNewoBlogService.findOne(id);
        return ResponseUtil.wrapOrNotFound(margenNewoBlogDTO);
    }

    /**
     * {@code DELETE  /margen-newo-blogs/:id} : delete the "id" margenNewoBlog.
     *
     * @param id the id of the margenNewoBlogDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/margen-newo-blogs/{id}")
    public ResponseEntity<Void> deleteMargenNewoBlog(@PathVariable Long id) {
        log.debug("REST request to delete MargenNewoBlog : {}", id);
        margenNewoBlogService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/margen-newo-blogs?query=:query} : search for the margenNewoBlog corresponding
     * to the query.
     *
     * @param query the query of the margenNewoBlog search.
     * @param pageable the pagination information.
     * @param queryParams a {@link MultiValueMap} query parameters.
     * @param uriBuilder a {@link UriComponentsBuilder} URI builder.
     * @return the result of the search.
     */
    @GetMapping("/_search/margen-newo-blogs")
    public ResponseEntity<List<MargenNewoBlogDTO>> searchMargenNewoBlogs(@RequestParam String query, Pageable pageable, @RequestParam MultiValueMap<String, String> queryParams, UriComponentsBuilder uriBuilder) {
        log.debug("REST request to search for a page of MargenNewoBlogs for query {}", query);
        Page<MargenNewoBlogDTO> page = margenNewoBlogService.search(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(uriBuilder.queryParams(queryParams), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

}