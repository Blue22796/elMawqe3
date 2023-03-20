package com.elMawqe3.Controllers.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elMawqe3.Models.Event;

@Repository
public interface NewsRepository extends JpaRepository<Event,Long>{

}
