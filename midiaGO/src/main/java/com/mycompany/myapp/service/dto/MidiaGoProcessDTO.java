package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;
import org.akip.service.dto.ProcessInstanceDTO;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.MidiaGoProcess} entity.
 */
public class MidiaGoProcessDTO implements Serializable {

    private Long id;

    private ProcessInstanceDTO processInstance;

    private MidiaGoDTO midiaGo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProcessInstanceDTO getProcessInstance() {
        return processInstance;
    }

    public void setProcessInstance(ProcessInstanceDTO processInstance) {
        this.processInstance = processInstance;
    }

    public MidiaGoDTO getMidiaGo() {
        return midiaGo;
    }

    public void setMidiaGo(MidiaGoDTO midiaGo) {
        this.midiaGo = midiaGo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MidiaGoProcessDTO)) {
            return false;
        }

        MidiaGoProcessDTO midiaGoProcessDTO = (MidiaGoProcessDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, midiaGoProcessDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MidiaGoProcessDTO{" +
            "id=" + getId() +
            ", processInstance=" + getProcessInstance() +
            ", midiaGo=" + getMidiaGo() +
            "}";
    }
}
