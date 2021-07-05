package com.ncs.doorsystem.service;

import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

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
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ncs.doorsystem.enginnerdashboard.entity.CustomerProfile;
import com.ncs.doorsystem.enginnerdashboard.entity.EngineerEntity;
import com.ncs.doorsystem.enginnerdashboard.repository.CustomerProfileRepository;
import com.ncs.doorsystem.enginnerdashboard.repository.EngineeringRepository;
import com.ncs.doorsystem.entity.ConfirmationToken;
import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.Customer;
import com.ncs.doorsystem.entity.LoginEvenLogsTable;
import com.ncs.doorsystem.entity.LoginModalForCustomerOrUser;
import com.ncs.doorsystem.repository.ConfirmationTokenRepository;
import com.ncs.doorsystem.repository.CustomerRepository;
import com.ncs.doorsystem.repository.UserManagementRepository;

@Service("customerService")
@Transactional
public class CustomerService 
{
	public static Long custid=48l;
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	EngineeringRepository engineerRepo;
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	CustomerProfileRepository repo;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	private UserManagementRepository userRepo;
//	
	@Autowired PasswordEncoder passwordEncoder;
	
	@Autowired
	private Environment env;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	Random rand = new Random();
	int newCode = rand.nextInt(10000);

	
	
	public Customer registerUser(Customer customer, String custprofileid) throws Exception
	{
		System.out.println("Enterd");
		System.out.println(customer.toString());
		CustomerProfile id = repo.findBycustomerID(custprofileid);
		if(id!=null)
		{
			Customer existingUser = customerRepository.findByEmailId(customer.getEmailId());
			if(existingUser != null)
			{
				throw new Exception("The User with  " +existingUser.getEmailId()+" already present");
			}
			else 
			{
				//customer.setPassword(passwordEncoder.encode(customer.getPassword()));
				//bCryptPasswordEncoder.encode(customer.getPassword());
				//String encryptedPassword = passwordEncoder.encode(customer.getPassword());
				//customer.setPassword(encryptedPassword);

				customerRepository.save(customer);
				
				ConfirmationToken confirmationToken = new ConfirmationToken(customer);
				
				confirmationTokenRepository.save(confirmationToken);
//			            
	            Properties props = new Properties();
	            props.put("mail.smtp.auth", "true");
	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.host", "mail.smtp2go.com");
	            props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
	            Session session = Session.getInstance(props,
	            new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(env.getProperty("spring.mail.username"),env.getProperty("spring.mail.password"));
	            }
	            });
	            try {
	            Message message = new MimeMessage(session);
	            Multipart mp = new MimeMultipart("alternative");
	            BodyPart textmessage = new MimeBodyPart();
	            textmessage.setText("To confirm your account, please click here : "
	        			+"http://b72600cdd610.ngrok.io/confirm-account?token="+confirmationToken.getToken());
	            BodyPart htmlmessage = new MimeBodyPart();
	            htmlmessage.setContent("It is a html message.", "text/html");
	            mp.addBodyPart(textmessage);
	          //  mp.addBodyPart(htmlmessage);
	            message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
	            message.setRecipients(Message.RecipientType.TO,
	            InternetAddress.parse(customer.getEmailId()));
	            message.setSubject("Complete Registration!");
	            message.setContent(mp);
	            Transport.send(message);
	            System.out.println("Done");
	            } catch (MessagingException e) {
	            throw new RuntimeException(e);
	            }
			//	SimpleMailMessage mailMessage = new SimpleMailMessage();
//				mailMessage.setTo(user.getEmailId());
//				mailMessage.setSubject("Complete Registration!");
//				mailMessage.setFrom("jyotiullagaddi123@gmail.com");
//				mailMessage.setText("To confirm your account, please click here : "
//				+"http://localhost:8083/confirm-account?token="+ confirmationToken.getToken());
//				
//				emailSenderService.sendEmail(mailMessage);
				
				
				return customer;
				
			}
			
		}
		else
		{
			throw new Exception("Invalid Customer");
		}
		
		
		
		
	}
	
	
	public Customer registerUserlink(Customer customer) throws Exception
	{
		System.out.println("Enterd");
		System.out.println(customer.toString());
		
		Customer existingUser = customerRepository.findByEmailId(customer.getEmailId());
		if(existingUser != null)
		{
			throw new Exception("The User with  " +existingUser.getEmailId()+" already present");
		}
		else 
		{
			//customer.setPassword(passwordEncoder.encode(customer.getPassword()));
			//bCryptPasswordEncoder.encode(customer.getPassword());
			//String encryptedPassword = passwordEncoder.encode(customer.getPassword());
			//customer.setPassword(encryptedPassword);

			customerRepository.save(customer);
			
			ConfirmationToken confirmationToken = new ConfirmationToken(customer);
			
			confirmationTokenRepository.save(confirmationToken);
//		            
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "mail.smtp2go.com");
            props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
            Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(env.getProperty("spring.mail.username"),env.getProperty("spring.mail.password"));
            }
            });
            try {
            Message message = new MimeMessage(session);
            Multipart mp = new MimeMultipart("alternative");
            BodyPart textmessage = new MimeBodyPart();
            textmessage.setText("To confirm your account, please click here : "
        			+"http://b72600cdd610.ngrok.io/confirm-account?token="+ confirmationToken.getToken());
            BodyPart htmlmessage = new MimeBodyPart();
            htmlmessage.setContent("It is a html message.", "text/html");
            mp.addBodyPart(textmessage);
          //  mp.addBodyPart(htmlmessage);
            message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(customer.getEmailId()));
            message.setSubject("Complete Registration!");
            message.setContent(mp);
            Transport.send(message);
            System.out.println("Done");
            } catch (MessagingException e) {
            throw new RuntimeException(e);
            }
			
			
			return customer;
			
		}
		
		
	}
	
	
	public Customer resendConfirmationLink(String emailID, Customer customer) 
	{
		
		
		System.out.println("Method called");
		Customer checkUser = customerRepository.findByEmailId(emailID);
		
		
		ConfirmationToken token = confirmationTokenRepository.findByCustomer(checkUser);
		Long id = token.getTokenid();
		System.out.println("The user Id is "+id);
		confirmationTokenRepository.deleteById(id);
		String emailid = checkUser.getEmailId();
		System.out.println("The new Email id is  "+emailid);
		
		ConfirmationToken confirmationToken = new ConfirmationToken(checkUser);
		
		String tokenVal=confirmationToken.getToken();
		confirmationToken.setToken(tokenVal);
		System.out.println(confirmationToken.getCreatedDate());
		System.out.println(confirmationToken.getExpirdDate());
		confirmationTokenRepository.save(confirmationToken);
		//confirmationTokenRepository.save(confirmationToken);
		System.out.println("The token is "+ tokenVal);
		
		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.smtp2go.com");
        props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(env.getProperty("spring.mail.username"),env.getProperty("spring.mail.password"));
        }
        });
        try {
        Message message = new MimeMessage(session);
        Multipart mp = new MimeMultipart("alternative");
        BodyPart textmessage = new MimeBodyPart();
        textmessage.setText("To confirm your account, please click here : "
    			+"http://b72600cdd610.ngrok.io/confirm-account?token="+ confirmationToken.getToken());
        BodyPart htmlmessage = new MimeBodyPart();
        htmlmessage.setContent("It is a html message.", "text/html");
        mp.addBodyPart(textmessage);
      //  mp.addBodyPart(htmlmessage);
        message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(customer.getEmailId()));
        message.setSubject("Complete Registration!");
        message.setContent(mp);
        Transport.send(message);
          System.out.println("Sent message successfully....");
       }catch (MessagingException mex) {
          mex.printStackTrace();
       }
		
		
		return customer;
		
	}
	
	
	
	public String confirmUserAccount(String confirmationToken, Model modal)
	{
		System.out.println("called this method");
		ConfirmationToken token = confirmationTokenRepository.findByToken(confirmationToken);
		
		if(token != null)
		{
			 Customer customer = token.getCustomer();
			    Calendar cal = Calendar.getInstance();
			    if ((token.getExpirdDate().getTime() - cal.getTime().getTime()) <= 0) {
			        String messageValue = "invalid link or link broken!!! please check the link or resend  the link";
			        		modal.addAttribute( messageValue);
			        		return " Link expired";
			        
			    } 
			    
			
			Customer customerCheckToken = customerRepository.findByEmailId(token.getCustomer().getEmailId());
			customerCheckToken.setEnable(true);
			customerRepository.save(customerCheckToken);
			/////modal.addAttribute("account varified");
			//return model.addAttribute("message", "Account varified");
			return "Account varified";
		}
		else
		{
			return  "invalid link or link broken!!! please check the link or resend  the link ";
		}
		
		//return modelAndView;
	}
	
	public Customer customerLogin(String emailId, String password) throws Exception 
	{
		LoginModalForCustomerOrUser loginforCustomerAnduser = new LoginModalForCustomerOrUser();
		
		System.out.println("Login method called");
		
//		if(userName!= null)
//		{
//			CreateUserModal  user = userRepo.findByuserName(userName);
//			
//			
//			return user.getUser_id();
//			
//			
//			
//		}
//		else
		
			Customer userLogin= customerRepository.findUserByEmailIdAndPassword(emailId, password);
			
			//System.out.println(userLogin.toString());
			
			if(userLogin!=null && userLogin.isEnable())
			{
				custid=custid+userLogin.getId();
				return userLogin;
			}
		
		return null;
		
		//String encryptedPassword = passwordEncoder.encode(password);
//		customer.setPassword(encryptedPassword);
	//	passwordEncoder.matches(password, encodedPassword)
		
//		return null;
//		else
//		{
//			throw new Exception("Bad Credentials!!! Please check your email and password");
//		}
		
		
	}
	
	
	


	public CustomerRepository getUserRepository() {
		return customerRepository;
	}

	public void setUserRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public ConfirmationTokenRepository getConfirmationTokenRepository() {
		return confirmationTokenRepository;
	}

	public void setConfirmationTokenRepository(ConfirmationTokenRepository confirmationTokenRepository) {
		this.confirmationTokenRepository = confirmationTokenRepository;
	}

	public EmailSenderService getEmailSenderService() {
		return emailSenderService;
	}

	public void setEmailSenderService(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	public Customer updateCustomer(Customer customerUpdate, long id) 
	{
		Customer checkVal = customerRepository.findByid(id);
		if(checkVal!=null)
		{
			checkVal.setAddress(customerUpdate.getAddress());
			checkVal.setConfirmPassword(customerUpdate.getConfirmPassword());
			checkVal.setEmailId(customerUpdate.getEmailId());
			checkVal.setFirstname(customerUpdate.getFirstname());
			checkVal.setLastname(customerUpdate.getLastname());
			checkVal.setMobileNo(customerUpdate.getMobileNo());
			checkVal.setPassword(customerUpdate.getPassword());
			Customer updatedres = customerRepository.save(checkVal);
			return updatedres;
		}
		
		return null;
	}

	public Customer changePassword(long id, Customer changePassObj) 
	{
		ConfirmationToken oldToken = confirmationTokenRepository.findByCustomer_id(id);
		System.out.println("obj" +oldToken.toString());
		long custId = oldToken.getTokenid();
		System.out.println("The user Id is "+custId);
		confirmationTokenRepository.deleteByid(id);
		//changePassObj.setEnable(false);
		//System.out.println("deleted value is "+val);
		//changePassObj.setEnable(false);
		
        
		Customer changePasswordCustomer =customerRepository.findByEmailId(changePassObj.getEmailId());
		if(changePasswordCustomer!=null)
		{
			
			changePasswordCustomer.setAddress(changePassObj.getAddress());
			changePasswordCustomer.setConfirmPassword(changePassObj.getConfirmPassword());
			changePasswordCustomer.setEmailId(changePassObj.getEmailId());
			changePasswordCustomer.setFirstname(changePassObj.getFirstname());
			changePasswordCustomer.setLastname(changePassObj.getLastname());
			changePasswordCustomer.setMobileNo(changePassObj.getMobileNo());
			changePasswordCustomer.setPassword(changePassObj.getPassword());
			changePasswordCustomer.setEnable(false);
			
			Customer changedValues = customerRepository.save(changePasswordCustomer);
			
			ConfirmationToken confirmationToken = new ConfirmationToken(changedValues);
			System.out.println("confirmtoken respose is "+confirmationToken.toString());
			String tokenVal=confirmationToken.getToken();
			System.out.println("the new Token is "+tokenVal);
			confirmationToken.setToken(tokenVal);
			System.out.println(confirmationToken.getCreatedDate());
			System.out.println(confirmationToken.getExpirdDate());
			
			confirmationTokenRepository.save(confirmationToken);
			
			Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "mail.smtp2go.com");
	        props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
	        Session session = Session.getInstance(props,
	        new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(env.getProperty("spring.mail.username"),env.getProperty("spring.mail.password"));
	        }
	        });
	        try {
	        Message message = new MimeMessage(session);
	        Multipart mp = new MimeMultipart("alternative");
	        BodyPart textmessage = new MimeBodyPart();
	        textmessage.setText("To confirm your account, please click here : "
	      			+"http://b72600cdd610.ngrok.io/confirm-account?token="+confirmationToken.getToken());
	        BodyPart htmlmessage = new MimeBodyPart();
	        htmlmessage.setContent("It is a html message.", "text/html");
	        mp.addBodyPart(textmessage);
	      //  mp.addBodyPart(htmlmessage);
	        message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
	        message.setRecipients(Message.RecipientType.TO,
	        InternetAddress.parse(changedValues.getEmailId()));
	        message.setSubject("Your password has been reseted Confirm your account!");
	        message.setContent(mp);
	        Transport.send(message);
	          // Set Subject: header field
	          message.setSubject("Your password has been reseted Confirm your account!");

	          // Now set the actual message
	          message.setText("To confirm your account, please click here : "
	      			+"http://b72600cdd610.ngrok.io/confirm-account?token="+confirmationToken.getToken());

	          // Send message
	          Transport.send(message);
	          System.out.println("Sent message successfully....");
	       }catch (MessagingException mex) {
	          mex.printStackTrace();
	       }
			return changedValues;
		}
		
		return null;
	}

	public CreateUserModal userLogin(String emailid) throws Exception {
		CreateUserModal userResult= userRepo.findByuserName(emailid);
		if(userResult!=null)
		{
			return userResult;
		}
		else
			throw new Exception("The User with  " +userResult.getUserName()+" is not present");
		
	}

	public CreateUserModal userLoginWithForgetpassword(String emailid) 
	{
		CreateUserModal userResult= userRepo.findByuserName(emailid);
		String emailId = userResult.getEmail();
		System.out.println("the email id is "+emailId);
		
		
		System.out.printf("%04d%n", newCode);
		
		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.smtp2go.com");
        props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(env.getProperty("spring.mail.username"),env.getProperty("spring.mail.password"));
        }
        });
        try {
        Message message = new MimeMessage(session);
        Multipart mp = new MimeMultipart("alternative");
        BodyPart textmessage = new MimeBodyPart();
        textmessage.setText("Your code is "+newCode);
        BodyPart htmlmessage = new MimeBodyPart();
        htmlmessage.setContent("It is a html message.", "text/html");
        mp.addBodyPart(textmessage);
      //  mp.addBodyPart(htmlmessage);
        message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(emailId));
        message.setSubject("Reseted Your account!");
        message.setContent(mp);
        Transport.send(message);
          System.out.println("Sent message successfully....");
         // userLoginWithForgetPassword(newCode);
       }catch (MessagingException mex) {
          mex.printStackTrace();
       }
		
		return userResult;
	}

	private CreateUserModal userLoginWithForgetPassword(int newCode) 
	{
		
		return null;
		
		
	}

	public int userLoginSubmitCode(long code) 
	{
		if(code==newCode)
		{
			
			return 1;
		}
		else
		{
			return 0;
		}
		
		
		
	}

	public LoginEvenLogsTable userLogout(String userName) {
		
		return null;
	}
	
	
	public Customer cutomerLoginWithForgetpassword(String emailid) throws Exception {
		Customer customerResult= customerRepository.findByEmailId(emailid);
		if(customerResult!=null) {
			
			
		String emailId = customerResult.getEmailId();
		System.out.println("the email id is "+emailId);
		
		
		System.out.printf("%04d%n", newCode);
		
		Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "mail.smtp2go.com");
        props.put("mail.smtp.port", "587"); // 8025, 587 and 25 can also be used.
        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(env.getProperty("spring.mail.username"),env.getProperty("spring.mail.password"));
        }
        });
        try {
        Message message = new MimeMessage(session);
        Multipart mp = new MimeMultipart("alternative");
        BodyPart textmessage = new MimeBodyPart();
        textmessage.setText("To confirm your account, please click here : "
    			+"http://b72600cdd610.ngrok.io/confirm-reset");
        BodyPart htmlmessage = new MimeBodyPart();
        htmlmessage.setContent("It is a html message.", "text/html");
        mp.addBodyPart(textmessage);
      //  mp.addBodyPart(htmlmessage);
        message.setFrom(new InternetAddress(env.getProperty("spring.mail.username")));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(emailId));
        message.setSubject("Reseted Your account!");
        message.setContent(mp)
;
        Transport.send(message);
          System.out.println("Sent message successfully....");
         // userLoginWithForgetPassword(newCode);
       }catch (MessagingException mex) {
          mex.printStackTrace();
       }
		
		return customerResult;
		}
		else {
			throw new Exception("customer doesnot exist");
		}
	}


	public EngineerEntity engineerDashboardLogin(String emailid, String pass) {
		EngineerEntity username =engineerRepo.finduser(emailid,pass);
		//EngineerEntity password=engineerRepo.findBypassword(pass);
		
		if((username!=null))
		{
			return username;
		}
		return null;
	}


	



	
}
