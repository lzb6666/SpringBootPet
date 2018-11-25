package com.test.pet.adopt;

import com.test.pet.po.AdoptRecord;
import com.test.pet.po.Pet;
import com.test.pet.util.result.CodeResult;
import com.test.pet.util.result.PetCode;
import com.test.pet.util.result.PetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/adopt")
public class AdoptController {

    @Autowired
    private AdoptService adoptService;



    @RequestMapping("")
    public PetResult adopt(String petID, String userID){
        if (adoptService.adopt(petID, userID)){

            return new CodeResult(PetCode.SUCCESS,"领养成功");
        }else{
            return new CodeResult(PetCode.FAIL,"领养失败");
        }
    }

    @RequestMapping("/records")
    public List<AdoptRecord> records(String userID){
        return adoptService.records(userID);
    }

    @RequestMapping("/record")
    public AdoptRecord record(String recordID){
        return adoptService.record(recordID);
    }
}
