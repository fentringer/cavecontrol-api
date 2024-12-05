package com.uaua.cavecontrol.repository;

import com.uaua.cavecontrol.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
