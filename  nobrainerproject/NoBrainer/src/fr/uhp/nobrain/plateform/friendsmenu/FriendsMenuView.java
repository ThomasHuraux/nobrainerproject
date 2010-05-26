package fr.uhp.nobrain.plateform.friendsmenu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.mvc.View;

public class FriendsMenuView extends JPanel implements View{

	private static final long serialVersionUID = 1L;
	
	private Model model;


	private JButton friendButton;
	private JButton demandButton;
	private JButton invitationButton;
	private JButton returnButton;

	private JLabel logo;
	
	public void initialize(Model model){

		this.model = model;
		
		friendButton = new JButton("My friends");
		invitationButton = new JButton("Add friends");
		demandButton = new JButton("Demands");
		returnButton = new JButton("Return");
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(4,1));
		buttons.add(friendButton);
		buttons.add(invitationButton);
		buttons.add(demandButton);
		buttons.add(returnButton);
		
		String imgPath = ((FriendsMenu) model).getLogoPath();
		logo = new JLabel(new ImageIcon(imgPath));
		
		setLayout(new BorderLayout());
		add(logo,BorderLayout.CENTER);
		add(buttons,BorderLayout.SOUTH);

		model.attach(this);
		makeController();
	}

	public JButton getReturnButton() {
		return returnButton;
	}

	public JButton getDemandButton() {
		return demandButton;
	}

	public JButton getInvitationsButton() {
		return invitationButton;
	}

	public JButton getFriendButton() {
		return friendButton;
	}

	public void makeController() {
		FriendsMenuController mmc = new FriendsMenuController();
		mmc.initialize(model, this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}
