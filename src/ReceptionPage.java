import javax.swing.JLabel;
import javax.swing.JTextField;
/*
 * Author Jonathan Farrell
 * A class representing the fields on the reception tab, note this is not where the 
 * tab is created, that is in the GUI class Multiview, this object is for passing into
 * methods for in the FormFiller and Validator classes
 */
public class ReceptionPage {
	protected JTextField name;
	protected JTextField age;
	protected JTextField condition;
	protected JLabel nameVal;
	protected JLabel ageVal;
	protected JLabel condVal;

	public ReceptionPage(JTextField name, JTextField age, JTextField condition,
			JLabel nameVal, JLabel ageVal, JLabel condVal) {
		this.name = name;
		this.age = age;
		this.condition = condition;
		this.nameVal = nameVal;
		this.ageVal = ageVal;
		this.condVal = condVal;
	}
	
}
