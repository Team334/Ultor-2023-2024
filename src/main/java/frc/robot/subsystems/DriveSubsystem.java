// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;
import frc.robot.utils.TalonFXConfig;

public class DriveSubsystem extends SubsystemBase {
  // left and right 1s are WPI_TalonFX to work with WPI DifferentialDrive class
  private final WPI_TalonFX _left1;
  private final TalonFX _left2;
  private final TalonFX _left3;
  private final WPI_TalonFX _right1;
  private final TalonFX _right2;
  private final TalonFX _right3;

  private final DifferentialDrive _drive;

  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    _left1 = new WPI_TalonFX(RobotMap.DRIVE_LEFT_1);
    _left2 = new TalonFX(RobotMap.DRIVE_LEFT_2);
    _left3 = new TalonFX(RobotMap.DRIVE_LEFT_3);

    _right1 = new WPI_TalonFX(RobotMap.DRIVE_RIGHT_1);
    _right2 = new TalonFX(RobotMap.DRIVE_RIGHT_2);
    _right3 = new TalonFX(RobotMap.DRIVE_RIGHT_3);

    TalonFXConfig.configureDriveMasterFalcon(_left1, false);
    TalonFXConfig.configureDriveFollowerFalcon(_left2, _left1, false);
    TalonFXConfig.configureDriveFollowerFalcon(_left3, _left1, false);

    TalonFXConfig.configureDriveMasterFalcon(_right1, true);
    TalonFXConfig.configureDriveFollowerFalcon(_right2, _right1, false);
    TalonFXConfig.configureDriveFollowerFalcon(_right3, _right1, false);

    _drive = new DifferentialDrive((WPI_TalonFX) _left1, (WPI_TalonFX) _right1);
  }

  /**
   * Tank drive.
   * 
   * @param leftSpeed - Left side speed (JOYSTICK INPUT).
   * @param rightSpeed - Right side speed (JOYSTICK INPUT).
   */
  public void tank(double leftSpeed, double rightSpeed) {
    _left1.set(TalonFXControlMode.PercentOutput, -1 * leftSpeed * Constants.Speed.TANK_DRIVE_COEFF);
    _right1.set(TalonFXControlMode.PercentOutput, -1 * rightSpeed * Constants.Speed.TANK_DRIVE_COEFF);
  }

  /**
   * Arcade drive.
   * 
   * @param xSpeed - X axis speed (JOYSTICK INPUT).
   * @param zRotation - Z rotation speed (JOYSTICK INPUT).
   */
  public void arcade(double xSpeed, double zRotation) {
    _drive.arcadeDrive(
      -1 * xSpeed * Constants.Speed.ARCADE_DRIVE_COEFF,
      -1 * zRotation * Constants.Speed.ARCADE_DRIVE_COEFF
    );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
