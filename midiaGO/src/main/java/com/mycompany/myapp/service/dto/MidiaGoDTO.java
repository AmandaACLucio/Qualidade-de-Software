package com.mycompany.myapp.service.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.MidiaGo} entity.
 */
public class MidiaGoDTO implements Serializable {

    private Long id;

    private String userName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String mediaName;

    private String mediaBookingNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaBookingNumber() {
        return mediaBookingNumber;
    }

    public void setMediaBookingNumber(String mediaBookingNumber) {
        this.mediaBookingNumber = mediaBookingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MidiaGoDTO)) {
            return false;
        }

        MidiaGoDTO midiaGoDTO = (MidiaGoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, midiaGoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MidiaGoDTO{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", mediaName='" + getMediaName() + "'" +
            ", mediaBookingNumber='" + getMediaBookingNumber() + "'" +
            "}";
    }
}
