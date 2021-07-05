package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.UserTypeModal;

@Repository
public interface UsertypeRepository extends JpaRepository<UserTypeModal, String> 
{
//	@Query(value="SELECT * FROM user_type",nativeQuery=true)
//	List<UserTypeModal> getAll();
	//List<UserTypeModal> findByUserType(UserTypeModal typeModal);
	

}
