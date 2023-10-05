// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeSubsystem extends SubsystemBase {
  // drive: spin on actuator to bring ball in
  // actuator: extends from robot
  private TalonFX _drive, _actuator;

  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {
    
  }

  /**
   * Set intake speed for ball.
   * 
   * @param speed The speed to set the intake.
   */
  public void setIntake(double speed) {

  }

  /**
   * Set the speed of the actuator motor.
   * 
   * @param speed The speed of the actuator motor.
   */
  public void setActuator(double speed) {
  }

  /**
   * Get the encoder value of the actuator motor.
   */
  public double getActuator() {
    return 0.0;  
  }

  /**
   * Set ball feed for shooter.
   * 
   * @param speed The speed to set the feed.
   */
  public void setFeed(double speed) {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // System.out.println(getActuator());
  }
}
