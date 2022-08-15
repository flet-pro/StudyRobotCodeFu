package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Component.*;

public class Mode {
    
    public Modes mode;
    public XboxController controller;

    public void addController(XboxController controller){
        this.controller = controller;
    }

    public static void changeMode() {
    }

    public enum Modes{
        Drive(new Drive()),
        Shoot(new Shoot()),
        Climb(new Climb());

        private Component Mode;

        private Modes(Component mode) {
            this.Mode = mode;
        }

        private void changeMode() {
            changeMode();
        }
    }
}
