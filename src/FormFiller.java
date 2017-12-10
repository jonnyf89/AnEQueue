import javax.swing.JLabel;
/*
 * Author Jonathan Farrell
 * a class for filling GUI fields
 */
public class FormFiller {//constructor
	private DoubleLinkedList patientList;
	
	public FormFiller(DoubleLinkedList patientList) {
		this.patientList = patientList;
	}
	
	public Patient FillTriage(TriagePage triagePage) {//fills the fields of the triage page, takes a triagePage object as a parameter, rather than taking 4 arguments
		Patient p = patientList.getFirstNonPriority();
		if(p!=null) {
			triagePage.getHeader().setText("Patient Details");
			triagePage.getNameField().setText(p.getName());
			triagePage.getAgeField().setText(String.valueOf(p.getAge()));
			triagePage.getConditionField().setText(p.getCondition());
			}else {
			clearTriage(triagePage);
		}
		return p;
	}
	
	public Patient FillDoctor(DoctorPage doctorPage) {//fills the fields of the doctor page, takes a doctorPage object as a parameter, rather than taking 6 arguments
		Patient p = patientList.getHighestPriority();
		if(p.getPriority()!=0) {
			doctorPage.header.setText("Patient Details");
			doctorPage.name.setText(p.getName());
			doctorPage.age.setText(String.valueOf(p.getAge()));
			doctorPage.condition.setText(p.getCondition());
			doctorPage.vitals.setText(p.getVitals());
			doctorPage.priority.setText(String.valueOf(p.getPriority()));
			
		}else {
			clearDoctor(doctorPage);
		}
		return p;
	}
	
	public void setPatientList(DoubleLinkedList patientList) {
		this.patientList = patientList;
	}
	
	public void clearTriage(TriagePage triagePage) {//clears the triage page when there is no patient in the list to fill it
		triagePage.getHeader().setText("No Patients");
		triagePage.getNameField().setText("");
		triagePage.getAgeField().setText("");
		triagePage.getConditionField().setText("");
	}
	
	public void clearDoctor(DoctorPage doctorPage) {//clears the doctor page when there is no patient in the list to fill it
		doctorPage.header.setText("No Patients");
		doctorPage.name.setText("");
		doctorPage.age.setText("");
		doctorPage.condition.setText("");
		doctorPage.vitals.setText("");
		doctorPage.priority.setText("");
	}

}
