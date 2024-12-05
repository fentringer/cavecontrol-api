package com.uaua.cavecontrol.service;

import com.uaua.cavecontrol.exception.EntityNotFoundException;
import com.uaua.cavecontrol.model.dto.CommentDTO;
import com.uaua.cavecontrol.model.entity.Comment;
import com.uaua.cavecontrol.model.mapper.CommentMapper;
import com.uaua.cavecontrol.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository repository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository repository, CommentMapper commentMapper) {
        this.repository = repository;
        this.commentMapper = commentMapper;
    }

    public CommentDTO getComment() {
        return commentMapper.toDTO(findComment());
    }

    public CommentDTO updateComment(String content) {
        Comment comment = findComment();

        comment.setContent(content);
        comment = repository.save(comment);

        return commentMapper.toDTO(comment);
    }

    private Comment findComment() {
        Comment comment = repository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found."));
        return comment;
    }
}
