import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.event.*;


public class Main extends JFrame {

	public static int[] integerVar = new int[10];
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;

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
		//====================================================================================================
		// 	Main Panel
		//====================================================================================================
		MainPanel(){
			setPreferredSize(new Dimension(350,450));
			setLayout(null);
			
			add(label1);
			add(label2);
			add(label3);
			add(taskAddButton);
			add(taskRemoveButton);
			add(taskMoveButton);
			add(taskEditButton);
			add(saveButton);
			add(loadButton);
			add(showFinder);
			add(macroTime);
			add(startButton);
			add(jobScroll);
			
			label1.setBounds(10,0,330,30);
			taskAddButton.setBounds(10, 260, 110, 30);
			taskRemoveButton.setBounds(120, 260, 110, 30);
			saveButton.setBounds(230, 260, 110, 30);
			loadButton.setBounds(10, 290, 110, 30);
			taskMoveButton.setBounds(120, 290, 110, 30);
			taskEditButton.setBounds(230, 290, 110, 30);
			showFinder.setBounds(10,320,330,30);
			label2.setBounds(10,370,60,30);
			macroTime.setBounds(70,370,60,30);
			startButton.setBounds(140,370,200,30);
			label3.setBounds(250,410,80,40);
			jobScroll.setBounds(10,30,330,230);
			
			
			taskAddButton.addActionListener(new AdderListener());
			taskRemoveButton.addActionListener(new RemoverListener());
			showFinder.addActionListener(new FinderListener());
			saveButton.addActionListener(new SaveTaskListener());
			loadButton.addActionListener(new LoadTaskListener());

			jobText.setEditable(false);
		}
		
		//====================================================================================================
		//  Show Finder Button
		//====================================================================================================
		class FinderListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new FindPostionPanel();
			}
		}
		
		//====================================================================================================
		//  Show Task Adder Form
		//====================================================================================================
		class AdderListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new AddTaskForm();
			}
		}
		
		//====================================================================================================
		//  Show Task Adder Form
		//====================================================================================================
		class RemoverListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				new RemoveTaskForm();
			}
		}
		
		//====================================================================================================
		//  Save Task Form
		//====================================================================================================
		class SaveTaskListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				//============================================================================================
				//  Serializable Object Write
				//============================================================================================
				try {
					fos = new FileOutputStream("TaskList.dat");
					oos = new ObjectOutputStream(fos);
					
					for (Task saveTask : myTaskList) 
						oos.writeObject(saveTask);
					
					JOptionPane.showMessageDialog(null,"저장에 성공하였습니다.");
				} catch (FileNotFoundException e1) {}
				catch (IOException e2) {}
				finally {
					if(fos != null) try{fos.close();} catch(IOException e){}
					if(oos != null) try{oos.close();} catch(IOException e){}	
				}
			}
		}
		
		//====================================================================================================
		//  Load Task Form
		//====================================================================================================
		class LoadTaskListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				//============================================================================================
				//  Serializable Object Write
				//============================================================================================
				try {
					fis = new FileInputStream("TaskList.dat");
					ois = new ObjectInputStream(fis);
					
					
					myTaskList.clear();
					Task loadTask = (Task)ois.readObject();
					reload();
					while (loadTask != null) {
						myTaskList.add(loadTask);
						loadTask = (Task)ois.readObject();
					}
						
					JOptionPane.showMessageDialog(null,"로딩에 성공하였습니다.");
					reload();
					
				} catch (FileNotFoundException e1) {JOptionPane.showMessageDialog(null,"파일이 없습니다.");}
				catch (IOException e2) {
					reload();
					JOptionPane.showMessageDialog(null,"로딩에 성공하였습니다.");
				}
				catch (ClassNotFoundException e3) {JOptionPane.showMessageDialog(null,"Class Not Found발생.");}
				finally {
					if(fos != null) try{fis.close();} catch(IOException e){}
					if(oos != null) try{ois.close();} catch(IOException e){}	
				}
			}
		}
		
		
		
		
	}

}
