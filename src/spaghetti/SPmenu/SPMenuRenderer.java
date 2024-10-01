package spaghetti.SPmenu;

import arc.*;
import arc.input.KeyCode;
import arc.math.Mat;
import arc.math.Mathf;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.EventType;
import mindustry.graphics.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;

import static mindustry.Vars.*;

public class SPMenuRenderer extends MenuRenderer implements PlanetRenderer.PlanetInterfaceRenderer {
    PlanetRenderer planets;
    PlanetParams state;

    public SPMenuRenderer(){
        super();
        this.planets = renderer.planets;
        this.state = new PlanetParams();
        this.state.renderer = this;
        this.state.drawUi = true;
	//TODO : change planets (at runtime?)
        this.state.planet = (Planet) content.getByName(ContentType.planet, Core.settings.getString("lastplanet", "serpulo"));
        if (this.state.planet == null) {
            this.state.planet = Planets.serpulo;
        }
    }

    @Override
    public void render(){
        planets.render(state);
	//TODO move camera around        
	/*if(Core.input.keyTap(KeyCode.mouseLeft)){
            state.camPos
            .mul(new Mat()
            .translate(
                Mathf.sin(System.currentTimeMillis()),
                Mathf.cos(System.currentTimeMillis()))
            .rotate(Mathf.sin(System.currentTimeMillis())));
        };*/
    }

    @Override
    public void renderSectors(Planet planet) {

    }

    @Override
    public void renderProjections(Planet planet) {

    }
}
