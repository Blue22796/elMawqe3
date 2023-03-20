package com.elMawqe3.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elMawqe3.Controllers.Repositories.NewsRepository;
import com.elMawqe3.Models.Event;

@Service
public class newsService {

	private final NewsRepository newsRepo;
	
	@Autowired
	public newsService(NewsRepository newsRepo) {
		this.newsRepo=newsRepo;
	}
	
	public List<Event> events() {
		return newsRepo.findAll();
	}
	
	public void insert(Event newEvent) {
		newsRepo.save(newEvent);
	}
	
}
