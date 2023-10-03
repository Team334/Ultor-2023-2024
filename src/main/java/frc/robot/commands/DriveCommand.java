// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  private DriveSubsystem _driveSubsystem;

  private DoubleSupplier _getLeft;
  private DoubleSupplier _getRight;

  /** Creates a new DriveCommand. This command is used for teleop driving. */
  public DriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier getLeft, DoubleSupplier getRight) {
    _driveSubsystem = driveSubsystem;
    _getLeft = getLeft;
    _getRight = getRight;

    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _driveSubsystem.tank(
      _getLeft.getAsDouble(),
      _getRight.getAsDouble()
    );
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
