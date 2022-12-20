package com.mycompany.myapp.process.midiaGoProcess;

import com.mycompany.myapp.repository.MidiaGoProcessRepository;
import com.mycompany.myapp.service.MidiaGoService;
import com.mycompany.myapp.service.dto.MidiaGoDTO;
import com.mycompany.myapp.service.dto.MidiaGoProcessDTO;
import com.mycompany.myapp.service.mapper.MidiaGoProcessMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskBookingService {

    private final TaskInstanceService taskInstanceService;

    private final MidiaGoService midiaGoService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final MidiaGoProcessRepository midiaGoProcessRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskBookingMapper taskBookingMapper;

    private final MidiaGoProcessMapper midiaGoProcessMapper;

    public TaskBookingService(
        TaskInstanceService taskInstanceService,
        MidiaGoService midiaGoService,
        TaskInstanceRepository taskInstanceRepository,
        MidiaGoProcessRepository midiaGoProcessRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskBookingMapper taskBookingMapper,
        MidiaGoProcessMapper midiaGoProcessMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.midiaGoService = midiaGoService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.midiaGoProcessRepository = midiaGoProcessRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskBookingMapper = taskBookingMapper;
        this.midiaGoProcessMapper = midiaGoProcessMapper;
    }

    public TaskBookingContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        MidiaGoProcessDTO midiaGoProcess = midiaGoProcessRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskBookingMapper::toMidiaGoProcessDTO)
            .orElseThrow();

        TaskBookingContextDTO taskBookingContext = new TaskBookingContextDTO();
        taskBookingContext.setTaskInstance(taskInstanceDTO);
        taskBookingContext.setMidiaGoProcess(midiaGoProcess);

        return taskBookingContext;
    }

    public TaskBookingContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskBookingContextDTO taskBookingContext) {
        MidiaGoDTO midiaGoDTO = midiaGoService.findOne(taskBookingContext.getMidiaGoProcess().getMidiaGo().getId()).orElseThrow();
        midiaGoDTO.setUserName(taskBookingContext.getMidiaGoProcess().getMidiaGo().getUserName());
        midiaGoDTO.setStartDate(taskBookingContext.getMidiaGoProcess().getMidiaGo().getStartDate());
        midiaGoDTO.setEndDate(taskBookingContext.getMidiaGoProcess().getMidiaGo().getEndDate());
        midiaGoDTO.setMediaName(taskBookingContext.getMidiaGoProcess().getMidiaGo().getMediaName());
        midiaGoDTO.setMediaBookingNumber(taskBookingContext.getMidiaGoProcess().getMidiaGo().getMediaBookingNumber());
        midiaGoService.save(midiaGoDTO);
    }

    public void complete(TaskBookingContextDTO taskBookingContext) {
        save(taskBookingContext);
        MidiaGoProcessDTO midiaGoProcess = midiaGoProcessRepository
            .findByProcessInstanceId(taskBookingContext.getMidiaGoProcess().getProcessInstance().getId())
            .map(midiaGoProcessMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskBookingContext.getTaskInstance(), midiaGoProcess);
    }
}
