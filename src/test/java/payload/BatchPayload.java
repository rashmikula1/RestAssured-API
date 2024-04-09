package payload;

import java.util.Map;

import dataProvider.ExcelReader;
import pojo.Batch;
import stepDefinition.BatchStep;
import stepDefinition.ProgramStep;



public class BatchPayload {
	
	public Batch CreateBatch(String s, String s1) throws Exception
	{

	Batch p=new Batch();
	
	Map<String, String> excelDataMap = null;
	 excelDataMap = ExcelReader.getData(s,s1 );
	 if (null != excelDataMap && excelDataMap.size() > 0)
	 {
	
		 p.setBatchName(( excelDataMap).get("BatchName"));
		 p.setBatchNoOfClasses(( excelDataMap).get("NoofClasses"));
		 p.setBatchStatus(( excelDataMap).get("BatchStatus"));
		
		 p.setProgramId(ProgramStep.ProgramId);
		
		 
	 }
	
	return p;
	}

	public Batch UpdateBatch(String s, String s1) throws Exception
	{

	Batch p=new Batch();
	
	Map<String, String> excelDataMap = null;
	 excelDataMap = ExcelReader.getData(s,s1 );
	 if (null != excelDataMap && excelDataMap.size() > 0)
	 {
	
		 p.setBatchName((BatchStep.BatchName));
		 p.setProgramId(ProgramStep.ProgramId);
		 
		 p.setBatchNoOfClasses(( excelDataMap).get("NoofClasses"));
		 p.setBatchStatus(( excelDataMap).get("BatchStatus"));
		p.setBatchDescription(( excelDataMap).get("BatchDescription"));
		p.setProgramName(ProgramStep.ProgramName);
		
		 
	 }
	
	return p;
	}
	
	
	
}
