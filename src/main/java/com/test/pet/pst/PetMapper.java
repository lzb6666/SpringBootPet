package com.test.pet.pst;

import com.test.pet.po.Pet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetMapper {
    @Select("select * from pet where owner is null limit #{start},#{end}")
    List<Pet> selectPets(@Param("start") int start,@Param("end") int end);

    @Select("select * from pet where petID=#{petID}")
    Pet selectByID(String petID);

    @Insert("insert into pet (petID,name,detail,imgURL) values (#{petID},#{name},#{detail},#{imgURL})")
    int insertPet(Pet pet);
}
