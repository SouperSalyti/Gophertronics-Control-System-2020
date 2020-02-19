/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ColorwheelSpininator extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    DigitalInput ColorwheelUpperLimit = null;
    WPI_VictorSPX ColorwheelTurningMotorSPX = null;
    WPI_VictorSPX ColorwheelElevatorMotorSPX = null;

    public ColorwheelSpininator(){
        this.ColorwheelTurningMotorSPX = new WPI_VictorSPX(RobotMap.COLORWHEEL_TURNER_ID);
        this.ColorwheelElevatorMotorSPX = new WPI_VictorSPX(RobotMap.COLORWHEEL_ELEVATOR_ID);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void Elevate(double elevationSpeed, boolean goingUp) {
        this.ColorwheelElevatorMotorSPX.set(ControlMode.PercentOutput, -1 * elevationSpeed);
    }

    public void stopElevating(){

    }

    public void Spin(double spinSpeed, boolean direction) {

    }

    public void stopSpinning(){
        
    }
}
