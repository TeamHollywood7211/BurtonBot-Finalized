package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Climb extends Subsystem 
    {
        private VictorSPX climbMotor;

    public Climb() {
        climbMotor = new VictorSPX(RobotMap.climbMotor);
    }
    @Override
    protected void initDefaultCommand() {
        climbMotor.set(ControlMode.PercentOutput, 0);
    }
    public void run(double power) {
        climbMotor.set(ControlMode.PercentOutput, power);
    }

    }
