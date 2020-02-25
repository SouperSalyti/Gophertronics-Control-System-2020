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
//import frc.robot.commands.Harvest;

/**
 * Add your docs here.
 */
public class Harvester extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    WPI_VictorSPX HarvesterSPX = null;

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public Harvester() {
        this.HarvesterSPX = new WPI_VictorSPX(RobotMap.HARVESTER_MOTOR_ID);
    }

    public void move(double HarvestSpeed) {
        this.HarvesterSPX.set(ControlMode.PercentOutput, HarvestSpeed);
    }    
    public void stopMove() { // Kill motors.
        HarvesterSPX.set(ControlMode.PercentOutput, 0);
    }
}
