// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenixpro.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.utils.TalonFXConfig;


public class IntakeSubsystem extends SubsystemBase {
  // drive: spin on actuator to bring ball in
  // actuator: extends from robot
  private WPI_TalonFX _drive, _actuator;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    _actuator = new WPI_TalonFX(RobotMap.INTAKE_ACTUATOR);
    _drive = new WPI_TalonFX(RobotMap.INTAKE_DRIVE);

    TalonFXConfig.configureFalcon(_actuator);
  }

  /**
   * Set drive intake speed for ball.
   * 
   * @param speed - The speed to set the drive intake.
   */
  public void setDriveIntake(double speed) {
    _drive.set(TalonFXControlMode.PercentOutput, speed);
  }

  /**
   * Set ball feed for shooter.
   * 
   * @param speed - The speed to set the feed.
   */
  public void setFeed(double speed) {
    
  }

  /**
   * Set the voltage of the actuator Falcon.
   * 
   * @param voltage - The voltage of the actuator Falcon.
   */
  public void setActuatorVoltage(double voltage) {
    _actuator.setVoltage(voltage);
  }

  /**
   * Get the encoder value of the actuator Falcon.
   */
  public double getActuator() {
    return _actuator.getSelectedSensorPosition();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println(getActuator());
  }
}
