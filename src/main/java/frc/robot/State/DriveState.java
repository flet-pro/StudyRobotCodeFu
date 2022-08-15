package frc.robot.State;

public class DriveState extends State{

    public driveSpeeds driveSpeed;
    
    @Override
    public void initState(){
        driveSpeed = driveSpeeds.mid;
    }

    @Override
    public void resetState(){
        driveSpeed = driveSpeeds.mid;
    }

    public enum driveSpeeds {
        fast,
        mid,
        slow;
    }
}
