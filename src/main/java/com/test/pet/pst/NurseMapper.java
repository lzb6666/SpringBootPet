package com.test.pet.pst;

import com.test.pet.po.Nurse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhong on 2018/11/26 18:15
 */
@Repository
public interface NurseMapper {

    @Select("select * from nurse where status='available'")
    List<Nurse> selectAll();

    @Select("select * from nurse where nurseID=#{nurseID}")
    Nurse selectByID(String nurseID);

    @Insert("insert into nurse values (#{nurseID},#{announcer},#{recipient},#{recTime},#{imgURL},#{variety},#{sex},#{age}" +
            ",#{health},#{note},#{other},#{status},#{name})")
    int insert(Nurse nurse);

    //接受寄养
    @Update("update nurse set status=#{status} where nurseID=#{nurseID}")
    int recipient(@Param("nurseID") String nurseID,@Param("status")String status);

    //申请寄养
    @Update("update nurse set recTime=#{recTime},status=#{status},recipient=#{userID} where nurseID=#{nurseID}")
    int updateStatus(@Param("nurseID") String nurseID,@Param("userID") String userID
            ,@Param("status")String status,@Param("recTime")String recTime);

    @Select("select * from nurse where announcer=#{userID}")
    List<Nurse> selectAllSend(String userID);

    @Select("select * from nurse where recipient=#{userID} and status <> 'available'")
    List<Nurse> selectAllRe(String userID);
}
