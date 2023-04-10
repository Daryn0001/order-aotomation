package kz.sdu.stu.dsalimov.dao;

import kz.sdu.stu.dsalimov.dto.db.Company;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CompanyDao {

    @Select(//language=PostgreSQL
            "SELECT uuid, name, description, address, phone, owner_uuid as ownerUuid FROM companies WHERE uuid = #{uuid}")
    Company findById(String uuid);

    @Insert(//language=PostgreSQL
            "INSERT INTO companies (uuid, name, description, address, phone, owner_uuid) VALUES (#{uuid}, #{name}, #{description}, #{address}, #{phone}, #{ownerUuid})")
    void insert(Company company);

    @Delete(//language=PostgreSQL
            "DELETE FROM companies WHERE uuid = #{uuid}")
    void delete(String uuid);

    @Update(//language=PostgreSQL
            "UPDATE companies SET name = #{name} WHERE uuid = #{uuid}")
    void updateName(String uuid, String name);

    @Update(//language=PostgreSQL
            "UPDATE companies SET description = #{description} WHERE uuid = #{uuid}")
    void updateDescription(String uuid, String description);

    @Update(//language=PostgreSQL
            "UPDATE companies SET address = #{address} WHERE uuid = #{uuid}")
    void updateAddress(String uuid, String address);

    @Update(//language=PostgreSQL
            "UPDATE companies SET phone = #{phone} WHERE uuid = #{uuid}")
    void updatePhone(String uuid, String phone);

    @Update(//language=PostgreSQL
            "UPDATE companies SET owner_uuid = #{ownerUuid} WHERE uuid = #{uuid}")
    void updateOwnerUuid(String uuid, String ownerUuid);
}
