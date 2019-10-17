/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DefenseArmToggleS;
import frc.robot.commands.RunClimb;
import frc.robot.commands.RunHatchRelease;
import frc.robot.commands.SetElevatorPosition;
import frc.robot.subsystems.Elevator;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
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

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // DECLARATIONS
    
    public Joystick driverJoystick;
    
    public JoystickButton driverJoystickButtonGreen;
    public JoystickButton driverJoystickButtonRed;
    public JoystickButton driverJoystickButtonBlue;
    public JoystickButton driverJoystickButtonYellow;
    

    public Joystick operatorJoystick;
    public JoystickButton operatorJoystickButtonGreen;
    public JoystickButton operatorJoystickButtonBlue;
    public JoystickButton operatorJoystickButtonYellow;
    public JoystickButton operatorJoystickButtonRed;
    public JoystickButton operatorJoystickButtonLeftBumper;
    public JoystickButton operatorJoystickButtonRightBumper;
    public JoystickButton operatorJoystickButtonStart;
    public JoystickButton operatorJoystickButtonBack;

    private RunHatchRelease runHatchRelease = new RunHatchRelease();
    
    public OI() {
        // CONSTRUCTORS

        driverJoystick = new Joystick(0);
        operatorJoystick = new Joystick(1);

        driverJoystickButtonGreen = new JoystickButton(driverJoystick, 1);
        driverJoystickButtonGreen.whileHeld(new RunClimb());

        operatorJoystickButtonBlue = new JoystickButton(operatorJoystick, 3);
        operatorJoystickButtonBlue.whileHeld(new SetElevatorPosition(Elevator.ElevatorPositions.low));
        
        operatorJoystickButtonYellow = new JoystickButton(operatorJoystick, 4);
        operatorJoystickButtonYellow.whileHeld(new SetElevatorPosition(Elevator.ElevatorPositions.middle));
        
        operatorJoystickButtonRed = new JoystickButton(operatorJoystick, 2);
        operatorJoystickButtonRed.whileHeld(new SetElevatorPosition(Elevator.ElevatorPositions.high));

        operatorJoystickButtonLeftBumper = new JoystickButton(operatorJoystick, 5);
        operatorJoystickButtonLeftBumper.whileHeld(new SetElevatorPosition(Elevator.ElevatorPositions.zero));

        operatorJoystickButtonGreen = new JoystickButton(operatorJoystick, 1);
        operatorJoystickButtonGreen.whileHeld(runHatchRelease);

        operatorJoystickButtonStart = new JoystickButton(operatorJoystick, 8);
        operatorJoystickButtonStart.whenPressed(new SetElevatorPosition(Elevator.ElevatorPositions.midLow));

        operatorJoystickButtonBack = new JoystickButton(operatorJoystick, 7);
        operatorJoystickButtonBack.whenPressed(new DefenseArmToggleS());

        

    }

    // FUNCTIONS
    public Joystick getdriverJoystick() {
        return driverJoystick;
    }

    public Joystick getoperatorJoystick(){
        return operatorJoystick;
    }

}

