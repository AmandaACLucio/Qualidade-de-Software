package com.mycompany.myapp.process.midiaGoProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/midia-go-process/task-booking")
public class TaskBookingController {

    private final Logger log = LoggerFactory.getLogger(TaskBookingController.class);

    private final TaskBookingService taskBookingService;

    public TaskBookingController(TaskBookingService taskBookingService) {
        this.taskBookingService = taskBookingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskBookingContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBookingContextDTO taskBookingContext = taskBookingService.loadContext(id);
        return ResponseEntity.ok(taskBookingContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskBookingContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskBookingContextDTO taskBookingContext = taskBookingService.claim(id);
        return ResponseEntity.ok(taskBookingContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskBookingContextDTO taskBookingContext) {
        log.debug("REST request to complete MidiaGoProcess.TaskBooking {}", taskBookingContext.getTaskInstance().getId());
        taskBookingService.complete(taskBookingContext);
        return ResponseEntity.noContent().build();
    }
}
