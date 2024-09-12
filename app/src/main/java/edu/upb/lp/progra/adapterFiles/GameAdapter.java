package edu.upb.lp.progra.adapterFiles;

import edu.upb.lp.progra.ludayna.LudaynaConnector;
import edu.upb.lp.progra.overcooked.OvercookedConnector;

/**
 * This class allows to select what UI will be used by the Android library.
 * 
 * @author Alexis Marechal
 * @author Alfredo Villalba
 */
public class GameAdapter {
	public static AppConnector selectGame(AndroidLibrary gui) { return new OvercookedConnector(gui);
	}	
}
