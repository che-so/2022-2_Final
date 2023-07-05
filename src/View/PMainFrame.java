package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JFrame;

import ValueObject.VAccount;
import global.Constants;

public class PMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private PAccountPanel accountPanel;
	private PSugnasincheongPanel sugangsincheongPanel;

	private VAccount vAccount;

	public void setVAccount(VAccount vAccount) {
		this.vAccount = vAccount;
	}

	public PMainFrame(VAccount account) {
		setTitle("명지대학교 수강신청");

		// attributes
		this.setSize(Constants.CMainFrame.WIDHT, Constants.CMainFrame.HEIGHT);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(size.width / 2 - this.getWidth() / 2, Constants.CMainFrame.Y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("Image/symbol.png");
		this.setIconImage(img);

		// components
		LayoutManager layoutManager = new BorderLayout();
		this.setLayout(layoutManager);

		this.accountPanel = new PAccountPanel(account);
		this.add(this.accountPanel, BorderLayout.NORTH);

		this.sugangsincheongPanel = new PSugnasincheongPanel();
		this.add(sugangsincheongPanel, BorderLayout.CENTER);

	}

	public void initialize() {
		this.setVisible(true);
	}
}
