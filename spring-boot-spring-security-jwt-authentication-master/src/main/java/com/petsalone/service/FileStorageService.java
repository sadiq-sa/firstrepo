package com.petsalone.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.petsalone.core.My_Pet;
import com.petsalone.repository.PetRepository;

@Service
public class FileStorageService {

  @Autowired
  private PetRepository petRepository;

  public My_Pet store(MultipartFile file,int id) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Optional<My_Pet> FileDB = petRepository.findById(id);
    FileDB.get().setPetImg(file.getBytes());
    return petRepository.save(FileDB.get());
  }
}
