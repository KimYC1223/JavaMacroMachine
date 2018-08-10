import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AddTaskForm extends JFrame{
	public AddPanel addPanel = new AddPanel();
	
	public AddTaskForm() {
		setContentPane(addPanel);
		setResizable(false);
		pack();
		setVisible(true);
	}

	class AddPanel extends JPanel {
		private String[] dropdownItem = {
			"MOUSE_MOVE_TASK",
			"MOUSE_CLICK_TASK",
			"MOUSE_WHEEL_TASK",
			"KEYBOARD_INPUT_TASK",
			"STRING_INPUT_TASK",
			"SET_VARIABLE_TASK",
			"INCREASE_VARIABLE_TASK",
			"WAIT_TASK"				
		};
		public JComboBox selection = new JComboBox(dropdownItem);
		public JTextArea ta = new JTextArea(3,20);
		public JScrollPane sp = new JScrollPane(ta);
		private JButton okButton = new JButton("생성");
		
		AddPanel() {
			setLayout(null);
			setPreferredSize(new Dimension(300,120));
			add(selection);
			add(okButton);
			add(sp);
			
			selection.setBounds(10,10,200,30);
			selection.addItemListener(new DropdownListener());
			
			okButton.setBounds(210,10,80,30);
			ta.setEditable(false);
			ta.setText("▶ 마우스 이동 작업"+"\n");
			ta.append("마우스를 지정한 X,Y좌표로 움직입니다."+"\n");
			ta.append("좌측 상단이 원점 (0,0)입니다."+"\n");
			ta.append("마우스 파인더를 이용하여 쉽게 이용가능합니다.");
			ta.setCaretPosition(0);
			sp.setBounds(10, 50, 280, 60);
			okButton.addActionListener(new AddingButtonListener());
		}
		
		
		//===================================================================================
		//	ITEM DESCRIPTION
		//===================================================================================
		class DropdownListener implements ItemListener{
			public void itemStateChanged(ItemEvent e) {
				switch(e.getItem().toString()) {
				case "INCREASE_VARIABLE_TASK" :
					ta.setText("▶ 변수 증감 작업"+"\n");
					ta.append("지정한 변수를 증감시킵니다.");
					ta.setCaretPosition(0);
					break;
				case "MOUSE_MOVE_TASK" :
					ta.setText("▶ 마우스 이동 작업"+"\n");
					ta.append("마우스를 지정한 X,Y좌표로 움직입니다."+"\n");
					ta.append("좌측 상단이 원점 (0,0)입니다."+"\n");
					ta.append("마우스 파인더를 이용하여 쉽게 이용가능합니다.");
					ta.setCaretPosition(0);
					break;
				case "MOUSE_CLICK_TASK" :
					ta.setText("▶ 마우스 이동 작업"+"\n");
					ta.append("마우스를 클릭합니다.");
					ta.setCaretPosition(0);
					break;
				case "MOUSE_WHEEL_TASK" :
					ta.setText("▶ 마우스 휠 작업"+"\n");
					ta.append("마우스를 휠을 올리거나 내립니다.");
					ta.setCaretPosition(0);
					break;
				case "KEYBOARD_INPUT_TASK" :
					ta.setText("▶ 키보드 입력 작업"+"\n");
					ta.append("키보드로 글자릅 입력합니다.");
					ta.setCaretPosition(0);
					break;
				case "STRING_INPUT_TASK" :
					ta.setText("▶ 문장 입력 작업"+"\n");
					ta.append("키보드로 문장을 입력합니다.");
					ta.setCaretPosition(0);
					break;
				case "SET_VARIABLE_TASK" :
					ta.setText("▶ 변수 대입 작업"+"\n");
					ta.append("지정한 변수에 대입합니다.");
					ta.setCaretPosition(0);
					break;
				case "WAIT_TASK" :
					ta.setText("▶ 대기 작업"+"\n");
					ta.append("지정한 milli second 만큼 대기합니다.");
					ta.setCaretPosition(0);
					break;
				}
			}
		}
		
		
		//===================================================================================
		//	BUTTON LISTENER
		//===================================================================================
		class AddingButtonListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Task myTask = null;
				
				JFrame targetFrame = new JFrame("작업 추가");
				JPanel targetPlane = null;
				
				switch (selection.getSelectedItem().toString()) {
				case "INCREASE_VARIABLE_TASK" :
					targetPlane = new IncreaseVariableTaskForm(targetFrame);
					
					break;
				case "MOUSE_MOVE_TASK" :
					targetPlane = new MouseMoveTask(targetFrame);
					
					break;
				case "MOUSE_CLICK_TASK" :
					targetPlane = new MouseClickTask(targetFrame);
					
					break;
				case "MOUSE_WHEEL_TASK" :
					targetPlane = new MouseWheelTask(targetFrame);
					
					break;
				case "KEYBOARD_INPUT_TASK" :
					//targetPlane = new KeyboardInputTask();
					
					break;
				case "STRING_INPUT_TASK" :
					//targetPlane = new StringInputTask();
					
					break;
				case "SET_VARIABLE_TASK" :
					//targetPlane = new SetVariableTask();
					
					break;
				case "WAIT_TASK" :
					//targetPlane = new WaitTask();
					break;
				}
				
				targetFrame.setContentPane(targetPlane);
				targetFrame.pack();
				targetFrame.setVisible(true);
				targetFrame.setResizable(false);
			}
		}
		
		
	}
}
