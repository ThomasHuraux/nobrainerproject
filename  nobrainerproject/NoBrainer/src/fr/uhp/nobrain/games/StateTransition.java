package fr.uhp.nobrain.games;

import java.util.ArrayList;


public interface StateTransition {

    public static final ArrayList<GameState> list = new ArrayList<GameState>();

    public void changeToState (GameState gameState);

}

