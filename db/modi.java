
import  javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class modi extends JFrame implements ActionListener{
	public static int r;
	JTextField j2;	
	static Connection con;
	static Statement st;
	static ResultSet rs;
	modi(){
		setName("Modification");
		ImageIcon pic =new ImageIcon("2.jpg");
		JLabel j=new JLabel("",pic,JLabel.CENTER);
		j.setBounds(0,0,650,700);
		
		setBounds(300,20,650,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel head=new JLabel("<html><h2><font color=white>Enter Your Name Or Roll number for changes</font><h2><html>");
		JLabel name=new JLabel("<html><h2><font color=white>Name</font><h2><html>");
		JLabel roll=new JLabel("<html><h2><font color=white>Roll Number</font><h2><html>");
		
		head.setBounds(150,4,500,100);
		add(head);
		
		name.setBounds(150,200,50,50);
		add(name);
		roll.setBounds(150,300,100,50);
		add(roll);


		JTextField j1=new JTextField();
		j1.setBounds(250,215,250,30);
		add(j1);
		j2=new JTextField();
		j2.setBounds(250,315,250,30);
		add(j2);	

		JButton next=new JButton("Back");
		next.setBounds(330,400,80,30);
		add(next);
		JButton cancel=new JButton("OK!");
		cancel.setBounds(420,400,80,30);
		add(cancel);
		next.addActionListener(this);
		cancel.addActionListener(this);
		add(j);		
		setVisible(true);		
	}
	public void actionPerformed(ActionEvent ae){
		JButton btn=(JButton)ae.getSource();
		if(btn.getText().equals("OK!")){
			label:
			{
			String rol= j2.getText();
			try{ r=Integer.parseInt(rol);}catch(Exception ax){JOptionPane.showMessageDialog(null,"Invalid DataType!");setVisible(false);new modi(); break label;}
				
				try{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				con=DriverManager.getConnection("jdbc:ucanaccess://student.accdb");
				st=con.createStatement();
				rs=st.executeQuery("select id from mytable ");
				boolean sear=true;
				while(rs.next())
				{
					if(rs.getInt(1)==r)
					{
						try{
						rs.close();
						st.close();
						con.close();}
						catch(Exception ai)
						{}
						setVisible(false);
						new modii();
						sear=false;
					}
					
				}
				if(sear)
				{
				JOptionPane.showMessageDialog(null,"Record dont Exist");
				setVisible(false);
				new modi();
				break label;
				}
				}catch(Exception ai){}
						
			}
			
		}
		else{
			setVisible(false);
			new frame();	
		}		
	}		
}
