/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    // Drivetrain modifier. Change number to allow for speed-limiting.
    public static final double DRIVETRAIN_SPEED_MODIFIER = 0.50;
    public static final double DRIVETRAIN_SPEEDBOOST_MODIFIER = 0.70;

    // Motor definitions.
    public static int DRIVETRAIN_LEFT_FRONT_ID = 10;
    public static int DRIVETRAIN_LEFT_BACK_ID = 11;
    public static int DRIVETRAIN_RIGHT_FRONT_ID = 20;
    public static int DRIVETRAIN_RIGHT_BACK_ID = 21;

    // Definitions for Driver Station-related stuff.
    public static int OI_DRIVERSTATION_CONTROLLER = 0;
    // Joystick axes.
    public static int OI_MOVE_AXIS = 1; // LS
    public static int OI_ROTATE_AXIS = 0; // LS

    public static int OI_SPEEDBOOST_BUTTON = 5; // RB

    // Conveyor motor, speed, and button definitions
    public static int HARVESTER_MOTOR_ID = 51;
    public static int CONVEYOR_MOTOR_ID = 50;
    public static double HARVESTER_SPEED = 0.75;
    public static double CONVEYOR_SPEED = 1.00;
    public static int OI_CONVESTER_NON_REVERSE = 2; // B
    public static int OI_CONVESTER_REVERSE = 3; // X
    public static int DIO_CONVEYOR_LIMIT = 6;

    public static double CONVEYOR_TIME = 3;

    // Collor Wheel motor, speed, button, and limit switch definitions
    public static int COLORWHEEL_ELEVATOR_ID = 60;
    public static int COLORWHEEL_SPINNER_ID = 61;
    public static int DIO_COLORWHEEL_UPPER_LIMIT = 4; // Color Wheel upper limit switch
    public static int DIO_COLORWHEEL_LOWER_LIMIT = 5;
    public static int OI_COLORWHEEL_RIGHT = 1; // A
    public static int OI_COLORWHEEL_LEFT = 4; // Y
    public static double COLORWHEEL_SPIN_SPEED = 0.50;
    public static double COLORWHEEL_ELEVATION_SPEED = 0.50;
    public static int OI_COLORWHEEL_ELEVATOR_AXIS = 5; // RS
    public static int OI_COLORWHEEL_SPINNER_AXIS = 4;

    // Global speed modifier.
    public static double SUBSYSTEMS_GLOBAL_SPEED_MODIFIER = 0.45;

    // Encoder A/B inputs for Left and Right on RoboRio Dio board
    public static int ENCODER_INPUT_LEFT_A = 0;
    public static int ENCODER_INPUT_LEFT_B = 1;
    public static int ENCODER_INPUT_RIGHT_A = 2;
    public static int ENCODER_INPUT_RIGHT_B = 3;
}
