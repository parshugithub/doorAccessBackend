package com.ncs.doorsystem.service;

import java.util.Arrays;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
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
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.CreateSiteModal;
import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.repository.UserManagementRepository;

@Service
@Transactional
@PropertySource("classpath:application.properties")
public class UserManagementService {

	@Autowired
	UserManagementRepository userRepo;

	@Autowired
	private Environment env;

	public List<CreateUserModal> findAllUsresOfCustomer(long custId) {
		List<CreateUserModal> usermodal = userRepo.findBycustId(custId);

		return usermodal;
	}

	public CreateUserModal createNewUser(CreateUserModal userModal, long custid) throws Exception {

		CreateUserModal checkForUsername = userRepo.findByuserName(userModal.getUserName());

		if (checkForUsername != null) {
			throw new Exception("User name with " + userModal.getUserName() + "  already exists ");
		} else {

			System.out.println(userModal.toString());
			String userName = userModal.getUserName();
			String email = userModal.getEmail();
			String password = RandomPassword.generateRandomPassword();

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
				textmessage.setText("UserName:" + userName + "  Password :" + password);
				BodyPart htmlmessage = new MimeBodyPart();
				htmlmessage.setContent("It is a html message.", "text/html");
				mp.addBodyPart(textmessage);
				// mp.addBodyPart(htmlmessage);
				message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				message.setSubject("Created your new account!!!!!!");
				message.setContent(mp);
				Transport.send(message);
				System.out.println("Sent message successfully....");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
			System.out.println("the password is " + password + " email is  " + email);

			System.out.println("rtertertcustid  " + custid);
			userModal.setCustId(custid);
			return userRepo.save(userModal);
		}

	}

	public CreateUserModal updateuser(CreateUserModal userModal, String userName) {
		System.out.println("The username is " + userModal.getUserName());
		CreateUserModal user = userRepo.findByuserName(userName);
		System.out.println("The username is" + user.getUserName());
		user.setFirstName(userModal.getFirstName());
		user.setLastName(userModal.getLastName());
		user.setAddress(userModal.getAddress());
		user.setEmail(userModal.getEmail());
		user.setPhone_number(userModal.getPhone_number());
		user.setUser_type(userModal.getUser_type());

		CreateUserModal updateUser = userRepo.save(user);
		return updateUser;

	}

	public int deleteUser(String username) throws Exception {
		int value = 0;
		CreateUserModal userdelete = userRepo.findByuserName(username);
		// System.out.println("The data is "+ userdelete.toString());
		if (userdelete != null) {
			System.out.println("entering");
			value = value + userRepo.deleteByuserName(username);
			System.out.println("The values " + value);
			return value;
		}
		System.out.println("Valus" + value);

		return value;

	}

	public CreateUserModal resendPassword(String userName) throws Exception {

		CreateUserModal userResendPass = userRepo.findByuserName(userName);
		if (userResendPass != null) {
			String emailId = userResendPass.getEmail();
			String password = RandomPassword.generateRandomPassword();

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "mail.smtp2go.com");
			props.put("mail.smtp.port", "857"); // 8025, 587 and 25 can also be used.
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
				textmessage.setText("UserName:" + userName + "  Password :" + password);
				BodyPart htmlmessage = new MimeBodyPart();
				htmlmessage.setContent("It is a html message.", "text/html");
				mp.addBodyPart(textmessage);
				// mp.addBodyPart(htmlmessage);
				message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userResendPass.getEmail()));
				message.setSubject("Created your new account!!!!!!");
				message.setContent(mp);
				Transport.send(message);

				System.out.println("Sent message successfully....");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
			System.out.println("the password is " + password + " email is  " + emailId);
			return userResendPass;
		} else {
			throw new Exception("User Does not exists");
		}

	}

	public List<CreateUserModal> searchCreatedUser(String keyword) {
		if (keyword != null) {
			return userRepo.search(keyword);
		}
		return userRepo.findAll();

	}

	public CreateUserModal findUsres(String usernname) {

		CreateUserModal usermodal = userRepo.findByuserName(usernname);
		return usermodal;
	}

}
