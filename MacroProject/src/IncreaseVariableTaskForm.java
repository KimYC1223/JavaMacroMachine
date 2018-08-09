import java.awt.AWTException;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.InputEvent;

public class IncreaseVariableTaskForm extends JPanel {
	private String[] stringArray = {"1번 변수","2번 변수","3번 변수","4번 변수","5번 변수","6번 변수","7번 변수","8번 변수","9번 변수","10번 변수"};
	private JComboBox selectVariable = new JComboBox(stringArray);
	private JTextField varDelta = new JTextField(5); 
	private JButton okButton = new JButton("추가");
	private JLabel sumary = new JLabel("변수 증감 작업 추가");
	
	public IncreaseVariableTaskForm() {
	
		setLayout(null);
		setPreferredSize(new Dimension(300,75));
		
		add(selectVariable);
		add(varDelta);
		add(okButton);
		add(sumary);
		
		selectVariable.setBounds(5,35,120,30);
		varDelta.setBounds(135,35,80,30);
		okButton.setBounds(220,35,60,30);
		sumary.setBounds(5,0,285,30);
		
		
	}
}
