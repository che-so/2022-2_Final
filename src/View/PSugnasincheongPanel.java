package View;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ValueObject.VLecture;

public class PSugnasincheongPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static ArrayList<String> save = new ArrayList<String>();

	private PDirectoryPanel directoryPanel;
	private PControlPanel ControlPanel1;
	private PmiridamgiPanel miridamgiPanel;
	private PControlPanel ControlPanel2;
	private PsinchongPanel sinchongPanel;

	public PSugnasincheongPanel() {
		ActionHandler actionHandler = new ActionHandler();

		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);

		this.directoryPanel = new PDirectoryPanel();
		this.add(this.directoryPanel);

		this.ControlPanel1 = new PControlPanel("1", actionHandler);
		this.add(this.ControlPanel1);

		JScrollPane scrollPane = new JScrollPane();
		this.miridamgiPanel = new PmiridamgiPanel();
		scrollPane.setViewportView(this.miridamgiPanel);
		this.add(scrollPane);

		this.ControlPanel2 = new PControlPanel("2", actionHandler);
		this.add(this.ControlPanel2);

		scrollPane = new JScrollPane();
		this.sinchongPanel = new PsinchongPanel();
		scrollPane.setViewportView(this.sinchongPanel);
		this.add(scrollPane);

	}

	private void moveFromMiridamgiToLectures() {
		int row;
		row = this.miridamgiPanel.getSelectedLectures2();
		this.miridamgiPanel.delLectures(row - 1);
	}

	private void moveFromSincheongToMiridamgi() {
		int row;
		row = this.miridamgiPanel.getSelectedLectures1();
		Vector<VLecture> lectures = this.miridamgiPanel.getSelectedLectures();
		if (lectures != null) {
			this.sinchongPanel.addLectures(lectures);
		}
		this.miridamgiPanel.delLectures(row - 1);
	}

	private void moveFromMiridamgiToSincheong() {
		int row;
		row = this.sinchongPanel.getSelectedLectures1();
		Vector<VLecture> lectures = this.sinchongPanel.getSelectedLectures();
		if (lectures != null) {
			this.miridamgiPanel.addLectures(lectures);
		}
		this.sinchongPanel.delLectures(row);
	}

	private void moveFromLecturesToMiridamgi() {
		Vector<VLecture> lectures = this.directoryPanel.getSelectedLectures();
		if (lectures != null) {
			this.miridamgiPanel.addLectures(lectures);
			this.directoryPanel.delLectures();
		}
	}

	public static void addsave(String cheack) {
		save.add(cheack);
	}

	public static void delsave(String cheack) {
		save.remove(cheack);
	}

	public static int cheack(String cheack) {
		int bysave = save.indexOf(cheack);
		return bysave;
	}

	public class ActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().compareTo("1>>") == 0) {
				moveFromLecturesToMiridamgi();
			} else if (e.getActionCommand().compareTo("1<<") == 0) {
				moveFromMiridamgiToLectures();
			}
			if (e.getActionCommand().compareTo("2>>") == 0) {
				moveFromSincheongToMiridamgi();
			} else if (e.getActionCommand().compareTo("2<<") == 0) {
				moveFromMiridamgiToSincheong();
			}

		}

	}
}
