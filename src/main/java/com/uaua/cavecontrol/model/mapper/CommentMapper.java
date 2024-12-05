package com.uaua.cavecontrol.model.mapper;

import com.uaua.cavecontrol.model.dto.CommentDTO;
import com.uaua.cavecontrol.model.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDTO toDTO(Comment comment);

    Comment toEntity(CommentDTO commentDTO);
}
