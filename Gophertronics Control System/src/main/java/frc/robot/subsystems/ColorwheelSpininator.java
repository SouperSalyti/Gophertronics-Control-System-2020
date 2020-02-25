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
import frc.robot.commands.ColorwheelVate;

/**
 * Add your docs here.
 */
public class ColorwheelSpininator extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    DigitalInput ColorwheelUpperLimit = null;
    DigitalInput ColorwheelLowerLimit = null;
    WPI_VictorSPX ColorwheelSpinnerMotorSPX = null;
    WPI_VictorSPX ColorwheelElevatorMotorSPX = null;

    public ColorwheelSpininator(){
        this.ColorwheelSpinnerMotorSPX = new WPI_VictorSPX(RobotMap.COLORWHEEL_SPINNER_ID);
        this.ColorwheelElevatorMotorSPX = new WPI_VictorSPX(RobotMap.COLORWHEEL_ELEVATOR_ID);
        this.ColorwheelUpperLimit = new DigitalInput(RobotMap.DIO_COLORWHEEL_UPPER_LIMIT);
        this.ColorwheelLowerLimit = new DigitalInput(RobotMap.DIO_COLORWHEEL_LOWER_LIMIT);
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ColorwheelVate());
    }

    public void Elevate(double elevationSpeed) {
        if (!this.ColorwheelUpperLimit.get()) {
            elevationSpeed = Math.max(elevationSpeed, 0);
        }
        this.ColorwheelElevatorMotorSPX.set(ControlMode.PercentOutput, elevationSpeed);
    }

    public void stopElevating(){
        this.ColorwheelElevatorMotorSPX.set(ControlMode.PercentOutput, 0);
    }

    public void Spin(double spinSpeed) {
        this.ColorwheelSpinnerMotorSPX.set(ControlMode.PercentOutput, spinSpeed);
        
    }

    public void stopSpinning(){
        this.ColorwheelSpinnerMotorSPX.set(ControlMode.PercentOutput, 0);
    }
}
