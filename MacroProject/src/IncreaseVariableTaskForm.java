import java.awt.AWTException;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.InputEvent;

public class IncreaseVariableTaskForm extends JPanel {
	private String[] stringArray = {"1�� ����","2�� ����","3�� ����","4�� ����","5�� ����","6�� ����","7�� ����","8�� ����","9�� ����","10�� ����"};
	private JComboBox selectVariable = new JComboBox(stringArray);
	private JTextField varDelta = new JTextField(5); 
	private JButton okButton = new JButton("�߰�");
	private JLabel sumary = new JLabel("���� ���� �۾� �߰�");
	
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