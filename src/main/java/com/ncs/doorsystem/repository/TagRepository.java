package com.ncs.doorsystem.repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.ChannelTag;
import com.ncs.doorsystem.entity.TagModal;

@Repository
public interface TagRepository extends JpaRepository<TagModal, Long> {

	List<TagModal> findBycustomerid(long custid);

	List<ChannelTag> findBytagname(String tagname);

	TagModal findBytagid(long tagid);

	int deleteBytagid(long tagid);

	TagModal findBytagRFid(long tagRFid);
	
//	@Query(
//			value = "SELECT * FROM doorsystem.channels_tag_table t where  t.channels_id = :tagRFid", 
//			nativeQuery=true
//			)
//	TagModal findBytag(long c);

	@Query(
			value = "SELECT * FROM TagModal t where t.tagname = :tagname AND t.tagRFid = :tagRFid", 
			nativeQuery=true
			)
	public Optional<TagModal> findBytagnameAndtagRFid( String tagname, long tagRFid);



	@Query("SELECT t.hexaval FROM TagModal t where t.tagRFid = :tagrfid") 
	Future<Optional<String>>  findByhexaval(long tagrfid);
	
	
	@Query(
			value = "SELECT * FROM tag_table t where t.tagname = :tagname OR t.tagrfid = :rfid", 
			nativeQuery=true
			)
	List<TagModal> findtagname(String tagname, long rfid);

	
	@Query(
			value = "SELECT * FROM doorsystem.channels_tag_table t where  t.channels_id = :channelid", 
			nativeQuery=true
			)
	List<ChannelTag> findTags(long channelid);

}
