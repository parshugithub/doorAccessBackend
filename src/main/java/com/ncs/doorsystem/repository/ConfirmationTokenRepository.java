package com.ncs.doorsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.ConfirmationToken;
import com.ncs.doorsystem.entity.Customer;
@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
	ConfirmationToken findByToken(String confirmToken);
	
	//ConfirmationToken deleteBytoken_id(Long token_id);

	ConfirmationToken findByCustomer(Customer checkUser);

	ConfirmationToken findByCustomer_id(long id);

	void deleteBytokenid(long custId);
	
//	@Query("delete from ConfirmationToken c where c.token_id=:#{#id}")
//	void deletetokenid(@Param("id")long id);

	int deleteBytoken(String token);

	ConfirmationToken findBycustomer(Customer changePassObj);

	@Modifying
	@Query(value = "delete FROM doorsystem.confrirmation_token where id=:id",nativeQuery=true)
	void deleteByid(long id);

	//int deleteByCustomer_id(long id);

	//void deletetByToken(String token);

	//void deletetBytoken_id(long id);

//	ConfirmationToken findByToken(String confirmationToken);
}
