package com.petsalone.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.petsalone.core.My_Pet;
import com.petsalone.repository.PetRepository;
import com.petsalone.service.FileStorageService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/petfinder")
public class PetController {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private FileStorageService fileStorageService;

	@GetMapping("/all")
	public String allAccess() {
		return "petfinder";
	}

	@GetMapping("/pet")
	public List<My_Pet> getAllPets() {
		return petRepository.findAll();
	}

	@PostMapping("/pet")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public My_Pet savePet(@RequestBody My_Pet pet) {
		System.out.println(pet.getMissingSince());
		return petRepository.save(pet);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/uploadImage/{id}")
	public My_Pet savePet(@RequestParam("file") MultipartFile file, @PathVariable("id") int id) {
		System.out.println(id);
		try {
			return fileStorageService.store(file, id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
