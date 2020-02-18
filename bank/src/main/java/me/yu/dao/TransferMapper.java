package me.yu.dao;

import me.yu.domain.Transfer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferMapper {
    @Select("select * from transfers where f_uid=#{uid} or t_uid=#{uid}")
    Transfer findByUid(Integer uid);
    @Insert("insert into transfers (id,f_uid,t_uid,money) values (#{id},#{f_uid},#{t_uid},#{money})")
    void insetTransfer(Transfer transfer);
    /*不能改账和删除账*/
}
