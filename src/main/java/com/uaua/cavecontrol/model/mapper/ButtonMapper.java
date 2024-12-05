package com.uaua.cavecontrol.model.mapper;

import com.uaua.cavecontrol.model.dto.ButtonDTO;
import com.uaua.cavecontrol.model.entity.Button;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ButtonMapper {

    ButtonDTO toDTO(Button button);

    Button toEntity(ButtonDTO buttonDTO);
}
