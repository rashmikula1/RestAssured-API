package payload;

import java.util.Map;

import dataProvider.ExcelReader;
import pojo.Program;
import stepDefinition.ProgramStep;

public class ProgramPayload {

	public Program CreateProgram(String s, String s1) throws Exception
	{
		
		Program p=new Program();
		
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
		
			 p.setProgramDescription(( excelDataMap).get("ProgramDescription"));
			 p.setProgramName(( excelDataMap).get("ProgramName"));
			 p.setProgramStatus(( excelDataMap).get("ProgramStatus"));
			 
		 }
		
		return p;
	}
	
	public Program UpdateProgram(String s, String s1) throws Exception
	{
		
		Program p=new Program();
		
		Map<String, String> excelDataMap = null;
		 excelDataMap = ExcelReader.getData(s,s1 );
		 if (null != excelDataMap && excelDataMap.size() > 0)
		 {
		
			 p.setProgramDescription(( excelDataMap).get("ProgramDescription"));
			 p.setProgramName(ProgramStep.ProgramName);
			 p.setProgramId(ProgramStep.ProgramId);
			
			 p.setProgramStatus(( excelDataMap).get("ProgramStatus"));
			 
		 }
		
		return p;
	}
}
