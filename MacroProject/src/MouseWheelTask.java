import java.awt.Dimension;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
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
//	Mouse Click Task Form
//	마우스 클릭 또는 누르기 떼기를 하는 작업
//==================================================================================================
public class MouseWheelTask extends JPanel {
	private JFrame ancestorFrame = null; 
	//==============================================================================================
	//	JComponents Declare
	//==============================================================================================
	
	public String[] textArray = { "1번 변수","2번 변수","3번 변수","4번 변수","5번 변수",
			  					  "6번 변수","7번 변수","8번 변수","9번 변수","10번 변수"};
	private JRadioButton isVar = new JRadioButton();
	private JRadioButton isCon = new JRadioButton();
	private JComboBox<String> varBox = new JComboBox<String>(textArray);
	private ButtonGroup varBG = new ButtonGroup();
	private JTextField wheelCount = new JTextField(5); 
	private JButton okButton = new JButton("추가");
	private JLabel text = new JLabel("마우스 휠을");
	private JLabel text2 = new JLabel("만큼 돌림");
	private JLabel text3 = new JLabel("음수 : UP / 양수 : DOWN");
	private JLabel sumary = new JLabel("마우스 휠 작업 추가");
	
	//==============================================================================================
	//	CONSTRUCTOR
	//==============================================================================================
	public MouseWheelTask(JFrame ancestorFrame) {
		//==========================================================================================
		//	Layout Setting
		//==========================================================================================
		setLayout(null);
		setPreferredSize(new Dimension(320,105));
		this.ancestorFrame = ancestorFrame;
		
		//==========================================================================================
		//	Adding Components
		//==========================================================================================
		add(wheelCount);	add(okButton);		add(sumary);		add(varBox);		add(text);
		add(isVar);			add(isCon);			varBG.add(isVar);	varBG.add(isCon);	add(text2);
		add(text3);
		
		//==========================================================================================
		//	Component Location & Size Setting
		//==========================================================================================
		text.setBounds(5,45,100,30);
		text2.setBounds(180,45,100,30);
		isCon.setBounds(75,35,20,20);
		wheelCount.setBounds(95,35,80,20);
		isVar.setBounds(75,60,20,20);
		varBox.setBounds(95,60,80,20);
		okButton.setBounds(250,45,60,30);
		sumary.setBounds(5,0,285,30);
		text3.setBounds(180, 85, 150, 20);
		text3.setFont(new Font("굴림",Font.PLAIN,11));
		
		
		//==========================================================================================
		//	Adding Listener
		//==========================================================================================
		isVar.addItemListener(new MyMouseWheelItemListener());
		isCon.addItemListener(new MyMouseWheelItemListener());
		okButton.addActionListener(new MyMouseClickActionListener());
		
		//==========================================================================================
		//	Initializing
		//==========================================================================================
		isCon.setSelected(true);
		wheelCount.setText("0");
	}
	
	//==============================================================================================
	//	My Item Listener
	//==============================================================================================
	class MyMouseWheelItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent event) {
			if (event.getSource().equals(isVar)) {
				wheelCount.setText("0");
				wheelCount.setEnabled(false);
				varBox.setEnabled(true);
			} else {
				wheelCount.setEnabled(true);
				varBox.setSelectedIndex(0);
				varBox.setEnabled(false);
			}
		}
	}
	
	//==============================================================================================
	//	Ok Button Listener
	//==============================================================================================
	class MyMouseClickActionListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
		
			try {
				Task makingTask = new Task(Task.TYPE.MOUSE_WHEEL_TASK);
				if(isVar.isSelected()) {
					makingTask.isCon = false;
					makingTask.targetVarIndex = varBox.getSelectedIndex()+1;
				} if (isCon.isSelected()) {
					makingTask.isCon = true;
					makingTask.wheelCount = Integer.parseInt(wheelCount.getText());
				}
				
				//==================================================================================
				//	Adding List & Refresh List
				//==================================================================================
				Main.myTaskList.add(makingTask);
				Main.reload();
				
			//======================================================================================
			//	Error Reporting
			//======================================================================================
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, 
						"에러가 발생했습니다.", "에러", 
						JOptionPane.ERROR_MESSAGE);
			}
			
			//======================================================================================
			//	CLosing Frame
			//======================================================================================
			ancestorFrame.dispose();
		}
	}
	
	
}

