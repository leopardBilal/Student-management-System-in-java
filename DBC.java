import java.sql.*;
public class DBC{
	public static void main(String args

}
class deoperation{
	
	static Connection con;		//interface
	static Statement st;
	static ResultSet rs;
	
	public void doSetup(){
		
		try{
		//1. to load the driver / register the driver UcanaccessDriver.class
			//a.first way to load driver : Class.forName("fullyqualifiednameofUcanaccessdriver.class);
		ClassforName("net.ucanaccess.jdbc.UcanaccessDriver");
		//this will create the object of UcanaccessDriver class and will give to DriverManager
		
		//2. Create the connection 
		con = DriverManager.getConnection("jdbc:ucanaccess://Hostel Man);
		//con is object of interface this shows DriverManage class is implementing the interface
		//the above line will use
		}catch(Exception ex){
		}
			
	}
	public void dbRead(){
		
		doSetup();
		try{
		
			//3. Create the statement/instruction for the database management software to execute on 			//database
		
			st= con.createStatement();
			//System.out.println(st);
			//4. Execute the instruction.
			
			st.executeQuery("select * from studentTable");		//for only selecting data
			//	first name, lastname from StudentTable"
			//this will give the values from table that can be stored in a special cariable of
			//ResultSet variabel
			
			while(rs.next()){
				
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}		
		}
		catch(Exception ex){
		
		}
		undoSetup();
		
	}
	public void doInsert(){
		doSetup();		//build connection
		
		st=con.createStatement();
		int count= st.executeUpdate("insert into studentTable (firstname, lastName, city) value('Nadir','Hussain','Kumb'));
		//this will return 1 if data is inserted else zero
			
		
	}	
	public void undoSetup(){
		//Last Step.  close All the connections
		rs.close();
		con.close();
		st.close();
	}
}






/*
summary
sql interfaces

//java Mycode-----Java API(pre built)----Drivers------database
//sql is java API(Application programming interface)
//driver ----ucanaccess
//database-----MS ACCESS
//this java API(sql) can also use OracleDriver
//Another driver is ODBC(was supported before ucanaccess)
//MS Access------ .accdb(Extension)



/*steps
1. select- Reading data from database(Select all records from database)
//if we want to select only first name of all records select firstname,lastname form table
//if we want to select only first name of a single student select firstname,lastname from table id=1;


2. insert- Inserting data into database
//Insert into Student Table (firstname, lastname) values('John','Kumar');
3. Update- updating data into database
//Update StudentTable set firstname='john', lastname='gage' where id=2
4. delete- Removing data form database
//delete from studentTable where id=2;
//database understands Structured query Language but not Language of JAVA

*/