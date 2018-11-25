package com.test.pet.adopt;


import com.test.pet.po.Adopt;
import com.test.pet.po.AdoptRecord;
import com.test.pet.pst.AdoptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdoptService {
    @Autowired
    private AdoptMapper adoptMapper;

    @Transactional
   public boolean adopt(String petID,String userID){
        if (adoptMapper.insert(new Adopt(userID, petID))==1){
            adoptMapper.adopt(petID,userID);
            adoptMapper.updateAdopt(petID);
            return true;
        }else{
            return false;
        }
   }

   public List<AdoptRecord> records(String userID){
       return adoptMapper.selectRecord(userID);
   }

   public AdoptRecord record(String recordID){
       return adoptMapper.select(recordID);
   }

}
