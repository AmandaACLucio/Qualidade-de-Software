package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.MidiaGoDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link MidiaGo} and its DTO {@link MidiaGoDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MidiaGoMapper extends EntityMapper<MidiaGoDTO, MidiaGo> {}
