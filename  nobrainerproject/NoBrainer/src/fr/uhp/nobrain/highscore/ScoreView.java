package fr.uhp.nobrain.highscore;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.uhp.nobrain.tools.Observateur;


public class ScoreView {

	private static final long serialVersionUID = 1L;
	private JLabel label = new JLabel();
	private Score score;
	private JPanel panel;
	
	public ScoreView(Score hs){
		this.panel = new JPanel();
		this.score = hs;

		this.score.addObservateur(new Observateur(){
			public void update(String o) {
				label.setText(o);
			}
		});
		
		Font police = new Font("DS-digital", Font.TYPE1_FONT, 10);
		this.label.setFont(police);
		this.label.setHorizontalAlignment(JLabel.NORTH_EAST);
		this.panel.add(label);		
	}
	
	public JPanel getPanel() {
		return panel;
	}
}
