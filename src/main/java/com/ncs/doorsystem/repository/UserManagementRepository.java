package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.CreateUserModal;

@Repository
public interface UserManagementRepository extends JpaRepository<CreateUserModal,String> {

	CreateUserModal findByuserName(String userName);
	int deleteByuserName(String userName);
	
//	@Query("SELECT u FROM CreateUserModal u WHERE CONCAT(u.user_name, u.first_name, u.last_name, u.address,u.user_type,"
//			+ "u.phone_number,u.email) LIKE %?1%")
//	List<CreateUserModal> search(String keyword);
	
	@Query("SELECT p FROM CreateUserModal p WHERE CONCAT(p.userName, ' ', p.firstName, ' ', p.lastName, ' ', p.address,'',"
			+ "p.user_type,' ',p.phone_number,' ',p.email) LIKE %?1%")
	public List<CreateUserModal> search(String keyword);
	
	List<CreateUserModal> findBycustId(long custId);
	
	@Query(value = "SELECT * FROM user_table c WHERE c.user_type=:voiceOperator And c.cust_id=:custId ",nativeQuery=true)
	List<CreateUserModal> getAllVoiceOperator(String voiceOperator, long custId);
	

}
