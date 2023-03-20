package com.elMawqe3.Controllers.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elMawqe3.Models.Comment;

@Repository
public interface BoardRepository extends JpaRepository<Comment,Long> {
}
