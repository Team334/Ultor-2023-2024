// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class FeedCommand extends CommandBase {
  private final IntakeSubsystem _intakeSubsystem;
  private final boolean _feedIn;

  /** Creates a new FeedCommand. */
  public FeedCommand(IntakeSubsystem intakeSubsystem, boolean feedIn) {
    // Use addRequirements() here to declare subsystem dependencies.
    _intakeSubsystem = intakeSubsystem;
    _feedIn = feedIn;

    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (_feedIn) {
      _intakeSubsystem.setMag(-0.1);
      _intakeSubsystem.setFeed(-0.16);
      _intakeSubsystem.setDriveIntake(0.2);
    } else {
      _intakeSubsystem.setMag(0.1);
      _intakeSubsystem.setFeed(0.16);
      _intakeSubsystem.setDriveIntake(-0.2);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    _intakeSubsystem.setMag(0);
    _intakeSubsystem.setFeed(0);
    _intakeSubsystem.setDriveIntake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
