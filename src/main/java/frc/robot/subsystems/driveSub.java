package frc.robot.subsystems;

import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.team5430.util.DriveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class driveSub extends SubsystemBase{

    public driveSub(){}

    TalonFX backLeftMotor;
    TalonFX backRightMotor;
    TalonFX frontLeftMotor;
    TalonFX frontRightMotor;

    private DriveTrain chassis = new DriveTrain(
        frontLeftMotor,
        backLeftMotor,
        frontRightMotor,
        backRightMotor);
    
        public void motorConfig() {

            chassis.InvertMotors(false, true);
            chassis.setkP(.15);
            chassis.setGearRatio(Constants.ratio);
        
          }
        
          // Method to decrease variable speed of drivetrain
          public void RSpeed() {
            Constants.multiplier = .7;
          }
        
          // Method to decrease variable speed of drivetrain
          public void DefaultSpeed() {
            Constants.multiplier = 1;
          }
        
          //method to further decrease variable speed, respctive to right and left joysticks
          public void LSpeed() {
            Constants.multiplier = 0.3;
          }
        
          /**Negative goes towards intake side, postive goes towards the electornics side. */ 
        
          public void driveininches(double inches) {
        
            // reset encoder values
            chassis.ZeroMotors();
        
            // converts wanted distance to rotations
            double distance = inches / Constants.circumferenceInInches;
        
            // set motors to achieve wanted distance
            chassis.setControl(new PositionDutyCycle(distance));
        
          }
          
          /** Method for drive using {@code left} and {@code right} for respective sides
           * 
           * @param left
           * @param right
          */
          public void drive(double left, double right) {
        
            chassis.drive(left * Constants.multiplier, right * Constants.multiplier);
        
          }

}