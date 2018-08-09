import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//==================================================================================================
// 	Remove Task Form
//	작업을 제거하는 Form
//==================================================================================================
public class RemoveTaskForm extends JFrame{
	
	//==============================================================================================
	//	Variable Declare
	//==============================================================================================
	JFrame thisFrame = (JFrame) this;			//Present Frame
	JFrame popUpFrame = null;					//Popup Frame
	
	//==============================================================================================
	//	JComponent Declare
	//==============================================================================================
	JLabel label1 = new JLabel("제거할 명령 번호를 입력하세요.");
	JLabel label2 = new JLabel("EX) 1,3,5-7");
	JTextField deleteTarget = new JTextField();
	JButton okButton = new JButton("제거");
	
	//==============================================================================================
	//	CONSTRUCTOR
	//==============================================================================================
	public RemoveTaskForm() {
		this.setContentPane(new RemovePanel());
		this.setTitle("작업 제거");
		pack();
		setVisible(true);
		setResizable(false);
	}
	
	//==============================================================================================
	//	Inner CLass : Remove Task Panel
	//==============================================================================================
	class RemovePanel extends JPanel {
		
		//==========================================================================================
		//	CONSTRUCTOR
		//==========================================================================================
		public RemovePanel() {
			
			//======================================================================================
			//	Layout Setting
			//======================================================================================
			setLayout(null);
			setPreferredSize(new Dimension(220,100));
			
			//======================================================================================
			//	Adding Components
			//======================================================================================
			add(label1);
			add(label2);
			add(deleteTarget);
			add(okButton);
			
			//======================================================================================
			//	Compents Location & Size Setting
			//======================================================================================
			label1.setBounds(15, 5, 195, 15);
			label1.setFont(new Font("굴림",Font.BOLD,12));
			label2.setBounds(15, 20, 195, 15);
			label2.setFont(new Font("굴림",Font.PLAIN,11));
			deleteTarget.setBounds(15, 45, 195, 20);
			okButton.setBounds(150, 70, 60, 20);
			okButton.setFont(new Font("굴림",Font.PLAIN,12));
		}
		
		class okButtonListener implements ActionListener {
			//======================================================================================
			//	Compents Location & Size Setting
			//======================================================================================
			public void actionPerformed(ActionEvent arg0) {
				popUpFrame = new JFrame("경고!");
				popUpFrame.setContentPane(new WarningMessage());
			}
			
			//======================================================================================
			//	Warning Message Panel
			//======================================================================================
			class WarningMessage extends JPanel {
				JButton okButton = new JButton ("진행");
				JButton cancleButton = new JButton ("취소");
				JLabel warning = new JLabel("이 작업은 Undo할 수 없습니다.");
				JLabel warning2 = new JLabel("그래도 계속 하시겠습니까?");
				JLabel warning3 = new JLabel("제거될 작업 수 : ");
				
				//======================================================================================
				//	CONSTRUCTOR
				//======================================================================================
				WarningMessage(){
					
					//======================================================================================
					//	Component Properties
					//======================================================================================
					setLayout(null);
					setPreferredSize(new Dimension(220,100));
					add(warning);
					warning.setFont(new Font("굴림",Font.PLAIN,11));
					add(warning2);
					warning2.setFont(new Font("굴림",Font.PLAIN,11));
					add(warning3);
					warning3.setFont(new Font("굴림",Font.BOLD,12));
					add(okButton);
					add(cancleButton);
				
					//======================================================================================
					//	Component Position & Size Setting
					//======================================================================================
					warning.setBounds(15, 15, 200, 20);
					warning.setBounds(15, 35, 200, 20);
					warning.setBounds(15, 55, 200, 20);
				}
					
			}
		}
		
		
	}
	
	
}
