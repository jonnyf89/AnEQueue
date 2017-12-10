import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
/*
 * Author Jonathan Farrell
 * A class for validating user inputs
 * 
 */
public class Validator {

	public Validator() {
		
	}
	public void ValidateAgeField(java.awt.event.KeyEvent evt, JLabel validation, JTextField Age) {
		int key = evt.getKeyCode();
		if((key>=evt.VK_0&&key<=evt.VK_9)||
				(key>=evt.VK_NUMPAD0&&key<=evt.VK_NUMPAD9)||
				key==KeyEvent.VK_BACK_SPACE) {
			Age.setEditable(true);
			Age.setBackground(Color.WHITE);
			validation.setText("");
		}else {
			Age.setEditable(false);
			Age.setBackground(Color.red);
			validation.setText("Age must be a number");
		}
	}

	public boolean ValidateReception(ReceptionPage page) {
		boolean isValid = false;
		if((!page.name.getText().trim().equals(""))&&(!page.age.getText().trim().equals(""))&&
				(!page.condition.getText().trim().equals(""))) {
			isValid = true;
			page.nameVal.setText("");
			page.ageVal.setText("");
			page.condVal.setText("");
		}else {
			if(page.name.getText().equals("")) {
				page.nameVal.setText("Name cannot be blank");
			}
			if(page.age.getText().equals("")) {
				page.ageVal.setText("Age cannot be blank");
			}
			if(page.condition.getText().equals("")) {
				page.condVal.setText("Condition cannot be blank");
			}
		}
		return isValid;
	}

	public boolean ValidateTriage(TriagePage page){
		boolean isValid = false;
		if((!page.vitals.getText().trim().equals(""))&&((Integer)page.prioritySpinner.getValue()>0)) {
			isValid = true;
			page.vitalsVal.setText("");
			page.priorityVal.setText("");
		}else {
			if(page.vitals.getText().trim().equals("")) {
				page.vitalsVal.setText("Vitals cannot be blank");
			}
			if((Integer)page.prioritySpinner.getValue()<=0) {
				page.priorityVal.setText("Priority value be selected");
			}
		}
		return isValid;
	}
	
	public boolean ValidateDoctor(DoctorPage page) {
		boolean isValid = false;
		if(!page.treatment.getText().equals("")) {
			isValid = true;
		}else {
			page.treatmentVal.setText("You have not entered a treatment");
		}
		return isValid;
	}
	public boolean isFilled(JLabel fieldName) {//this method checks if a given field has been filled
		boolean isFilled = false;//using this we can determine if a screen is displaying a patient
		if(!fieldName.getText().equals("")) {
			isFilled = true;
		}
		return isFilled;
	}
	
}
