// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private TalonFX _left, _right;

  private final CANSparkMax _mag;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    _mag = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
  }

  public void setMag(double speed) {
    _mag.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
