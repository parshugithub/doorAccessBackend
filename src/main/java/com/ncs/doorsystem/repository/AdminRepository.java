package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.AdminLoginModal;

@Repository
public interface AdminRepository extends JpaRepository<AdminLoginModal, String> {

	AdminLoginModal findByemail(String email);

	//AdminLoginModal findAdminById(String userName);

}
