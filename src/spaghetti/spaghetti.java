package spaghetti;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class spaghetti extends Mod{

    public spaghetti(){
        Log.info("Loaded ExampleJavaMod constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Mod in development");
                dialog.cont.add(
                        "The mod \"SpaghettiDustry\" is in very early development and may not be very good or balanced.\n" +
                        "If you have a suggestion or find a bug go to the mod's GitHub and submit an issue.\n" +
                        "\n" +
                        "Thank you for playing and I hope you enjoy my mod.\n"
                ).row();
                dialog.cont.image(Core.atlas.find("spaghetti-frog")).pad(20f).row();
                dialog.cont.button("Why is there a frog", dialog::hide).size(100f, 75f);
                dialog.show();

            });
        });
    }

    @Override
    public void loadContent(){

    }

}
