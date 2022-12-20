package com.mycompany.myapp.process.midiaGoProcess;

import com.mycompany.myapp.domain.MidiaGo;
import com.mycompany.myapp.domain.MidiaGoProcess;
import com.mycompany.myapp.service.dto.MidiaGoDTO;
import com.mycompany.myapp.service.dto.MidiaGoProcessDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskBookingMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    MidiaGoProcessDTO toMidiaGoProcessDTO(MidiaGoProcess midiaGoProcess);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "mediaName", source = "mediaName")
    @Mapping(target = "mediaBookingNumber", source = "mediaBookingNumber")
    MidiaGoDTO toMidiaGoDTO(MidiaGo midiaGo);
}
