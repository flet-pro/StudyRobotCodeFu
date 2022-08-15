package frc.robot.Component;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Const.DriveConst;
import frc.robot.State.DriveState;
import frc.robot.State.DriveState.driveSpeeds;

public class Drive extends Component{
    public DriveState state;
    public DriveConst constant;
    WPI_TalonSRX driveRightFrontMotor, driveLeftFrontMotor;
    VictorSPX driveRightBackMotor, driveLeftBackMotor;
    DifferentialDrive drive;

    public Drive(){
        state = new DriveState();
        constant = new DriveConst();

        driveRightFrontMotor = new WPI_TalonSRX(0);
        driveLeftFrontMotor = new WPI_TalonSRX(2);
        driveRightBackMotor = new VictorSPX(1);
        driveLeftBackMotor = new VictorSPX(3);

        driveRightFrontMotor.setInverted(true);
        driveRightBackMotor.setInverted(true);
        driveLeftFrontMotor.setInverted(false);
        driveLeftBackMotor.setInverted(false);

        driveRightBackMotor.follow(driveRightFrontMotor);
        driveLeftBackMotor.follow(driveLeftFrontMotor);

        drive = new DifferentialDrive(driveLeftFrontMotor, driveRightFrontMotor);
    }

    @Override
    public void initState() {
        state.initState();
    }

    @Override
    public void resetState(){
        state.resetState();
    }

    @Override
    public void changeState(){
        if(controller.getRightTriggerAxis() > 0.8){
            state.driveSpeed = driveSpeeds.fast;
        }else if(controller.getLeftTriggerAxis() > 0.8){
            state.driveSpeed = driveSpeeds.slow;
        }else{
            state.driveSpeed = driveSpeeds.mid;
        }
    }

    @Override
    public void applyState() {
        double xSpeed = -1 * controller.getLeftY();
        double zRotation = controller.getRightX();
        switch (state.driveSpeed) {
            case mid:
                arcadeDrive(xSpeed * constant.defaultSpeed, zRotation * constant.defaultSpeed);
                break;

            case fast:
                arcadeDrive(xSpeed * constant.fastSpeed, zRotation * constant.fastSpeed);
                break;
            
            case slow:
                arcadeDrive(xSpeed * constant.slowSpeed, zRotation * constant.slowSpeed);
                break;
        }
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        drive.arcadeDrive(xSpeed, zRotation);
    }
}
