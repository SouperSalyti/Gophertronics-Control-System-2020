/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    public Joystick driverController = new Joystick(RobotMap.OI_DRIVERSTATION_CONTROLLER);

    public Button lbButton = new JoystickButton(driverController, RobotMap.OI_SPEEDBOOST_BUTTON);
    public Button bbutton = new JoystickButton(driverController, RobotMap.OI_CONVESTER_NON_REVERSE);
    public Button xbutton = new JoystickButton(driverController, RobotMap.OI_CONVESTER_REVERSE);
    public Button abutton = new JoystickButton(driverController, RobotMap.OI_COLORWHEEL_RIGHT);
    public Button ybutton = new JoystickButton(driverController, RobotMap.OI_COLORWHEEL_LEFT);

    public OI() {
        lbButton.whileHeld(new Speedboost());
        //bbutton.whileHeld(new ConveyorVate(false, 100));
        //xbutton.whileHeld(new ConveyorVate(true, 100));
        //bbutton.whenPressed(new ConveyorVate(false, 100));
        //abutton.whileHeld(new ColorwheelTurn(true));
        //ybutton.whileHeld(new ColorwheelTurn(false));

        xbutton.whenPressed(new Harvest());
        ybutton.whenPressed(new ConveyorVate(false, 2.5));
    }

}
