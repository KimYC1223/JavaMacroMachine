import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//==================================================================================================
//	Remove Task Form
//	�۾��� �����ϴ� Form
//==================================================================================================
public class MouseMoveTask extends JPanel {

	//==============================================================================================
	//	Variable Declare
	//==============================================================================================
	public String[] textArray = { "1�� ����","2�� ����","3�� ����","4�� ����","5�� ����",
								  "6�� ����","7�� ����","8�� ����","9�� ����","10�� ����"};
	public MouseMoveTask thisForm = this;
	private JFrame ancestorFrame = null;

	//==============================================================================================
	//	JComponent Declare
	//==============================================================================================
	public JTextField xData = new JTextField(5);
	public JTextField yData = new JTextField(5); 
	public JComboBox<String> xSelection = new JComboBox<String>(textArray);
	public JComboBox<String> ySelection = new JComboBox<String>(textArray);
	public JRadioButton xIsVar = new JRadioButton();
	public JRadioButton yIsVar = new JRadioButton();
	public JRadioButton xIsCon = new JRadioButton();
	public JRadioButton yIsCon = new JRadioButton();
	public ButtonGroup xRG = new ButtonGroup();
	public ButtonGroup yRG = new ButtonGroup();
	public JButton okButton = new JButton("�߰�");
	public JButton autoButton = new JButton("���콺 ���δ�");
	public JLabel sumary = new JLabel("���콺 �̵� �۾� �߰�");
	public JLabel x = new JLabel("X :");
	public JLabel y = new JLabel("Y :");
	
	//==============================================================================================
	//	CONSTRUCTOR
	//==============================================================================================
	public MouseMoveTask(JFrame ancestorFrame) {
		
		//==========================================================================================
		//	Layout Setting
		//==========================================================================================
		setLayout(null);
		setPreferredSize(new Dimension(350,110));
		this.ancestorFrame = ancestorFrame;
		
		//==========================================================================================
		//	Adding Components
		//==========================================================================================
		xRG.add(xIsVar);	xRG.add(xIsCon);
		yRG.add(yIsVar);	yRG.add(yIsCon);
		add(xIsVar);		add(xIsCon);
		add(yIsVar);		add(yIsCon);
		add(xData);			add(yData);
		add(xSelection);	add(ySelection);
		add(x); 			add(y);
		add(okButton);		add(autoButton);
		add(sumary);
	
		//==========================================================================================
		//	Compents Location & Size Setting
		//==========================================================================================
		x.setBounds(5,40,20,30);
		y.setBounds(135,40,20,30);
		xIsCon.setBounds(25,32,20,25);
		xIsVar.setBounds(25,52,20,25);
		yIsCon.setBounds(155,32,20,25);
		yIsVar.setBounds(155,52,20,25);
		xData.setBounds(45,35,85,20);
		yData.setBounds(175,35,85,20);
		xSelection.setBounds(45,55,85,20);
		ySelection.setBounds(175,55,85,20);
		autoButton.setBounds(10,80,250,20);
		okButton.setBounds(270,35,70,30);
		sumary.setBounds(5,0,285,30);
		
		//==========================================================================================
		//	Initializing Form
		//==========================================================================================
		xIsCon.setSelected(true);
		yIsCon.setSelected(true);
		xSelection.setEnabled(false);
		ySelection.setEnabled(false);
		
		//==========================================================================================
		//	Adding Listener
		//==========================================================================================
		xIsCon.addItemListener(new XItemListener());
		xIsVar.addItemListener(new XItemListener());
		yIsCon.addItemListener(new YItemListener());
		yIsVar.addItemListener(new YItemListener());
		autoButton.addActionListener(new AutoListener());
		okButton.addActionListener(new OkListener());
	}
	
	//==============================================================================================
	//	Select Type of X position Value. Variable or Constant
	//==============================================================================================
	class XItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent event) {
			if (event.getItem().equals(xIsVar)) {
				xSelection.setEnabled(true);
				xData.setEnabled(false);
			} else if (event.getItem().equals(xIsCon)) {
				xSelection.setEnabled(false);
				xSelection.setSelectedIndex(0);
				xData.setEnabled(true);
			} 
		}
	}
	
	//==============================================================================================
	//	Select Type of Y position Value. Variable or Constant
	//==============================================================================================
	class YItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent event) {
			if (event.getItem().equals(yIsVar)) {
				ySelection.setEnabled(true);
				yData.setEnabled(false);
			} else if (event.getItem().equals(yIsCon)) {
				ySelection.setEnabled(false);
				ySelection.setSelectedIndex(0);
				yData.setEnabled(true);
			} 
		}
	}
	
	//==============================================================================================
	//	AutoButton Action Listener
	//==============================================================================================
	class AutoListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			new MouseMoveHelper(thisForm);
		}
	}
	
	//==============================================================================================
	//	okayButton Action Listener
	//==============================================================================================
	class OkListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try {
				Task makingTask = new Task(Task.TYPE.MOUSE_MOVE_TASK);
				//==================================================================================
				//	When Selection X is Variable
				//==================================================================================
				if ( xIsVar.isSelected() ) {
					makingTask.isCon = false;
					makingTask.targetVar = xSelection.getSelectedIndex()+1;
				} else if ( xIsCon.isSelected() ) {
					makingTask.isCon = true;
					makingTask.X_position = Integer.parseInt(xData.getText());
				} 
				
				//==================================================================================
				//	When Selection X is Variable
				//==================================================================================
				if ( yIsVar.isSelected() ) {
					makingTask.isCon2 = false;
					makingTask.targetVar2 = ySelection.getSelectedIndex()+1;
				} else if ( yIsCon.isSelected() ) {
					makingTask.isCon2 = true;
					makingTask.Y_position = Integer.parseInt(yData.getText());
				} 
				//==================================================================================
				//	Adding List & Refresh List
				//==================================================================================
				Main.myTaskList.add(makingTask);
				Main.reload();
				
			//======================================================================================
			//	Error Reporting
			//======================================================================================
			} catch ( Exception excep) {
				JOptionPane.showMessageDialog(null, "������ �߻��߽��ϴ�.",
						"����", JOptionPane.ERROR_MESSAGE);
			}
			
			//======================================================================================
			//	CLosing Frame
			//======================================================================================
			ancestorFrame.dispose();
		}
	}
}
