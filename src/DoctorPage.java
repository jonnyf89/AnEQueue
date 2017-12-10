import javax.swing.JLabel;
/*
 * Author Jonathan Farrell
 * A class representing the fields on the reception tab, note this is not where the 
 * tab is created, that is in the GUI class Multiview, this object is for passing into
 * methods for in the FormFiller and Validator classes
 */
import javax.swing.JTextField;

public class DoctorPage {

	protected JLabel name;
	protected JLabel age;
	protected JLabel vitals;
	protected JLabel priority;
	protected JLabel header;
	protected JLabel condition;
	protected JLabel treatmentVal;
	protected JTextField treatment;
	
	public DoctorPage(JLabel name, JLabel age, JLabel vitals, JLabel priority,
			JLabel header, JLabel condition, JLabel treatmentVal, JTextField treatment) {
		this.name = name;
		this.age = age;
		this.vitals = vitals;
		this.priority = priority;
		this.header = header;
		this.condition = condition;
		this.treatmentVal = treatmentVal;
		this.treatment = treatment;
	}

	public JLabel getVitals() {
		return vitals;
	}

	public void setVitals(JLabel vitals) {
		this.vitals = vitals;
	}

	public JLabel getPriority() {
		return priority;
	}

	public void setPriority(JLabel priority) {
		this.priority = priority;
	}

	public JLabel getHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	public JLabel getNameField() {
		// TODO Auto-generated method stub
		return null;
	}

	public JLabel getAgeField() {
		// TODO Auto-generated method stub
		return null;
	}

	public JLabel getConditionField() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
