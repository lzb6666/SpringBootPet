package com.test.pet.pet;

import com.test.pet.po.Pet;
import com.test.pet.pst.AdoptMapper;
import com.test.pet.pst.PetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class PetService {
    //private String filePath="e:\\test\\";
    private String filePath="/usr/share/tomcat7/image/pet/";
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private AdoptMapper adoptMapper;
    public List<Pet> pets(){
        return petMapper.selectPets();
    }

    public Pet pet(String petID){
        return petMapper.selectByID(petID);
    }

    public void createPet(Pet pet){
        petMapper.insertPet(pet);
    }

    public String petImg(MultipartFile file)throws Exception{
        byte[] bytes = file.getBytes();
        String fileName= UUID.randomUUID().toString().replace('_','1')+".png";
        Path path = Paths.get(filePath + fileName);
        Files.write(path, bytes);
        return "http://193.112.44.141/image/pet/" + fileName;
    }

    public void setAdopt2False(String petID){
        adoptMapper.updateAdopt(petID);
    }

    public List<Pet> myPets(String userID){
        return petMapper.selectMyPet(userID);
    }

    public int updatePet(Pet pet){
        return petMapper.update(pet);
    }
}
