import java.lang.reflect.Field;
/*
 * author Jonny
 * ORM class, Patients inherits from here, this class adds 
 * and updates entries to the database
 */
public class ObjectMapper {

	public String uniqueId;

	public String create() {
		String query = null;
		try {
			String insert_fields="";
			String insert_values="";
			int counter = 0;
			
			Class<?> objClass = this.getClass();//what class are you?
			String db_tableName = objClass.getSimpleName() + "s";
			Field[] fields = objClass.getDeclaredFields();
			
			for (int i = 0; i < fields.length-1; i++) {
				String name = fields[i].getName();
				Object value = fields[i].get(this);
				
				if(counter == 0) {
					insert_fields = insert_fields + name;
				}else {
					insert_fields = insert_fields + ", " + name;
				}
				
				switch(value.getClass().toString()) {
				case"class java.lang.String":
					if(counter == 0) {
						insert_values = insert_values + "'" + value.toString() + "'";
					}else {
						insert_values = insert_values + "," + "'" + value.toString() + "'";
					}
					break;
				case "class java.lang.Integer":
					if(counter == 0) {
						insert_values = insert_values + value.toString();	
					}else {
						insert_values = insert_values + ", " + value.toString();
					}
					break;
				default:
					//something went wrong if we got here!
					break;
				}
				counter += 1;
			}
			query = ("insert into " + db_tableName + " (" + insert_fields + ") values (" + insert_values + ");");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return query;
	}
	
	
	public String update() {
		String query = null;
		try {
			String update_cols = "";
			int counter = 0;
			
			Class<?> objClass = this.getClass();
			String db_tableName = objClass.getSimpleName() + "s";
			Field[] fields = objClass.getDeclaredFields();
			
			
			for(int i = 0; i<fields.length-1; i++) {
				String name = fields[i].getName();
				String fieldValue = ";";
				Object value = fields[i].get(this);
				
				if(name.equals("id")) {
					uniqueId = value.toString();
				}
				
				switch (value.getClass().toString()) {
					case "class java.lang.String":
						fieldValue = name + " = '" + value.toString() + "'";
						break;
					case "class java.lang.Integer":
						fieldValue = name + " = " + value.toString();
						break;
					default:
						//Something went wrong if we get here!
						break;
				}
				
				if(counter == 0) {
					update_cols = fieldValue;
				}else {
					update_cols = update_cols + ", " + fieldValue;
				}
				counter += 1;
			}
			query = ("UPDATE " + db_tableName + " SET " + update_cols + " WHERE id=" + '"' + uniqueId + '"' + ";");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return query;
	}

}











