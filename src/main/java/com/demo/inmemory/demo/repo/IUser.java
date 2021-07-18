package com.demo.inmemory.demo.repo;

import com.demo.inmemory.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User , Long> {
    User findOneById(Long id);

    @Query("SELECT email FROM User WHERE id=:id")
    String findEmailById(@Param("id") Long id);

}
