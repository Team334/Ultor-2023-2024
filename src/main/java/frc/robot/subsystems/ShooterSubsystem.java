// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.utils.TalonFXConfig;

public class ShooterSubsystem extends SubsystemBase {
  private TalonFX _left, _right;


  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    _left = new TalonFX(RobotMap.SHOOTER_LEFT);
    _right = new TalonFX(RobotMap.SHOOTER_RIGHT);

    TalonFXConfig.configureFalcon(_left);
    TalonFXConfig.configureFalcon(_right);

    _right.setInverted(TalonFXInvertType.Clockwise);
    _left.setInverted(TalonFXInvertType.CounterClockwise);

   // _left.set(TalonFXControlMode.Follower, _right.getDeviceID());
    //_left.setInverted(TalonFXInvertType.OpposeMaster);
  }


  public void setShooter(double speed) {
    _left.set(TalonFXControlMode.PercentOutput, speed);
    _right.set(TalonFXControlMode.PercentOutput, speed);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
