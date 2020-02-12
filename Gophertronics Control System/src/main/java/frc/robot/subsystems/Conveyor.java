/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Conveyor extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    WPI_VictorSPX ConveyorFrontArmSPX = null;
    WPI_VictorSPX ConveyorBackArmSPX = null;

    public Conveyor() {
        this.ConveyorBackArmSPX = new WPI_VictorSPX(RobotMap.CONVEYOR_BACK_MOTOR_ID);
        this.ConveyorFrontArmSPX = new WPI_VictorSPX(RobotMap.CONVEYOR_FRONT_MOTOR_ID);
    }

    public void move(double moveSpeed) {
        this.ConveyorBackArmSPX.set(ControlMode.PercentOutput, RobotMap.CONVEYOR_SPEED);
        this.ConveyorFrontArmSPX.set(ControlMode.PercentOutput, RobotMap.CONVEYOR_SPEED);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
