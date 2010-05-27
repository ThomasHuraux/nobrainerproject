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
	
	private JTextField login;
	private JPasswordField pass;
	private JPasswordField confirm;
	private JButton ok;
	private JButton returnB;
	
	
	public void initialize(Model model){
		
		login = new JTextField(10);
		pass = new JPasswordField(10);
		confirm = new JPasswordField(10);
		
		ok = new JButton("Create");
		returnB = new JButton("Return");
		
		JPanel loginP = new JPanel();
		loginP.add(new JLabel("Login    "));
		loginP.add(login);
		
		JPanel passP = new JPanel();
		passP.add(new JLabel("Password"));
		passP.add(pass);

		JPanel confirmP = new JPanel();
		confirmP.add(new JLabel("Confirm "));
		confirmP.add(confirm);

		setLayout(new GridLayout(4,1));

		JPanel buttons = new JPanel();
		buttons.add(returnB);
		buttons.add(ok);
		
		add(loginP);
		add(passP);
		add(confirmP);
		add(buttons);
		
		model.attach(this);
		makeController();

	}

	public JTextField getLogin() {
		return login;
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
