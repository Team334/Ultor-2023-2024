// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.intake;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;

public class ActuatorCommand extends CommandBase {
  private final IntakeSubsystem _intakeSubsystem;
  private final PIDController _pid;

  private final boolean _retract;

  /** Creates a new ActuatorCommand. */
  public ActuatorCommand(IntakeSubsystem intakeSubsystem, boolean retract) {
    _intakeSubsystem = intakeSubsystem;
    _pid = new PIDController(0.1, 0, 0); // TODO: VALUES?
    _retract = retract;

    _pid.setTolerance(50); // TODO: VALUE?

    addRequirements(intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double setpoint;

    if (_retract) {
      setpoint = Constants.Encoder.INTAKE_RETRACTED;
    } else {
      setpoint = Constants.Encoder.INTAKE_EXTENDED;
    }

    double volts = _pid.calculate(_intakeSubsystem.getActuator(), setpoint);
    volts = MathUtil.clamp(volts, -0.5, 0.5);

    System.out.println(_intakeSubsystem.getActuator());

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
