package spaghetti.multiblock;

import arc.Events;
import arc.math.geom.*;
import arc.struct.*;

import mindustry.game.*;
import mindustry.world.*;
import mindustry.gen.*;

//TODO implement some interface to do this
public class MultiblockStaticManager {
    /** The multiblocks this class handles */
    public Seq<Multiblock> children = new Seq<>();

    public MultiblockStaticManager(Multiblock[] array){
        this.children = new Seq<>(array);
    }

    public void addChild(Multiblock m){
        children.add(m);
    }

    public void addChildren(Multiblock[] m){
        children.add(m);
    }

    /** Test whether there is any way to place a multiblock on top of a certain building */
    public Point2 testPlaceable(Block block, Multiblock m){
        Building building = block.newBuilding();
        boolean[][] validPositions = new boolean[m.size][m.size];
        for (int dx = (int) building.x - m.size; dx <= building.x; dx++) {
            for (int dy = (int) building.y - m.size; dy <= building.y; dy++) {
                if(m.construtableChecks.get(dy * m.size + dx).test(block)) validPositions[dx][dy] = true;
            }
        }
        for (int dx = (int) building.x - m.size; dx <= building.x; dx++) {
            for (int dy = (int) building.y - m.size; dy <= building.y; dy++) {
                if(validPositions[dx][dy]) if(m.testConstructable(dx, dy)) return new Point2(dx, dy);
            }
        }
        throw new RuntimeException("Couldn't find any way to place a multiblock above this block");
    }

    /** Used to initialize this multiblock manager */
    public void init(){
        //TODO finish this without blowing up the call stack
        Events.on(EventType.BlockBuildEndEvent.class, e ->{
            //TODO figure out how to place buildings, or whatever the class was named
            for (Multiblock m : children) testPlaceable(e.tile.block(), m);
        });
    }
}
