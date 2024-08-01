package spaghetti.multiblock;

import arc.Events;

import arc.struct.*;
import mindustry.game.*;
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
    private void testPlaceable(Building b, Multiblock m) {
        //TODO
    }
     /** Used to initialize this multiblock manager */
    public void init(){
        //TODO
        Events.on(EventType.BlockBuildEndEvent.class, e ->{});
    }
}
