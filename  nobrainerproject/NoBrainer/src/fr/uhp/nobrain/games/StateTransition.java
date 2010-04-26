package fr.uhp.nobrain.games;

import java.util.ArrayList;
import java.util.List;


public interface StateTransition {

    public static final List list = new ArrayList<GameState>();

    public void changeToState (GameState gameState);

}

