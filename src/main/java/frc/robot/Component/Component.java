package frc.robot.Component;


import edu.wpi.first.wpilibj.XboxController;


public abstract class Component {
    public XboxController controller;

    public void addController(XboxController controller) {
        this.controller = controller;
    }

    /**
     * Robot.javaのinitで実行
     */
    public abstract void initState();

    /**
     * Stateをリセット
     */
    public abstract void resetState();

    /**
     * Stateを変える
     * controllerを元に
     */
    public abstract void changeState();

    /**
     * Stateを反映する
     */
    public abstract void applyState();
}
