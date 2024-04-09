package payload;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import dataProvider.ExcelReader;

import pojo.User;
import pojo.UserLogin;
import pojo.UserRoleList;
import pojo.UserRoleMap;
import pojo.UserRoleProgramBatch;
import pojo.UserUpdate;
import pojo.UserUpdateProgramBatchStatus;
import pojo.UserUpdateRoleSatus;
import stepDefinition.BatchStep;
import stepDefinition.ProgramStep;
import stepDefinition.UserStep;

public class UserPayload<string> {
	public User CreateUser(String s, String s1) throws Exception
	{
		User u= new User();
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
		
			 u.setUserComments(( excelDataMap).get("Comments"));
			 u.setUserEduPg(( excelDataMap).get("EduPg"));
			 u.setUserEduUg(( excelDataMap).get("EduUg"));
			u.setUserId("String");
			 u.setUserFirstName(( excelDataMap).get("FirstName"));
			 u.setUserLastName(( excelDataMap).get("LastName"));
			 u.setUserLinkedinUrl(( excelDataMap).get("LinkedinUrl"));
			 u.setUserLocation(( excelDataMap).get("Location"));
			 u.setUserMiddleName(( excelDataMap).get("MiddleName"));
			 u.setUserPhoneNumber(( excelDataMap).get("PhoneNumber"));
			 u.setUserTimeZone(( excelDataMap).get("TimeZone"));
			 u.setUserVisaStatus(( excelDataMap).get("VisaStatus"));
			 UserLogin u1= new UserLogin();
			 
			 u1.setUserLoginEmail(( excelDataMap).get("LoginEmail"));
			 u1.setLoginStatus("String");
			 u1.setPassword("String");
			 u1.setStatus("String");
			 String roleIdsString = excelDataMap.get("roleID");
			 List<String> roleIdsList = Arrays.asList(roleIdsString.split(","));
	            u1.setRoleIds(roleIdsList);
	            u.setUserLogin(u1);
	            
	            List<UserRoleMap> userRoleMaps = new ArrayList<UserRoleMap>();
	            UserRoleMap u2 = new UserRoleMap();
	            u2.setRoleId(excelDataMap.get("roleID"));
	            u2.setUserRoleStatus(excelDataMap.get("RoleStatus"));
	            userRoleMaps.add(u2);
	            u.setUserRoleMaps(userRoleMaps);
		
		
	}
		
		return u;
	}

	
	public UserUpdateProgramBatchStatus updatebatchstatus( String s, String s1) throws Exception
	{
		UserUpdateProgramBatchStatus u=new UserUpdateProgramBatchStatus();
		
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
			 u.setProgramId(ProgramStep.ProgramId);
			 u.setUserId(UserStep.UserId); 
			 u.setRoleId(excelDataMap.get("roleID"));
			 List<UserRoleProgramBatch> userRoleProgramBatches = new ArrayList<UserRoleProgramBatch>();
			 UserRoleProgramBatch u1 = new UserRoleProgramBatch();
			 u1.setBatchId(BatchStep.BatchId);
			 u1.setUserRoleProgramBatchStatus(excelDataMap.get("Status"));
			 userRoleProgramBatches.add(u1);
			 u.setUserRoleProgramBatches(userRoleProgramBatches);
			 
			 
		 }
		
		return u;
		
	}
	
	public UserUpdate Updateuser( String s, String s1) throws Exception
	{
		UserUpdate u= new UserUpdate();
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
		
			 u.setUserComments(( excelDataMap).get("Comments"));
			 u.setUserEduPg(( excelDataMap).get("EduPg"));
			 u.setUserEduUg(( excelDataMap).get("EduUg"));
			u.setUserId("String");
			 u.setUserFirstName(( excelDataMap).get("FirstName"));
			 u.setUserLastName(( excelDataMap).get("LastName"));
			 u.setUserLinkedinUrl(( excelDataMap).get("LinkedinUrl"));
			 u.setUserLocation(( excelDataMap).get("Location"));
			 u.setUserMiddleName(( excelDataMap).get("MiddleName"));
			 u.setUserPhoneNumber(( excelDataMap).get("PhoneNumber"));
			 u.setUserTimeZone(( excelDataMap).get("TimeZone"));
			 u.setUserVisaStatus(( excelDataMap).get("VisaStatus"));
			
			 
			 u.setUserLoginEmail(( excelDataMap).get("LoginEmail"));
			 
		
		
	}
		
		return u;
		
	}
	
	public UserUpdateRoleSatus update(String s, String s1) throws Exception
	{
		UserUpdateRoleSatus u= new UserUpdateRoleSatus();
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
		u.setRoleId(( excelDataMap).get("Role"));
		u.setUserRoleStatus(( excelDataMap).get("Status"));
		
		 }
		 return u;
	}
	

	public  List<UserRoleList> UpdateUserRoleId(String s, String s1) throws Exception
	{
		 List<UserRoleList> userRoleLists = new ArrayList<UserRoleList>();
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
			 UserRoleList userRoleList = new UserRoleList();
		        List<String> roles = new ArrayList<String>();
		        roles.add(excelDataMap.get("Role")); 
		        userRoleList.setUserRoleList(roles);
		        userRoleLists.add(userRoleList);
	 
		 }
		 return  userRoleLists;
	}
	
	public  UserLogin UpdateUserLogin(String s, String s1) throws Exception
	{
		UserLogin u1= new UserLogin();
	
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
	
	 
	 u1.setUserLoginEmail(( excelDataMap).get("LoginEmail"));
	 u1.setLoginStatus(( excelDataMap).get("loginStatus"));
	 u1.setPassword(( excelDataMap).get("password"));
	 u1.setStatus(( excelDataMap).get("status"));
	 String roleIdsString = excelDataMap.get("Role");
	 List<String> roleIdsList = Arrays.asList(roleIdsString.split(","));
       u1.setRoleIds(roleIdsList);
       
		 }
		 return u1;
}
}

