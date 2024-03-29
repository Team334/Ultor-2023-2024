// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  private final DriveSubsystem _driveSubsystem;

  private final DoubleSupplier _getLeft;
  private final DoubleSupplier _getRight;

  private final boolean _arcade;

  /** Creates a new DriveCommand. This command is used for either tank or arcade teleop driving. */
  public DriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier getLeft, DoubleSupplier getRight, boolean arcade) {
    _driveSubsystem = driveSubsystem;

    _getLeft = getLeft;
    _getRight = getRight;

    _arcade = arcade;

    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (_arcade) {
      _driveSubsystem.arcade(
        _getLeft.getAsDouble(),
        _getRight.getAsDouble()
      );
    }
    
    else {
      _driveSubsystem.tank(
        _getLeft.getAsDouble(),
        _getRight.getAsDouble()
      );
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
