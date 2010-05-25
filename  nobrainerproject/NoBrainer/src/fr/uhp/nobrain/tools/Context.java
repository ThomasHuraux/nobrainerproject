package fr.uhp.nobrain.tools;

import javax.swing.JFrame;

import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.player.Player;

public class Context{
	
	private static Player current;
	private static JFrame context;
	
	@SuppressWarnings("static-access")
	private Context(JFrame context){
		this.context = context;
	}
	
	public static void create(){
		if(getContext()==null)
			context = new JFrame();
	}
	
	public static void change(Model m){
		context.setContentPane(m.getView());
		context.setVisible(true);
		context.pack();
	}

	public static JFrame getContext() {
		return context;
	}

	public static Player getCurrentPlayer() {
		return current;
	}

	public static void setCurrentPlayer(Player current) {
		Context.current = current;
	}
	
	

}
