package Entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ValueObject.VAccount;

public class EAccount {
	private String Id;
	private String password;
	private String name;
	private String num;
	private String gubun;
	private String dahak;
	private String jungong;

	public EAccount() {
	}

	private boolean read(String id, String password) {
		boolean found = false;
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && !found) {
				this.Id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				this.num = scanner.next();
				this.gubun = scanner.next();
				this.dahak = scanner.next();
				this.jungong = scanner.next();
				if (this.Id.compareTo(id) == 0 && this.password.compareTo(password) == 0) {
					found = true;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	private boolean read1(String id) {
		boolean found = false;
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && !found) {
				this.Id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				this.num = scanner.next();
				this.gubun = scanner.next();
				this.dahak = scanner.next();
				this.jungong = scanner.next();
				if (this.Id.compareTo(id) == 0) {
					found = true;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	private boolean read2(String name, String num) {
		boolean found = false;
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && !found) {
				this.Id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				this.num = scanner.next();
				this.gubun = scanner.next();
				this.dahak = scanner.next();
				this.jungong = scanner.next();
				if (this.name.compareTo(name) == 0 && this.num.compareTo(num) == 0) {
					found = true;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	private boolean read3(String id, String name, String num) {
		boolean found = false;
		try {
			File file = new File("account/account");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && !found) {
				this.Id = scanner.next();
				this.password = scanner.next();
				this.name = scanner.next();
				this.num = scanner.next();
				this.gubun = scanner.next();
				this.dahak = scanner.next();
				this.jungong = scanner.next();
				if (this.Id.compareTo(Id) == 0 && this.name.compareTo(name) == 0 && this.num.compareTo(num) == 0) {
					found = true;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return found;

	}

	public VAccount getAccount(String id, String password) {
		VAccount vAccount = null;
		// file read
		boolean found = this.read(id, password);
		if (found) {
			vAccount = new VAccount();
			vAccount.setId(this.Id);
			vAccount.setPassword(this.password);
			vAccount.setName(this.name);
			vAccount.setnum(this.num);
			vAccount.setgubun(this.gubun);
			vAccount.setdahak(this.dahak);
			vAccount.setjungong(this.jungong);
		}

		return vAccount;
	}

	public VAccount getAccount1(String id) {
		VAccount vAccount = null;
		// file read
		boolean found = this.read1(id);
		if (found) {
			vAccount = new VAccount();
			vAccount.setId(this.Id);
			vAccount.setPassword(this.password);
			vAccount.setName(this.name);
			vAccount.setnum(this.num);
			vAccount.setgubun(this.gubun);
			vAccount.setdahak(this.dahak);
			vAccount.setjungong(this.jungong);
		}

		return vAccount;
	}

	public VAccount getAccount2(String name, String num) {
		VAccount vAccount = null;
		// file read
		boolean found = this.read2(name, num);
		if (found) {
			vAccount = new VAccount();
			vAccount.setId(this.Id);
			vAccount.setPassword(this.password);
			vAccount.setName(this.name);
			vAccount.setnum(this.num);
			vAccount.setgubun(this.gubun);
			vAccount.setdahak(this.dahak);
			vAccount.setjungong(this.jungong);
		}

		return vAccount;
	}

	public VAccount getAccount3(String id, String name, String num) {
		VAccount vAccount = null;
		// file read
		boolean found = this.read3(id, name, num);
		if (found) {
			vAccount = new VAccount();
			vAccount.setId(this.Id);
			vAccount.setPassword(this.password);
			vAccount.setName(this.name);
			vAccount.setnum(this.num);
			vAccount.setgubun(this.gubun);
			vAccount.setdahak(this.dahak);
			vAccount.setjungong(this.jungong);
		}

		return vAccount;
	}

}
