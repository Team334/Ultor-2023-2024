package frc.robot.utils;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import frc.robot.Constants;

/**
 * For configuring Falcons.
 */
public class TalonFXConfig {
    public static void configureFalcon(TalonFX falcon) {
        falcon.configFactoryDefault(Constants.CAN.CAN_TIMEOUT);
        falcon.configNeutralDeadband(0.01, Constants.CAN.CAN_TIMEOUT);
        falcon.setNeutralMode(NeutralMode.Brake);
    }

    /**
     * Configure a master Falcon motor.
     * 
     * @param falcon - The Falcon to config.
     * @param invert - Boolean for whether the Falcon should be inverted or not.
     */
    public static void configureDriveMasterFalcon(TalonFX falcon, boolean invert) {
        falcon.configFactoryDefault(Constants.CAN.CAN_TIMEOUT);
        falcon.configNeutralDeadband(0.01, Constants.CAN.CAN_TIMEOUT);
        falcon.setInverted(invert ? TalonFXInvertType.CounterClockwise : TalonFXInvertType.Clockwise);
        falcon.setNeutralMode(NeutralMode.Coast);
    }

    /**
     * Configure a slave of a master Falcon motor.
     * 
     * @param falcon - The slave motor to config.
     * @param master - The master motor.
     * @param invert - Boolean for whether the slave move inverted to the master.
     */
    public static void configureDriveFollowerFalcon(TalonFX falcon, TalonFX master, boolean invert) {
        falcon.configFactoryDefault(Constants.CAN.CAN_TIMEOUT);
        falcon.configNeutralDeadband(0.001, Constants.CAN.CAN_TIMEOUT);
        falcon.set(TalonFXControlMode.Follower, master.getDeviceID());
        falcon.setInverted(invert ? TalonFXInvertType.OpposeMaster : TalonFXInvertType.FollowMaster);
        falcon.setNeutralMode(NeutralMode.Coast);
    }
}
