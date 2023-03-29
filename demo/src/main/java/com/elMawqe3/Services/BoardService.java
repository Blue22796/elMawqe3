package com.elMawqe3.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.elMawqe3.Controllers.Repositories.BoardRepository;
import com.elMawqe3.Models.Comment;

@Service
public class BoardService {

	private final BoardRepository bRepo;
	
	public BoardService(BoardRepository bRepo) {
		this.bRepo=bRepo;
	}
	
	public List<Comment> getAll(){
		return bRepo.findAll();
	}

	public void save(Comment cmt) {
		bRepo.save(cmt);
	}
}
