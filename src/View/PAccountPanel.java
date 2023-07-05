package View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ValueObject.VAccount;
import global.Locale;

public class PAccountPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	String id;
	String password;
	String name;
	String num;
	String gubun;
	String dahak;
	String jungong;

	public PAccountPanel(VAccount vAccount) {

		id = vAccount.getId();
		password = vAccount.getPassword();
		name = vAccount.getName();
		num = vAccount.getnum();
		gubun = vAccount.getgubun();
		dahak = vAccount.getdahak();
		jungong = vAccount.getjungong();

		JLabel lName = new JLabel(vAccount.getName());
		this.add(lName);

		JLabel lGreeting = new JLabel(Locale.AccountPanel.INSA_POSTFIX);
		this.add(lGreeting);

		JLabel lLogin = new JLabel(Locale.AccountPanel.LOGINTIME_PREFIX);
		this.add(lLogin);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Locale.TIME_FORMAT);
		JLabel lTime = new JLabel(simpleDateFormat.format(new Date()));
		this.add(lTime);

		JLabel lDescription = new JLabel(Locale.IPNIDA);
		this.add(lDescription);

		JButton button = new JButton("내 정보 확인");
		this.add(button);
		button.addActionListener(new MyActionListener());

		JButton button1 = new JButton("로그아웃");
		this.add(button1);
		button1.addActionListener(new MyActionListener1());
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame Frame = new JFrame();
			Frame.setSize(250, 350);
			Frame.setVisible(true);
			Frame.setResizable(false);

			Frame.setLayout(new GridLayout(7, 1));
			// Frame.setLayout(layoutManager);

			JLabel infoID = new JLabel("     ID : ");
			Frame.add(infoID);

			JLabel infoID1 = new JLabel(id);
			Frame.add(infoID1);

			JLabel infopassword = new JLabel("     password : ");
			Frame.add(infopassword);

			JLabel infopassword1 = new JLabel(password);
			Frame.add(infopassword1);

			JLabel infoname = new JLabel("     이름 : ");
			Frame.add(infoname);

			JLabel infoname1 = new JLabel(name);
			Frame.add(infoname1);

			JLabel infonum = new JLabel("     학번 : ");
			Frame.add(infonum);

			JLabel infonum1 = new JLabel(num);
			Frame.add(infonum1);

			JLabel infogubun = new JLabel("     주/야간 구분 : ");
			Frame.add(infogubun);

			JLabel infogubun1 = new JLabel(gubun);
			Frame.add(infogubun1);

			JLabel infodahak = new JLabel("     학년 : ");
			Frame.add(infodahak);

			JLabel infodahak1 = new JLabel(dahak);
			Frame.add(infodahak1);

			JLabel infojungong = new JLabel("     전공 : ");
			Frame.add(infojungong);

			JLabel infojungong1 = new JLabel(jungong);
			Frame.add(infojungong1);

		}

	}

	class MyActionListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Main main = new Main();
			Main.mainFrame.dispose();
			main.initialize();

		}

	}
}
