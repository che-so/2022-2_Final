package View;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import View.PSugnasincheongPanel.ActionHandler;

public class PControlPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JButton butteonRight;
	private JButton butteonLeft;

	public PControlPanel(String id, ActionHandler actionHandler) {
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);

		this.butteonRight = new JButton(">>");
		this.butteonRight.addActionListener(actionHandler);
		this.butteonRight.setActionCommand(id + this.butteonRight.getText());
		this.add(this.butteonRight);

		this.butteonLeft = new JButton("<<");
		this.butteonLeft.addActionListener(actionHandler);
		this.butteonLeft.setActionCommand(id + this.butteonLeft.getText());
		this.add(this.butteonLeft);
	}
}
