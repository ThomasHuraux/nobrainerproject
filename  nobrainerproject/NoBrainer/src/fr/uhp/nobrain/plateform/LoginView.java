package fr.uhp.nobrain.plateform;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextField nickname;
	private JTextField pass;
	private JButton ok;
	private JButton create;
	
	public LoginView(){
		
		nickname = new JTextField();
		pass = new JTextField();
		
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
		
		setLayout(new GridLayout(1,3));
		add(nicknameP);
		add(passP);
		add(buttons);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JTextField getNickname() {
		return nickname;
	}

	public JTextField getPass() {
		return pass;
	}

	public JButton getOk() {
		return ok;
	}

	public JButton getCreate() {
		return create;
	}

}
