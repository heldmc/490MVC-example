import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.text.BoxView;
import javax.swing.text.View;

import Controller.*;
import Model.SystemStatus;
import View.*;



public class Main {

    public static void main(String[] args) {

  //      ChangeListener changeListener = new ChangeListener() {
  //          @Override
  //          public void stateChanged(ChangeEvent event, String newText) {

  //          }
   //     }



        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                runApp();
 //              View.GUI JFrame = new GUI();
 //               ChangeEvent event;
//                event = new ChangeEvent(this);
            } // end of run
        }); // end of invoking swing

  //     System.out.println("Processor is booting up...\n");
   //     changeListener.stateChanged(event, "Processor is booting up...");

    }
     public static void runApp(){
        SystemStatus systemStatus = new SystemStatus();

        systemStatus.setRunningState("Processor is booting up...");

        System.out.println(systemStatus.getRunningState());

        GUI gui = new GUI(systemStatus); // passing model to the view

         Controller controller = new Controller(systemStatus, gui);

         gui.setSystemStart(controller);

     }
}
