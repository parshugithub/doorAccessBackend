package com.ncs.doorsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.CreateUserModal;

@Repository
public interface CreateSiteRepository extends JpaRepository<CreateSiteModal, String> 
{
	
	CreateSiteModal findByCustomerName(CreateSiteModal createSite);

	List<CreateSiteModal> findByCustomerName(String customerName);

	CreateSiteModal findBysiteName(String siteName);
	
	@Query("SELECT s FROM CreateSiteModal s WHERE CONCAT(s.siteName, ' ', s.deviceId, ' ', s.siteReference, ' ', s.customerName,'',"
			+ "s.customerAddress,' ',s.customerPhone,' ',s.address2,' ',s.country,' ',s.area,' ',s.town,' ',s.city) LIKE %?1%")
	public List<CreateSiteModal> search(String keyword);

	int deleteBysiteName(String sitename);

	CreateSiteModal findBydeviceId(String deviceId);

	List<CreateSiteModal> findBycustId(long custId);

	CreateSiteModal findBysiteid(long siteid);

	
	@Modifying
	@Query(value = "delete FROM doorsystem.t_staffgroup_site_mapping_table where site_id=:siteid",nativeQuery=true)
	void deleteMappedSite(long siteid);
	
//	@Query("SELECT s FROM CreateSiteModal s WHERE s.siteName=:sitename and s.deviceId=:deviceId")
//	CreateSiteModal findbysiteNameAnddeviceId(String sitename,String deviceId);
	
	//CreateSiteModal findTopBysiteNameAndDeviceId(String sitename,String deviceId);
	

	//CreateUserModal findBysiteName(String siteName);

}
