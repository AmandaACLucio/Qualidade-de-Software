package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.MidiaGo;
import com.mycompany.myapp.repository.MidiaGoRepository;
import com.mycompany.myapp.service.dto.MidiaGoDTO;
import com.mycompany.myapp.service.mapper.MidiaGoMapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link MidiaGoResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class MidiaGoResourceIT {

    private static final String DEFAULT_USER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_USER_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_START_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_START_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_END_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_END_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_MEDIA_NAME = "AAAAAAAAAA";
    private static final String UPDATED_MEDIA_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_MEDIA_BOOKING_NUMBER = "AAAAAAAAAA";
    private static final String UPDATED_MEDIA_BOOKING_NUMBER = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/midia-gos";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private MidiaGoRepository midiaGoRepository;

    @Autowired
    private MidiaGoMapper midiaGoMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restMidiaGoMockMvc;

    private MidiaGo midiaGo;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MidiaGo createEntity(EntityManager em) {
        MidiaGo midiaGo = new MidiaGo()
            .userName(DEFAULT_USER_NAME)
            .startDate(DEFAULT_START_DATE)
            .endDate(DEFAULT_END_DATE)
            .mediaName(DEFAULT_MEDIA_NAME)
            .mediaBookingNumber(DEFAULT_MEDIA_BOOKING_NUMBER);
        return midiaGo;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static MidiaGo createUpdatedEntity(EntityManager em) {
        MidiaGo midiaGo = new MidiaGo()
            .userName(UPDATED_USER_NAME)
            .startDate(UPDATED_START_DATE)
            .endDate(UPDATED_END_DATE)
            .mediaName(UPDATED_MEDIA_NAME)
            .mediaBookingNumber(UPDATED_MEDIA_BOOKING_NUMBER);
        return midiaGo;
    }

    @BeforeEach
    public void initTest() {
        midiaGo = createEntity(em);
    }

    @Test
    @Transactional
    void getAllMidiaGos() throws Exception {
        // Initialize the database
        midiaGoRepository.saveAndFlush(midiaGo);

        // Get all the midiaGoList
        restMidiaGoMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(midiaGo.getId().intValue())))
            .andExpect(jsonPath("$.[*].userName").value(hasItem(DEFAULT_USER_NAME)))
            .andExpect(jsonPath("$.[*].startDate").value(hasItem(DEFAULT_START_DATE.toString())))
            .andExpect(jsonPath("$.[*].endDate").value(hasItem(DEFAULT_END_DATE.toString())))
            .andExpect(jsonPath("$.[*].mediaName").value(hasItem(DEFAULT_MEDIA_NAME)))
            .andExpect(jsonPath("$.[*].mediaBookingNumber").value(hasItem(DEFAULT_MEDIA_BOOKING_NUMBER)));
    }

    @Test
    @Transactional
    void getMidiaGo() throws Exception {
        // Initialize the database
        midiaGoRepository.saveAndFlush(midiaGo);

        // Get the midiaGo
        restMidiaGoMockMvc
            .perform(get(ENTITY_API_URL_ID, midiaGo.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(midiaGo.getId().intValue()))
            .andExpect(jsonPath("$.userName").value(DEFAULT_USER_NAME))
            .andExpect(jsonPath("$.startDate").value(DEFAULT_START_DATE.toString()))
            .andExpect(jsonPath("$.endDate").value(DEFAULT_END_DATE.toString()))
            .andExpect(jsonPath("$.mediaName").value(DEFAULT_MEDIA_NAME))
            .andExpect(jsonPath("$.mediaBookingNumber").value(DEFAULT_MEDIA_BOOKING_NUMBER));
    }

    @Test
    @Transactional
    void getNonExistingMidiaGo() throws Exception {
        // Get the midiaGo
        restMidiaGoMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
