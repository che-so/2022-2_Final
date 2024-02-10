package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ValueObject.VAccount;

public class Main {
	static int Count = 0;
	static PLoginDialog loginDialog;
	static PMainFrame mainFrame;
	ActionHandler actionHandler = new ActionHandler();

	public Main() {
	}

	void initialize() {

		Main.loginDialog = new PLoginDialog(actionHandler);
		Main.loginDialog.setVisible(true);
	}

	private void run() {
		VAccount account = this.loginDialog.login();
		this.loginDialog.dispose();
		Loop: if (account != null) {
			mainFrame = new PMainFrame(account);
			mainFrame.initialize();
		} else {
			if (Count == 5) {
				JOptionPane.showMessageDialog(null, "로그인 실패. 프로그램이 종료됩니다.");
				break Loop;
			}
			JOptionPane.showMessageDialog(null, "로그인 실패, 아이디와 비밀번호를 다시 입력하세요");
			// System.out.print(Count);
			if (Count > 2) {
				JOptionPane.showMessageDialog(null, "로그인 시도 " + Count + "회, 5회가 되면 프로그램이 종료됩니다");
			}
			main(null);
		}
	}

	private void finish() {
	}

	class ActionHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Login")) {
				run();
			} else if (e.getActionCommand().equals("회원가입")) {
				loginDialog.setVisible(false);
				loginDialog.join();
			} else if (e.getActionCommand().equals("ID 찾기")) {
				loginDialog.setVisible(false);
				loginDialog.findID();
			} else if (e.getActionCommand().equals("PS 찾기")) {
				loginDialog.setVisible(false);
				loginDialog.findPS();
			}
		}
	}

	public static void main(String[] args) {
		Main main = new Main();
		Count++;

		main.initialize();

	}

}
