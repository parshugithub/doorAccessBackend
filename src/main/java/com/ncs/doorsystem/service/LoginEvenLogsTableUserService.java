package com.ncs.doorsystem.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.doorsystem.entity.CreateUserModal;
import com.ncs.doorsystem.entity.EmbeddedCotrollerEventsLogsModal;
import com.ncs.doorsystem.entity.LoginEvenLogsTable;
import com.ncs.doorsystem.repository.LoginEvenLogsTableRepository;
import com.ncs.doorsystem.repository.UserManagementRepository;

@Service
@Transactional
public class LoginEvenLogsTableUserService {
	@Autowired
	LoginEvenLogsTableRepository repo;

	@Autowired
	UserManagementRepository userRepo;

	public List<LoginEvenLogsTable> getAllLogsfor(long custid, String username) {

		System.out.println("customer id is " + custid);
		System.out.println("username  is " + username);
		List<LoginEvenLogsTable> userReponse = repo.findbyusername(custid,username);
		System.out.println("the result is "+userReponse.toString());
		if (userReponse.size() > 0) {

			for (int i = 0; i < userReponse.size(); i++) {

				if (userReponse.get(i).getUserType() != null) {
					if (username.isEmpty() == false) {
						System.out.println("entring if");

						if (userReponse.get(i).getUserType().equalsIgnoreCase("webAppAdmin")) {
							List<LoginEvenLogsTable> result = repo.findbywebapp("webAppAdmin",custid);
							return result;
						} else if (userReponse.get(i).getUserType().equalsIgnoreCase("Voice Operator")) {
							List<LoginEvenLogsTable> result = repo.findbyusertype("Voice Operator",custid);
							return result;

						} else if (userReponse.get(i).getUserType().equalsIgnoreCase("customerAdmin")) {
							List<LoginEvenLogsTable> result = repo.findbyusertype("customerAdmin",custid);
							return result;

						} else if (userReponse.get(i).getUserType().equalsIgnoreCase("siteAdmin")) {
							List<LoginEvenLogsTable> result = repo.findbyusertype("siteAdmin",custid);
							return result;

						} else if (userReponse.get(i).getUserType().equalsIgnoreCase("engineer")) {
							List<LoginEvenLogsTable> result = repo.findbywebapp("engineer",custid);
							return result;

						}

					}

				}

			}
		} else {
			System.out.println("else cmg");
			List<LoginEvenLogsTable> result = repo.findbycutomerid(custid);
			return result;
		}

		// return null;
		return null;

	}

	public List<LoginEvenLogsTable> findAllBydate(String startdate, String enddate) {
		List<LoginEvenLogsTable> result = repo.getAllBetweenDate(startdate, enddate);
		return result;
	}

	public LoginEvenLogsTable findWErrorLog(long loginid) {
		LoginEvenLogsTable result = repo.findById(loginid).get();
		// TODO Auto-generated method stub
		return result;
	}

	public LoginEvenLogsTable userLogout(String userName) {

		return null;
	}

}
