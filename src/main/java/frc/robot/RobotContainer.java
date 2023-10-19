// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.drive.DriveCommand;
import frc.robot.commands.intake.FeedCommand;
import frc.robot.commands.intake.IntakeCommand;
import frc.robot.commands.shooter.ShooterCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem _driveSubsystem = new DriveSubsystem();
  private final IntakeSubsystem _intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem _shooterSubsystem = new ShooterSubsystem();

  private final RobotCtrl _robotCtrl = new RobotCtrl();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();

    // _driveSubsystem.setDefaultCommand(new DriveCommand(
    //   _driveSubsystem,
    //   _robotCtrl :: driveLeftY,
    //   _robotCtrl :: driveRightX,
    //   true
    // ));
  }

  private void configureBindings() {
    _robotCtrl.driveController.cross().onTrue(
      new IntakeCommand(_intakeSubsystem, false)
    ).onFalse(
      new IntakeCommand(_intakeSubsystem, true)
    );

    _robotCtrl.driveController.L1().whileTrue(
      new FeedCommand(_intakeSubsystem, false)
    );

    _robotCtrl.driveController.R1().whileTrue(
      new FeedCommand(_intakeSubsystem, true)
    );

    _robotCtrl.driveController.R2().whileTrue(
      new ShooterCommand(_shooterSubsystem)
    );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
