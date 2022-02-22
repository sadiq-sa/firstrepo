package com.petsalone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petsalone.core.My_Pet;

public interface PetRepository  extends JpaRepository<My_Pet, Integer> {
	
	
}
