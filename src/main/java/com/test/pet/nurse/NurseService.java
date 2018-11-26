package com.test.pet.nurse;

import com.test.pet.po.Nurse;
import com.test.pet.pst.NurseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhong on 2018/11/26 18:32
 */
@Service
public class NurseService {
    @Autowired
    private NurseMapper nurseMapper;

    private String filePath="/usr/share/tomcat7/image/pet/";

    public List<Nurse> getAll(){
        return nurseMapper.selectAll();
    }

    public Nurse getNurse(String nurseID){
        return nurseMapper.selectByID(nurseID);
    }

    public boolean apply(String nurseID,String userID){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (nurseMapper.updateStatus(nurseID,userID,"applying", df.format(new Date()))==1){
            return true;
        }else {
            return false;
        }
    }

    public boolean process(String nurseID,String result){
        if (result.equals("ok")){
            if (nurseMapper.recipient(nurseID,"complete")==1){
                return true;
            }
        }else if (result.equals("no")){
            if (nurseMapper.recipient(nurseID,"available")==1){
                return true;
            }
        }else {
            return false;
        }
        return false;
    }

    public boolean add(Nurse nurse){
         if (nurseMapper.insert(nurse)==1){
             return true;
         }else {
             return false;
         }
    }

    public List<Nurse> getAllSend(String userID){
        return nurseMapper.selectAllSend(userID);
    }

    public List<Nurse> getAllRe(String userID){
        return nurseMapper.selectAllRe(userID);
    }

}
