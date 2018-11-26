package com.test.pet.nurse;

import com.test.pet.pet.PetService;
import com.test.pet.po.Nurse;
import com.test.pet.util.result.CodeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhong on 2018/11/26 18:31
 */
@RequestMapping("/nurse")
@RestController
public class NurseController {

    @Autowired
    private NurseService nurseService;
    @Autowired
    private PetService petService;

    @RequestMapping("/all")
    public List<Nurse> all(){
        return nurseService.getAll();
    }

    @RequestMapping("")
    public Nurse getNurse(String nurseID){
        return nurseService.getNurse(nurseID);
    }

    @RequestMapping("/apply")
    public CodeResult apply(String nurseID,String userID){
        if (nurseService.apply(nurseID,userID)){
            return new CodeResult(200,"申请成功，请等待主人联系审核");
        }else{
            return new CodeResult(400,"申请失败");
        }
    }

    @RequestMapping("/submit")
    public CodeResult submit(String nurseID,String result){
        if (nurseService.process(nurseID,result)){
            return new CodeResult(200,"处理完毕");
        }else{
            return new CodeResult(400,"处理失败");
        }
    }

    @RequestMapping("/add")
    public CodeResult addNurse(Nurse nurse,@RequestParam("petImg") MultipartFile file){
        try{
            String url=petService.petImg(file);
            nurse.setImgURL(url);
            if (nurseService.add(nurse)){
                return new CodeResult(200,"上传完毕");
            }else {
                return new CodeResult(400,"上传失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new CodeResult(400,"上传失败");
        }
    }

    @RequestMapping("/sendRecords")
    public List<Nurse> record(String userID){
        return nurseService.getAllSend(userID);
    }

    @RequestMapping("/reRecords")
    public List<Nurse> reRecord(String userID){
        return nurseService.getAllRe(userID);
    }
}
