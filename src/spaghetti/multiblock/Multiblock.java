package spaghetti.multiblock;

import arc.struct.*;

import mindustry.world.*;
import mindustry.world.meta.*;
import static mindustry.Vars.*;

import java.util.function.*;

public class Multiblock extends Block{
    /** The functions to run on the nearby blocks
     *  to check whether the multiblock should be placed */
    public Seq<Predicate<Block>> construtableChecks = new Seq<>();

    public Multiblock(String name){
        super(name);
        this.buildVisibility = BuildVisibility.hidden;
    }

    public boolean testConstructable(int x, int y){
        for (int dx = x; dx <= x + this.size; dx++){
            for (int dy = y; dy <= y +this.size; dy++) {
            //Here we need to run the function that corresponds to the block,
            // on the block in the world and return false if the function itself does,
            // then, only when all of them have returned true, we return true
            if(!construtableChecks.get(dy * this.size + dx).test(world.build(dy, dx).block())) return false;
            }
        }
        return true;
    }
}
