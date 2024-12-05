package com.uaua.cavecontrol.controller;

import com.uaua.cavecontrol.model.dto.CommentDTO;
import com.uaua.cavecontrol.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public ResponseEntity<CommentDTO> getComment() {
        CommentDTO comment = commentService.getComment();
        return ResponseEntity.ok(comment);
    }

    @PutMapping
    public ResponseEntity<CommentDTO> updateComment(@RequestBody CommentDTO commentDTO) {
        CommentDTO updatedComment = commentService.updateComment(commentDTO.getContent());
        return ResponseEntity.ok(updatedComment);
    }
}
