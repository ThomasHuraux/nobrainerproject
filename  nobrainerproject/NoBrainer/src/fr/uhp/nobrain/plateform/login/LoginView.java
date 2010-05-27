package fr.uhp.nobrain.plateform.login;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
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
	
	private JLabel logo;
	
	public void initialize(Model model){
		
		nickname = new JTextField(10);
		pass = new JPasswordField(10);
		
		ok = new JButton("OK");
		create = new JButton("Create an account");
		
		String imgPath = ((Login) model).getLogoPath();
		logo = new JLabel(new ImageIcon(imgPath));
		
		JPanel nicknameP = new JPanel();
		nicknameP.add(new JLabel("Login      "));
		nicknameP.add(nickname);
		
		JPanel passP = new JPanel();
		passP.add(new JLabel("Password"));
		passP.add(pass);
		
		JPanel buttons = new JPanel();
		buttons.add(create);
		buttons.add(ok);
		
		JPanel form = new JPanel();
		form.setLayout(new GridLayout(3,1));
		form.add(nicknameP);
		form.add(passP);
		form.add(buttons);
		
		setLayout(new BorderLayout());
		add(logo,BorderLayout.CENTER);
		add(form,BorderLayout.SOUTH);
		
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
