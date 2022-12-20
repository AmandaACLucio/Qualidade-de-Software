package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MidiaGoDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(MidiaGoDTO.class);
        MidiaGoDTO midiaGoDTO1 = new MidiaGoDTO();
        midiaGoDTO1.setId(1L);
        MidiaGoDTO midiaGoDTO2 = new MidiaGoDTO();
        assertThat(midiaGoDTO1).isNotEqualTo(midiaGoDTO2);
        midiaGoDTO2.setId(midiaGoDTO1.getId());
        assertThat(midiaGoDTO1).isEqualTo(midiaGoDTO2);
        midiaGoDTO2.setId(2L);
        assertThat(midiaGoDTO1).isNotEqualTo(midiaGoDTO2);
        midiaGoDTO1.setId(null);
        assertThat(midiaGoDTO1).isNotEqualTo(midiaGoDTO2);
    }
}
