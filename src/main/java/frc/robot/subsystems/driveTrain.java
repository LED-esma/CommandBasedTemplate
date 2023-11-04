package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.team5430.motors.RoboTires;

public class driveTrain extends SubsystemBase {
    
    final static RoboTires backLeftMotor = new RoboTires(Constants.CANid.backLeftMotor);
    final static RoboTires frontLeftMotor = new RoboTires(Constants.CANid.frontLeftMotor);
    final static RoboTires backRightMotor = new RoboTires(Constants.CANid.backRightMotor);
    final static RoboTires frontRightMotor = new RoboTires(Constants.CANid.frontRightMotor);
    //grouping
    final static MotorControllerGroup Lgroup = new MotorControllerGroup(backLeftMotor, frontLeftMotor);
    final static MotorControllerGroup Rgroup = new MotorControllerGroup(backRightMotor, frontRightMotor);
    static SupplyCurrentLimitConfiguration configTalonCurrent = new SupplyCurrentLimitConfiguration(true,55,0,0);


    public void motorSettings(){
        backLeftMotor.setInverted(true);
        frontLeftMotor.setInverted(true);
        //CONFIG
        backLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
        frontLeftMotor.configSupplyCurrentLimit(configTalonCurrent);
        backRightMotor.configSupplyCurrentLimit(configTalonCurrent);
        frontRightMotor.configSupplyCurrentLimit(configTalonCurrent);
    }

    public void VariableSpeedIncrease(){
        Constants.multiplier += .1;
    }

    public void VariableSpeedDecrease(){
        Constants.multiplier -= .1;
    }
    public void drive(double left, double right){
        Lgroup.set(left);
        Rgroup.set(right);        
    }

    public Command C_drive(double left, double right){
        return new InstantCommand(
            () -> drive(left, right)
        );
    }
        //  
    public void driveInDistance(double feet){
        backLeftMotor.driveInDistance(feet);
        frontLeftMotor.driveInDistance(feet);
        backRightMotor.driveInDistance(feet);
        frontRightMotor.driveInDistance(feet);
    }

    public Command C_driveInDistance(double feet){
        return new InstantCommand(
        () -> driveInDistance(feet)
        );
    }

@Override
public void periodic(){

}
}
