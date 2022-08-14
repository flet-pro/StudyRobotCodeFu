package frc.robot.Component;

import frc.robot.Const.Const;
import frc.robot.State.State;

public abstract class Component {
    public State state;
    public Const constant;

    public Component(State state, Const constant){
        this.state = state;
        this.constant = constant;
    }

    public abstract void applyState();
}
