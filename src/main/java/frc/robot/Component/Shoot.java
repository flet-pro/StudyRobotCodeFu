package frc.robot.Component;

import frc.robot.Const.ShootConst;
import frc.robot.State.ShootState;

public class Shoot extends Component{
    public Shoot() {
        super(new ShootState(), new ShootConst());
    }

    @Override
    public void applyState() {

    }
}
