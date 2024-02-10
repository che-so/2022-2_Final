package ValueObject;

public class VAccount {
	private String id;
	private String password;
	private String name;
	private String num;
	private String gubun;
	private String dahak;
	private String jungong;

	public VAccount() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getnum() {
		return num;
	}

	public void setnum(String num) {
		this.num = num;
	}

	public String getgubun() {
		return gubun;
	}

	public void setgubun(String gubun) {
		this.gubun = gubun;
	}

	public String getdahak() {
		return dahak;
	}

	public void setdahak(String dahak) {
		this.dahak = dahak;
	}

	public String getjungong() {
		return jungong;
	}

	public void setjungong(String jungong) {
		this.jungong = jungong;
	}

}
