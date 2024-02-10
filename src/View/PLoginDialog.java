package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Service.SLogin;
import ValueObject.VAccount;

public class PLoginDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private JTextField tfId;
	private JPasswordField tfPassword;

	JFrame joinFrame = new JFrame();
	JPanel joinPanel = new JPanel();
	JFrame FindID = new JFrame();
	JFrame FindPS = new JFrame();
	static JTextField lbId1 = new JTextField(); // ���̵�
	static JTextField sec1 = new JTextField(); // ���ȹ���
	JPasswordField Password = new JPasswordField(); // ��й�ȣ
	JPasswordField Password1 = new JPasswordField(); // ��й�ȣ Ȯ��
	JTextField name1 = new JTextField(); // �̸�
	JTextField num1 = new JTextField(); // �й�
	JTextField gubun1 = new JTextField(); // �ְ� �߰� ����
	JTextField dahak1 = new JTextField(); // �г�
	JTextField jungong1 = new JTextField(); // ����
	static int ran;

	JTextField FindID1 = new JTextField(); // id ã�� �̸�
	JTextField FindID3 = new JTextField(); // id ã�� �й�

	JTextField FindPS5 = new JTextField(); // PS ã�� ID
	JTextField FindPS1 = new JTextField(); // PS ã�� �̸�
	JTextField FindPS3 = new JTextField(); // PS ã�� �й�

	File file = new File("account/account");

	private SLogin sLogin;

	static boolean IDjb = false;
	static boolean secjb = false;

	public PLoginDialog(View.Main.ActionHandler actionHandler) {

		Toolkit toolkit = Toolkit.getDefaultToolkit(); // ��� ������
		Image img = toolkit.getImage("Image/symbol.png"); // �̹��� ��������
		this.setIconImage(img); // �̹��� ������ ����

		setTitle("�������б� �α���"); // ����

		JLabel imgLbl = new JLabel(); // ������ ���� imgLbl
		ImageIcon Img = new ImageIcon("Image/�α���.jpg"); // ����
		imgLbl.setIcon(Img);
		this.add(imgLbl);

		this.setSize(450, 260);
		this.setModal(true);
		this.getContentPane().setBackground(Color.WHITE);

		LayoutManager layoutManager = new FlowLayout();
		this.setLayout(layoutManager);

		JLabel lbId = new JLabel("���̵�");
		this.add(lbId);

		this.tfId = new JTextField();
		this.tfId.setColumns(10);
		this.add(tfId);

		JLabel lbPassword = new JLabel("��й�ȣ");
		this.add(lbPassword);

		this.tfPassword = new JPasswordField();
		this.tfPassword.setColumns(10);
		this.add(tfPassword);

		JButton btLogin1 = new JButton("Login");
		this.getRootPane().setDefaultButton(btLogin1);
		btLogin1.setBackground(Color.decode("#071d49"));
		btLogin1.setForeground(Color.WHITE);
		this.add(btLogin1, BorderLayout.SOUTH);
		btLogin1.setActionCommand("Login");

		JButton btLogin2 = new JButton("ȸ������");
		btLogin2.setBackground(Color.decode("#071d49"));
		btLogin2.setForeground(Color.WHITE);
		this.add(btLogin2, BorderLayout.SOUTH);
		btLogin2.setActionCommand("ȸ������");

		JButton btLogin3 = new JButton("ID ã��");
		btLogin3.setBackground(Color.decode("#071d49"));
		btLogin3.setForeground(Color.WHITE);
		this.add(btLogin3, BorderLayout.SOUTH);
		btLogin3.setActionCommand("ID ã��");

		JButton btLogin4 = new JButton("PS ã��");
		btLogin4.setBackground(Color.decode("#071d49"));
		btLogin4.setForeground(Color.WHITE);
		this.add(btLogin4, BorderLayout.SOUTH);
		btLogin4.setActionCommand("PS ã��");

		btLogin1.addActionListener(actionHandler);
		btLogin2.addActionListener(actionHandler);
		btLogin3.addActionListener(actionHandler);
		btLogin4.addActionListener(actionHandler);

		this.addWindowListener(new WinEvent3());

		this.sLogin = new SLogin();

	}

	public VAccount login() {
		String id = this.tfId.getText();
		String password = this.tfPassword.getText();
		VAccount vAccount = this.sLogin.login(id, password);
		this.dispose();
		return vAccount;
	}

	public void join() {
		joinFrame.setTitle("ȸ������");
		joinFrame.setResizable(false);
		joinFrame.addWindowListener(new WinEvent());

		LayoutManager layoutManager = new FlowLayout();
		joinPanel.setLayout(layoutManager);

		Toolkit toolkit = Toolkit.getDefaultToolkit(); // ��� ������
		Image img = toolkit.getImage("Image/symbol.png"); // �̹��� ��������
		joinFrame.setIconImage(img);

		joinFrame.setVisible(true);
		joinFrame.setSize(350, 370);

		joinFrame.add(joinPanel);

		JLabel join = new JLabel("            ���� ������ ������ ���̵�� ��й�ȣ�� �Է��ϼ���            ");
		joinPanel.add(join);
		join.setForeground(Color.BLUE);

		JLabel lbId = new JLabel("���� ���� ���̵� : ");
		joinPanel.add(lbId);

		lbId1.setColumns(10);
		joinPanel.add(lbId1);

		JButton btLogin1 = new JButton("ID �ߺ�Ȯ��");
		joinPanel.getRootPane().setDefaultButton(btLogin1);
		btLogin1.setBackground(Color.decode("#071d49"));
		btLogin1.setForeground(Color.WHITE);
		joinPanel.add(btLogin1, BorderLayout.SOUTH);
		btLogin1.addActionListener(new MyActionListener());

		JLabel lbPassword = new JLabel("���� ���� ��й�ȣ : ");
		joinPanel.add(lbPassword);

		Password.setColumns(10);
		joinPanel.add(Password);

		JLabel join1 = new JLabel("            ��й�ȣ Ȯ���� ���� ��й�ȣ�� �ѹ� �� �Է����ּ���            ");
		joinPanel.add(join1);
		join1.setOpaque(true);
		join1.setForeground(Color.BLUE);

		JLabel lbPassword1 = new JLabel("��й�ȣ Ȯ�� : ");
		joinPanel.add(lbPassword1);

		Password1.setColumns(10);
		joinPanel.add(Password1);

		JLabel join2 = new JLabel("                         �л� ������ �Է����ּ���                          ");
		joinPanel.add(join2);
		join2.setForeground(Color.BLUE);

		JLabel name = new JLabel("�̸� : ");
		joinPanel.add(name);

		name1.setColumns(4);
		joinPanel.add(name1);

		JLabel num = new JLabel("�й� : ");
		joinPanel.add(num);

		num1.setColumns(6);
		joinPanel.add(num1);

		JLabel gubun = new JLabel("��/�߰� ���� : ");
		joinPanel.add(gubun);

		gubun1.setColumns(3);
		joinPanel.add(gubun1);

		JLabel dahak = new JLabel("�г� : ");
		joinPanel.add(dahak);

		dahak1.setColumns(5);
		joinPanel.add(dahak1);

		JLabel jungong = new JLabel("���� : ");
		joinPanel.add(jungong);

		jungong1.setColumns(10);
		joinPanel.add(jungong1);

		JLabel join3 = new JLabel("ȭ�鿡 ǥ�õ� ���ȹ��ڸ� �Է����ּ��� ->");
		joinPanel.add(join3);
		join3.setForeground(Color.BLUE);

		JTextField sec = new JTextField();
		sec.setColumns(7);
		joinPanel.add(sec);

		Random random = new Random();
		ran = random.nextInt(100000, 300000);
		String ran1 = Integer.toString(ran);
		sec.setText(ran1);

		JLabel lbPassword2 = new JLabel("���ȹ��� �Է� : ");
		joinPanel.add(lbPassword2);

		sec1.setColumns(10);
		joinPanel.add(sec1);

		JButton btLogin4 = new JButton("���ȹ��� Ȯ��");
		joinPanel.getRootPane().setDefaultButton(btLogin4);
		btLogin4.setBackground(Color.decode("#071d49"));
		btLogin4.setForeground(Color.WHITE);
		joinPanel.add(btLogin4);
		btLogin4.addActionListener(new MyActionListener1());

		JButton btLogin2 = new JButton("�������б� ȸ������");
		joinPanel.getRootPane().setDefaultButton(btLogin2);
		btLogin2.setBackground(Color.decode("#071d49"));
		btLogin2.setForeground(Color.WHITE);
		joinPanel.add(btLogin2);
		btLogin2.addActionListener(new MyActionListener2());

	}

	public void findID() {

		FindID.setTitle("ID ã��");
		FindID.setResizable(false);
		FindID.addWindowListener(new WinEvent1());

		LayoutManager layoutManager = new FlowLayout();
		FindID.setLayout(layoutManager);

		Toolkit toolkit = Toolkit.getDefaultToolkit(); // ��� ������
		Image img = toolkit.getImage("Image/symbol.png"); // �̹��� ��������
		FindID.setIconImage(img);

		FindID.setVisible(true);
		FindID.setSize(260, 150);

		JLabel FindID0 = new JLabel("�̸� �Է� : ");
		FindID.add(FindID0);

		FindID1.setColumns(10);
		FindID.add(FindID1);

		JLabel FindID2 = new JLabel("�й� �Է� : ");
		FindID.add(FindID2);

		FindID3.setColumns(10);
		FindID.add(FindID3);

		JButton btfind1 = new JButton("ID ã��");
		FindID.getRootPane().setDefaultButton(btfind1);
		btfind1.setBackground(Color.decode("#071d49"));
		btfind1.setForeground(Color.WHITE);
		FindID.add(btfind1);
		btfind1.addActionListener(new MyActionListener4());

	}

	public void findPS() {

		FindPS.setTitle("PS ã��");
		FindPS.setResizable(false);
		FindPS.addWindowListener(new WinEvent2());

		LayoutManager layoutManager = new FlowLayout();
		FindPS.setLayout(layoutManager);

		Toolkit toolkit = Toolkit.getDefaultToolkit(); // ��� ������
		Image img = toolkit.getImage("Image/symbol.png"); // �̹��� ��������
		FindPS.setIconImage(img);

		FindPS.setVisible(true);
		FindPS.setSize(240, 160);

		JLabel FindPS4 = new JLabel("ID �Է� : ");
		FindPS.add(FindPS4);

		FindPS5.setColumns(10);
		FindPS.add(FindPS5);

		JLabel FindPS0 = new JLabel("�̸� �Է� : ");
		FindPS.add(FindPS0);

		FindPS1.setColumns(10);
		FindPS.add(FindPS1);

		JLabel FindPS2 = new JLabel("�й� �Է� : ");
		FindPS.add(FindPS2);

		FindPS3.setColumns(10);
		FindPS.add(FindPS3);

		JButton btfind2 = new JButton("PS ã��");
		FindPS.getRootPane().setDefaultButton(btfind2);
		btfind2.setBackground(Color.decode("#071d49"));
		btfind2.setForeground(Color.WHITE);
		FindPS.add(btfind2);
		btfind2.addActionListener(new MyActionListener5());

	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String id = lbId1.getText();
			if (id.equals("")) {
				JOptionPane.showMessageDialog(null, "���̵� �Է� ĭ�� ����ֽ��ϴ�.");
			} else {
				VAccount vAccount = sLogin.login1(id);

				if (vAccount != null) {
					JOptionPane.showMessageDialog(null, "���� ���̵� �����մϴ�. �ٸ� ���̵�� ȸ������ �� �ּ���");
				} else {
					JOptionPane.showMessageDialog(null, "�� ���̵�� ȸ������ �����մϴ�");
					IDjb = true;
				}
			}
		}

	}

	class MyActionListener1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (sec1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���ȹ��� �Է�ĭ�� ��� �ֽ��ϴ�.");
			} else {
				if (Integer.parseInt(sec1.getText()) == ran) {
					JOptionPane.showMessageDialog(null, "���ȹ��ڸ� �˸°� �Է��ϼ̽��ϴ�.");
					secjb = true;
				} else {
					JOptionPane.showMessageDialog(null, "���ȹ��ڸ� �ٸ��� �Է��ϼ̽��ϴ�.");
				}
			}
		}

	}

	class MyActionListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (IDjb == false) {
				JOptionPane.showMessageDialog(null, "ID �ߺ�Ȯ�� ��ư�� ���� Ȯ�����ּ���");
			} else if (secjb == false) {
				JOptionPane.showMessageDialog(null, "���ȹ��� Ȯ�� ��ư�� ���� Ȯ�����ּ���");
			} else if (!Password.getText().equals(Password1.getText())) {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ��й�ȣ Ȯ���� ���� �ʽ��ϴ�. �ٽ� �Է��� �ּ���");
			} else {
				if (name1.getText().equals("") || num1.getText().equals("") || gubun1.getText().equals("")
						|| dahak1.getText().equals("") || jungong1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ä���� ���� ������ �ֽ��ϴ�.");
				} else {

					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
						bw.newLine();
						bw.write(lbId1.getText());
						bw.write(" ");
						bw.write(Password.getText());
						bw.write(" ");
						bw.write(name1.getText());
						bw.write(" ");
						bw.write(num1.getText());
						bw.write(" ");
						bw.write(gubun1.getText());
						bw.write(" ");
						bw.write(dahak1.getText());
						bw.write(" ");
						bw.write(jungong1.getText());
						bw.close();

						JOptionPane.showMessageDialog(null, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
						name1.setText("");
						num1.setText("");
						gubun1.setText("");
						dahak1.setText("");
						jungong1.setText("");
						Password.setText("");
						Password1.setText("");
						name1.setText("");
						lbId1.setText("");
						sec1.setText("");
						joinFrame.setVisible(false);
						Main main = new Main();
						main.initialize();

					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		}

	}

	class MyActionListener4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String findname = FindID1.getText();
			String findnum = FindID3.getText();
			VAccount vAccount = sLogin.login2(findname, findnum);
			if (vAccount != null) {
				JOptionPane.showMessageDialog(null, "ID�� : " + vAccount.getId() + " �Դϴ�");

			} else {
				JOptionPane.showMessageDialog(null, "ID�� �����ϴ�. �ùٸ� ������ �Է����ּ���");
			}

		}

	}

	class MyActionListener5 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String findpsid = FindPS5.getText();
			String findpsname = FindPS1.getText();
			String findpsnum = FindPS3.getText();

			VAccount vAccount = sLogin.login3(findpsid, findpsname, findpsnum);
			if (vAccount != null) {
				JOptionPane.showMessageDialog(null, "PS�� : " + vAccount.getPassword() + " �Դϴ�");

			} else {
				JOptionPane.showMessageDialog(null, "PS�� �����ϴ�. �ùٸ� ������ �Է����ּ���");
			}

		}

	}

	class WinEvent implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			name1.setText("");
			num1.setText("");
			gubun1.setText("");
			dahak1.setText("");
			jungong1.setText("");
			Password.setText("");
			Password1.setText("");
			name1.setText("");
			lbId1.setText("");
			sec1.setText("");
			joinFrame.dispose();
			Main main = new Main();
			main.initialize();

		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class WinEvent1 implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			FindID.dispose();
			Main main = new Main();
			main.initialize();

		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class WinEvent2 implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			FindPS.dispose();
			Main main = new Main();
			main.initialize();

		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}

	class WinEvent3 implements WindowListener {

		@Override
		public void windowOpened(WindowEvent e) {

		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);

		}

		@Override
		public void windowClosed(WindowEvent e) {

		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent e) {

		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub

		}

	}
}
