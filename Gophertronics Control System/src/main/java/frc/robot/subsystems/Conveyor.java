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

    WPI_VictorSPX ConveyorSPX = null;

    public Conveyor() {
        this.ConveyorSPX = new WPI_VictorSPX(RobotMap.CONVEYOR_MOTOR_ID);
    }

    public void move(boolean reverse) {
        if (reverse == false){
            this.ConveyorSPX.set(ControlMode.PercentOutput, RobotMap.CONVEYOR_SPEED);
        } else {
            this.ConveyorSPX.set(ControlMode.PercentOutput, -1 * RobotMap.CONVEYOR_SPEED);
        }
    }

    @Override
    protected void initDefaultCommand() {

    }
    public void stopMove() { // Kill motors.
        ConveyorSPX.set(ControlMode.PercentOutput, 0);
    }
}
