package endpoints;

public enum APIResources {
	//User Login Controller
	LoginAPI("/login"),
	LogoutAPI("/logoutlms"),
	//Program  Controller
	GetAllProgramAPI("/allPrograms"),
	GellAllProgramWithUserAPI("/allProgramsWithUsers"),
    GetProgrambyProgramID("/programs/{programId}"),
	DeleteProgramByProgramIDAPI("/deletebyprogid/{programId}"),
	DeleteProgramByProgramNameAPI("deletebyprogname/{programName}"),
	UpdateProgramByProgramNameAPI("program/{programName}"),
	UpdateProgrambyProgramIDAPI("/putprogram/{programId}"),
	CreateProgramAPI("/saveprogram"),
	//Program Batch Controller
	GetAllBatchAPI("/batches"),
    GetBatchdetailsBatchIdAPI("/batches/batchId/{batchId}"),
    GetBatchdetailsbyBatchNameAPI("/batches/batchName/{batchName}"),
    GetBatchdetailsbyProgramIdAPI("/batches/program/{programId}"),
    CreateNewBatchAPI("/batches"),
    UpdateBatchdetailsAPI("/batches/{batchId}"),
    DeleteexistingBatchAPI("/batches/{batchId}"),

     //User Controller

   GetAllrolesAPI("/roles"),
   GetallUsersAPI("/users"),
   GetUserInfobyID("/users/{userId}"),
   UpdateUserAPI("/users/{userId}"),
   DeleteUserAPI("/users/{userId}"),
   GetallActiveUserAPI("/users/activeUsers"),
   GetcountofactiveandinactiveUSerAPI("/users/byStatus"),
   GetUserbyProgramBatchesAPI("/users/programBatch/{batchId}"),
   GetUserforProgramAPI("/users/programs/{programId}"),
   UpdateUserRoleIdAPI("/users/roleId/{userId}"),
   UpdateUserRoleProgramBatchstatusAPI("/users/roleProgramBatchStatus/{userId}"),
   GetAllUsersWithRolesAPI("/users/roles"),
   GetUserbyRoleIDAPI("/users/roles/{roleId}"),
  CreateUserLoginwithRoleAPI("/users/roleStatus"),
  UpdateUserRoleStatusAPI("/users/roleStatus/{userId}"),
  UpdateUserLoginStatusAPI("/users/userLogin/{userId}"),
   GetallUserswithFacetsFiltersAPI("/v2/users"),
 
   //User Role Program Batch Map Controller

   GetAssignedProgramBatchesofAllUsersAPI("/userRoleProgramBatchMap"),
   GetAssignedProgramBatchofUserByUserIdAPI("/userRoleProgramBatchMap/{userId}"),
   DeleteAllProgramsBatchesassignedtotheUserByUserIdAPI("/userRoleProgramBatchMap/deleteAll/{userId}");
   

	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}


}
