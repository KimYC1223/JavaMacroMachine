import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class IncreaseVariableTaskForm extends JPanel {
	//=================================================================================
	//	JComponents Declare
	//=================================================================================
	private String[] stringArray = {"1�� ����","2�� ����","3�� ����","4�� ����","5�� ����",
									"6�� ����","7�� ����","8�� ����","9�� ����","10�� ����"};
	private JComboBox<String> selectVariable = new JComboBox<String>(stringArray);
	private JComboBox<String> applyVariable = new JComboBox<String>(stringArray);
	private JTextField varDelta = new JTextField(5); 
	private JButton okButton = new JButton("�߰�");
	private JLabel sumary = new JLabel("���� ���� �۾� �߰�");
	private ButtonGroup radioGroup = new ButtonGroup();
	private JRadioButton conCheck = new JRadioButton();
	private JRadioButton varCheck = new JRadioButton();
	JFrame topFrame =
			(JFrame) SwingUtilities.getRoot(this);
	JFrame topTopFrame;
	
	//=================================================================================
	//	Increase Variable Task Form
	//=================================================================================
	public IncreaseVariableTaskForm(JFrame topTopFrame) {
		this.topTopFrame = topTopFrame;
		setLayout(null);
		setPreferredSize(new Dimension(350,110));
		
		//=============================================================================
		//	Adding Components
		//=============================================================================
		add(selectVariable);
		add(varDelta);
		add(okButton);
		add(sumary);
		add(conCheck);
		add(varCheck);
		add(applyVariable);
		radioGroup.add(conCheck);
		radioGroup.add(varCheck);
		
		//=============================================================================
		//	Initial Setting
		//=============================================================================
		conCheck.setSelected(true);
		applyVariable.setEnabled(false);
		
		//=============================================================================
		//	Components Location & Size Setting
		//=============================================================================
		selectVariable.setBounds(5,50,120,30);
		conCheck.setBounds(135,35,20,30);
		varCheck.setBounds(135,70,20,30);
		applyVariable.setBounds(160,70,105,30);
		varDelta.setBounds(160,35,105,30);
		okButton.setBounds(270,50,60,30);
		sumary.setBounds(5,0,285,30);
		
		//=============================================================================
		//	Adding Listener
		//=============================================================================
		conCheck.addItemListener(new myItemListener());
		varCheck.addItemListener(new myItemListener());
		okButton.addActionListener(new myOkButtonListener());	
	}

	//=================================================================================
	//	Radio Button Handler
	//=================================================================================
	class myItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			//=========================================================================
			//	When conCheck Press
			//=========================================================================
			if (e.getItem().equals(conCheck) ) {
				applyVariable.setEnabled(false);
				varDelta.setText("");
				varDelta.setEnabled(true);				
			}
			//=========================================================================
			//	When varCheck Press
			//=========================================================================
			else if (e.getItem().equals(varCheck)) {
				applyVariable.setSelectedIndex(0);
				applyVariable.setEnabled(true);
				varDelta.setEnabled(false);	
			}
		}
	}
	
	//=================================================================================
	//	Okay Button Handler
	//=================================================================================
	class myOkButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			int delta;
			Task makingTask = null;
			//=========================================================================
			//	When conCheck is Selected
			//=========================================================================
			if (conCheck.isSelected()) {
				try {
					delta=Integer.parseInt(varDelta.getText());
					makingTask = new Task(Task.TYPE.INCREASE_VARIABLE_TASK);
					makingTask.varCount = selectVariable.getSelectedIndex()+1;
					makingTask.varDelta = delta;
					makingTask.isCon = true;
				} catch ( Exception e ) { }
			}
			//=========================================================================
			//	When varCheck is Selected
			//=========================================================================
			else if (varCheck.isSelected()) {
				delta=applyVariable.getSelectedIndex()+1;
				makingTask = new Task(Task.TYPE.INCREASE_VARIABLE_TASK);
				makingTask.varCount = selectVariable.getSelectedIndex()+1;
				makingTask.TargetVarIndex = delta;
				makingTask.isCon = false;
			}
			
			//=========================================================================
			//	Adding List & Refresh List
			//=========================================================================
			Main.myTaskList.add(makingTask);
			Main.reload();
			JComponent comp = (JComponent) event.getSource();
			Window win = SwingUtilities.getWindowAncestor(comp);
			win.dispose();
			topTopFrame.dispose();
		}
	}
		
}
