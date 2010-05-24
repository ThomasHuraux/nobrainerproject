
package fr.uhp.nobrain.tools;

public interface Observable {
        public void addObservateur(Observateur obs);
        public void updateObservateur();
        public void delObservateur();
}