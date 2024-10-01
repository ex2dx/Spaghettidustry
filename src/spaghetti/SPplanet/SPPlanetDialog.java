package spaghetti.SPplanet;

import arc.scene.event.*;
import mindustry.ui.dialogs.*;

public class SPPlanetDialog extends PlanetDialog {
    /**Class for a custom planet dialog without max zoom*/
    public SPPlanetDialog(){
        super();
        //Super hacky, but only way I found to remove the scroll listener
        this.getListeners().remove(3);
        this.addListener(new InputListener() {
            public boolean scrolled(InputEvent event, float x, float y, float amountX, float amountY) {
                if (event.targetActor == SPPlanetDialog.this) {
                    SPPlanetDialog.this.zoom = SPPlanetDialog.this.zoom + amountY / 10.0F;
                }

                return true;
            }
        });
    }
}
