
package test;

import java.util.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

/**
 * @author Zhouyang Wang 
 * @version 1.0
 * @since 1.8.201
 */
/**
 * This class create MultipleChoiceGui for the user to choose difficulty of the
 * question he/she will confront. Once the user has chosen the mode,it will show
 * one question which is exactly that type of question. And the user did not
 * need to finish all the questions of current mode,he/she has the chance to try
 * different mode every time. Until all questions are finished.For each
 * mode,when questions are finished, it will show the message on the button to
 * remind the user that he/she can not choose again. Implement function of Reset
 * and Showing current score.
 */
public class MultipleChoiceGui extends JFrame {

	/**
	 * the number of easy questions total
	 */
	protected static int NUM_OF_EASY = 4;
	/**
	 * the number of medium questions total
	 */
	protected static int NUM_OF_MEDIUM= 2;
	/**
	 * the number of difficult questions total
	 */
	protected static int NUM_OF_DIFF = 1;
	/**
	 * the number of questions that have not been finished which initial value is NUM_OF_EASY + NUM_OF_MEDIUM + NUM_OF_DIFF
	 */
	protected static int total = NUM_OF_EASY + NUM_OF_MEDIUM + NUM_OF_DIFF;
	/**
	 * the number of easy questions that currently have been completed.
	 */
	protected static int countEasy = 0;
	/**
	 * the number of medium questions that currently have been completed.
	 */
	protected static int countMedium = 0;
	/**
	 * the number of difficult questions that currently have been completed.
	 */
	protected static int countDiff = 0;

	/**
	 * The main method launches the application.
	 * 
	 */
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MultipleChoiceGui frame = new MultipleChoiceGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create Question GUI When user click button.
	 * 
	 * @param decide The mode of question.
	 * 
	 */

	public void makeMCG(int decide) throws Exception {

		int count = 0; //the number of questions that have been finished
		int point = 0; // Default point for each different type of question
		if (decide == 1) {

			ReadFile f1 = new ReadFile();
			f1.toReadFile(1);
			count = countEasy;
			point = 2; // Default point for easy question
		} else if (decide == 2) {
			ReadFile f2 = new ReadFile();
			f2.toReadFile(2);
			count = countMedium; // Default point for medium question
			point = 4;
		} else {
			ReadFile f1 = new ReadFile();
			f1.toReadFile(3);
			count = countDiff;
			point = 6; // Default point for difficult question
		}

		MultipleChoiceGuiFrame frame = new MultipleChoiceGuiFrame(point, ReadFile.strArray.get(0 + 5 * count),
				ReadFile.strArray.get(1 + 5 * count), ReadFile.strArray.get(2 + 5 * count),
				ReadFile.strArray.get(3 + 5 * count), ReadFile.strArray.get(4 + 5 * count));
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		MultipleChoiceGuiFrame.check = 0;
		total--;
		count++;
		/**
		 * update the count values for each type of question.
		 */
		if (decide == 1)
			countEasy = count;
		else if (decide == 2)
			countMedium = count;
		else
			countDiff = count;
	}

	/**
	 * This method is to reset counters n,m,k equal to 0, reset number of questions
	 * right now to the total number.
	 * 
	 */
	public void reset() {
		MultipleChoiceGuiFrame.num = 0;
		countEasy = countMedium = countDiff = 0;
		total = NUM_OF_EASY + NUM_OF_MEDIUM + NUM_OF_DIFF;
	}

	/**
	 * Create the frame.
	 */
	public MultipleChoiceGui() throws Exception {
		setTitle("Mutiple Choice Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPleaseChoose = new JLabel("Please choose the difficulty of the Question.");
		lblPleaseChoose.setBounds(14, 13, 422, 34);
		lblPleaseChoose.setFont(new Font("Book Antiqua", Font.PLAIN, 18));
		contentPane.add(lblPleaseChoose);

		JRadioButton btnEasy = new JRadioButton("Easy");
		btnEasy.setBounds(14, 49, 404, 41);
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (countEasy <= NUM_OF_EASY - 1)
					try {
						dispose(); // close current Frame
						makeMCG(1); // make Easy question GUI
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				else
					btnEasy.setText("There are only " + NUM_OF_EASY + " Easy Questions!");
			}
		});
		btnEasy.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		contentPane.add(btnEasy);

		JRadioButton btnMidium = new JRadioButton("Midium");
		btnMidium.setBounds(14, 103, 404, 41);
		btnMidium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (countMedium <= NUM_OF_MEDIUM - 1)
					try {
						dispose(); // close current Frame
						makeMCG(2); // make Medium question GUI
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				else
					btnMidium.setText("There are only " + NUM_OF_MEDIUM + " Midium Questions!");
			}
		});
		btnMidium.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		contentPane.add(btnMidium);

		JRadioButton btnDifficult = new JRadioButton("Difficult");
		btnDifficult.setBounds(14, 157, 404, 41);
		btnDifficult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (countDiff <= NUM_OF_DIFF - 1)
					try {
						dispose(); // close current Frame
						makeMCG(3); // make Difficult question GUI
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				else
					btnDifficult.setText("There are only " + NUM_OF_DIFF + " Difficult Questions!");

			}
		});
		btnDifficult.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		contentPane.add(btnDifficult);

		JLabel lblScore = new JLabel("score=" + MultipleChoiceGuiFrame.num);
		lblScore.setBounds(143, 207, 113, 29);
		lblScore.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		contentPane.add(lblScore);

		JLabel lblTotal = new JLabel("total: " + total);
		lblTotal.setBounds(14, 210, 83, 23);
		lblTotal.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		contentPane.add(lblTotal);

		JButton btnReset = new JButton("reset");
		btnReset.setBounds(305, 211, 113, 27);
		btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
				lblScore.setText("score = " + MultipleChoiceGuiFrame.num);
				lblTotal.setText("total: " + total);
				btnEasy.setText("Easy");
				btnMidium.setText("Midium");
				btnDifficult.setText("Difficult");
			}
		});
		contentPane.add(btnReset);
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(btnEasy);
		btnGroup.add(btnMidium);
		btnGroup.add(btnDifficult);

		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
