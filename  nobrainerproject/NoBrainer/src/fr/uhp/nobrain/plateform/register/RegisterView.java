package fr.uhp.nobrain.plateform.register;

import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class RegisterView extends JPanel implements View{

	private static final long serialVersionUID = 1L;
	
	private JTextField lastname;
	private JTextField firstname;
	private JTextField nickname;
	private JTextField date;
	private JPasswordField pass;
	private JPasswordField confirm;
	private JButton ok;
	private JButton returnB;
	
	
	public void initialize(Model model){
		
		lastname = new JTextField();
		firstname = new JTextField();
		nickname = new JTextField();
		date = new JTextField();
		pass = new JPasswordField();
		confirm = new JPasswordField();
		
		ok = new JButton("OK");
		returnB = new JButton("Return");
		
		JPanel lastnameP = new JPanel();
		lastnameP.add(new JLabel("Lastname"));
		lastnameP.add(lastname);
		
		JPanel firstnameP = new JPanel();
		firstnameP.add(new JLabel("Firstname"));
		firstnameP.add(firstname);
		
		JPanel nicknameP = new JPanel();
		nicknameP.add(new JLabel("Nickname"));
		nicknameP.add(nickname);
		
		JPanel dateP = new JPanel();
		dateP.add(new JLabel("Birth date"));
		dateP.add(date);
		
		JPanel passP = new JPanel();
		passP.add(new JLabel("Password"));
		passP.add(pass);
		
		JPanel confirmP = new JPanel();
		confirmP.add(new JLabel("Confirm password"));
		confirmP.add(confirm);
		
		setLayout(new GridLayout(8,1));
		add(lastnameP);
		add(firstnameP);
		add(nicknameP);
		add(dateP);
		add(passP);
		add(confirmP);
		add(ok);
		add(returnB);
		
		model.attach(this);
		makeController();

	}


	public JTextField getLastname() {
		return lastname;
	}


	public JTextField getFirstname() {
		return firstname;
	}


	public JTextField getNickname() {
		return nickname;
	}


	public JTextField getDate() {
		return date;
	}


	public JTextField getPass() {
		return pass;
	}


	public JTextField getConfirm() {
		return confirm;
	}


	public JButton getOk() {
		return ok;
	}
	
	public JButton getReturnB(){
		return returnB;
	}

	@Override
	public void makeController() {
		RegisterController rc = new RegisterController();
		rc.initialize(null, this);
	}


	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	
}
