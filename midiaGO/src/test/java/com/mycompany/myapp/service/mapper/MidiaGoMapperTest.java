package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MidiaGoMapperTest {

    private MidiaGoMapper midiaGoMapper;

    @BeforeEach
    public void setUp() {
        midiaGoMapper = new MidiaGoMapperImpl();
    }
}
