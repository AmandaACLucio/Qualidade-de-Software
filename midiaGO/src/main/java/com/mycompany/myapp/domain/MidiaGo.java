package com.mycompany.myapp.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A MidiaGo.
 */
@Entity
@Table(name = "midia_go")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MidiaGo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "media_name")
    private String mediaName;

    @Column(name = "media_booking_number")
    private String mediaBookingNumber;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MidiaGo id(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return this.userName;
    }

    public MidiaGo userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public MidiaGo startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public MidiaGo endDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getMediaName() {
        return this.mediaName;
    }

    public MidiaGo mediaName(String mediaName) {
        this.mediaName = mediaName;
        return this;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaBookingNumber() {
        return this.mediaBookingNumber;
    }

    public MidiaGo mediaBookingNumber(String mediaBookingNumber) {
        this.mediaBookingNumber = mediaBookingNumber;
        return this;
    }

    public void setMediaBookingNumber(String mediaBookingNumber) {
        this.mediaBookingNumber = mediaBookingNumber;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MidiaGo)) {
            return false;
        }
        return id != null && id.equals(((MidiaGo) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MidiaGo{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", mediaName='" + getMediaName() + "'" +
            ", mediaBookingNumber='" + getMediaBookingNumber() + "'" +
            "}";
    }
}
