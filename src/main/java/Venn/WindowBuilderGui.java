package Venn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class WindowBuilderGui {

	private JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderGui window = new WindowBuilderGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBuilderGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{169, 0};
		gbl_panel.rowHeights = new int[]{130, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_3.add(panel_4);
		
		JButton button_3 = new JButton("Set Text");
		panel_4.add(button_3);
		
		JButton button_4 = new JButton("Clear Test");
		panel_4.add(button_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_3.add(panel_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_5.add(textField_1);
		
		JButton button_5 = new JButton("Generate Item");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("testes");
				//Set.
			}
		});
		panel_3.add(button_5);
		
		Set panel_1 = new Set();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
	}

	
}
