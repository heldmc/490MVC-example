package Model;

public class SystemStatus {

    private String runningState;  // indicates if the system is paused or running

    public SystemStatus(){
        this.runningState = null;
    }

    public void setRunningState(String inpRunningState) {
        this.runningState = inpRunningState;
    }

    public String getRunningState(){
        return this.runningState;
    }
}
