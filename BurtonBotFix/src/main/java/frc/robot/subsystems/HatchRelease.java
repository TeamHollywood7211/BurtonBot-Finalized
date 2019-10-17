package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class HatchRelease extends Subsystem 
    {
        private VictorSPX hatchReleaseMotor;
        private DoubleSolenoid pneumatic1;
        // private Solenoid pneumatic;
        // private Solenoid pneumatic2;

    public HatchRelease() {
        hatchReleaseMotor = new VictorSPX(RobotMap.hatchReleaseMotor);
        pneumatic1 = new DoubleSolenoid(0,1);
        // pneumatic = new Solenoid(0);
        // pneumatic2 = new Solenoid(1);
        // pneumatic.set(false);
        // pneumatic2.set(false);

        // pneumatic = new Solenoid(0);
        // pneumatic2 = new Solenoid(1);
        // pneumatic.set(false);
        // pneumatic2.set(false);
    }
    @Override
    protected void initDefaultCommand() {
        hatchReleaseMotor.set(ControlMode.PercentOutput, 0);
    }
    public void run(double power) {

        if (Robot.m_elevator.getEncoder() > 700 )
        {
        hatchReleaseMotor.set(ControlMode.PercentOutput, power);
        }
        else {
            hatchReleaseMotor.set(ControlMode.PercentOutput, 0);

            }
    }
      

    
    
    public void setPneumatic1(boolean on) {
        pneumatic1.set(on ? Value.kForward : Value.kReverse);
        // pneumatic.set(on);
        //pneumatic2.set(on);
    }

    }