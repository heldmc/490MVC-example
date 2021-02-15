package View;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.*;
import Model.*;




/**
 * This is the container for all the GUI components
 */


public class GUI extends JFrame implements ActionListener {
    ////////////
    // FIELDS //
    ////////////

    private JPanel GUIThreadSystemControl;  // a section to contain the System control information
    private JButton btnStartSystem;         // Button to start the system
    private JButton btnPauseSystem;         // Button to pause the system
    private JTextField txtFldSystemStatus;  // text field that displays if the system is running or pause
    private JScrollPane spProcessQueue;     // Scroll Pane to hold the process queue table
    private JTextArea txtAreaReportStats;   // a Text Area to show the reporting statistics
    private JPanel processingInfo;          // a section to contain the CPU processing information
    private JTextArea txtCPUprocessing;     // information about the CPU processing
    private JTable tblProcessQueue;         // table to hold the list of processes in the queue
    private JLabel lblSystemStatus;

//    private String strFldSystemStatus;
    private StringListener textListener;
    private SystemStartListener systemStartListener;
    //
 //   private Controller.StringListener changeListener;

    private SystemStatus systemStatus;

    /////////////
    // METHODS //
    /////////////

    // Creates the GUI and makes it visible
//    public GUI(Runnable runnable) { setVisible(true); }

  //  public Controller.ChangeListener sysStatuslistener;

    // Creates the GUI
 //   public GUI() {
    public GUI (SystemStatus systemStatus) { // throws HeadlessException{
  //      super("Thread Processing System");
   //     this.systemStatus = systemStatus;
 //   }

        JFrame GUIMainFrame = new JFrame("Thread Processing System");
        //       super("Thread Processing System");     // create a new window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when the upper x is clicked closed the window

        // ***************************************************************
        // Set up the panel for the system status
        // ***************************************************************
        JPanel GUIThreadSystemControl = new JPanel();

        // Create components that will be added to the panel
        btnStartSystem = new JButton("Start System");
        btnStartSystem.addActionListener(this) ;

        btnPauseSystem = new JButton("Pause System");
        btnPauseSystem.addActionListener(this) ;

        lblSystemStatus = new JLabel("System Status: ");

        txtFldSystemStatus = new JTextField(20);
        txtFldSystemStatus.setText(systemStatus.getRunningState());
        System.out.println(systemStatus.getRunningState());



        //ModuleLayer.Controller listener = new ChangeListener() {
        //    @Override
         //   public void stateChanged(ChangeEvent event,String newText) {
         //       txtFldSystemStatus.setText(newText);
         //   }
        //};

        /*
     //   ChangeListener listener = new ChangeListener({
    //        @Override
     //       public void stateChanged(ChangeEvent event) {
//
      //      }

       //     public void stateChange(ChageEvent event)
    //        {
   //             textArea.setText(systemStatus);
   //         }

    //    }
        */
        //   txtFldSystemStatus = (JTextField) getStringListener();
   //     txtFldSystemStatus.setText(strFldSystemStatus);


        // Add the components to the GUIThreadSystemControl panel
        GUIThreadSystemControl.add (btnStartSystem) ;
        GUIThreadSystemControl.add (btnPauseSystem);
        GUIThreadSystemControl.add(lblSystemStatus);
        GUIThreadSystemControl.add (txtFldSystemStatus);


        // ***************************************************************
        // End of setting up the system status panel
        // ***************************************************************

        // ***************************************************************
        // Set up the form panel for the process queue
        // ***************************************************************

        // Data to be displayed in the Process Queue table
        String[][] processQueueValues ={
                {"Process A","10"},
                {"Process B", "4"},
                {"Process C","14"}
        };

        // Column names for the Process Queue table
        String[] columnsName = {"Process Name","Service Time"};

        // Initialize the table
        tblProcessQueue = new JTable(processQueueValues,columnsName);
        // tblProcessQueue.setBounds(30,40,200,200);

        // Add to the scroll panel that holds the table
        Border blackline = BorderFactory.createTitledBorder("Waiting Process Queue");
        JScrollPane spProcessQueue = new JScrollPane(tblProcessQueue);
        spProcessQueue.setBorder(blackline);

        // ***************************************************************
        // End of setting up the Process Queue scroll panel
        // ***************************************************************

        // ***************************************************************
        // Set up the panel for processing information
        // ***************************************************************

        processingInfo = new JPanel();
        processingInfo.setPreferredSize(new Dimension(200,200));
        txtCPUprocessing = new JTextArea();

        txtCPUprocessing.append("CPU 1\n");
        txtCPUprocessing.append("exec: Process A\n");
        txtCPUprocessing.append("time remaining = a\n");
        txtCPUprocessing.setBackground(Color.orange);

        int numMsecs = 100;
        String processBoaderString = "1 time unit = " + numMsecs + "ms";
        Border processBoarder = BorderFactory.createTitledBorder(processBoaderString);
        processingInfo.setBorder(processBoarder);
        processingInfo.add(txtCPUprocessing);

        // ***************************************************************
        // End of setting up the panel for processing information
        // ***************************************************************

        // ***************************************************************
        // Set up the text area  for the Report Statistics area
        // ***************************************************************

        txtAreaReportStats = new JTextArea("Use this area to show system report stats");

        // ***************************************************************
        // End of setting up the Report Statistics area
        // ***************************************************************

        // ***************************************************************
        // End of setting up the form panel for the process queue
        // ***************************************************************

        BorderLayout layout = new BorderLayout(10,10);
        GUIMainFrame.setLayout(layout);
        GUIMainFrame.add(GUIThreadSystemControl,BorderLayout.NORTH);    // Place at the top of the form
        GUIMainFrame.add(spProcessQueue,BorderLayout.LINE_START);       // Place the table at the center left of the form
        GUIMainFrame.add(processingInfo,BorderLayout.LINE_END);         // Place the processing information at the center right of the form
        GUIMainFrame.add(txtAreaReportStats,BorderLayout.SOUTH);        // Place the report status at the bottom of the form

        GUIMainFrame.pack();            // Size the window
        GUIMainFrame.setVisible(true);  // Display the frame
    }



    /**
     * Method to set the txtFldSystemStatus
     * @param systemStatus a String
     */
 //   public void setSystemStatus(String systemStatus){
 //       strFldSystemStatus = systemStatus;
 //       txtFldSystemStatus.setText(systemStatus.getRunningState());
 //   }


    /**
     * Method to get the value of  the stringListener
     */
    public StringListener getStringListener(){
        return this.textListener;
    }

    public void setStringListener(StringListener listener){
        this.textListener = listener;
    }


    /**
     * Method to handle any event
     * @param e an event action has taken place
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == btnStartSystem ){
            //         Main.pause = false;
            txtFldSystemStatus.setText("System is Running");

            if(systemStartListener !=null){
                systemStartListener.startSystem();
            }
        }
        else if (clicked == btnPauseSystem){
            //         Main.pause = true;
            txtFldSystemStatus.setText("System is Paused");
        }
    } // end of actionPerformed

 public void addItem(String strText){
  //      ChangeEvent event = new ChangeEvent(this);
 //       changeListener.stateChanged(event, strText);
     System.out.println(strText);
    } // end of addItem

    public void setSystemStart(SystemStartListener systemStartListener) {
        this.systemStartListener = systemStartListener;

    }
}
