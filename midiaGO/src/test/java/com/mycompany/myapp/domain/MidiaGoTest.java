package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class MidiaGoTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(MidiaGo.class);
        MidiaGo midiaGo1 = new MidiaGo();
        midiaGo1.setId(1L);
        MidiaGo midiaGo2 = new MidiaGo();
        midiaGo2.setId(midiaGo1.getId());
        assertThat(midiaGo1).isEqualTo(midiaGo2);
        midiaGo2.setId(2L);
        assertThat(midiaGo1).isNotEqualTo(midiaGo2);
        midiaGo1.setId(null);
        assertThat(midiaGo1).isNotEqualTo(midiaGo2);
    }
}
