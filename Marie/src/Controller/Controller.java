package Controller;

import Model.SystemStatus;
import View.GUI;
import View.SystemStartListener;

// import javax.swing.text.View;

public class Controller implements SystemStartListener {
    private GUI gui;
    private SystemStatus systemStatus;

    public Controller( SystemStatus systemStatus, GUI gui){

        this.gui = gui;
        this.systemStatus = systemStatus;
    }


    @Override
    public void startSystem() {
        System.out.println("Start system event was received");
    }
}
