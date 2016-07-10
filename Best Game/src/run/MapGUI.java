package run;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapGUI extends JFrame {
	private Map map;
	private Hero hero;
	public MapGUI(Map map, Hero h) {
		this.setTitle("Map");
		this.hero = h;
		this.map = map;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(map.getMapSize(), map.getMapSize()));
		for (int i = 0; i < map.getMapSize(); i++) {
			for (int j = 0; j < map.getMapSize(); j++) {
				if (hero.getVerticalLocation() == j && hero.getHorizontalLocation() == i) {
					panel.add(new JLabel("H"));
				} else
					panel.add(new JLabel("" + map.getRoom(j, i)));
			}
		}

		setContentPane(panel);
		setVisible(true);
		setSize(350, 350);
		setLocation(1000, 500);
		
		/*
		 * panel.setLayout(new GridLayout(map.getMapSize()+3, 1)); JLabel labelY
		 * = new JLabel(); labelY.setText(
		 * "          X1    X2    X3    Y4   X5   X6    X7    X8   X9   X10");
		 * panel.add(labelY); for (int i = 0; i < map.getMapSize(); i++) {
		 * JLabel label = new JLabel(); label.setText("Y"+i); for (int j = 0; j
		 * < map.getMapSize(); j++) { label.setText(label.getText() + "      " +
		 * map.getRoom(i, j)); } panel.add(label); } JLabel legend = new JLabel(
		 * "0=Empty / 2=Monster / 3=Trader / 6=Boss") ; panel.add(legend);
		 * setContentPane(panel); setSize(350, 350); setVisible(true);
		 */
	}
	public void update(){

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(map.getMapSize(), map.getMapSize()));
		for (int i = map.getMapSize()-1; i >=0; i--) {
			for (int j = 0; j < map.getMapSize(); j++) {
				if (hero.getVerticalLocation() == j && hero.getHorizontalLocation() == i) {
					panel.add(new JLabel("H"));
				} else
					panel.add(new JLabel("" + map.getRoom(j, i)));
			}
		}
		this.setContentPane(panel);
		this.setVisible(true);
	}

}
