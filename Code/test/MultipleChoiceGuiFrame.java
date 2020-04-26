package test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

/**className: MultipleChoiceGuiFrame
 * packageName:test
* @author Zhouyang Wang 
 * @version 1.0
 * @since 1.8.201
 */
/**
 * This class create MultipleChoiceGui for the user to choose the answer to the
 * question. Implement currently calculating score function for the user.
 * Implement function of Reset and Showing current score.
 */
public class MultipleChoiceGuiFrame extends JFrame {
	/**
	 * the value of score
	 */
	protected static double num = 0;
	/**
	 * a counter to check if the user has attempted twice
	 */
	protected static int check = 0;
	private JPanel contentPane;
	private JButton btnLondon;
	private JButton btnRio;
	private JButton btnReset;
	private JLabel lable;
	private JLabel lblQuestionWaht;
	private JLabel lblPossibleAnswersclickOne;
	private JLabel lblTotal;

	/**
	 * Create the MultipleChoiceGuiFrame. params:double point:Default point for each
	 * different type of question. String s1,String s2,String s3,String s4 are 4
	 * answers for the user to choose. String s5 is the question.
	 * 
	 */
	public MultipleChoiceGuiFrame(double point, String s1, String s2, String s3, String s4, String s5) {

		setTitle("Mutiple Choice Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnParis = new JButton(s1);
		btnParis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * For Easy Questions, if the user choose the right answer for one attempt
				 * he/she can get 2 points. If two attempt, the user can only 1.
				 */
				/**
				 * For Medium Questions, if the user choose the right answer for one attempt
				 * he/she can get 4 points. If two attempt, the user can only 2.
				 */
				/**
				 * For Difficult Questions, if the user choose the right answer for one attempt
				 * he/she can get 6 points. If two attempt, the user can only 3.
				 */
				if (check == 0)
					num += point;
				else
					num += point / 2;
				lable.setText("score=" + (num));
				dispose(); // close current Frame
				try {
					new MultipleChoiceGui();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnParis.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		btnParis.setBounds(14, 98, 435, 27);
		contentPane.add(btnParis);

		JButton btnBeijing = new JButton(s2);

		btnBeijing.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		btnBeijing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBeijing.setText("Wrong Answer!");
				check++;

				if (check == 2) {
					dispose(); // close current Frame
					try {
						new MultipleChoiceGui();
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			}
		});
		btnBeijing.setBounds(14, 138, 435, 27);
		contentPane.add(btnBeijing);

		btnLondon = new JButton(s3);
		btnLondon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLondon.setText("Wrong Answer!");
				check++;

				if (check == 2) {
					dispose(); // close current Frame
					try {
						new MultipleChoiceGui();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnLondon.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		btnLondon.setBounds(14, 189, 435, 27);
		contentPane.add(btnLondon);

		btnRio = new JButton(s4);
		btnRio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRio.setText("Wrong Answer!");
				check++;
				if (check == 2) {
					dispose();
					try {
						new MultipleChoiceGui();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnRio.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		btnRio.setBounds(14, 240, 435, 27);
		contentPane.add(btnRio);

		btnReset = new JButton("reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num = 0;
				lable.setText("score=" + num);
				MultipleChoiceGui.countMedium = MultipleChoiceGui.countEasy = MultipleChoiceGui.countDiff = 0;
				MultipleChoiceGui.total = MultipleChoiceGui.NUM_OF_EASY + MultipleChoiceGui.NUM_OF_MEDIUM
						+ MultipleChoiceGui.NUM_OF_DIFF;
				lblTotal.setText("total: " + MultipleChoiceGui.total);

				try {
					new MultipleChoiceGui();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btnReset.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		btnReset.setBounds(336, 302, 113, 27);
		contentPane.add(btnReset);

		lable = new JLabel("score=" + num);
		lable.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lable.setBackground(new Color(240, 240, 240));
		lable.setBounds(187, 306, 100, 18);
		contentPane.add(lable);

		lblQuestionWaht = new JLabel(s5);
		lblQuestionWaht.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		lblQuestionWaht.setBounds(14, 13, 394, 33);
		contentPane.add(lblQuestionWaht);

		lblPossibleAnswersclickOne = new JLabel("Possible Answers:click one");
		lblPossibleAnswersclickOne.setBounds(14, 54, 261, 18);
		contentPane.add(lblPossibleAnswersclickOne);

		lblTotal = new JLabel("total: " + MultipleChoiceGui.total);
		lblTotal.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		lblTotal.setBackground(new Color(240, 240, 240));
		lblTotal.setBounds(31, 306, 72, 18);
		contentPane.add(lblTotal);

		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}
}
