package frc.robot;

import frc.robot.Component.*;

public class Control {
    public static Controllers controller;

    public static void changeMode() {
    }

    public enum Controllers{
        Drive(new Drive()),
        Shoot(new Shoot()),
        Climb(new Climb());

        private Component Controller;

        private Controllers(Component controller) {
            this.Controller = controller;
        }

        private void changeMode() {
            changeMode();
        }
    }
}