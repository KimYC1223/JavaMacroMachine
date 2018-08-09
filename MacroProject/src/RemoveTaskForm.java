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
//	�۾��� �����ϴ� Form
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
	JLabel label1 = new JLabel("������ ��� ��ȣ�� �Է��ϼ���.");
	JLabel label2 = new JLabel("EX) 1,3,5-7");
	JTextField deleteTarget = new JTextField();
	JButton okButton = new JButton("����");
	
	//==============================================================================================
	//	CONSTRUCTOR
	//==============================================================================================
	public RemoveTaskForm() {
		this.setContentPane(new RemovePanel());
		this.setTitle("�۾� ����");
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
			label1.setFont(new Font("����",Font.BOLD,12));
			label2.setBounds(15, 20, 195, 15);
			label2.setFont(new Font("����",Font.PLAIN,11));
			deleteTarget.setBounds(15, 45, 195, 20);
			okButton.setBounds(150, 70, 60, 20);
			okButton.setFont(new Font("����",Font.PLAIN,12));
		}
		
		class okButtonListener implements ActionListener {
			//======================================================================================
			//	Compents Location & Size Setting
			//======================================================================================
			public void actionPerformed(ActionEvent arg0) {
				popUpFrame = new JFrame("���!");
				popUpFrame.setContentPane(new WarningMessage());
			}
			
			//======================================================================================
			//	Warning Message Panel
			//======================================================================================
			class WarningMessage extends JPanel {
				JButton okButton = new JButton ("����");
				JButton cancleButton = new JButton ("���");
				JLabel warning = new JLabel("�� �۾��� Undo�� �� �����ϴ�.");
				JLabel warning2 = new JLabel("�׷��� ��� �Ͻðڽ��ϱ�?");
				JLabel warning3 = new JLabel("���ŵ� �۾� �� : ");
				
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
					warning.setFont(new Font("����",Font.PLAIN,11));
					add(warning2);
					warning2.setFont(new Font("����",Font.PLAIN,11));
					add(warning3);
					warning3.setFont(new Font("����",Font.BOLD,12));
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
