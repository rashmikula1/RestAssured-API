package pojo;

import java.util.List;

public class UserUpdateProgramBatchStatus {

	 private int programId;
	 public int getProgramId() {
		return programId;
	}
	public void setProgramId(int programId) {
		this.programId = programId;
	}
	private String roleId;
	    private String userId;
	    private List<UserRoleProgramBatch> userRoleProgramBatches;
	    
	   
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<UserRoleProgramBatch> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}
	public void setUserRoleProgramBatches(List<UserRoleProgramBatch> userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}
		
}
