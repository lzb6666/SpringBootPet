package com.test.pet.pst;

import com.test.pet.po.Adopt;
import com.test.pet.po.AdoptRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptMapper {
    @Update("update pet set owner=#{userID} where petID=#{petID}")
    int adopt(@Param("petID")String petID,@Param("userID") String userID);

    @Select("select * from recoder_view where userID=#{userID}")
    List<AdoptRecord> selectRecord(String userID);

    @Insert("insert into adopt_record values (#{recordID},#{petID},#{userID},#{adoptTime})")
    int insert(Adopt adopt);

    @Select("select * from recoder_view where recordID=#{recordID}")
    AdoptRecord select(String recordID);

    @Update("update pet set isAdopt='false' where petID=#{petID}")
    int updateAdopt(String petID);
}
