package com.ncs.doorsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ncs.doorsystem.entity.ChannelTag;

@Repository
public interface ChannelsTagsRepository extends JpaRepository<ChannelTag, Long> 
{
	
	@Query(
			value = "SELECT * FROM doorsystem.channels_tag_table t where  t.channels_id = :channelid", 
			nativeQuery=true
			)
	List<ChannelTag> findTags(long channelid);

}
