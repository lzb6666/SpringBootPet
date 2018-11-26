package com.test.pet.pst;

import com.test.pet.po.Pet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetMapper {
    @Select("select * from adopt_view")
    List<Pet> selectPets();

    @Select("select * from adopt_view where petID=#{petID}")
    Pet selectByID(String petID);

    @Insert("insert into pet (petID,name,detail,imgURL,owner,sex,age,variety,healthStatus,other) values (#{petID},#{name},#{detail},#{imgURL}" +
            ",#{owner},#{sex},#{age},#{variety},#{healthStatus},#{other})")
    int insertPet(Pet pet);

    @Select("select * from pet where owner=#{userID}")
    List<Pet> selectMyPet(String userID);

    @Update("update pet set name=#{name},detail=#{detail},imgURL=#{imgURL},variety=#{variety}," +
            "sex=#{sex},age=#{age},healthStatus=#{healthStatus},other=#{other} where petID=#{petID}")
    int update(Pet pet);
}
