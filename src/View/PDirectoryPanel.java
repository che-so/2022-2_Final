package View;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Service.SDirectory;
import ValueObject.VDirectory;
import ValueObject.VLecture;

public class PDirectoryPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public static ArrayList<String> save = new ArrayList<String>();
	private static final int fileName = 0;

	private ListSelectionHandler listSelectionHandler;
	private PDirectory campusTable;
	private PDirectory collegeTable;
	private PDirectory departmentTable;
	private PLectureTable lectureTable;

	public PDirectoryPanel() {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);

		JPanel subPanel1 = new JPanel();

		layoutManager = new BoxLayout(subPanel1, BoxLayout.X_AXIS);
		subPanel1.setLayout(layoutManager);

		JScrollPane scrollPane = new JScrollPane();
		this.campusTable = new PDirectory("campus");
		this.listSelectionHandler = new ListSelectionHandler(campusTable);
		this.campusTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
		scrollPane.setViewportView(this.campusTable);
		subPanel1.add(scrollPane);

		scrollPane = new JScrollPane();
		this.collegeTable = new PDirectory("university");
		this.listSelectionHandler = new ListSelectionHandler(collegeTable);
		this.collegeTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
		scrollPane.setViewportView(this.collegeTable);
		subPanel1.add(scrollPane);

		scrollPane = new JScrollPane();
		this.departmentTable = new PDirectory("department");
		this.listSelectionHandler = new ListSelectionHandler(departmentTable);
		this.departmentTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
		scrollPane.setViewportView(this.departmentTable);
		subPanel1.add(scrollPane);

		this.add(subPanel1);

		JPanel subPanel2 = new JPanel();
		layoutManager = new BoxLayout(subPanel2, BoxLayout.X_AXIS);
		subPanel2.setLayout(layoutManager);

		scrollPane = new JScrollPane();
		this.lectureTable = new PLectureTable();
		this.lectureTable.getSelectionModel().addListSelectionListener(this.listSelectionHandler);
		scrollPane.setViewportView(this.lectureTable);
		subPanel2.add(scrollPane);

		this.add(subPanel2);

		this.updateTable(null, 0);
	}

	private void updateTable(Object object, int selectedIndex) {
		String fileName = null;
		if (object == null) {
			fileName = "root";
			fileName = this.campusTable.setData(fileName);
			fileName = this.collegeTable.setData(fileName);
			fileName = this.departmentTable.setData(fileName);
			this.lectureTable.setData(fileName);
		} else if (object == this.campusTable.getSelectionModel()) {
			fileName = this.campusTable.getVDirectories().get(selectedIndex).getFileName();
			fileName = this.collegeTable.setData(fileName);
			fileName = this.departmentTable.setData(fileName);
			this.lectureTable.setData(fileName);
		} else if (object == this.collegeTable.getSelectionModel()) {
			fileName = this.collegeTable.getVDirectories().get(selectedIndex).getFileName();
			fileName = this.departmentTable.setData(fileName);
			this.lectureTable.setData(fileName);
		} else if (object == this.departmentTable.getSelectionModel()) {
			fileName = this.departmentTable.getVDirectories().get(selectedIndex).getFileName();
			this.lectureTable.setData(fileName);
		} else if (object == this.lectureTable.getSelectionModel()) {

		}
	}

	public Vector<VLecture> getSelectedLectures() {
		Vector<VLecture> mlectures = new Vector<VLecture>();
		VLecture vLecture = new VLecture();

		int row = lectureTable.getSelectedRow();

		if (row == -1) {
			JOptionPane.showMessageDialog(null, "선택된 과목이 없습니다.");
			return null;
		}

		if (vLecture != null) {
			for (int i = 0; i < this.lectureTable.getSelectedRowCount(); i++) {
				vLecture.setId((String) lectureTable.getValueAt(row, 0));
				vLecture.setname((String) lectureTable.getValueAt(row, 1));
				vLecture.setprofessor((String) lectureTable.getValueAt(row, 2));
				vLecture.setcredit((String) lectureTable.getValueAt(row, 3));
				vLecture.settime((String) lectureTable.getValueAt(row, 4));
				mlectures.add(vLecture);
				row++;
			}

			String cheack = vLecture.getName();
			int bysave = PSugnasincheongPanel.cheack(cheack);
			if (bysave >= 0) {
				JOptionPane.showMessageDialog(null, "같은 과목을 넣을 수 없습니다.");
				return null;
			} else
				PSugnasincheongPanel.addsave(cheack);
		}
		return mlectures;
	}

	public Vector<VLecture> addLectures(Vector<VLecture> lectures) {
		for (VLecture vLecture : lectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getId());
			row.add(vLecture.getName());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getCredit());
			row.add(vLecture.getTime());
		}
		return lectures;
	}

	public void delLectures() {
		int row = lectureTable.getSelectedRow();
		((DefaultTableModel) lectureTable.getModel()).removeRow(row);
	}

	private class ListSelectionHandler implements ListSelectionListener {
		private PDirectory pDirectory;

		public ListSelectionHandler(PDirectory table) {
			this.pDirectory = table;
		}

		@Override
		public void valueChanged(ListSelectionEvent e) {

			int select = this.pDirectory.getSelectedRow();

			if (!e.getValueIsAdjusting() && select != -1) {
				updateTable(e.getSource(), select);
			} else {

			}
		}
	}

	private class PDirectory extends JTable {
		private static final long serialVersionUID = 1L;

		private DefaultTableModel tableModel;
		private Vector<VDirectory> vDirectories;
		SDirectory sDirectory;

		public PDirectory(String a) {

			Vector<String> header = new Vector<String>();
			header.add(a);
			this.tableModel = new DefaultTableModel(header, 0);
			this.setModel(this.tableModel);
		}

		public Vector<VDirectory> getVDirectories() {
			return this.vDirectories;
		}

		public String setData(String filename) {
			sDirectory = new SDirectory();

			this.tableModel.setNumRows(0);
			vDirectories = sDirectory.getDirectories(filename);
			for (VDirectory vDirectory : this.vDirectories) {
				Vector<String> row = new Vector<String>();
				row.add(vDirectory.getName());
				this.tableModel.addRow(row);
			}
			this.setRowSelectionInterval(0, 0);
			return vDirectories.get(0).getFileName();
		}
	}

}