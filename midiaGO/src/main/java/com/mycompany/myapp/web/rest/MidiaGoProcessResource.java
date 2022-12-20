package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.MidiaGoProcessService;
import com.mycompany.myapp.service.dto.MidiaGoProcessDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.MidiaGoProcess}.
 */
@RestController
@RequestMapping("/api")
public class MidiaGoProcessResource {

    private final Logger log = LoggerFactory.getLogger(MidiaGoProcessResource.class);

    private static final String ENTITY_NAME = "midiaGoProcess";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MidiaGoProcessService midiaGoProcessService;

    public MidiaGoProcessResource(MidiaGoProcessService midiaGoProcessService) {
        this.midiaGoProcessService = midiaGoProcessService;
    }

    /**
     * {@code POST  /midia-go-processes} : Create a new midiaGoProcess.
     *
     * @param midiaGoProcessDTO the midiaGoProcessDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new midiaGoProcessDTO, or with status {@code 400 (Bad Request)} if the midiaGoProcess has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/midia-go-processes")
    public ResponseEntity<MidiaGoProcessDTO> create(@RequestBody MidiaGoProcessDTO midiaGoProcessDTO) throws URISyntaxException {
        log.debug("REST request to save MidiaGoProcess : {}", midiaGoProcessDTO);
        if (midiaGoProcessDTO.getId() != null) {
            throw new BadRequestAlertException("A new midiaGoProcess cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MidiaGoProcessDTO result = midiaGoProcessService.create(midiaGoProcessDTO);
        return ResponseEntity
            .created(new URI("/api/midia-go-processes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /midia-go-processes} : get all the midiaGoProcesss.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of midiaGoProcesss in body.
     */
    @GetMapping("/midia-go-processes")
    public List<MidiaGoProcessDTO> getAllMidiaGoProcesss() {
        log.debug("REST request to get all MidiaGoProcesss");
        return midiaGoProcessService.findAll();
    }

    /**
     * {@code GET  /midia-go-processes/:id} : get the "id" midiaGoProcess.
     *
     * @param processInstanceId the id of the midiaGoProcessDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the midiaGoProcessDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/midia-go-processes/{processInstanceId}")
    public ResponseEntity<MidiaGoProcessDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get MidiaGoProcess by processInstanceId : {}", processInstanceId);
        Optional<MidiaGoProcessDTO> midiaGoProcessDTO = midiaGoProcessService.findByProcessInstanceId(processInstanceId);
        return ResponseUtil.wrapOrNotFound(midiaGoProcessDTO);
    }
}
