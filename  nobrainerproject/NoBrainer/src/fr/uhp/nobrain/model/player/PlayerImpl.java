package fr.uhp.nobrain.model.player;

import com.google.inject.Inject;

public class PlayerImpl implements Player{
	String name="toto";

	public PlayerImpl() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
