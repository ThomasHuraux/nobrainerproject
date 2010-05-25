package fr.uhp.nobrain.plateform.login;

import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class LoginView extends JPanel implements View{

	private static final long serialVersionUID = 1L;
	
	private JTextField nickname;
	private JPasswordField pass;
	private JButton ok;
	private JButton create;
	
	public void initialize(Model model){
		
		nickname = new JTextField();
		pass = new JPasswordField();
		
		ok = new JButton("OK");
		create = new JButton("Create an account");
		
		JPanel nicknameP = new JPanel();
		nicknameP.add(new JLabel("Nickname"));
		nicknameP.add(nickname);
		
		JPanel passP = new JPanel();
		passP.add(new JLabel("Password"));
		passP.add(pass);
		
		JPanel buttons = new JPanel();
		buttons.add(create);
		buttons.add(ok);
		
		setLayout(new GridLayout(3,1));
		add(nicknameP);
		add(passP);
		add(buttons);
		
		model.attach(this);
		makeController();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getNickname() {
		return nickname;
	}

	public JPasswordField getPass() {
		return pass;
	}

	public JButton getOk() {
		return ok;
	}

	public JButton getCreate() {
		return create;
	}

	@Override
	public void makeController() {
		LoginController lc = new LoginController();
		lc.initialize(null, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}
