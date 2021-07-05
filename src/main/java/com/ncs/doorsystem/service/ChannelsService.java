package com.ncs.doorsystem.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.ChannelTag;
import com.ncs.doorsystem.entity.ChannelsModal;
import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.Door;
import com.ncs.doorsystem.entity.StaffGroupManytoMany;
import com.ncs.doorsystem.entity.StaffManagementModal;
import com.ncs.doorsystem.entity.TagModal;
import com.ncs.doorsystem.repository.ChannelsRepository;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.TagRepository;

@Service
@Transactional
public class ChannelsService 
{
	@Autowired
	ChannelsRepository channelrepo;
	
	@Autowired
	CustomerRepository customerrepo;
	
	@Autowired
	TagRepository tagRepo;

	public List<ChannelsModal> getAllChannels(long custID,long siteid) {
		return channelrepo.findBycustomeridAndsiteid(custID,siteid);
		
	}

	public ChannelsModal createNewChannes(ChannelsModal modal, long custid, long siteid) throws Exception
	{
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    System.out.println("fsdfsd "+formatter.format(date));  
		System.out.println("service calling");
		long channelvalue = modal.getChannel();
		System.out.println("the channel value "+ channelvalue);
		long val=channelrepo.count();
		System.out.println("max values is "+val);
	
		List<ChannelTag> groupTag= new ArrayList<>();
		 List<ChannelTag> tagvalues = modal.getTags();
		 
		 for (int i=0; i< modal.getTags().size(); i++) {
				ChannelTag tagModal = modal.getTags().get(i);
				String tagname= tagModal.getTagname();
				long rfId = tagModal.getTagRFid();
				System.out.println("The site Name is "+tagname);
				List<TagModal> checkTag =tagRepo.findtagname(tagname,rfId);
				
				System.out.println("dfgdfgrespose is"+checkTag);
				System.out.println("the checkTag size "+checkTag.size());
				if(!checkTag.isEmpty())
				{
					ChannelTag ct= new ChannelTag();
					ct.setCustomerid(custid);
					ct.setCreatedDate(modal.getTags().get(i).getCreatedDate());
					ct.setUpdatedDate(modal.getTags().get(i).getUpdatedDate());
					ct.setTagname(modal.getTags().get(i).getTagname());
					ct.setTagRFid(modal.getTags().get(i).getTagRFid());
					ct.setHexaval(modal.getTags().get(i).getHexaval());
					
					groupTag.add(ct);
					
//					for(int j=0;j<checkTag.size();j++)
//					{
//						System.out.println("entring");
//						List<ChannelTag> secodeCheck = tagRepo.findBytagname(checkTag.get(j).getTagname());
//						
//						System.out.println("objecty"+secodeCheck.toString());
//						if(!secodeCheck.isEmpty())
//						{
////							secodeCheck.add(secodeCheck.add(modal.getTags().get(j).getTagname()));
////							secodeCheck.setTagname(modal.getTags().get(j).getTagname());
////							secodeCheck.setTagRFid(modal.getTags().get(j).getTagRFid());
//							groupTag.addAll(secodeCheck);
//						}
//						
//						
//						//groupTag.addAll(checkTag);
//					}
					
				}	
				
				//groupTag.addAll(modal.getTags());
			}
		//StaffFGroupModal grp = new StaffFGroupModal((List<StaffManagementModal>) modal);
		System.out.println("the response is"+modal);
		System.out.println("tags"+groupTag);
		
		ChannelsModal newChannel = new ChannelsModal();
		Door door = new Door();
		
		
		
		//List<ChannelsModal> ch= channelrepo.findBychannelInAndflotInAndpppIn( modal.getChannel(), modal.getFlot(),modal.getPpp());
		
		List<ChannelsModal> ch = channelrepo.findByChannelAndFlatAndPpp(modal.getChannel(), modal.getFlat(),modal.getPpp());
		
		System.out.println(ch.toString());
		ChannelsModal channel = channelrepo.findchannelForSiteAndCustomer(modal.getChannel(),custid,siteid);
		ChannelsModal channelFlot = channelrepo.findByflatForSiteAndCustomer(modal.getFlat(),custid,siteid);
		ChannelsModal channelppp = channelrepo.findBypppForSiteAndCustomer(modal.getPpp(),custid,siteid);
		Customer customerName= customerrepo.findById(custid);
		System.out.println("the customer name "+ customerName);
		if((channel!=null))
		{
			channel.setCreatedDate(modal.getCreatedDate());
			channel.setCreatedBy(customerName.getFirstname()+ "    " +  customerName.getLastname());
			channel.setChannel(modal.getChannel());
			channel.setSiteid(siteid);
			channel.setCustomerid(custid);
			channel.setFlat(modal.getFlat());
			channel.setPpp(modal.getPpp());
			channel.setDoor(modal.getDoor());
			channel.setTags(groupTag);
			channelrepo.save(channel);
			return channel;

		}
		else if(channelFlot!=null)
		{
			channelFlot.setCreatedDate(modal.getCreatedDate());
			channelFlot.setCreatedBy(customerName.getFirstname()+ "    " +  customerName.getLastname());
			channelFlot.setChannel(modal.getChannel());
			channelFlot.setSiteid(siteid);
			channelFlot.setCustomerid(custid);
			channelFlot.setFlat(modal.getFlat());
			channelFlot.setPpp(modal.getPpp());
			channelFlot.setDoor(modal.getDoor());
			channelFlot.setTags(groupTag);
			channelrepo.save(channelFlot);
			return channelFlot;
			
		} else  if(channelppp!=null){
			
			channelppp.setCreatedDate(modal.getCreatedDate());
			channelppp.setCreatedBy(customerName.getFirstname()+ "    " +  customerName.getLastname());
			channelppp.setChannel(modal.getChannel());
			channelppp.setSiteid(siteid);
			channelppp.setCustomerid(custid);
			channelppp.setFlat(modal.getFlat());
			channelppp.setPpp(modal.getPpp());
			channelppp.setDoor(modal.getDoor());
			channelppp.setTags(groupTag);
			channelrepo.save(channelppp);
			return channelppp;
			 
		}
		else {
			newChannel.setCreatedDate(new Date(calendar.getTime().getTime()));
			//modal.setExpiraydate(new Date(calendar.getTime().getTime()));
			newChannel.setSiteid(siteid);
			newChannel.setCustomerid(custid);
			newChannel.setCreatedBy(customerName.getFirstname()+ "    " +  customerName.getLastname());
			newChannel.setDoor(modal.getDoor());
			newChannel.setTags(groupTag);
			newChannel.setChannel(modal.getChannel());
			newChannel.setFlat(modal.getFlat());
			newChannel.setPpp(modal.getPpp());
			channelrepo.save(newChannel);
			//staffGroupRepo.save(grp);
			return modal;
		}
		
		
	}

