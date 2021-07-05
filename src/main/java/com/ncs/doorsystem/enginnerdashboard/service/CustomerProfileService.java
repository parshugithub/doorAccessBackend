package com.ncs.doorsystem.enginnerdashboard.service;

import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.doorsystem.enginnerdashboard.entity.CustomerProfile;
import com.ncs.doorsystem.enginnerdashboard.repository.CustomerProfileRepository;

@Service
@Transactional
public class CustomerProfileService {

	@Autowired
	private Environment env;
	@Autowired
	CustomerProfileRepository repo;

	public CustomerProfile createCustomerProfile(CustomerProfile customer, long engid) throws Exception {
		CustomerProfile response = repo.findbycustomerIDAndCustomerEmail(customer.getCustomerID(),customer.getCustomerEmail());
		if (response != null) {
			throw new Exception("Customer is already exists");
		} else {
			customer.setEngId(engid);
			CustomerProfile saved = repo.save(customer);
			if (saved != null) {
				Properties props = new Properties();
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", "mail.smtp2go.com");
				props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
				Session session = Session.getInstance(props, new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(env.getProperty("spring.mail.username"),
								env.getProperty("spring.mail.password"));
					}
				});
				try {
					Message message = new MimeMessage(session);
					Multipart mp = new MimeMultipart("alternative");
					BodyPart textmessage = new MimeBodyPart();
					textmessage.setText("Your customer id is " + saved.getCustomerID());
					BodyPart htmlmessage = new MimeBodyPart();
					htmlmessage.setContent("It is a html message.", "text/html");
					mp.addBodyPart(textmessage);
					// mp.addBodyPart(htmlmessage);
					message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(saved.getCustomerEmail()));
					message.setSubject("Customer ID");
					message.setContent(mp);
					Transport.send(message);
					System.out.println("Done");
				} catch (MessagingException e) {
					throw new RuntimeException(e);
				}
				return saved;
			}
			

		}
		return null;

	}

	public List<CustomerProfile> getAllCustomers(long engid) {
		// TODO Auto-generated method stub
		List<CustomerProfile> res = repo.findByengId(engid);
		return res;
	}

	public CustomerProfile getCustomers(long custID) {
		// TODO Auto-generated method stub
		return  repo.findById(custID).get();
	}

	public List<CustomerProfile> getAllCustomersForAdmin() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public CustomerProfile updateCustomerProfile(CustomerProfile customer, long custid) {
		CustomerProfile res= repo.findBycustID(custid);
		if(res!=null)
		{
			res.setCreatedDate(res.getCreatedDate());
			res.setCustomerEmail(customer.getCustomerEmail());
			res.setCustomerID(res.getCustomerID());
			res.setEngId(res.getEngId());
			
			CustomerProfile result = repo.save(res);
			return result;
		}
		return customer;
	}

	public String deleteCustomerProfile(long custid) {
		long res= repo.deleteBycustID(custid);
		if(res==1)
		{
			return "Customer Profile deleted successfully";
		}
		return null;
	}

}
