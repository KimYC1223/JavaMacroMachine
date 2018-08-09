import java.awt.event.KeyEvent;

public class Task {
	public static enum TYPE {
			MOUSE_MOVE_TASK,
			MOUSE_CLICK_TASK,
			MOUSE_WHEEL_TASK,
			KEYBOARD_INPUT_TASK,
			STRING_INPUT_TASK,
			SET_VARIABLE_TASK,
			INCREASE_VARIABLE_TASK,
			WAIT_TASK,
			NULL}
	public TYPE isTYPE = TYPE.NULL;
	public int X_position;
	public int Y_position;
	public String mouseButton;
	public int clickCount;
	public int wheelCount;
	public int keyCode;
	public String inputString;
	public int varCount;
	public int varDelta;
	public int varSet;
	public int delayTime;
	
	public String toString() {
		String result = null;
		switch(isTYPE) {
		case MOUSE_MOVE_TASK :
			result =  "���콺�� X="+X_position+",Y="+Y_position+"���� �ű�ϴ�."; 
			break;
		case MOUSE_CLICK_TASK :
			result =  "���콺 "+mouseButton+"�� "+clickCount+"�� Ŭ���մϴ�.";
			break;
		case MOUSE_WHEEL_TASK :
			result =  "���콺 ���� "+wheelCount+"�� �����ϴ�.";
			break;
		case KEYBOARD_INPUT_TASK :
			result =  "Ű����� "+KeyEvent.getKeyText(keyCode)+"�� �Է��մϴ�.";
			break;
		case STRING_INPUT_TASK :
			result =  "Ű����� ���� \""+inputString+"\"(��)�� �Է��մϴ�.";
			break;
		case SET_VARIABLE_TASK :
			result =  varCount+"��° ������ ����"+varSet+"(��)�� �����մϴ�.";
			break;
		case INCREASE_VARIABLE_TASK :
			result =  varCount+"��° ������ "+varSet+"��ŭ �����մϴ�.";
			break;
		case WAIT_TASK :
			result = delayTime+"ms ��ŭ ����մϴ�.";
			break;
		}
		return result;
	}
	
	public Task(TYPE taskType) {
		switch(taskType) {
			case MOUSE_MOVE_TASK :
		
				break;
			
			case MOUSE_CLICK_TASK :
				
				break;
				
			case MOUSE_WHEEL_TASK :
				
				break;
				
			case KEYBOARD_INPUT_TASK :
				
				break;
				
			case STRING_INPUT_TASK :
				
				break;
				
			case SET_VARIABLE_TASK :
				
				break;
		
			case INCREASE_VARIABLE_TASK :
				
				break;
			case WAIT_TASK :
				
				break;
		}
	}
}