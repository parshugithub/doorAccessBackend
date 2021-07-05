package com.ncs.doorsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.ScheduleMainModal;
import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.StaffModal;

@Repository
public interface StaffManytoManyRepository extends JpaRepository<StaffManyToMany, Long> {

	StaffManyToMany findBypayrollno(String payrollno);

	Optional<StaffManyToMany> findById(long staffid);

	List<StaffManyToMany> findBycustomerId(Long custId);

	@Query(value = "SELECT schedule_id FROM doorsystem.t_staff_schedule_mapping_table  where staff_id=:staffid",nativeQuery=true)
	List<Long> getSchedules(long staffid);
	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_staff_staffgroup_mapping_table where staff_id=:staffid",nativeQuery=true)
	void deleteStaff(long staffid);

	@Query(value = "select * FROM doorsystem.staff_table where payrollno=:payrollno and customer_id=:custid ",nativeQuery=true)
	StaffManyToMany getstaff(String payrollno, long custid );

}
