package com.learning.springmvcboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learning.springmvcboot.model.Alien;

public interface AlienRepo extends JpaRepository<Alien,Integer>{

	//List<Alien> findByAname(String aname); // Query DSL

	@Query("from Alien where aname= :name and aid<100")
	List<Alien> find(@Param("name") String aname);
	
}