
import java.awt.event.KeyEvent;
import java.io.Serializable;

//=====================================================================================
//	Task Class
//=====================================================================================
public class Task implements Serializable{
	
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
		//	����/��� üĿ�� 2���� �� �ֱ� ������ ���� ó���Ѵ�.
		//=============================================================================
		if (isTYPE == Task.TYPE.MOUSE_MOVE_TASK ) {
			if ( isCon==true && isCon2 == true)
				result =  "���콺�� X="+X_position+",Y="+Y_position+"(��)�� �ű�ϴ�.";
			else if ( isCon==false && isCon2 == false)
				result =  "���콺�� X="+TargetVarIndex+"�� ����,Y="+
											TargetVarIndex2+"�� ������ �ű�ϴ�.";
			else if ( isCon==true && isCon2 == false)
				result =  "���콺�� X="+X_position+",Y="+TargetVarIndex2+"�� ������ �ű�ϴ�.";
			else if ( isCon==false && isCon2 == true)
				result =  "���콺�� X="+TargetVarIndex+"�� ����,Y="
											+Y_position+"(��)�� �ű�ϴ�.";
			return result+"\n";				// Return
		}
		
		//=============================================================================
		//	When Target Number is Constant
		//=============================================================================
		if ( isCon ) {
			switch(isTYPE) {
			case MOUSE_CLICK_TASK :
				result =  "���콺 "+mouseButton+"�� "+clickCount+"�� Ŭ���մϴ�.";
				break;
			case MOUSE_WHEEL_TASK :
				result =  "���콺 ���� "+wheelCount+"�� �����ϴ�.";
				break;
			case KEYBOARD_INPUT_TASK :
				result =  "Ű����� \'"+KeyEvent.getKeyText(keyCode)+"\'��/�� �Է��մϴ�.";
				break;
			case STRING_INPUT_TASK :
				result =  "Ű����� ���� \""+inputString+"\"��/�� �Է��մϴ�.";
				break;
			case NUMBER_INPUT_TASK :
				result =  "Ű����� ���� \""+inputString+"\"��/�� �Է��մϴ�.";
				break;
			case SET_VARIABLE_TASK :
				result =  varCount+"��° ������ ����"+varSet+"��/�� �����մϴ�.";
				break;
			case INCREASE_VARIABLE_TASK :
				result =  varCount+"��° ������ "+varDelta+"��ŭ �����մϴ�.";
				break;
			case WAIT_TASK :
				result = delayTime+"ms ��ŭ ����մϴ�.";
				break;
			}
		//=============================================================================
		//	When Target Number is Variable
		//=============================================================================
		} else if ( !isCon ) {
			switch(isTYPE) {
			case MOUSE_CLICK_TASK :
				result =  "���콺 "+mouseButton+"�� "+TargetVarIndex+"�� ������ŭ Ŭ���մϴ�.";
				break;
			case MOUSE_WHEEL_TASK :
				result =  "���콺 ���� "+TargetVarIndex+"�� ������ŭ �����ϴ�.";
				break;
			case KEYBOARD_INPUT_TASK :
				result =  "Ű����� \'"+KeyEvent.getKeyText(keyCode)+"\'��/�� �Է��մϴ�.";
				break;
			case STRING_INPUT_TASK :
				result =  "Ű����� ���� \""+inputString+"\"��/�� �Է��մϴ�.";
				break;
			case NUMBER_INPUT_TASK :
				result =  "Ű����� "+TargetVarIndex+"�� ������ �Է��մϴ�.";
				break;
			case SET_VARIABLE_TASK :
				result =  varCount+"��° ������ "+TargetVarIndex+"�� ������ �����մϴ�.";
				break;
			case INCREASE_VARIABLE_TASK :
				result =  varCount+"��° ������ "+TargetVarIndex+"�� ������ŭ �����մϴ�.";
				break;
			case WAIT_TASK :
				result = TargetVarIndex+"�� ������ ����� ��  * 1ms����մϴ�.";
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
