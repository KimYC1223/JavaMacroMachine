import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//==================================================================================================
//	Mouse Click Task Form
//	���콺 Ŭ�� �Ǵ� ������ ���⸦ �ϴ� �۾�
//==================================================================================================
public class MouseClickTask extends JPanel {
	private JFrame ancestorFrame = null; 
	//==============================================================================================
	//	JComponents Declare
	//==============================================================================================
	private String[] stringArray = {"������ ��ư","���� ��ư","�� ��ư"};
	public String[] textArray = { "1�� ����","2�� ����","3�� ����","4�� ����","5�� ����",
			  					  "6�� ����","7�� ����","8�� ����","9�� ����","10�� ����"};
	private JRadioButton isVar = new JRadioButton();
	private JRadioButton isCon = new JRadioButton();
	private JRadioButton isClick = new JRadioButton();
	private JRadioButton isPress = new JRadioButton();
	private JRadioButton isRelease = new JRadioButton();
	private JComboBox<String> varBox = new JComboBox<String>(textArray);
	private ButtonGroup BG = new ButtonGroup();
	private ButtonGroup varBG = new ButtonGroup();
	private JComboBox<String> mouseGroup = new JComboBox<String>(stringArray);
	private JTextField clickCount = new JTextField(5); 
	private JButton okButton = new JButton("�߰�");
	private JLabel sumary = new JLabel("���콺 ���� �۾� �߰�");
	private JLabel select1 = new JLabel("Ŭ���ϱ�");
	private JLabel select2 = new JLabel("������ �ֱ�");
	private JLabel select3 = new JLabel("����");
	
	//==============================================================================================
	//	CONSTRUCTOR
	//==============================================================================================
	public MouseClickTask(JFrame ancestorFrame) {
		//==========================================================================================
		//	Layout Setting
		//==========================================================================================
		setLayout(null);
		setPreferredSize(new Dimension(300,110));
		this.ancestorFrame = ancestorFrame;
		
		//==========================================================================================
		//	Adding Components
		//==========================================================================================
		add(mouseGroup);	add(clickCount);	add(okButton);
		add(sumary);			add(isClick);		add(isPress);
		add(isRelease);			add(select1);		add(select2);
		add(select3);			BG.add(isClick);	BG.add(isPress);
		BG.add(isRelease);		add(isVar);			add(isCon);
		varBG.add(isVar);		varBG.add(isCon);	add(varBox);
		
		//==========================================================================================
		//	Properties Setting
		//==========================================================================================
		select1.setFont(new Font("����",Font.PLAIN,11));
		select2.setFont(new Font("����",Font.PLAIN,11));
		select3.setFont(new Font("����",Font.PLAIN,11));
		
		//==========================================================================================
		//	Component Location & Size Setting
		//==========================================================================================
		mouseGroup.setBounds(5,35,100,30);
		isCon.setBounds(115,25,20,20);
		clickCount.setBounds(135,25,80,20);
		isVar.setBounds(115,50,20,20);
		varBox.setBounds(135,50,80,20);
		okButton.setBounds(220,35,60,30);
		sumary.setBounds(5,0,285,30);
		isClick.setBounds(5,70,20,30);
		select1.setBounds(25,70,65,30);
		isPress.setBounds(100,70,20,30);
		select2.setBounds(120, 70, 70, 30);
		isRelease.setBounds(200,70,20,30);
		select3.setBounds(220, 70, 50, 30);
		
		//==========================================================================================
		//	Adding Listener
		//==========================================================================================
		isClick.addItemListener(new MyMouseClickItemListener());
		isPress.addItemListener(new MyMouseClickItemListener());
		isRelease.addItemListener(new MyMouseClickItemListener());
		isVar.addItemListener(new MyMouseClickItemListener2());
		isCon.addItemListener(new MyMouseClickItemListener2());
		okButton.addActionListener(new MyMouseClickActionListener());
		
		//==========================================================================================
		//	Initializing
		//==========================================================================================
		isClick.setSelected(true);
		isCon.setSelected(true);
		clickCount.setText("1");
	}
	
	//==============================================================================================
	//	My Item Listener
	//==============================================================================================
	class MyMouseClickItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent event) {
			if (event.getSource().equals(isClick)) {
				isCon.setEnabled(true);
				isVar.setEnabled(true);
				isCon.setSelected(true);
				clickCount.setEnabled(true);
				clickCount.setText("1");
			} else {
				isVar.setEnabled(false);
				isCon.setEnabled(false);
				isCon.setSelected(false);
				isVar.setSelected(false);
				varBox.setSelectedIndex(0);
				varBox.setEnabled(false);
				clickCount.setText("");
				clickCount.setEnabled(false);
			}
		}
	}
	
	
	//==============================================================================================
	//	My Item Listener 2
	//==============================================================================================
	class MyMouseClickItemListener2 implements ItemListener{
		public void itemStateChanged(ItemEvent event) {
			if (event.getSource().equals(isVar)) {
				clickCount.setText("1");
				clickCount.setEnabled(false);
				varBox.setEnabled(true);
			} else {
				clickCount.setEnabled(true);
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
			ancestorFrame.dispose();
		}
	}
	
	
}
