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

    WPI_VictorSPX ConveyorFrontSPX = null;
    WPI_VictorSPX ConveyorBackSPX = null;

    public Conveyor() {
        this.ConveyorBackSPX = new WPI_VictorSPX(RobotMap.CONVEYOR_BACK_MOTOR_ID);
        this.ConveyorFrontSPX = new WPI_VictorSPX(RobotMap.CONVEYOR_FRONT_MOTOR_ID);
    }

    public void move(boolean reverse) {
        if (reverse == false){
            this.ConveyorBackSPX.set(ControlMode.PercentOutput, RobotMap.CONVEYOR_BACK_SPEED);
            this.ConveyorFrontSPX.set(ControlMode.PercentOutput, RobotMap.CONVEYOR_FRONT_SPEED);
        } else {
            this.ConveyorBackSPX.set(ControlMode.PercentOutput, -1 * RobotMap.CONVEYOR_BACK_SPEED);
            this.ConveyorFrontSPX.set(ControlMode.PercentOutput, -1 * RobotMap.CONVEYOR_FRONT_SPEED);
        }
    }

    @Override
    protected void initDefaultCommand() {

    }
    public void stopMove() { // Kill motors.
        ConveyorBackSPX.set(ControlMode.PercentOutput, 0);
        ConveyorFrontSPX.set(ControlMode.PercentOutput, 0);
      }
}
