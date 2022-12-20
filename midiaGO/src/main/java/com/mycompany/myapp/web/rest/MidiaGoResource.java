package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.MidiaGoRepository;
import com.mycompany.myapp.service.MidiaGoService;
import com.mycompany.myapp.service.dto.MidiaGoDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.MidiaGo}.
 */
@RestController
@RequestMapping("/api")
public class MidiaGoResource {

    private final Logger log = LoggerFactory.getLogger(MidiaGoResource.class);

    private final MidiaGoService midiaGoService;

    private final MidiaGoRepository midiaGoRepository;

    public MidiaGoResource(MidiaGoService midiaGoService, MidiaGoRepository midiaGoRepository) {
        this.midiaGoService = midiaGoService;
        this.midiaGoRepository = midiaGoRepository;
    }

    /**
     * {@code GET  /midia-gos} : get all the midiaGos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of midiaGos in body.
     */
    @GetMapping("/midia-gos")
    public List<MidiaGoDTO> getAllMidiaGos() {
        log.debug("REST request to get all MidiaGos");
        return midiaGoService.findAll();
    }

    /**
     * {@code GET  /midia-gos/:id} : get the "id" midiaGo.
     *
     * @param id the id of the midiaGoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the midiaGoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/midia-gos/{id}")
    public ResponseEntity<MidiaGoDTO> getMidiaGo(@PathVariable Long id) {
        log.debug("REST request to get MidiaGo : {}", id);
        Optional<MidiaGoDTO> midiaGoDTO = midiaGoService.findOne(id);
        return ResponseUtil.wrapOrNotFound(midiaGoDTO);
    }
}
