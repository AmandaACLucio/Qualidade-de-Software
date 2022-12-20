package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.MidiaGo;
import com.mycompany.myapp.repository.MidiaGoRepository;
import com.mycompany.myapp.service.dto.MidiaGoDTO;
import com.mycompany.myapp.service.mapper.MidiaGoMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MidiaGo}.
 */
@Service
@Transactional
public class MidiaGoService {

    private final Logger log = LoggerFactory.getLogger(MidiaGoService.class);

    private final MidiaGoRepository midiaGoRepository;

    private final MidiaGoMapper midiaGoMapper;

    public MidiaGoService(MidiaGoRepository midiaGoRepository, MidiaGoMapper midiaGoMapper) {
        this.midiaGoRepository = midiaGoRepository;
        this.midiaGoMapper = midiaGoMapper;
    }

    /**
     * Save a midiaGo.
     *
     * @param midiaGoDTO the entity to save.
     * @return the persisted entity.
     */
    public MidiaGoDTO save(MidiaGoDTO midiaGoDTO) {
        log.debug("Request to save MidiaGo : {}", midiaGoDTO);
        MidiaGo midiaGo = midiaGoMapper.toEntity(midiaGoDTO);
        midiaGo = midiaGoRepository.save(midiaGo);
        return midiaGoMapper.toDto(midiaGo);
    }

    /**
     * Partially update a midiaGo.
     *
     * @param midiaGoDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<MidiaGoDTO> partialUpdate(MidiaGoDTO midiaGoDTO) {
        log.debug("Request to partially update MidiaGo : {}", midiaGoDTO);

        return midiaGoRepository
            .findById(midiaGoDTO.getId())
            .map(
                existingMidiaGo -> {
                    midiaGoMapper.partialUpdate(existingMidiaGo, midiaGoDTO);
                    return existingMidiaGo;
                }
            )
            .map(midiaGoRepository::save)
            .map(midiaGoMapper::toDto);
    }

    /**
     * Get all the midiaGos.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MidiaGoDTO> findAll() {
        log.debug("Request to get all MidiaGos");
        return midiaGoRepository.findAll().stream().map(midiaGoMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one midiaGo by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MidiaGoDTO> findOne(Long id) {
        log.debug("Request to get MidiaGo : {}", id);
        return midiaGoRepository.findById(id).map(midiaGoMapper::toDto);
    }

    /**
     * Delete the midiaGo by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MidiaGo : {}", id);
        midiaGoRepository.deleteById(id);
    }
}
