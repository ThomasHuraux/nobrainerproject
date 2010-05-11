package fr.uhp.nobrain.games;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.net.URLClassLoader;


public class GameStateLoader {
	
	private static final boolean printTrace = true;
	private static final String conf = "games/conf.txt";
	
	@SuppressWarnings("deprecation")
	public void load(){
		
		try {
			FileReader fr = new FileReader(conf);
			BufferedReader br = new BufferedReader(fr);
			String current;
			while((current=br.readLine()) != null){
				String[] field = current.split("\t");
				
				if(printTrace)
					System.out.print("Try to load "+field[1]+" in "+field[0]+" ... ");
					
				URL url[] = new URL[1]; 
				url[0] = (new File(field[0])).toURL(); 
				URLClassLoader loader = new URLClassLoader(url); 
				Object o = loader.loadClass(field[1]).newInstance(); 
				StateTransition.list.add((GameState)o);
				
				if(printTrace)
					System.out.println("SUCCESS");
				
			}
			br.close();	
		}catch (Exception ex) {
			if(printTrace)
				System.out.println("ECHEC :");
			ex.printStackTrace();
		}
	}

}
