package com.fun2code.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fun2code.demo.spring.entity.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	 @Modifying
	 @Transactional
	 @Query("delete from Person where TO_DAYS(updatable)>=60")
public void delete_automatically();
}
