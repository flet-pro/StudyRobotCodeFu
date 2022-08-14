// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.nio.channels.NonReadableChannelException;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
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
  WPI_TalonSRX controlIntakeBelt;
  VictorSPX driveRightBackMotor, driveLeftBackMotor;
  VictorSPX controlIntakeRoller;
  CANSparkMax controlShootingMotor;
  DifferentialDrive drive;
  Solenoid controlIntakeSolenoid;
  Solenoid controlFirstLockSolenoid;
  Solenoid controlSecondLockSolenoid;

  private double beltSpeed = 0.0;
  private double rollerSpeed = 0.0;
  private boolean isIntakeOpened = false;
  private boolean isClimbSolenoidLocked = true;
  private double shootingMotorSpeed = 0.0;


  @Override
  public void robotInit() {
    controller = new XboxController(0);

    driveRightFrontMotor = new WPI_TalonSRX(0);
    driveLeftFrontMotor = new WPI_TalonSRX(2);
    driveRightBackMotor = new VictorSPX(1);
    driveLeftBackMotor = new VictorSPX(3);

    driveRightFrontMotor.setInverted(true);
    driveRightBackMotor.setInverted(true);
    driveRightBackMotor.follow(driveRightFrontMotor);
    driveLeftBackMotor.follow(driveLeftFrontMotor);

    drive = new DifferentialDrive(driveLeftFrontMotor, driveRightFrontMotor);

    controlIntakeRoller = new VictorSPX(5);
    controlIntakeBelt = new WPI_TalonSRX(4);

    controlShootingMotor = new CANSparkMax(6, MotorType.kBrushless);

    controlIntakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 3);
    controlFirstLockSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
    controlSecondLockSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(-controller.getLeftY(), controller.getLeftX());

    rollerSpeed = controller.getLeftTriggerAxis();
    beltSpeed = controller.getRightTriggerAxis();

    controlIntakeRoller.set(ControlMode.PercentOutput, rollerSpeed);
    controlIntakeBelt.set(ControlMode.PercentOutput, beltSpeed);

    if (controller.getXButtonPressed()) {
      isIntakeOpened = !isIntakeOpened;
    }

    if (controller.getBButtonPressed()) {
      isClimbSolenoidLocked = !isClimbSolenoidLocked;
    }

    controlIntakeSolenoid.set(isIntakeOpened);
    controlFirstLockSolenoid.set(isClimbSolenoidLocked);
    controlSecondLockSolenoid.set(isClimbSolenoidLocked);

    if (controller.getAButtonPressed()) {
      shootingMotorSpeed = 1.0;
    }else if (controller.getYButtonPressed()) {
      shootingMotorSpeed = 0.0;
    }

    controlShootingMotor.set(shootingMotorSpeed);
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
