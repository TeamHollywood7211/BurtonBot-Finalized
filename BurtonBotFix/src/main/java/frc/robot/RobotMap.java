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

  // These are the drivetrain motor ports.
  public static int lMotor1 = 0;
  public static int lMotor2 = 1;
  public static int lMotor3 = 2;
  public static int rMotor1 = 3;
  public static int rMotor2 = 4;
  public static int rMotor3 = 5;

  // This is the arm motor.
  public static int armMotor = 6;

  //This is the legs' motor
  public static int backLegsMotor = 7;

  // This is the climb motor
  public static int climbMotor = 8;

  // This is the hatch release motor
  public static int hatchReleaseMotor = 10;

  // This is the front arm motor.
  public static int frontlegMotor = 11;
  
  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
