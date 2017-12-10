import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SpinnerNumberModel;
/*
 * Author Jonathan Farrell
 * GUI class, builds the interface and contains its logic
 */
public class MultiView extends JFrame{

	private JPanel contentPane;
	private JTextField TFName;
	private JTextField TFAge;
	private JTextField TFCondition;
	private JTextField TFVitals2;
	private JTextField TFTreatment3;
	private DoubleLinkedList dll;
	private FormFiller ff;
	private Patient triagePatient;
	private Patient doctorPatient;
	private JLabel lblNameValidation;
	private JLabel lblAgeValidation;
	private JLabel lblConditionValidation;
	private JLabel lblVitalsValidation2;
	private JLabel lblPriorityValidation2;
	private JLabel lblTreatmentValidation3;
	private Validator validator;
	
	/**
	 * Create the frame.
	 */
	public MultiView() {
		dll = new DoubleLinkedList();
		ff = new FormFiller(dll);
		validator = new Validator();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 685);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, "name_782753064383526");

		
		JPanel ReceptionistView = new JPanel();
		tabbedPane.addTab("Reception", null, ReceptionistView, null);
		ReceptionistView.setLayout(null);
		
		JPanel pnlTab1 = new JPanel();
		pnlTab1.setLayout(null);
		pnlTab1.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlTab1.setBackground(SystemColor.activeCaption);
		pnlTab1.setBounds(0, 0, 451, 559);
		ReceptionistView.add(pnlTab1);
		
		JLabel headerReceptionistView = new JLabel("Receptionist View");
		headerReceptionistView.setFont(new Font("Tahoma", Font.PLAIN, 19));
		headerReceptionistView.setBounds(149, 16, 157, 31);
		pnlTab1.add(headerReceptionistView);
		
		JPanel pnlContent1 = new JPanel();
		pnlContent1.setLayout(null);
		pnlContent1.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlContent1.setBackground(SystemColor.inactiveCaption);
		pnlContent1.setBounds(15, 49, 421, 476);
		pnlTab1.add(pnlContent1);
		
		JLabel lblPatientDetails = new JLabel("Patient Details:");
		lblPatientDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPatientDetails.setBounds(15, 16, 118, 22);
		pnlContent1.add(lblPatientDetails);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(15, 64, 69, 37);
		pnlContent1.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(15, 130, 69, 37);
		pnlContent1.add(lblAge);
		
		TFName = new JTextField();
		TFName.setColumns(10);
		TFName.setBounds(98, 64, 252, 39);
		pnlContent1.add(TFName);
		

		lblAgeValidation = new JLabel("");
		lblAgeValidation.setForeground(Color.RED);
		lblAgeValidation.setToolTipText("");
		lblAgeValidation.setBounds(120, 169, 216, 20);
		pnlContent1.add(lblAgeValidation);
		
		
		TFAge = new JTextField();
		TFAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(java.awt.event.KeyEvent evt) {
				validator.ValidateAgeField(evt, lblAgeValidation, TFAge);
				}
				
		});
		TFAge.setColumns(10);
		TFAge.setBounds(99, 130, 252, 37);
		pnlContent1.add(TFAge);
		
		JLabel lblCondition = new JLabel("Condition");
		lblCondition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCondition.setBounds(15, 183, 93, 37);
		pnlContent1.add(lblCondition);
		
		TFCondition = new JTextField();
		TFCondition.setColumns(10);
		TFCondition.setBounds(15, 224, 391, 185);
		pnlContent1.add(TFCondition);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(91, 425, 115, 29);
		pnlContent1.add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFName.setText("");
				TFAge.setText("");
				TFCondition.setText("");
			}
		});
		btnReset.setBounds(211, 425, 115, 29);
		pnlContent1.add(btnReset);
		
		lblNameValidation = new JLabel("");
		lblNameValidation.setForeground(Color.RED);
		lblNameValidation.setBounds(98, 106, 194, 20);
		pnlContent1.add(lblNameValidation);
		
		lblConditionValidation = new JLabel("");
		lblConditionValidation.setForeground(Color.RED);
		lblConditionValidation.setBounds(109, 193, 241, 20);
		pnlContent1.add(lblConditionValidation);
		
		ReceptionPage receptionPage = new ReceptionPage(TFName, TFAge, 
				TFCondition, lblNameValidation, lblAgeValidation, 
				lblConditionValidation);
		
		JPanel TriageNurseView = new JPanel();
		tabbedPane.addTab("Triage", null, TriageNurseView, null);
		TriageNurseView.setLayout(null);
		
		JPanel pnlTab2 = new JPanel();
		pnlTab2.setLayout(null);
		pnlTab2.setBorder(null);
		pnlTab2.setBackground(SystemColor.activeCaption);
		pnlTab2.setBounds(0, 0, 451, 605);
		TriageNurseView.add(pnlTab2);
		
		JLabel lblTriageNurseView = new JLabel("Triage Nurse View");
		lblTriageNurseView.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTriageNurseView.setBounds(149, 16, 157, 31);
		pnlTab2.add(lblTriageNurseView);
		
		JPanel pnlContent2 = new JPanel();
		pnlContent2.setLayout(null);
		pnlContent2.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlContent2.setBackground(SystemColor.inactiveCaption);
		pnlContent2.setBounds(15, 49, 421, 529);
		pnlTab2.add(pnlContent2);
		
		JLabel lblPatientDetails2 = new JLabel("No Patients");
		lblPatientDetails2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPatientDetails2.setBounds(151, 16, 118, 33);
		pnlContent2.add(lblPatientDetails2);
		
		JLabel lblVitals2 = new JLabel("Vitals");
		lblVitals2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVitals2.setBounds(25, 368, 56, 29);
		pnlContent2.add(lblVitals2);
		
		TFVitals2 = new JTextField();
		TFVitals2.setColumns(10);
		TFVitals2.setBounds(96, 359, 299, 38);
		pnlContent2.add(TFVitals2);
		
		JLabel lblPriority2 = new JLabel("Priority");
		lblPriority2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPriority2.setBounds(25, 427, 63, 29);
		pnlContent2.add(lblPriority2);
		
		JSpinner spinnerPriority2 = new JSpinner();
		spinnerPriority2.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerPriority2.setBounds(91, 430, 32, 26);
		pnlContent2.add(spinnerPriority2);

		JButton btnSubmit2 = new JButton("Submit");
		
		btnSubmit2.setBounds(96, 484, 115, 29);
		pnlContent2.add(btnSubmit2);
		
		JButton btnReset2 = new JButton("Reset");
		btnReset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFVitals2.setText("");
				spinnerPriority2.setValue(0);
			}
		});
		btnReset2.setBounds(216, 484, 115, 29);
		pnlContent2.add(btnReset2);
		
		JLabel lblName2 = new JLabel("Name");
		lblName2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName2.setBounds(25, 59, 69, 20);
		pnlContent2.add(lblName2);
		
		JLabel FieldName2 = new JLabel("");
		FieldName2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		FieldName2.setBounds(91, 59, 299, 20);
		pnlContent2.add(FieldName2);
		
		JLabel FieldAge2 = new JLabel("");
		FieldAge2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		FieldAge2.setBounds(91, 99, 299, 29);
		pnlContent2.add(FieldAge2);
		
		JLabel lblAge2 = new JLabel("Age");
		lblAge2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAge2.setBounds(25, 99, 69, 29);
		pnlContent2.add(lblAge2);
		
		JLabel lblCondition2 = new JLabel("Condition");
		lblCondition2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCondition2.setBounds(25, 144, 87, 29);
		pnlContent2.add(lblCondition2);
		
		JLabel FieldCondition2 = new JLabel("");
		FieldCondition2.setBounds(25, 178, 370, 165);
		pnlContent2.add(FieldCondition2);
		
		
		
		lblVitalsValidation2 = new JLabel("");
		lblVitalsValidation2.setForeground(Color.RED);
		lblVitalsValidation2.setBounds(96, 404, 171, 20);
		pnlContent2.add(lblVitalsValidation2);
		
		lblPriorityValidation2 = new JLabel("");
		lblPriorityValidation2.setForeground(Color.RED);
		lblPriorityValidation2.setBounds(130, 433, 230, 20);
		pnlContent2.add(lblPriorityValidation2);
		
		//this is an object representing the triage tab, for passing into methods of FormFiller
		TriagePage triagePage = new TriagePage(FieldName2, FieldAge2, 
				lblCondition2, lblPatientDetails2, TFVitals2, spinnerPriority2, 
				lblVitalsValidation2, lblPriorityValidation2);		
		
		JPanel DoctorView = new JPanel();
		tabbedPane.addTab("Doctor", null, DoctorView, null);
		DoctorView.setLayout(null);
		
		JPanel pnlTab3 = new JPanel();
		pnlTab3.setLayout(null);
		pnlTab3.setBorder(null);
		pnlTab3.setBackground(SystemColor.activeCaption);
		pnlTab3.setBounds(0, 0, 451, 588);
		DoctorView.add(pnlTab3);
		
		JLabel lblDoctorView = new JLabel("Doctor View");
		lblDoctorView.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDoctorView.setBounds(176, 16, 100, 31);
		pnlTab3.add(lblDoctorView);
		
		JPanel pnlContent3 = new JPanel();
		pnlContent3.setLayout(null);
		pnlContent3.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlContent3.setBackground(SystemColor.inactiveCaption);
		pnlContent3.setBounds(15, 49, 421, 524);
		pnlTab3.add(pnlContent3);
		
		JButton btnSubmit3 = new JButton("Submit");
		
		btnSubmit3.setBounds(91, 482, 115, 29);
		pnlContent3.add(btnSubmit3);
		
		JButton btnReset3 = new JButton("Reset");
		btnReset3.setBounds(211, 482, 115, 29);
		btnReset3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TFTreatment3.setText("");
			}
		});
		pnlContent3.add(btnReset3);
		
		JLabel lblPatientDetails3 = new JLabel("No Patients");
		lblPatientDetails3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPatientDetails3.setBounds(151, 16, 118, 33);
		pnlContent3.add(lblPatientDetails3);
		
		JLabel lblTreatment3 = new JLabel("Treatment");
		lblTreatment3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTreatment3.setBounds(25, 299, 105, 29);
		pnlContent3.add(lblTreatment3);
		
		TFTreatment3 = new JTextField();
		TFTreatment3.setColumns(10);
		TFTreatment3.setBounds(25, 329, 370, 137);
		pnlContent3.add(TFTreatment3);
		
		JLabel FieldCondition3 = new JLabel("");
		FieldCondition3.setBounds(25, 201, 370, 96);
		pnlContent3.add(FieldCondition3);
		
		JLabel lblCondition3 = new JLabel("Condition");
		lblCondition3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCondition3.setBounds(25, 173, 87, 29);
		pnlContent3.add(lblCondition3);
		
		JLabel lblAge3 = new JLabel("Age");
		lblAge3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAge3.setBounds(25, 79, 69, 29);
		pnlContent3.add(lblAge3);
		
		JLabel FieldAge3 = new JLabel("");
		FieldAge3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		FieldAge3.setBounds(96, 79, 299, 29);
		pnlContent3.add(FieldAge3);
		
		JLabel lblName3 = new JLabel("Name");
		lblName3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblName3.setBounds(25, 50, 69, 20);
		pnlContent3.add(lblName3);
		
		JLabel FieldName3 = new JLabel("");
		FieldName3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		FieldName3.setBounds(91, 50, 299, 20);
		pnlContent3.add(FieldName3);
		
		JLabel lblVitals3 = new JLabel("Vitals");
		lblVitals3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVitals3.setBounds(25, 111, 69, 29);
		pnlContent3.add(lblVitals3);
		
		JLabel FieldVitals3 = new JLabel("");
		FieldVitals3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		FieldVitals3.setBounds(91, 111, 299, 29);
		pnlContent3.add(FieldVitals3);
		
		JLabel lblPriority3 = new JLabel("Priority");
		lblPriority3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPriority3.setBounds(25, 141, 69, 29);
		pnlContent3.add(lblPriority3);
		
		JLabel FieldPriority3 = new JLabel("");
		FieldPriority3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		FieldPriority3.setBounds(91, 141, 299, 29);
		pnlContent3.add(FieldPriority3);
		
		lblTreatmentValidation3 = new JLabel("");
		lblTreatmentValidation3.setForeground(Color.RED);
		lblTreatmentValidation3.setBackground(Color.WHITE);
		lblTreatmentValidation3.setBounds(131, 305, 248, 20);
		pnlContent3.add(lblTreatmentValidation3);
		
		//an object representing the doctor tab, for passing into FormFiller methods
		DoctorPage doctorPage = new DoctorPage(FieldName3, FieldAge3, 
				FieldVitals3, FieldPriority3, lblPatientDetails3, 
				FieldCondition3, lblTreatmentValidation3, TFTreatment3);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isValid = validator.ValidateReception(receptionPage);
				if(isValid == true) {//if inputs are valid
					String tmp_name = TFName.getText();
					int tmp_age = Integer.parseInt(TFAge.getText());
					String tmp_cond = TFCondition.getText();
				
					Patient tmp_patient = new Patient(tmp_name, tmp_age, tmp_cond);//create a new patient from inputs
					
					dll.add(tmp_patient);//add patient to the Double linked list
					TFName.setText("");//clear the fields for next input
					TFAge.setText("");
					TFCondition.setText("");
				
					ff.setPatientList(dll);
					triagePatient = ff.FillTriage(triagePage);//fill triage tab
					TFVitals2.setText("");//clear triage pages input fields, in case they have been previously filled with invalid information
					spinnerPriority2.setValue(0);
				}
			}
				
		});
		btnSubmit2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isFilled = validator.isFilled(FieldName2);
				boolean isValid = validator.ValidateTriage(triagePage);
				if((isValid == true)&&(isFilled == true)) {//if there is a patient shown and inputs are valid
					String vitals = TFVitals2.getText();
					int priority = (Integer)spinnerPriority2.getValue();
					triagePatient.setVitals(vitals);//update vitals and priority
					triagePatient.setPriority(priority);
					dll.updateById(triagePatient.getId(), triagePatient);//update the patient in the DLL
					TFVitals2.setText("");//clear fields
					spinnerPriority2.setValue(0);
				
				
					ff.setPatientList(dll);
					if(dll.getHead()!=null) {//fill triage and doctor tabs with appropriate patient data
						triagePatient = ff.FillTriage(triagePage);
						TFVitals2.setText("");
						spinnerPriority2.setValue(0);
						
						doctorPatient = ff.FillDoctor(doctorPage);
						TFTreatment3.setText("");
					}
				}
			}
		});
		btnSubmit3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isFilled = validator.isFilled(FieldName3);
				boolean isValid = validator.ValidateDoctor(doctorPage);
				if((isValid == true)&&(isFilled == true)) {//if there is a patient shown and inputs are valid
					lblTreatmentValidation3.setText("");
					String treatment = TFTreatment3.getText();
					doctorPatient.setTreatment(treatment);//update patient with treatment		
				
					if(TFTreatment3.getText()!="") {//clears the field and deletes the completed patient from the double linked list, it persists in the database 
						dll.removeById(doctorPatient.getId());
					}
					TFTreatment3.setText("");
				
				
					if(dll.getHead()!=null) {//fills tab with next appropriate data
						doctorPatient = ff.FillDoctor(doctorPage);
						}else {
							ff.clearDoctor(doctorPage);
						}
					ff.setPatientList(dll);
					}
				}
		});
	}
}
