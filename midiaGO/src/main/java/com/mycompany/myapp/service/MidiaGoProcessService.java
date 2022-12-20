package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.MidiaGoProcess;
import com.mycompany.myapp.repository.MidiaGoProcessRepository;
import com.mycompany.myapp.repository.MidiaGoRepository;
import com.mycompany.myapp.service.dto.MidiaGoProcessDTO;
import com.mycompany.myapp.service.mapper.MidiaGoProcessMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link MidiaGoProcess}.
 */
@Service
@Transactional
public class MidiaGoProcessService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "MidiaGoProcess";

    private final Logger log = LoggerFactory.getLogger(MidiaGoProcessService.class);

    private final ProcessInstanceService processInstanceService;

    private final MidiaGoRepository midiaGoRepository;

    private final MidiaGoProcessRepository midiaGoProcessRepository;

    private final MidiaGoProcessMapper midiaGoProcessMapper;

    public MidiaGoProcessService(
        ProcessInstanceService processInstanceService,
        MidiaGoRepository midiaGoRepository,
        MidiaGoProcessRepository midiaGoProcessRepository,
        MidiaGoProcessMapper midiaGoProcessMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.midiaGoRepository = midiaGoRepository;
        this.midiaGoProcessRepository = midiaGoProcessRepository;
        this.midiaGoProcessMapper = midiaGoProcessMapper;
    }

    /**
     * Save a midiaGoProcess.
     *
     * @param midiaGoProcessDTO the entity to save.
     * @return the persisted entity.
     */
    public MidiaGoProcessDTO create(MidiaGoProcessDTO midiaGoProcessDTO) {
        log.debug("Request to save MidiaGoProcess : {}", midiaGoProcessDTO);

        MidiaGoProcess midiaGoProcess = midiaGoProcessMapper.toEntity(midiaGoProcessDTO);

        //Saving the domainEntity
        midiaGoRepository.save(midiaGoProcess.getMidiaGo());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "MidiaGo#" + midiaGoProcess.getMidiaGo().getId(),
            midiaGoProcess
        );
        midiaGoProcess.setProcessInstance(processInstance);

        //Saving the process entity
        midiaGoProcess = midiaGoProcessRepository.save(midiaGoProcess);
        return midiaGoProcessMapper.toDto(midiaGoProcess);
    }

    /**
     * Get all the midiaGoProcesss.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<MidiaGoProcessDTO> findAll() {
        log.debug("Request to get all MidiaGoProcesss");
        return midiaGoProcessRepository
            .findAll()
            .stream()
            .map(midiaGoProcessMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one midiaGoProcess by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MidiaGoProcessDTO> findOne(Long id) {
        log.debug("Request to get MidiaGoProcess : {}", id);
        return midiaGoProcessRepository.findById(id).map(midiaGoProcessMapper::toDto);
    }

    /**
     * Get one midiaGoProcess by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MidiaGoProcessDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get MidiaGoProcess by  processInstanceId: {}", processInstanceId);
        return midiaGoProcessRepository.findByProcessInstanceId(processInstanceId).map(midiaGoProcessMapper::toDto);
    }
}
