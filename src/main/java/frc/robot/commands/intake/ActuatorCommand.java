// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class ActuatorCommand extends CommandBase {
  private final IntakeSubsystem _intakeSubsystem;
  private final PIDController _pid;

  /** Creates a new ActuatorCommand. */
  public ActuatorCommand(IntakeSubsystem intakeSubsystem) {
    _intakeSubsystem = intakeSubsystem;
    _pid = new PIDController(0, 0, 0); // TODO: VALUES?

    _pid.setTolerance(0); // TODO: VALUE?

    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double volts = _pid.calculate(0); // TODO: VALUE?
    volts = MathUtil.clamp(volts, 0, 0); // TODO: VALUES?

    _intakeSubsystem.setActuatorVoltage(volts);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    _intakeSubsystem.setActuatorVoltage(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _pid.atSetpoint();
  }
}
