package test;

public class User {
	private String userMethod;
	private String userName;
	private int userLevel;

	
	
	public User(String userMethod, String userName, int userLevel) {
		this.userMethod = userMethod;
		this.userName = userName;
		this.userLevel = userLevel;
	}

	public void login(String name) {
		if (this.userName.equals(name)) {
			System.out.println(this.userName + "从" + this.userMethod + "登录了！等级为" + this.userLevel);
			System.out.println();
		}
		
		
	}

	int dianQuan;
	int gold;

}
