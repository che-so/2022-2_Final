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
				JOptionPane.showMessageDialog(null, "�α��� ����. ���α׷��� ����˴ϴ�.");
				break Loop;
			}
			JOptionPane.showMessageDialog(null, "�α��� ����, ���̵�� ��й�ȣ�� �ٽ� �Է��ϼ���");
			// System.out.print(Count);
			if (Count > 2) {
				JOptionPane.showMessageDialog(null, "�α��� �õ� " + Count + "ȸ, 5ȸ�� �Ǹ� ���α׷��� ����˴ϴ�");
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
			} else if (e.getActionCommand().equals("ȸ������")) {
				loginDialog.setVisible(false);
				loginDialog.join();
			} else if (e.getActionCommand().equals("ID ã��")) {
				loginDialog.setVisible(false);
				loginDialog.findID();
			} else if (e.getActionCommand().equals("PS ã��")) {
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
