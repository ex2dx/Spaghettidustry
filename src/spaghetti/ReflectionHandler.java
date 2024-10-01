package spaghetti;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.ui.fragments.*;
import spaghetti.SPmenu.*;
import spaghetti.SPplanet.*;

import static mindustry.Vars.*;

public class ReflectionHandler {
    //TODO : make settings for this
    //TODO : dry this, it is too wet
    public static void init(){
        Events.on(EventType.ClientLoadEvent.class, e -> {
            try {
		//TODO : this doesn't even work
                Reflect.set(Vars.class, Vars.class, "planet", new SPPlanetDialog());
            } catch (Exception ex){
                Log.err("Failed to load custom planet dialog", ex);
            }
            try {
                Reflect.set(MenuFragment.class, ui.menufrag, "renderer", new SPMenuRenderer());
            } catch (Exception ex){
                Log.err("Failed to load custom menu fragment", ex);
            }
        });
    }
}
