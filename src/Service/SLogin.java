package Service;

import Entity.EAccount;
import ValueObject.VAccount;

public class SLogin {
	private EAccount eAccount;

	public SLogin() {
		this.eAccount = new EAccount();
	}

	public VAccount login(String id, String password) {
		VAccount vAccount = this.eAccount.getAccount(id, password);
		return vAccount;
	}

	public VAccount login1(String id) {
		VAccount vAccount = this.eAccount.getAccount1(id);
		return vAccount;
	}

	public VAccount login2(String name, String num) {
		VAccount vAccount = this.eAccount.getAccount2(name, num);
		return vAccount;
	}

	public VAccount login3(String id, String name, String num) {
		VAccount vAccount = this.eAccount.getAccount3(id, name, num);
		return vAccount;
	}

}
