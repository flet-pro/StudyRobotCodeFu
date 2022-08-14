package frc.robot;

import frc.robot.Component.*;

public class Mode {
    public static Modes mode;

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
