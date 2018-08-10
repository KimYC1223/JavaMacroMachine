
import java.awt.event.KeyEvent;
//=====================================================================================
//	Task Class
//=====================================================================================
public class Task {
	
	//=================================================================================
	//	Task Type Enum Declare
	//=================================================================================
	public static enum TYPE {
			MOUSE_MOVE_TASK,
			MOUSE_CLICK_TASK,
			MOUSE_WHEEL_TASK,
			KEYBOARD_INPUT_TASK,
			STRING_INPUT_TASK,
			NUMBER_INPUT_TASK,
			SET_VARIABLE_TASK,
			INCREASE_VARIABLE_TASK,
			WAIT_TASK,
			NULL}
	
	//=================================================================================
	//	Variable Declare
	//=================================================================================
	public TYPE isTYPE = TYPE.NULL;		// Task Type
	
	public int X_position;				// Mouse Move
	public int Y_position;				// Mouse Move
	public String mouseButton;			// Mouse Click
	public int clickCount;				// Mouse Click
	public int wheelCount;				// Mouse Wheel
	public int keyCode;					// Keyboard Input
	public String inputString;			// String Input
	public int varCount;				// Set Variable
										// Increase Variable
	public int varDelta;				// Increase Variable
	public int varSet;					// Set Variable
	public int delayTime;				// Wait
	
	public int TargetVarIndex;			// isVar
	public int TargetVar;				// isVar
	public int TargetVarIndex2;			// isVar2
	public int TargetVar2;				// isVar2
	public boolean isCon = true;		// con Check Value
	public boolean isCon2 = true;		// con Check Value
	
	//=================================================================================
	//	toString Method
	//=================================================================================
	public String toString() {
		String result = null;
		
		//=============================================================================
		//	When selected Mouse Move Task
		//	변수/상수 체커가 2개가 들어가 있기 때문에 먼저 처리한다.
		//=============================================================================
		if (isTYPE == Task.TYPE.MOUSE_MOVE_TASK ) {
			if ( isCon==true && isCon2 == true)
				result =  "마우스를 X="+X_position+",Y="+Y_position+"(으)로 옮깁니다.";
			else if ( isCon==false && isCon2 == false)
				result =  "마우스를 X="+TargetVarIndex+"번 변수,Y="+
											TargetVarIndex2+"번 변수로 옮깁니다.";
			else if ( isCon==true && isCon2 == false)
				result =  "마우스를 X="+X_position+",Y="+TargetVarIndex2+"번 변수로 옮깁니다.";
			else if ( isCon==false && isCon2 == true)
				result =  "마우스를 X="+TargetVarIndex+"번 변수,Y="
											+Y_position+"(으)로 옮깁니다.";
			return result+"\n";				// Return
		}
		
		//=============================================================================
		//	When Target Number is Constant
		//=============================================================================
		if ( isCon ) {
			switch(isTYPE) {
			case MOUSE_CLICK_TASK :
				result =  "마우스 "+mouseButton+"을 "+clickCount+"번 클릭합니다.";
				break;
			case MOUSE_WHEEL_TASK :
				result =  "마우스 휠을 "+wheelCount+"번 굴립니다.";
				break;
			case KEYBOARD_INPUT_TASK :
				result =  "키보드로 \'"+KeyEvent.getKeyText(keyCode)+"\'을/를 입력합니다.";
				break;
			case STRING_INPUT_TASK :
				result =  "키보드로 문장 \""+inputString+"\"을/를 입력합니다.";
				break;
			case NUMBER_INPUT_TASK :
				result =  "키보드로 변수 \""+inputString+"\"을/를 입력합니다.";
				break;
			case SET_VARIABLE_TASK :
				result =  varCount+"번째 변수에 숫자"+varSet+"을/를 대입합니다.";
				break;
			case INCREASE_VARIABLE_TASK :
				result =  varCount+"번째 변수에 "+varDelta+"만큼 증감합니다.";
				break;
			case WAIT_TASK :
				result = delayTime+"ms 만큼 대기합니다.";
				break;
			}
		//=============================================================================
		//	When Target Number is Variable
		//=============================================================================
		} else if ( !isCon ) {
			switch(isTYPE) {
			case MOUSE_CLICK_TASK :
				result =  "마우스 "+mouseButton+"을 "+TargetVarIndex+"번 변수만큼 클릭합니다.";
				break;
			case MOUSE_WHEEL_TASK :
				result =  "마우스 휠을 "+TargetVarIndex+"번 변수만큼 굴립니다.";
				break;
			case KEYBOARD_INPUT_TASK :
				result =  "키보드로 \'"+KeyEvent.getKeyText(keyCode)+"\'을/를 입력합니다.";
				break;
			case STRING_INPUT_TASK :
				result =  "키보드로 문장 \""+inputString+"\"을/를 입력합니다.";
				break;
			case NUMBER_INPUT_TASK :
				result =  "키보드로 "+TargetVarIndex+"번 변수를 입력합니다.";
				break;
			case SET_VARIABLE_TASK :
				result =  varCount+"번째 변수에 "+TargetVarIndex+"번 변수를 대입합니다.";
				break;
			case INCREASE_VARIABLE_TASK :
				result =  varCount+"번째 변수에 "+TargetVarIndex+"번 변수만큼 증감합니다.";
				break;
			case WAIT_TASK :
				result = TargetVarIndex+"번 변수의 저장된 값  * 1ms대기합니다.";
				break;
			}
		}
		return result;
	}
	
	//=================================================================================
	//	CONSTRUCTOR
	//=================================================================================
	public Task(TYPE taskType) {
		isTYPE = taskType;
	}
}
