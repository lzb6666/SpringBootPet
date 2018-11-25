package com.test.pet.pst;

import com.test.pet.po.VCode;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface VCodeMapper {
    @Select("select count(code) from vcode where phoneNum=#{phoneNum} and type=#{type} and code=#{code}")
    int selectVCode(@Param("phoneNum")String phoneNum,@Param("code") String code,@Param("type")String type);

    @Insert("insert into vcode values (#{phoneNum},#{code},#{type})")
    int insert(VCode vCode);
}
