package frc.robot.Component;

import frc.robot.Const.ClimbConst;
import frc.robot.State.ClimbState;

public class Climb extends Component{
    public Climb(){
        super(new ClimbState(), new ClimbConst());
    }

    @Override
    public void applyState(){

    }
}
