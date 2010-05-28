package fr.uhp.nobrain.highscore;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.uhp.nobrain.friends.FriendsPersistance;
import fr.uhp.nobrain.mvc.Model;
import fr.uhp.nobrain.player.PlayerPersistance;
import fr.uhp.nobrain.tools.Context;
import fr.uhp.nobrain.tools.HibernateUtil;

public class HighScore extends Observable implements Model{
	
	private List<Score> scores;
	private HighScoreView view;

	public HighScore() {
		super();
	}

	public void addEntry(Score s) {
		scores.add(s);
	}

	public List<Score> getScores() {
		return scores;
	}

	public void setScores(List<Score> scores) {
		this.scores = scores;
	}

	public HighScoreView getGraphView() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public HighScoreView getTabView() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		
		Query q = s.createQuery("from Score");
		scores = q.list();
		
		try {
			for(Score f : scores)
				if(! FriendsPersistance.areFriends(Context.getCurrentPlayer(), PlayerPersistance.select(f.getPlayerId())))
					scores.remove(f);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		s.close();
		
		return new HighScoreView(this);
	}

	@Override
	public void attach(Observer o) {
		view = (HighScoreView) o;
		this.addObserver(o);
	}

	@Override
	public void detach(Observer o) {
		this.deleteObserver(o);
	}

	@Override
	public HighScoreView getView() {
		return getTabView();
	}

}
