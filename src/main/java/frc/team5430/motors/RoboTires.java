package frc.team5430.motors;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.math.controller.PIDController;

/**  custom twist of {@link WPI_TalonFX} */

public class RoboTires extends WPI_TalonFX{

//constants
private double ratio;
private double circumferenceInInches;
private double inches = 12;
private double totalInches;
private double motorRotations;
private double encoderTicks = 2048;

    public RoboTires(int CANid){
        super(CANid);
    }

    //individually control motors for distance.
public void driveInDistance( double feet){

totalInches = feet * inches;

motorRotations = (totalInches/circumferenceInInches) * ratio;

this.set(ControlMode.Position, motorRotations * encoderTicks);

}
//note to anyone who contributes, driveInDistance should have more than one form of measuremental basis
public void driveInDistance(double feet, PIDController pid){

   
totalInches = feet * inches;

motorRotations = (totalInches/circumferenceInInches) * ratio;

pid.setSetpoint(motorRotations * encoderTicks);

    while(this.getSelectedSensorPosition() < motorRotations * encoderTicks){
this.set(ControlMode.PercentOutput, pid.calculate(this.getSelectedSensorPosition()));

}
    }


public void setCircumference(double diameter){
 circumferenceInInches = diameter * Math.PI;
 }

public double getCircumference(){
    return circumferenceInInches;
}

public void setRatio(double Gratio){
    ratio = Gratio;
}

public double getRatio(){
    return ratio;
}

}