package com.test.pet.account;

import com.test.pet.po.User;
import com.test.pet.po.VCode;
import com.test.pet.pst.AccountMapper;
import com.test.pet.pst.VCodeMapper;
import com.test.pet.util.result.CodeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class AccountService {
    private String filePath="/usr/share/tomcat7/image/pet/";
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private VCodeMapper vCodeMapper;
    public User login(String phoneNum, String password){
        return accountMapper.select(phoneNum,password);
    }

    @Transactional
    public void createUser(String phoneNum,String password){
        if (existUser(phoneNum)){
            return;
        }
        User user = new User(phoneNum);
        accountMapper.insert(user);
        accountMapper.updatePwd(user.getUserID(),password);
    }

    public boolean vlfCode(String phoneNum,String VCode,String type){
        if (vCodeMapper.selectVCode(phoneNum,VCode,type)!=0){
            return true;
        }else{
            return false;
        }
    }

    public void sendVCode(String phoneNum,String type)throws Exception{
        VCode vCode=new VCode(phoneNum,"123456",type);
        vCodeMapper.insert(vCode);
    }

    public boolean existUser(String phoneNum){
        if (accountMapper.selectUserCount(phoneNum)!=0){
            return true;
        }else {
            return false;
        }
    }

    public boolean resetPwd(String phoneNum,String newPwd){
        if (accountMapper.updatePwdByPhone(phoneNum,newPwd)==1){
            return true;
        }else {
            return false;
        }
    }

    public String setHeadImg(MultipartFile file,String userID)throws Exception{
        byte[] bytes = file.getBytes();
        String fileName= UUID.randomUUID().toString().replace('_','1')+".png";
        Path path = Paths.get(filePath + fileName);
        Files.write(path, bytes);
        String imgURL="http://193.112.44.141/image/pet/" + fileName;
        accountMapper.updateImg(imgURL,userID);
        return imgURL;
    }

    public User selectUserById(String userID){
        return accountMapper.selectUser(userID);
    }

    public CodeResult updateUser(User user){
        if (user.getUserID()==null){
            return new CodeResult(400,"用户不存在");
        }
        if (accountMapper.updateUser(user)==1){
            return new CodeResult(200,"用户信息更新成功");
        }else {
            return new CodeResult(400,"用户信息更新失败");
        }
    }
}
