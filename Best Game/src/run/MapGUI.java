package run;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.TextField;

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
					TextField textField = new TextField();
					textField.setEditable(false);
					textField.setBackground(Color.CYAN);
					textField.setText("HERO");
					panel.add(textField);
				} else {
					TextField textField = new TextField();
					textField.setEditable(false);
					textField.setText("" + map.getRoom(j, i));
					if (map.getRoom(j, i) instanceof MonsterRoom) {
						textField.setBackground(Color.DARK_GRAY);
					}
					if (map.getRoom(j, i) instanceof BossRoom) {
						textField.setBackground(Color.RED);
					}
					if (map.getRoom(j, i) instanceof CityRoom) {
						textField.setBackground(Color.YELLOW);
					}
					if (map.getRoom(j, i) instanceof EmptyRoom) {
						textField.setBackground(Color.GRAY);
					}
					panel.add(textField);
				}
			}
		}

		setContentPane(panel);
		setVisible(true);
		setSize(300, 300);
		setLocation(1050, 200);
	}

	public void update() {

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(map.getMapSize(), map.getMapSize()));

		for (int i = map.getMapSize() - 1; i >= 0; i--) {
			for (int j = 0; j < map.getMapSize(); j++) {
				if (hero.getVerticalLocation() == j && hero.getHorizontalLocation() == i) {
					TextField textField = new TextField();
					textField.setEditable(false);
					textField.setBackground(Color.CYAN);
					textField.setText("HERO");
					panel.add(textField);
				} else {
					TextField textField = new TextField();
					textField.setEditable(false);
					textField.setText("" + map.getRoom(j, i));
					if (map.getRoom(j, i) instanceof MonsterRoom) {
						textField.setBackground(Color.BLACK);
					}
					if (map.getRoom(j, i) instanceof BossRoom) {
						textField.setBackground(Color.RED);
					}
					if (map.getRoom(j, i) instanceof CityRoom) {
						textField.setBackground(Color.YELLOW);
					}
					if (map.getRoom(j, i) instanceof EmptyRoom) {
						textField.setBackground(Color.GRAY);}
					panel.add(textField);
				}
			}
		}
		this.setContentPane(panel);
		this.setVisible(true);
	}

}
