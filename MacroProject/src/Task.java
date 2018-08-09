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
			result =  "마우스를 X="+X_position+",Y="+Y_position+"으로 옮깁니다."; 
			break;
		case MOUSE_CLICK_TASK :
			result =  "마우스 "+mouseButton+"을 "+clickCount+"번 클릭합니다.";
			break;
		case MOUSE_WHEEL_TASK :
			result =  "마우스 휠을 "+wheelCount+"번 굴립니다.";
			break;
		case KEYBOARD_INPUT_TASK :
			result =  "키보드로 "+KeyEvent.getKeyText(keyCode)+"를 입력합니다.";
			break;
		case STRING_INPUT_TASK :
			result =  "키보드로 문장 \""+inputString+"\"(으)로 입력합니다.";
			break;
		case SET_VARIABLE_TASK :
			result =  varCount+"번째 변수에 숫자"+varSet+"(으)로 대입합니다.";
			break;
		case INCREASE_VARIABLE_TASK :
			result =  varCount+"번째 변수에 "+varSet+"만큼 증감합니다.";
			break;
		case WAIT_TASK :
			result = delayTime+"ms 만큼 대기합니다.";
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
