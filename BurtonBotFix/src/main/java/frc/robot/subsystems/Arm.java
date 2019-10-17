package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.RunArm;

public class Arm extends Subsystem 
    {
        private WPI_TalonSRX arm;
            
        public static enum ArmPositions {
            Rocket1, Rocket2, Rocket3
        }

        public Arm()
        {
            arm = new WPI_TalonSRX(RobotMap.armMotor);
            addChild("Arm",arm);
            arm.setInverted(false); 
        }
        @Override
        protected void initDefaultCommand()
        {
            setDefaultCommand(new RunArm());
        }
        public void run(double mod) 
        {
            double Joyval = Robot.m_oi.getoperatorJoystick().getRawAxis(1);
            arm.set(ControlMode.PercentOutput, (Joyval * mod));
        }

        public void setArmPosition(ArmPositions position) {
            
        }
    } 
