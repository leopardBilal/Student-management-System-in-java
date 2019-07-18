import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class pass extends JFrame implements ActionListener{
public static void main(String args[])
{
	new pass();
}
	JTextField j1;
	JPasswordField j2;
	pass(){
		
		ImageIcon pic =new ImageIcon("1.jpg");
		JLabel j=new JLabel("",pic,JLabel.CENTER);
		j.setBounds(0,0,650,700);
		
		setBounds(300,20,650,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel head=new JLabel("<html><h2><font color=white>Enter Username and Password</font><h2><html>");
		JLabel name=new JLabel("<html><h2><font color=white>Name</font><h2><html>");
		JLabel roll=new JLabel("<html><h2><font color=white>Password</font><h2><html>");
		
		head.setBounds(150,4,500,100);
		add(head);
		
		name.setBounds(150,200,50,50);
		add(name);
		roll.setBounds(150,300,100,50);
		add(roll);


		j1=new JTextField();
		j1.setBounds(250,215,250,30);
		add(j1);
			
		j2=new JPasswordField();
		j2.setBounds(250,215,250,30);
		add(j2);

		JButton cancel=new JButton("Login");
		cancel.setBounds(420,400,80,30);
		add(cancel);
		
		cancel.addActionListener(this);
		add(j);		
		setVisible(true);		
	}
	public void actionPerformed(ActionEvent ae){
		String s = ae.getActionCommand();
		if(s.equals("Login")){
			String str = j1.getText();
			String str1 = j2.getText();
			
			if(str.equals("Bakhtiar") && str1.equals("111") )
			{
				setVisible(false);
				new frame();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"username or password is invalid!");	
			}
		}
		
	}		
}
