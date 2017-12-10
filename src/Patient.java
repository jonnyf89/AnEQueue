import java.util.UUID;
/*
 * Author Jonathan Farrell
 * Class representing the patients in the system
 */
public class Patient extends ObjectMapper{

	protected String id;
	protected String name;
	protected int age;
	protected String condition;
	protected int priority;
	protected String vitals;
	protected String treatment;
	protected IStorePatient dataStorage;
	
	public Patient(String name, int age, String condition) {
		dataStorage = new SQLiteDB();
		
		UUID uniqueId = UUID.randomUUID();//creates a unique ID, we want this to be a string for our ORM so we convert it below
		this.id = uniqueId.toString();
		this.name = name;
		this.age = age;
		this.condition = condition;
		this.priority = 0;//a priority of 0 represents an unset priority
		this.vitals = "";
		this.treatment = "";
		String data = create();
		dataStorage.StorePatientDetails(data);//ORM automatically creates database table column when the patient object is created
	}
	
	public String toString() {
		return (name + " ,priority: " + priority);
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
		String data = update();//ORM automatically updates table columns
		dataStorage.StorePatientDetails(data);
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getCondition() {
		return condition;
	}
	public void setVitals(String vitals) {
		this.vitals = vitals;
		String data = update();//ORM automatically updates table columns
		dataStorage.StorePatientDetails(data);
	}
	public String getVitals() {
		return this.vitals;
	}
	public String getTreatment() {
		return this.treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
		String data = update();//ORM automatically updates table columns
		dataStorage.StorePatientDetails(data);
	}
	public String getId() {
		return id;
	}
}
