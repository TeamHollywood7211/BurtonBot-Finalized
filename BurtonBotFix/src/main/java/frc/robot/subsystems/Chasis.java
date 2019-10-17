/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;  
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.JoystickDrive;



/**
 * 
 */
public class Chasis extends Subsystem {

  private  WPI_TalonSRX rightMaster;
  private WPI_VictorSPX rightFollower1;
  private WPI_VictorSPX rightFollower2;

  private WPI_TalonSRX leftMaster;
  private WPI_VictorSPX leftFollower1;
  private WPI_VictorSPX leftFollower2;

  private DifferentialDrive diffDrive;
  private final double straightM = 0.9;
  private final double turnM = 0.75;


  public Chasis() {

    leftMaster = new WPI_TalonSRX(RobotMap.lMotor1);
    addChild("Left Master",leftMaster);
    leftMaster.setInverted(false);

    leftFollower1 = new WPI_VictorSPX(RobotMap.lMotor2);
    addChild("Left Follower 1",leftFollower1);
    leftFollower1.setInverted(InvertType.FollowMaster);

    leftFollower2 = new WPI_VictorSPX(RobotMap.lMotor3);
    addChild("Left Follower 2",leftFollower2);
    leftFollower2.setInverted(InvertType.FollowMaster);
    
    //  Other possible speedcontrollers:
    // victorSPX1 = new WPI_VictorSPX(0);
    // talonSRX1 = new WPI_TalonSRX(1);
    // spark = new Spark(0);
    
    

    rightMaster = new WPI_TalonSRX(RobotMap.rMotor1);
    addChild("Right Master",rightMaster);
    rightMaster.setInverted(true);
    
    rightFollower1 = new WPI_VictorSPX(RobotMap.rMotor2);
    addChild("Right Follower 1",rightFollower1);
    rightFollower1.setInverted(InvertType.FollowMaster);

    rightFollower2 = new WPI_VictorSPX(RobotMap.rMotor3);
    addChild("Right Follower 2",rightFollower2);
    rightFollower2.setInverted(InvertType.FollowMaster);


    diffDrive = new DifferentialDrive(leftMaster, rightMaster);
    addChild("Differential Drive",diffDrive);
    diffDrive.setSafetyEnabled(true);
    diffDrive.setExpiration(0.1);
    diffDrive.setMaxOutput(1.0);
  }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    leftMaster.configFactoryDefault();
    rightMaster.configFactoryDefault();

    leftFollower1.configFactoryDefault();
    leftFollower2.configFactoryDefault();

    rightFollower1.configFactoryDefault();
    rightFollower2.configFactoryDefault();

      leftFollower1.follow(leftMaster);
      leftFollower2.follow(leftMaster);

      rightFollower1.follow(rightMaster);
      rightFollower2.follow(rightMaster);
      

      setDefaultCommand(new JoystickDrive());

      diffDrive.setRightSideInverted(false);
    }

  public void driveByJoystick() {
    double moveSpeed = -(Robot.m_oi.driverJoystick.getRawAxis(1) * straightM); //Left Y
    double turnSpeed = (Robot.m_oi.driverJoystick.getRawAxis(4) * turnM); //Right X
    boolean squaredInputs = true;

    this.driveArcade(moveSpeed, turnSpeed, squaredInputs);
    // this.driveTank(moveSpeed, turnSpeed, squaredInputs);
  }
  public void driveArcade(double moveSpeed, double turnSpeed, boolean squaredInputs) {
    this.diffDrive.arcadeDrive(moveSpeed, turnSpeed, squaredInputs);
  }
  public void driveCurvature(double moveSpeed, double turnSpeed, boolean isQuickTurn) {
    this.diffDrive.curvatureDrive(moveSpeed, turnSpeed, isQuickTurn);
  }
  public void driveTank(double leftSpeed, double rightSpeed, boolean squareInputs) {
    this.diffDrive.tankDrive(leftSpeed, rightSpeed, squareInputs);
  }
  public void stopDrive() {
      this.diffDrive.arcadeDrive(0, 0, true);
  }
}
