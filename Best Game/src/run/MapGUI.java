package run;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapGUI extends JFrame {
	private Map map;

	public MapGUI(Map map) {
		this.map = map;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(map.getMapSize()+3, 1));
		JLabel labelY = new JLabel();
		labelY.setText("          Y1    Y2    Y3    Y4   Y5   Y6    Y7    Y8   Y9   Y10");
		panel.add(labelY);
		for (int i = 0; i < map.getMapSize(); i++) {
			JLabel label = new JLabel();
			label.setText("X"+i);
			for (int j = 0; j < map.getMapSize(); j++) {
				label.setText(label.getText() + "      " + map.getRoom(i, j));
			}
			panel.add(label);
		}
		JLabel legend = new JLabel("0=Empty / 2=Monster / 3=Trader / 6=Boss") ;
		panel.add(legend);
		setContentPane(panel);
		setSize(350, 350);
		setVisible(true);
	}
}
