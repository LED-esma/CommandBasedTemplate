package frc.robot.subsystems;


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


     //The left motors will move in the negative direction
     public Command Akira (double left, double right){
         return new InstantCommand(
             () -> drive(-left, right)
         );
     }
 
    public void motorSettings(){
        backLeftMotor.setInverted(true);
        frontLeftMotor.setInverted(true);
    }

    public void VariableSpeedIncrease(){
        Constants.multiplier += .1;
    }

    public void VariableSpeedDecrease(){
        Constants.multiplier -= .1;
    }

    public static void drive(double left, double right){
        backLeftMotor.set(left);
        frontLeftMotor.set(left);
        backRightMotor.set(right);
        frontRightMotor.set(right);
    }
//Commands are started with "C_" as to identify them as commands rather than methods
    public static Command C_drive(double left, double right){
        return new InstantCommand(
            () -> drive(left, right)
        );
    }
        
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
