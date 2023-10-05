// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.utils.TalonFXConfig;

public class DriveSubsystem extends SubsystemBase {
  private final TalonFX left1;
  private final TalonFX left2;
  private final TalonFX left3;
  private final TalonFX right1;
  private final TalonFX right2;
  private final TalonFX right3;


  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    left1 = new TalonFX(RobotMap.DRIVE_LEFT_1);
    left2 = new TalonFX(RobotMap.DRIVE_LEFT_2);
    left3 = new TalonFX(RobotMap.DRIVE_LEFT_3);

    right1 = new TalonFX(RobotMap.DRIVE_RIGHT_1);
    right2 = new TalonFX(RobotMap.DRIVE_RIGHT_2);
    right3 = new TalonFX(RobotMap.DRIVE_RIGHT_3);

    TalonFXConfig.configureDriveMasterFalcon(left1, false);
    TalonFXConfig.configureDriveFollowerFalcon(left2, left1, false);
    TalonFXConfig.configureDriveFollowerFalcon(left3, left1, false);

    TalonFXConfig.configureDriveMasterFalcon(right1, true);
    TalonFXConfig.configureDriveFollowerFalcon(right2, right1, false);
    TalonFXConfig.configureDriveFollowerFalcon(right3, right1, false);
  }

  /**
   * Tank drive.
   * 
   * @param leftSpeed - Left side speed.
   * @param rightSpeed - Right side speed.
   */
  public void tank(double leftSpeed, double rightSpeed) {
    left1.set(TalonFXControlMode.PercentOutput, -1 * leftSpeed * Constants.Speed.DRIVE_COEFF);
    right1.set(TalonFXControlMode.PercentOutput, -1 * rightSpeed * Constants.Speed.DRIVE_COEFF);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
