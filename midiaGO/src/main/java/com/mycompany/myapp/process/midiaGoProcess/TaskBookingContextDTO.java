package com.mycompany.myapp.process.midiaGoProcess;

import com.mycompany.myapp.service.dto.MidiaGoProcessDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskBookingContextDTO {

    private MidiaGoProcessDTO midiaGoProcess;
    private TaskInstanceDTO taskInstance;

    public MidiaGoProcessDTO getMidiaGoProcess() {
        return midiaGoProcess;
    }

    public void setMidiaGoProcess(MidiaGoProcessDTO midiaGoProcess) {
        this.midiaGoProcess = midiaGoProcess;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
