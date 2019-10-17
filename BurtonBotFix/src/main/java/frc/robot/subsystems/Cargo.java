/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


/**
 * Add your docs here.
 */
public class Cargo extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private WPI_VictorSPX frontLeg;

  public Cargo(){
    frontLeg = new WPI_VictorSPX(RobotMap.frontlegMotor);
        addChild("Front Leg",frontLeg);
        frontLeg.setInverted(true); 
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    frontLeg.set(ControlMode.PercentOutput, 0);
  }

  public void run(double power) {
    frontLeg.set(ControlMode.PercentOutput, power);
}
}
