/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

// I named this ConveyorVate even though nothing is Elevating...
// Actually the balls are elevating so I am mistaken.
// Not by much though, just like a foot higher
public class ConveyorVate extends Command {
    
    private boolean isReversed;
    private double m_Timer;

	public ConveyorVate(boolean reversed, double timer) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.m_conveyor);
        this.isReversed = reversed;
        m_Timer = timer;
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setTimeout(m_Timer);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.m_conveyor.move(isReversed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.m_conveyor.stopMove();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
