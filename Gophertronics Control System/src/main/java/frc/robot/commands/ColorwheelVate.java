/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ColorwheelVate extends Command {

    public ColorwheelVate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.m_colorwheelspininator);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double elevationSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.OI_COLORWHEEL_ELEVATOR_AXIS) * RobotMap.COLORWHEEL_ELEVATION_SPEED;
        Robot.m_colorwheelspininator.Elevate(elevationSpeed);
        double turnSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.OI_COLORWHEEL_SPINNER_AXIS) * RobotMap.COLORWHEEL_SPIN_SPEED;
        Robot.m_colorwheelspininator.Spin(turnSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.m_colorwheelspininator.stopElevating();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}

