package com.test.pet.pet;

import com.test.pet.po.Pet;
import com.test.pet.util.result.CodeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;
    @RequestMapping("/pets")
    public List<Pet> pets(){
        return petService.pets();
    }

    @RequestMapping("")
    public Pet pet(String petID){
        return petService.pet(petID);
    }

    @RequestMapping("/upload")
    public CodeResult uploadPet(@RequestParam("petImg") MultipartFile file,String name,String detail,String sex,String age,String health,String other,String variety,String userID){
        if (file==null){
            System.out.println(1);
        }
        try{
            String url=petService.petImg(file);
            Pet pet=new Pet(name,detail,url,userID,variety,sex,age,health,other);
            petService.createPet(pet);
        }catch (Exception e){
            e.printStackTrace();
            return new CodeResult(400,"宠物信息上传失败");
        }
        return new CodeResult(200,"宠物信息上传成功");
    }

    @RequestMapping("/uploadPet")
    public CodeResult upload(@RequestParam("petImg") MultipartFile file,String name,String detail,String sex,String age,String health,String other,String variety,String userID){
        try{
            String url=petService.petImg(file);
            Pet pet=new Pet(name,detail,url,userID,variety,sex,age,health,other);
            petService.createPet(pet);
            petService.setAdopt2False(pet.getPetID());
        }catch (Exception e){
            e.printStackTrace();
            return new CodeResult(400,"宠物信息上传失败");
        }
        return new CodeResult(200,"宠物信息上传成功");
    }

    @RequestMapping("/my")
    public List<Pet> myPets(String userID){
        return  petService.myPets(userID);
    }

    @RequestMapping("/updatePet")
    public CodeResult updatePet(@RequestParam("petImg") MultipartFile file,String name,String detail,String sex,String age,String health,String other,String variety,String petID){
        try{
            String url=petService.petImg(file);
            Pet pet=new Pet(petID,name,detail,url);
            pet.setSex(sex);
            pet.setAge(age);
            pet.setVariety(variety);
            pet.setHealthStatus(health);
            pet.setOther(other);
            petService.updatePet(pet);
            //petService.setAdopt2False(pet.getPetID());
        }catch (Exception e){
            e.printStackTrace();
            return new CodeResult(400,"宠物信息上传失败");
        }
        return new CodeResult(200,"宠物信息上传成功");
    }
}
