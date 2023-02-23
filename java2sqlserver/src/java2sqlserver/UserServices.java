package java2sqlserver;

public interface UserServices {

	// create User
	public void createUser(User user);

	// get user by id singleUser
	public void getUserbyID(int id);

	// get all user
	public void getAllUser();

	// update User
	public void updateUser();

	// Delete by id
	public void deleteById();

	//login to available account
	public void Login(int id);
	
	
	

	

}
