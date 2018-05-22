package com.example.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MemberDAO extends JpaRepository<MemberDO, Integer> {
    @Query(value = "SELECT * FROM member m WHERE m.user_id = :userId", nativeQuery = true)
    MemberDO selectByUserId(@Param("userId") String userId);

    @Query(value = "SELECT * FROM member m WHERE m.email = :email", nativeQuery = true)
    MemberDO selectByEmail(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM member m WHERE m.user_id = :userId", nativeQuery = true)
    int deleteByUserId(@Param("userId") String userId);
}
