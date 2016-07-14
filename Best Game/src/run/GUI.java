package run;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JProgressBar;

public class GUI extends JFrame {
	private static JTextArea textArea;
	private JPanel contentPane;
	private JTextField textField;
	private PrintStream standardOut;
	static InputStream is;
	static JProgressBar progressBar;
	static JProgressBar progressBar_1;

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
	private static JList<Item> list = new JList<Item>();
	private static JList<Item> list_1 = new JList<Item>();

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
		setBounds(100, 100, 951, 661);
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

		getList().setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		getList_1().setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

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
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 925, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)));

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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false).addComponent(scrollPane)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(31)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(274, Short.MAX_VALUE))
								.addComponent(lblHp, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAtk, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup().addGap(29).addComponent(label_1,
										GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addComponent(getList(), GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
								.addComponent(getList_1(), GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE)
								.addGap(11).addComponent(textField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(label)
										.addComponent(lblHp))
								.addGap(6)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblAtk)
										.addComponent(label_1))
								.addGap(18)
								.addComponent(getList(), GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(getList_1(), GroupLayout.PREFERRED_SIZE, 216,
										GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	public static JList<Item> getList() {
		return list;
	}

	public static void setList(JList<Item> list) {
		GUI.list = list;
	}

	public static JList<Item> getList_1() {
		return list_1;
	}

	public static void setList_1(JList<Item> list_1) {
		GUI.list_1 = list_1;
	}
}
