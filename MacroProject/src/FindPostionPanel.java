import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class FindPostionPanel extends JFrame {
	public KeyPanel p = new KeyPanel();
	
	public FindPostionPanel() {
		setContentPane(p); // KeyPanel����
		setUndecorated(true);
		setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
		setVisible(true);
		setResizable(false);
		pack();
		setSize(1920, 1080); // size
		p.requestFocus(); // ���� ��û
	}

	class KeyPanel extends JPanel {
		JLabel la = new JLabel("Mouse Position"); // ���̺� ����

		public KeyPanel() { // �г� ������
			add(la); // ���̺� �߰�
			this.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) { // Ű�� ���������� �̺�Ʈ
					if ( e.getKeyCode() == KeyEvent.VK_ESCAPE )
						dispose();
				}
			});
			this.addMouseMotionListener(new MyMouseMotionListener());
		}
		
		class MyMouseMotionListener extends MouseMotionAdapter{
			public void mouseMoved(MouseEvent e) {
	            la.setText("MouseMoved("+e.getX()+","+e.getY()+") / Close = ESC or Alt+Tab");
	        }
		}
	}

}