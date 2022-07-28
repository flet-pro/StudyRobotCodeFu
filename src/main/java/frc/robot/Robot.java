// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  XboxController controller;
  WPI_TalonSRX driveRightFrontMotor, driveLeftFrontMotor;
  VictorSPX driveRightBackMotor, driveLeftBackMotor;
  DifferentialDrive drive;

  @Override
  public void robotInit() {
    controller = new XboxController(0);
    driveRightFrontMotor = new WPI_TalonSRX(0);
    driveLeftFrontMotor = new WPI_TalonSRX(2);
    driveRightBackMotor = new VictorSPX(1);
    driveLeftBackMotor = new VictorSPX(3);

    driveRightBackMotor.follow(driveRightFrontMotor);
    driveLeftBackMotor.follow(driveLeftFrontMotor);

    drive = new DifferentialDrive(driveLeftFrontMotor, driveRightFrontMotor);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(-controller.getLeftY(), controller.getLeftX());
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
