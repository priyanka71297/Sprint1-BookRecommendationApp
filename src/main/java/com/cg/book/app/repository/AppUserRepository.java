package com.cg.book.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.book.app.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

}