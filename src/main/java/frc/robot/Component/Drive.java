package frc.robot.Component;

import frc.robot.Const.DriveConst;
import frc.robot.State.DriveState;

public class Drive extends Component{
    public Drive(){
        super(new DriveState(), new DriveConst());
    }

    @Override
    public void applyState() {

    }
}
