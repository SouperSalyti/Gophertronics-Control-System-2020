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
    }

    public void Elevate(double elevationSpeed, boolean goingUp) {
        if (!this.ColorwheelUpperLimit.get()) {
            elevationSpeed = 0;
        }
        if (!this.ColorwheelLowerLimit.get()){
            elevationSpeed = 0;
        }

        if (goingUp == true)
        {
            this.ColorwheelElevatorMotorSPX.set(ControlMode.PercentOutput, elevationSpeed);
        } else {
            this.ColorwheelElevatorMotorSPX.set(ControlMode.PercentOutput, -1 * elevationSpeed);
        }
    }

    public void stopElevating(){
        this.ColorwheelElevatorMotorSPX.set(ControlMode.PercentOutput, 0);
    }

    public void Spin(double spinSpeed, boolean direction) {
        if (direction == true)
        {
            this.ColorwheelSpinnerMotorSPX.set(ControlMode.PercentOutput, spinSpeed);
        } else {
            this.ColorwheelSpinnerMotorSPX.set(ControlMode.PercentOutput, -1 * spinSpeed);
        }
    }

    public void stopSpinning(){
        this.ColorwheelSpinnerMotorSPX.set(ControlMode.PercentOutput, 0);
    }
}
