/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonomousMovement;
//import frc.robot.commands.PassTheLine;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    public static OI m_oi;

    public static Drivetrain m_drivetrain = null;

    public static CameraServer cameraOne = null;

    public static Encoder m_encoder_left = null;
    public static Encoder m_encoder_right = null;

    public static ColorwheelSpininator m_colorwheelspininator = null;

    public static Conveyor m_conveyor = null;

    public static Harvester m_harvester = null;

    public static DigitalInput ConveyorLimit = null;

    public static final double cpr = 5;
    // Wheel Diameter
    public static final double whd = 6;

    Command m_autonomousCommand;
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    Command autonomousMovement;
    //Command passTheLine;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {

        // Declare Drivetrain
        m_drivetrain = new Drivetrain();

        // Declare Conveyor
        m_conveyor = new Conveyor();

        // Declare Color Wheel Spinner
        m_colorwheelspininator = new ColorwheelSpininator();

        m_harvester = new Harvester();

        autonomousMovement = new AutonomousMovement();
        //passTheLine = new PassTheLine(2);
        
        Robot.ConveyorLimit = new DigitalInput(RobotMap.DIO_CONVEYOR_LIMIT);

        // Declare left and right Encoders    
        m_encoder_left = new Encoder(RobotMap.ENCODER_INPUT_LEFT_A, RobotMap.ENCODER_INPUT_LEFT_B);
        m_encoder_right = new Encoder(RobotMap.ENCODER_INPUT_RIGHT_A, RobotMap.ENCODER_INPUT_RIGHT_B);
        m_encoder_left.setDistancePerPulse(Math.PI*whd/cpr);
        m_encoder_right.setDistancePerPulse(Math.PI*whd/cpr);

        // Operator Input stuff.
        m_oi = new OI();
        // chooser.addOption("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", m_chooser);

        // Create Camera Server to serve video to control station.
        cameraOne = CameraServer.getInstance();
        cameraOne.startAutomaticCapture();
    }

    /**
     * This function is called every robot packet, no matter the mode. Use
     * this for items like diagnostics that you want ran during disabled,
     * autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
    */
    @Override
    public void autonomousInit() {
        autonomousMovement.start();
        //passTheLine.start();

        m_autonomousCommand = m_chooser.getSelected();

        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
