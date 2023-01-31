package com.dailycodework.excel2database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodework.excel2database.domain.Users;



public interface UserRepository extends JpaRepository<Users,Long>  {

}
