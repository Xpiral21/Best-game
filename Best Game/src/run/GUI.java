package run;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.PrintStream;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.JButton;

public class GUI extends JFrame {
	private static JTextArea textArea;
	private JPanel contentPane;
	private JTextField textField;
	private PrintStream standardOut;
	static InputStream is;
	static JProgressBar progressBar;
	static JProgressBar progressBar_1;
	static JList<Item> list_1;
	static JList<Item> list;
	int count=0;
	int count2=0;

	public static JProgressBar getProgressBar_1() {
		return progressBar_1;
	}

	public static void setProgressBar_1(JProgressBar progressBar_1) {
		GUI.progressBar_1 = progressBar_1;
	}

	public static JProgressBar getProgressBar() {
		return progressBar;
	}

	public static void setProgressBar(JProgressBar progressBar) {
		GUI.progressBar = progressBar;
	}

	public static JLabel getLabel() {
		return label;
	}

	private static JLabel label;
	private static String stdin;

	/**
	 * Launch the application.
	 */

	public static JTextArea getTextArea() {
		return textArea;
	}

	public static String getStdin() {
		return stdin;
	}

	public JTextField getTextField() {
		return textField;
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 678);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();

		standardOut = System.out;

		JLabel lblHp = new JLabel("HP");

		label = new JLabel(String.valueOf(MainThread.getHero().getCurrentHitPoints()));

		JLabel lblAtk = new JLabel("ATK ");

		JLabel label_1 = new JLabel(
				"" + (MainThread.getHero().getMaxDamage() + MainThread.getHero().getMinDamage()) / 2);



		textField = new JTextField();
		textField.setColumns(10);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				stdin = textField.getText();

				textField.setText("");

				synchronized (Main.gigi) {
					Main.gigi.notify();
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		this.textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);

		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
					.addContainerGap())
		);

		progressBar = new JProgressBar();
		progressBar.setToolTipText("HP");
		progressBar.setStringPainted(true);
		progressBar.setForeground(Color.red);
		progressBar.setMaximum(2500);
		progressBar.setValue(2500);

		progressBar_1 = new JProgressBar();
		progressBar_1.setToolTipText("XP");
		progressBar_1.setStringPainted(true);
		progressBar_1.setForeground(Color.yellow);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(progressBar, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
				.addComponent(progressBar_1, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)));
		panel_1.setLayout(gl_panel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblInventory = new JLabel("Inventory");
		
		JLabel lblEquiped = new JLabel("Equipped Items");
		
		JButton btnNewButton = new JButton("Equip Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Hero temp=MainThread.getHero();
				int tempInt=list.getSelectedIndex();
				if(tempInt>-1){
					
				temp.equipItem(temp.getInventory().getItem(tempInt));
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Drop Item");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Hero temp=MainThread.getHero();
			int tempInt=list.getSelectedIndex();
			
			if(tempInt>-1){
				
				String itemName;
				itemName=temp.getInventory().getItem(tempInt).getName();
				temp.getEquippedItems().removeItem(itemName);
				}
			if(tempInt!=-1){
			
			temp.getInventory().removeItem(tempInt);
			}
		
			}
		});
		
		JButton btnNewButton_2 = new JButton("Music Off");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(count2==0){
				Main.getSoundToPlay().pause();
				count2=1;
				count=1;
				}	
					
				
			}});
		
		JButton btnMusicOn = new JButton("Music on");
		btnMusicOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (count!=0){
				Main.getSoundToPlay().play();
				count=0;
				count2=0;
				}
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnMusicOn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_2))
						.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrollPane)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(31)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblHp, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAtk, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(29)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInventory)
								.addComponent(lblEquiped))
							.addGap(12))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(label)
										.addComponent(lblHp))
									.addGap(6)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblAtk)
										.addComponent(label_1))
									.addGap(17)
									.addComponent(lblInventory)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblEquiped)
									.addGap(176))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2)
						.addComponent(btnMusicOn))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		list_1 = new JList<Item>();
		scrollPane_2.setViewportView(list_1);
		
		list = new JList<Item>();
		scrollPane_1.setViewportView(list);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public static JList<Item> getList_1() {
		return list_1;
	}

	public void setList_1(JList<Item> list_1) {
		this.list_1 = list_1;
	}

	public static JList<Item> getList() {
		return list;
	}

	public void setList(JList<Item> list) {
		this.list = list;
	}
}