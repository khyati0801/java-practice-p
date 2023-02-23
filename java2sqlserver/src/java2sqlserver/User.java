package java2sqlserver;

public class User {
	private int id;
	private String Name;
	private String Add;
	private long mobileNo;
	private double balance;
	private String pwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAdd() {
		return Add;
	}

	public void setAdd(String add) {
		Add = add;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + ", Add=" + Add + ", mobileNo=" + mobileNo + ", balance=" + balance
				+ ", pwd=" + pwd + "]";
	}

	public User(int id, String name, String add, long mobileNo, double balance, String pwd) {
		super();
		this.id = id;
		Name = name;
		Add = add;
		this.mobileNo = mobileNo;
		this.balance = balance;
		this.pwd = pwd;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
