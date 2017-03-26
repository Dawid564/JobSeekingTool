package org.webwork.find.repository.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.webwork.find.domain.AlertMessage;
import org.webwork.find.domain.ChangePassword;
import org.webwork.find.domain.ContactMessages;
import org.webwork.find.domain.SeekingProcess;
import org.webwork.find.domain.User;
import org.webwork.find.domain.UserPayment;
import org.webwork.find.domain.UserRole;
import org.webwork.find.repositor.UserHibernate;


@EnableTransactionManagement
@Repository
@Transactional
public class UserHibernateImpl implements UserHibernate{

	/**
	@Autowired
	private SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(UserHibernate.class)
											.buildSessionFactory();
	**/
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	//create new account
	@SuppressWarnings("unchecked")
	public String addNewUser(User user) {
		Session session = this.getSession();
		try{
			User us = user;
			user.setPassword(PasswordEncoderGenerator(user.getPassword()));
			session.save(us);
			
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole("ROLE_USER");
			session.save(userRole);
			
			
			
			return "Account has created";
		}catch(Exception e){
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	
	private String PasswordEncoderGenerator(String pass){
		int i = 0;
		String hashedPass = null;
		while(i<10){
			//String pass = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPass = passwordEncoder.encode(pass);
			i++;
		}
		return hashedPass;
	}

	@SuppressWarnings("unchecked")
	public User findUserByName(String userName) {
		List<User> user = new ArrayList<User>();
		user = getSession().createQuery("FROM User WHERE firstName=?").setParameter(0, userName).getResultList();
		
		if (user.size() > 0) {
			
			return user.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SeekingProcess> getSeekingProcessNames() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		List<SeekingProcess> process = new ArrayList<SeekingProcess>();
		process = getSession().createQuery("FROM SeekingProcess WHERE userName= :username").setParameter("username", username).getResultList();
		return process;
	}

	@SuppressWarnings("unchecked")
	public String createNewProcessName(SeekingProcess seekingProcess) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();

		if(checkNumberOfProcessPerUser(getUserFromDatabase(getUserName()))){
			SeekingProcess tmpSeekingProcess = new SeekingProcess();
			tmpSeekingProcess.setAwaitSalary("0");
			tmpSeekingProcess.setProcessName(seekingProcess.getProcessName());
			tmpSeekingProcess.setCompanyDescription("");
			tmpSeekingProcess.setCompanyName("");
			tmpSeekingProcess.setDataResumeSend("");
			tmpSeekingProcess.setUser(getUserFromDatabase(username));
			tmpSeekingProcess.setContactEmail("");
			tmpSeekingProcess.setContactPhone("");
			tmpSeekingProcess.setSendResume(false);
			tmpSeekingProcess.setQuestionsPhoneCall("");
			tmpSeekingProcess.setNotesPhoneCall("");
			tmpSeekingProcess.setStrengths("");
			tmpSeekingProcess.setWeakness("");
			tmpSeekingProcess.setRightClothing(false);
			tmpSeekingProcess.setRemindResume(false);
			tmpSeekingProcess.setImportantDocs(false);
			tmpSeekingProcess.setInterviewPlace("");
			getSession().saveOrUpdate(tmpSeekingProcess);
		}
		
		return "";
	}
	
	//true if is less then 21 process per user
	@SuppressWarnings("unchecked")
	private boolean checkNumberOfProcessPerUser(User user){
		List<SeekingProcess> list = new ArrayList<SeekingProcess>();
		Query query = getSession().createQuery("FROM SeekingProcess WHERE userName= :userName").setParameter("userName", user);
		list = query.getResultList();
		try{
			list.get(19);
			return false;
		}catch(Exception e){
			return true;
		}
	}
	
	//get User object
	@SuppressWarnings("unchecked")
	private User getUserFromDatabase(String userName){
		User usr = new User();
		List<User> listUser = new ArrayList<User>();
		listUser = getSession().createQuery("FROM User WHERE firstName = :userName").setParameter("userName", userName).getResultList();
		usr = listUser.get(0);
		return usr;
	}
	
	private String getUserName(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		return username; 
	}

	//delete user inscription 
	@SuppressWarnings("unchecked")
	public String deleteProcessByName(String name) {
		Query query = getSession().createQuery("DELETE FROM SeekingProcess WHERE user = :user AND processname = :processName");
		query.setParameter("user", getUserFromDatabase(getUserName()));
		query.setParameter("processName", name);
		query.executeUpdate();
		return null;
	}

	@SuppressWarnings("unchecked")
	public SeekingProcess setProperProcess(String processName) { // get some process from database, i don't know why is it name setProperPorcess
		SeekingProcess seekingProcess = new SeekingProcess();
		List<SeekingProcess> listOfProcess = new ArrayList<SeekingProcess>();

		Query query = getSession().createQuery("FROM SeekingProcess WHERE processName = :procesname AND user = :username");
		query.setParameter("procesname", processName);
		query.setParameter("username", getUserFromDatabase(getUserName()));
		listOfProcess = query.getResultList();
		seekingProcess = listOfProcess.get(0);
		return seekingProcess;
	}

	@SuppressWarnings("unchecked")
	public boolean checkIsProcessExist(String processName) {
		List<SeekingProcess> list = new ArrayList<SeekingProcess>();
		Query query = getSession().createQuery("FROM SeekingProcess WHERE processName = :process AND user = :username");
		query.setParameter("process", processName);
		query.setParameter("username", getUserFromDatabase(getUserName()));
		list = query.getResultList();
		if(list.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	public String updateSeekingProcess(SeekingProcess seekingProcess) {
		
		seekingProcess.setUser(getUserFromDatabase(getUserName()));
		Query query = getSession().createQuery("UPDATE SeekingProcess SET awaitSalary= :awaitSalary, companyName= :companyName "
				+ ",companyDescription= :companyDescription, dataResumeSend= :dataResume, contactEmail= :contactEmail,"
				+ "contactPhone= :contactPhone, sendResume= :sendResume, responseDate= :responseDate, questionsPhoneCall= :questionsPhoneCall,"
				+ "notesPhoneCall= :notesPhoneCall, rightClothing= :rightClothing, remindResume= :remindResume, importantDocs= :importantDocs,"
				+ "interviewPlace= :interviewPlace, interviewTime= :interviewTime WHERE processName = :process AND user = :username");
		
		Query queryForSide = getSession().createQuery("UPDATE SeekingProcess SET weakness= :weakness, strengths= :strengths WHERE user = :username");
		//
		query.setParameter("awaitSalary", seekingProcess.getAwaitSalary().replaceAll("[\n\r]", " "));
		query.setParameter("process", seekingProcess.getProcessName());
		query.setParameter("username", getUserFromDatabase(getUserName()));
		query.setParameter("companyName", seekingProcess.getCompanyName().replaceAll("[\n\r]", " "));
		query.setParameter("companyDescription", seekingProcess.getCompanyDescription().replaceAll("[\n\r]", " "));
		query.setParameter("dataResume", seekingProcess.getDataResumeSend());
		query.setParameter("contactEmail", seekingProcess.getContactEmail().replaceAll("[\n\r]", " "));
		query.setParameter("contactPhone", seekingProcess.getContactPhone().replaceAll("[\n\r]", " "));
		query.setParameter("sendResume", seekingProcess.isSendResume());
		query.setParameter("responseDate", seekingProcess.getResponseDate());
		query.setParameter("questionsPhoneCall", seekingProcess.getQuestionsPhoneCall().replaceAll("[\n\r]", " "));
		query.setParameter("notesPhoneCall", seekingProcess.getNotesPhoneCall().replaceAll("[\n\r]", " "));
		query.setParameter("rightClothing", seekingProcess.isRightClothing());
		query.setParameter("remindResume", seekingProcess.isRemindResume());
		query.setParameter("importantDocs", seekingProcess.isImportantDocs());
		query.setParameter("interviewPlace", seekingProcess.getInterviewPlace().replaceAll("[\n\r]", " "));
		query.setParameter("interviewTime", seekingProcess.getInterviewTime());
		
		
		queryForSide.setParameter("username", getUserFromDatabase(getUserName()));
		queryForSide.setParameter("weakness", seekingProcess.getWeakness().replaceAll("[\n\r]", " "));
		queryForSide.setParameter("strengths", seekingProcess.getStrengths().replaceAll("[\n\r]", " "));
		
		queryForSide.executeUpdate();
		query.executeUpdate();
		return null;
	}

	//add to database information about user activated account
	public String addUserPayment() {
		Date currentDate = new Date();
		Date startDate = new Date(currentDate.getTime());// today 
		
		Date expiredDate = new Date();
		expiredDate.setTime(currentDate.getTime() + 2602000000L);// date when user account expired, add 30 days to current date
		
		User usr = new User();
		usr = getUserFromDatabase(getUserName());
		
		UserPayment userPayment = new UserPayment(usr, startDate, expiredDate);
		
		UserPayment userPaymentFromDatabase = new UserPayment();
		if(getUserPaymentFromDatabase(usr).isEmpty()){
			//do nothing
		}else{
			userPaymentFromDatabase = getUserPaymentFromDatabase(usr).get(0);
		}
		
		if(getUserPaymentFromDatabase(usr).isEmpty()){ //user buy first subscription
			getSession().save(userPayment);
		}else if(startDate.after(userPaymentFromDatabase.getExpiredDate())){//when user extend subscription before end actual sub
			getSession().createQuery("DELETE FROM UserPayment WHERE user= :userName").setParameter("userName", usr).executeUpdate();
			getSession().saveOrUpdate(userPayment);
		}else if(startDate.before(userPaymentFromDatabase.getExpiredDate())){//when user extend subscription after end actual sub
			Long milisec = userPaymentFromDatabase.getExpiredDate().getTime() + 2682000000L; 
			expiredDate.setTime(milisec);
			userPayment.setExpiredDate(expiredDate);
			getSession().createQuery("DELETE FROM UserPayment WHERE user= :userName").setParameter("userName", usr).executeUpdate();
			getSession().save(userPayment);
		}
		addPremiumRole();
		return null;
	}
	
	private void addPremiumRole(){
		UserRole userRole = new UserRole();
		List<UserRole> usrRole = new ArrayList<UserRole>();
		usrRole = getUserRoleList();
		boolean premiumFlag = false;
		
		for(UserRole u : usrRole){
			if(u.getRole().equals("ROLE_PREMIUM")){
				premiumFlag = true;
			}
		}
		
		if(premiumFlag != true){
			userRole.setRole("ROLE_PREMIUM");
			userRole.setUser(getUserFromDatabase(getUserName()));
			getSession().save(userRole);
		}
	}
	
	@SuppressWarnings("unchecked")
	private List<UserRole> getUserRoleList(){
		List<UserRole> usrRole = new ArrayList<UserRole>();
		usrRole = getSession().createQuery("FROM UserRole WHERE user= :userName").setParameter("userName", getUserFromDatabase(getUserName())).getResultList();
		return usrRole;
	}
	
	@SuppressWarnings("unchecked")
	private List<UserPayment> getUserPaymentFromDatabase(User u){// get date when user bought sub and when sub will expired
		List<UserPayment> user = new ArrayList<UserPayment>();
		
		user = getSession().createQuery("FROM UserPayment WHERE user= :userName").setParameter("userName", u).getResultList();
		return user;
	}

	//return millisecond to account expired
	public Long getAvaliabilityAccount() {
		List<UserPayment> availabilityAccount = new ArrayList<UserPayment>();
		availabilityAccount = getUserPaymentFromDatabase(getUserFromDatabase(getUserName()));
		try{
			UserPayment userAvaliabilityAccount = availabilityAccount.get(0);
			Date currentDate = new Date();
			Date startDate = new Date(currentDate.getTime());// today 
			
			if(startDate.before(userAvaliabilityAccount.getExpiredDate())){
				long expiredDate = userAvaliabilityAccount.getExpiredDate().getTime();
				long todayDate = startDate.getTime();
				
				return expiredDate - todayDate; //time to expired account 
			}else{
				expiredUserPremiumCheck();
				return 0L; //control expired date
			}
		}catch(Exception e){
			return 0L; //this should never be
		}
		
	}

	public boolean checkUserPremiumStatus() {
		List<UserRole> user = new ArrayList<UserRole>();
		user = getUserRoleList();
		int counter = 0;
		
		for(UserRole u : user){
			if(u.getRole().equals("ROLE_PREMIUM")){
				counter++;
			}
		}
		if(counter>0){
			return true;
		}else{
			return false;
		}
	}

	public void expiredUserPremiumCheck() {
		Query query = getSession().createQuery("DELETE FROM UserRole WHERE user= :userName AND role= :userRole");
		query.setParameter("userName", getUserFromDatabase(getUserName()));
		query.setParameter("userRole", "ROLE_PREMIUM");
		query.executeUpdate();
	}

	public void sendContactMessage(ContactMessages contactMessages) {
		if(contactMessages.getMessage() != null){
			ContactMessages contactMessages2 = contactMessages;
			contactMessages2.setUser(getUserFromDatabase(getUserName()));
			getSession().save(contactMessages2);
		}
	}
	
	//not working kek
	@SuppressWarnings("unchecked")
	public boolean updatePassword(ChangePassword changePassword) {
		List<User> userList = new ArrayList<User>();
		User usr = new User();
		Query query = getSession().createQuery("FROM User WHERE userName= :userName").setParameter("userName", getUserFromDatabase(getUserName()));
		userList = query.getResultList();
		String hashPass = PasswordEncoderGenerator(changePassword.getOldPassword());
		String existHashPass = null;
		try{
			System.out.println("pass2");
			usr = userList.get(0);
			existHashPass = usr.getPassword();

			System.out.println("pass2 " + hashPass);
			System.out.println("pass2 " + existHashPass);
			if(hashPass.equals(existHashPass)){ //proceed to change pass
				System.out.println("pass3");
				String freshHashPassword = PasswordEncoderGenerator(changePassword.getFreshPassword());
				Query qu = getSession().createQuery("UPDATE User SET password: =freshPassword WHERE userName= :userName AND password= :oldPassword")
						.setParameter("fershPassword", freshHashPassword)
						.setParameter("userName", usr.getFirstName())
						.setParameter("oldPassword", existHashPass);
				qu.executeUpdate();
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return false;
	}

	//check is user exist
	@SuppressWarnings("unchecked")
	public boolean userExists(User user) {
		List<User> usr = new ArrayList<User>();
		Query query = getSession().createQuery("FROM User WHERE userName= :userName")
				.setParameter("userName", user.getFirstName());
		
		usr = query.getResultList();
		if(usr.isEmpty()){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void deleteAllAlerts() {
		Query query = getSession().createQuery("DELETE FROM AlertMessage");
		query.executeUpdate();
	}

	@Override
	public void createAlertMessage(AlertMessage alertMessage) {
		System.out.println("createStart");

		System.out.println("createStart" + alertMessage.getMessage());
		getSession().save(alertMessage);
		System.out.println("createStop");
	}

	@Override
	@SuppressWarnings("unchecked")
	public String getAleryMessage() {
		Query query = getSession().createQuery("FROM AlertMessage");
		List<AlertMessage> alert = new ArrayList<>();
		String msg = "";
		try{
			alert = query.getResultList();
			msg = "from " + alert.get(0).getFrom() + " to " +  alert.get(0).getTo() + " " + alert.get(0).getMessage();
		}catch(Exception e){
			msg = "";
		}
		return msg;
	}
}
