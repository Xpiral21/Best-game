package run;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class GUI extends JFrame {
	private static JTextArea textArea;
	private JPanel contentPane;
	private JTextField textField;
	private PrintStream standardOut;
	static InputStream is;
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
		setBounds(100, 100, 795, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 779, 569);
		contentPane.add(panel);

		standardOut = System.out;

		JLabel lblHp = new JLabel("HP");
		lblHp.setBounds(560, 11, 130, 14);

		JLabel label = new JLabel("0");
		label.setBounds(591, 11, 60, 14);

		JLabel lblAtk = new JLabel("ATK");
		lblAtk.setBounds(560, 31, 190, 14);

		JLabel label_1 = new JLabel("0");
		label_1.setBounds(589, 31, 60, 14);

		JList list = new JList();
		list.setBounds(560, 63, 209, 245);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JList list_1 = new JList();
		list_1.setBounds(560, 326, 210, 216);
		list_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		textField = new JTextField();
		textField.setBounds(10, 514, 532, 20);
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
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 532, 492);
		panel.add(scrollPane);

		this.textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
		System.setOut(printStream);
		System.setErr(printStream);
		panel.add(textField);
		panel.add(list);
		panel.add(lblHp);
		panel.add(label);
		panel.add(lblAtk);
		panel.add(label_1);
		panel.add(list_1);
	}
}
