import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
/*
 * Author Jonathan Farrell
 * A class representing the fields on the triage tab, note this is not where the 
 * tab is created, that is in the GUI class Multiview, this object is for passing into
 * methods for in the FormFiller and Validator classes
 */
public class TriagePage {
	protected JLabel nameField; 
	protected JLabel ageField;
	protected JLabel conditionField;
	protected JLabel header;
	protected JTextField vitals;
	protected JSpinner prioritySpinner;
	protected JLabel vitalsVal;
	protected JLabel priorityVal;
	
	public TriagePage(JLabel nameField, JLabel ageField, 
			JLabel conditionField, JLabel header, JTextField vitals, 
			JSpinner prioritySpinner, JLabel vitalsVal, JLabel priorityVal) {
		this.nameField = nameField;
		this.ageField = ageField;
		this.conditionField = conditionField;
		this.header = header;
		this.vitals = vitals;
		this.prioritySpinner = prioritySpinner;
		this.vitalsVal = vitalsVal;
		this.priorityVal = priorityVal;
	}

	public JLabel getNameField() {
		return nameField;
	}

	public void setNameField(JLabel nameField) {
		this.nameField = nameField;
	}

	public JLabel getAgeField() {
		return ageField;
	}

	public void setAgeField(JLabel ageField) {
		this.ageField = ageField;
	}

	public JLabel getConditionField() {
		return conditionField;
	}

	public void setConditionField(JLabel conditionField) {
		this.conditionField = conditionField;
	}

	public JLabel getHeader() {
		return header;
	}

	public void setHeader(JLabel header) {
		this.header = header;
	}
	
	
}