	public ChannelsModal getSingleChannel(long channelid) {
		
		if(channelrepo.findById(channelid).isPresent())
            return channelrepo.findById(channelid).get();
        else return null;
	}

	public ResponseEntity<Object> deleteChannel(long channelid) {
		
		if (channelrepo.findById(channelid).isPresent()) {
			channelrepo.deleteById(channelid);
            if (channelrepo.findById(channelid).isPresent()) {
                return ResponseEntity.unprocessableEntity().body("Failed to delete the specified record");
            } else return ResponseEntity.ok().body("Successfully deleted specified record");
        } else
            return ResponseEntity.unprocessableEntity().body("No Records Found");
    }

	public ResponseEntity<Object> updateChannels(Long channelid, ChannelsModal channelsUpdate) {
		if(channelrepo.findById(channelid).isPresent()){
			ChannelsModal updateChannel = channelrepo.findById(channelid).get();
			updateChannel.setChannel((channelsUpdate.getChannel()));
           // newRole.setName(staffGroup2.getName());
            //newRole.setDescription(staffGroup2.getDescription());
			ChannelsModal savedChannel = channelrepo.save(updateChannel);
            if(channelrepo.findById(savedChannel.getChannelid()).isPresent())
                return ResponseEntity.accepted().body("channel saved successfully");
            else return ResponseEntity.badRequest().body("Failed to update channel");

        } else return ResponseEntity.unprocessableEntity().body("Specified channel not found");
	}
	

}
