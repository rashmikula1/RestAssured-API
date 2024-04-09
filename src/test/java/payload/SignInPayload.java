package payload;

import java.util.Map;

import dataProvider.ExcelReader;
import pojo.SignIn;

public class SignInPayload {
	
	public SignIn login(String s, String s1) throws Exception
	{
		SignIn sn= new SignIn();
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
		
		sn.setUserLoginEmailId(( excelDataMap).get("loginemail"));
		sn.setPassword(( excelDataMap).get("password"));
		
		
	}
		 return sn;		
	}

}
