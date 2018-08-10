import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.event.*;


public class Main extends JFrame {
	
	public static int[] integerVar = new int[10];

	public static ArrayList<Task> myTaskList = new ArrayList<Task>();
	public static Object mainPanel;
	public JLabel label1 = new JLabel("수행할 작업들");
	public JLabel label2 = new JLabel("반복 횟수 ");
	public JLabel label3 = new JLabel("제작 - 김영찬 ");
	public JTextField macroTime = new JTextField();
	public JButton startButton = new JButton("매크로 작동");
	public JButton showFinder = new JButton("마우스 파인더");
	public JButton saveButton = new JButton("작업 저장");
	public JButton loadButton = new JButton("작업 로드");
	public JButton taskAddButton = new JButton("작업 추가");
	public JButton taskRemoveButton = new JButton("작업 제거");
	public JButton taskMoveButton = new JButton("작업 이동");
	public JButton taskEditButton = new JButton("작업 수정");
	public static JTextArea jobText = new JTextArea(10,28);
	JScrollPane jobScroll = new JScrollPane(jobText);
	
	Main() {
		MainPanel mainPanel = new MainPanel();
		this.setContentPane(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Target Generator Macro - KYC");
		this.setVisible(true);
		this.pack();
		this.setResizable(false);
	}
	
	public static void main(String args[]) {
		new Main();
	}
	
	public static void reload() {
		jobText.setText("");
		for (Task task:myTaskList) {
			jobText.append(task.toString()+"\n");
		}
	}
	
	class MainPanel extends JPanel {
		//=========================================================
		// 	Main Panel
		//=========================================================
		MainPanel(){
			setPreferredSize(new Dimension(350,450));
			setLayout(null);
			
			add(label1);
			label1.setBounds(10,0,330,30);
	
			add(taskAddButton);
			taskAddButton.setBounds(10, 260, 110, 30);
			taskAddButton.addActionListener(new AdderListener());
			add(taskRemoveButton);
			taskRemoveButton.setBounds(120, 260, 110, 30);
			add(saveButton);
			saveButton.setBounds(230, 260, 110, 30);

			add(loadButton);
			loadButton.setBounds(10, 290, 110, 30);
			add(taskMoveButton);
			taskMoveButton.setBounds(120, 290, 110, 30);
			add(taskEditButton);
			taskEditButton.setBounds(230, 290, 110, 30);
			
			add(showFinder);
			showFinder.addActionListener(new FinderListener());
			showFinder.setBounds(10,320,330,30);
			
			add(label2);
			label2.setBounds(10,370,60,30);
			
			add(macroTime);
			macroTime.setBounds(70,370,60,30);
			
			add(startButton);
			startButton.setBounds(140,370,200,30);
			
			add(label3);
			label3.setBounds(250,410,80,40);
			
			add (jobScroll);
			jobScroll.setBounds(10,30,330,230);
			jobText.setEditable(false);
		}
		
		//=========================================================
		//  Show Finder Button
		//=========================================================
		class FinderListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new FindPostionPanel();
			}
		}
		
		//=========================================================
		//  Show Task Adder Form
		//=========================================================
		class AdderListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new AddTaskForm();
			}
		}
	}

}
