package com.test.pet.account;

import com.test.pet.po.User;
import com.test.pet.util.result.CodeResult;
import com.test.pet.util.result.PetCode;
import com.test.pet.util.result.PetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/login")
    public PetResult login(String phoneNum, String password){
        User user  = accountService.login(phoneNum,password);
        return user;
    }

    //@param type:注册1 忘记密码2
    @RequestMapping("/VCode")
    public PetResult vCode(String phoneNum,String type){
        try{
            accountService.sendVCode(phoneNum,type);
        }catch (Exception e){
            e.printStackTrace();
            return new CodeResult(PetCode.SUCCESS,"验证码发送失败");
        }
        return new CodeResult(PetCode.SUCCESS,"验证码发送成功");
    }

    @RequestMapping("/vlfVCode")
    public PetResult vlfVCode(String phoneNum,String VCode,String type){
        if (accountService.vlfCode(phoneNum,VCode,type)){
            return new CodeResult(PetCode.SUCCESS,"验证成功");
        }else {
            return new CodeResult(PetCode.FAIL,"验证失败");
        }

    }

    @RequestMapping("/register")
    public PetResult register(String phoneNum,String VCode,String password){
        if (accountService.vlfCode(phoneNum,VCode,"1")){
            accountService.createUser(phoneNum,password);
        }else{
            return new CodeResult(PetCode.SUCCESS,"注册失败");
        }
        return new CodeResult(PetCode.SUCCESS,"注册成功");
    }

    @RequestMapping("/reset")
    public PetResult resetPassword(String userID,String oldPassword,String newPassword){
        CodeResult codeResult=accountService.vlfOldPassword(userID,oldPassword);
        if (codeResult.getRstCode()==200){
            accountService.resetPwd(userID,newPassword);
            return new CodeResult(PetCode.SUCCESS," 重置密码成功");
        }else{
            return codeResult;
        }
    }

    @RequestMapping("/uploadHeadImg")
    public CodeResult uploadPet(@RequestParam("headImg") MultipartFile file, String userID){
        try{
            String url=accountService.setHeadImg(file,userID);
        }catch (Exception e){
            e.printStackTrace();
            return new CodeResult(400,"头像信息上传失败");
        }
        return new CodeResult(200,"头像信息上传成功");
    }

    @RequestMapping("/info")
    public PetResult user(String userID){
        return accountService.selectUserById(userID);
    }

    @RequestMapping("/update")
    public CodeResult uploadUser(User user){
        return accountService.updateUser(user);
    }
}
