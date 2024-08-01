package spaghetti.multiblock;

import arc.struct.*;

import mindustry.gen.Building;
import mindustry.world.*;
import mindustry.world.meta.*;
import static mindustry.Vars.*;

import java.util.function.*;

public class Multiblock extends Block{
    /** The functions to run on the nearby blocks
     *  to check whether the multiblock should be placed */
    public Seq<Predicate<Building>> construtableChecks = new Seq<>();

    public Multiblock(String name){
        super(name);
        this.buildVisibility = BuildVisibility.hidden;
    }

    public boolean checkConstructable(int x, int y){
        for (int dx = x; dx <= x + this.size; dx++){
            for (int dy = x; dy <= y +this.size; dy++) {
            //Here we need to run the function that corresponds to the building,
            // on the building in the world and return false if the function itself does,
            // then, only when all of them have returned true, we return true
            if(!construtableChecks.get(dy * this.size + dx).test(world.build(dy, dx))) return false;
            }
        }
        return true;
    }
}
