package View;

import java.util.Vector;

import javax.swing.JOptionPane;

import ValueObject.VLecture;

public class PmiridamgiPanel extends PLectureTable {
	private static final long serialVersionUID = 1L;

	public PmiridamgiPanel() {
	}

	public Vector<VLecture> getSelectedLectures() {
		Vector<VLecture> mlectures = new Vector<VLecture>();
		VLecture vLecture = new VLecture();

		int row = this.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "선택된 과목이 없습니다.");
			return null;
		}
		if (vLecture != null) {
			for (int i = 0; i < this.getSelectedRowCount(); i++) {
				vLecture.setId((String) this.getValueAt(row, 0));
				vLecture.setname((String) this.getValueAt(row, 1));
				vLecture.setprofessor((String) this.getValueAt(row, 2));
				vLecture.setcredit((String) this.getValueAt(row, 3));
				vLecture.settime((String) this.getValueAt(row, 4));
				mlectures.add(vLecture);
				row++;
			}
		}
		return mlectures;
	}

	public int getSelectedLectures1() {
		VLecture vLecture = new VLecture();

		int row = this.getSelectedRow();
		if (row == -1) {
			// JOptionPane.showMessageDialog(null, "선택된 과목이 없습니다.");
			return 0;
		}
		if (vLecture != null) {
			for (int i = 0; i < this.getSelectedRowCount(); i++) {
				vLecture.setId((String) this.getValueAt(row, 0));
				vLecture.setname((String) this.getValueAt(row, 1));
				vLecture.setprofessor((String) this.getValueAt(row, 2));
				vLecture.setcredit((String) this.getValueAt(row, 3));
				vLecture.settime((String) this.getValueAt(row, 4));
				row++;
			}
		}
		return row;
	}

	public int getSelectedLectures2() {
		VLecture vLecture = new VLecture();

		int row = this.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "선택된 과목이 없습니다.");
			return 0;
		}
		if (vLecture != null) {
			for (int i = 0; i < this.getSelectedRowCount(); i++) {
				vLecture.setId((String) this.getValueAt(row, 0));
				vLecture.setname((String) this.getValueAt(row, 1));
				vLecture.setprofessor((String) this.getValueAt(row, 2));
				vLecture.setcredit((String) this.getValueAt(row, 3));
				vLecture.settime((String) this.getValueAt(row, 4));
				row++;
			}
		}
		String cheack = vLecture.getName();
		PSugnasincheongPanel.delsave(cheack);
		return row;
	}

	public void addLectures(Vector<VLecture> lectures) {
		for (VLecture vLecture : lectures) {
			Vector<String> row = new Vector<String>();
			row.add(vLecture.getId());
			row.add(vLecture.getName());
			row.add(vLecture.getProfessor());
			row.add(vLecture.getCredit());
			row.add(vLecture.getTime());
			this.tableModel.addRow(row);
		}
	}

	public void delLectures(int row) {
		if (row != -1) {
			this.tableModel.removeRow(row);
		}
	}
}