package com.test.pet.pst;

import com.test.pet.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {
    @Select("SELECT userID,username,phoneNum,headImgURL FROM user WHERE phoneNum = #{phoneNum} AND password = #{password}")
    User select(@Param("phoneNum") String phoneNum, @Param("password") String password);

    @Insert("insert into user (userID,phoneNum,username) values (#{userID},#{phoneNum},#{username})")
    int insert(User user);

    @Update("update user set password=#{password} where userID=#{userID}")
    int updatePwd(@Param("userID")String userID,@Param("password") String password);

    @Select("select count(userID) from user where phoneNum=#{phoneNum}")
    int selectUserCount(String phoneNum);

    @Update("update user set password=#{password} where phoneNum=#{phoneNum}")
    int updatePwdByPhone(@Param("phoneNum")String phoneNum,@Param("password") String password);

    @Update("update user set headImgURL=#{imgURL} where userID=#{userID}")
    int updateImg(@Param("imgURL") String imgURL,@Param("userID") String userID);

    @Select("select userID,username,headImgURL,sex,age,career,city,petExperience,preference from user where userID=#{userID}")
    User selectUser(String userID);

    @Update("update user set username=#{username},sex=#{sex},age=#{age},career=#{career},city=#{city}" +
            ",petExperience=#{petExperience},preference=#{preference} where userID=#{userID}")
    int updateUser(User user);

    @Update("update user set password=#{password} where userID=#{userID}")
    int updatePwdByUserID(@Param("userID")String userID,@Param("password") String password);

    @Select("select userID from user where userID=#{userID} and password=#{password}")
    String vlfOld(@Param("userID")String userID,@Param("password") String password);
}
