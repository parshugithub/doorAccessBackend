package com.ncs.doorsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ncs.doorsystem.entity.StaffManyToMany;
import com.ncs.doorsystem.entity.StaffGroupManytoMany;
public interface StaffGroupManytomanyRepository extends JpaRepository<StaffGroupManytoMany, Long> {

	
	@Query(value = "select * FROM doorsystem.staff_group_table where staff_group_name=:staffGroupName and customerid=:custid ",nativeQuery=true)
	StaffGroupManytoMany findstaffGroupName(String staffGroupName, long custid);

	List<StaffGroupManytoMany> findBycustomerid(long custId);

	
	
	
//	@Modifying
//	@Query(value = "delete FROM doorsystem.t_staff_staffgroup_mapping_table, where staffgroup_id=:id",nativeQuery=true)
//	void deleteMappedStaffGroup(long id);

	@Modifying
	@Query(value = "delete FROM doorsystem.t_staffgroup_site_mapping_table where group_id=:id",nativeQuery=true)
	void deleteMappedSite(long id);

	@Modifying
	@Query(value = "delete FROM doorsystem.t_staffgroup_door_mapping_table where group_id=:id",nativeQuery=true)
	void deleteMappedDoor(long id);

	@Modifying
	@Query(value = "delete FROM doorsystem.t_staffgroup_tag_mapping_table where group_id=:id",nativeQuery=true)
	void deleteMappedTag(long id);

	@Modifying
	@Query(value = "delete FROM doorsystem.t_staff_staffgroup_mapping_table where staffgroup_id=:id",nativeQuery=true)
	void deleteMappedStaff(long id);

}
