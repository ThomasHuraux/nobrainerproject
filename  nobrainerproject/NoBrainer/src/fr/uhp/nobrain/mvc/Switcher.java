package fr.uhp.nobrain.mvc;

import javax.swing.JFrame;

public class Switcher{
	
	private static JFrame context;
	
	@SuppressWarnings("static-access")
	private Switcher(JFrame context){
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

}
