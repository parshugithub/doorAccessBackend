package com.ncs.doorsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.DashBoardmodal;

@Repository
public interface DashBoardRepository extends JpaRepository<CreateSiteModal, Long>
{
	CreateSiteModal findByCustomerName(String customer);

	@Query(value = "SELECT * FROM  doorsystem.site_table where cust_id=:custid And siteid=:siteid",nativeQuery=true)
	CreateSiteModal findSiteBySiteidAndCustomerid(long custid, long siteid);

	CreateSiteModal findBydeviceId(String string);

}
