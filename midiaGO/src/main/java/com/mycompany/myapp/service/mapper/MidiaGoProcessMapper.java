package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.MidiaGoProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link MidiaGoProcess} and its DTO {@link MidiaGoProcessDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, MidiaGoMapper.class })
public interface MidiaGoProcessMapper extends EntityMapper<MidiaGoProcessDTO, MidiaGoProcess> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "midiaGo", source = "midiaGo")
    MidiaGoProcessDTO toDto(MidiaGoProcess s);
}
