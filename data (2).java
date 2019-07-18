import java.sql.*;

class data{
	public static void main(String args[]){
					
		Read ob=new Read();
		ob.Readall();	
	
	}
}
class Read{


		Connection con=null;
		ResultSet rs=null;
		Statement st=null;
	public void doSetup(){
	
			try{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			
			con=DriverManager.getConnection("jdbc:Ucanaccess://Record.accdb");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	public void Readall(){		
			//reading statements
			doSetup();
			try{
			st=con.createStatement();
			st.executeQuery("Select *  form Record");

			while(rs.next()){
				System.out.println(rs.getInt(1));	
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			}
			catch(Exception ex){
			ex.printStackTrace();		
			}
		}
	public void closeAll(){
		try{
		rs.close();	
		st.close();
		con.close();
		}
		catch(Exception ex){
		ex.printStackTrace();
		}	
	}
}
		//int id=given by user;
		//String str="Select * form Record where id="+id;	