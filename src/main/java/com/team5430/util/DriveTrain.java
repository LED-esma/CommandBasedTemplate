  package com.team5430.util;

import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;


public class DriveTrain {

    private TalonFX frontleft;
    private TalonFX backleft;
    private TalonFX frontright;
    private TalonFX backright;

    
    /**DriveTrain grouping to control chassis altogether
     * @param FRONTLEFT
     * @param BACKLEFT
     * @param FRONTRIGHT
     * @param BACKRIGHT
     */
    public DriveTrain(TalonFX FRONTLEFT, TalonFX BACKLEFT, TalonFX FRONTRIGHT, TalonFX BACKRIGHT){
        frontleft = FRONTLEFT;
        backleft = BACKLEFT;
        frontright = FRONTRIGHT;
        backright = BACKRIGHT;
    }

    /**Set proportinal gain for all motors in your Drivetrain
     * @param kP
     */
    public void setkP(double kP){

        var slot0 = new Slot0Configs();

        slot0.kP = kP;
//apply to motors
        frontleft.getConfigurator().apply(slot0);
        backleft.getConfigurator().apply(slot0);
        frontright.getConfigurator().apply(slot0);
        backright.getConfigurator().apply(slot0);

    }

    /**Invert Motors based on physcal properties
     * @param left
     * 
     * @param right
     */
    public void InvertMotors(boolean left, boolean right){
//invert motors depending on user input
        frontleft.setInverted(left);
        backleft.setInverted(left);
        frontright.setInverted(right);
        backright.setInverted(right);

    }

    /**Set Gear Ratio for motors to chassis */
    public void setGearRatio(double ratio){

        var mfeed = new FeedbackConfigs();

        mfeed.FeedbackSensorSource = FeedbackSensorSourceValue.RotorSensor;

        mfeed.SensorToMechanismRatio = ratio;
//apply to motors
        frontleft.getConfigurator().apply(mfeed);
        backleft.getConfigurator().apply(mfeed);
        frontright.getConfigurator().apply(mfeed);
        backright.getConfigurator().apply(mfeed);

    }

    /**Set Control request to all motors */
    public void setControl(ControlRequest request){ 
        frontleft.setControl(request);
        backleft.setControl(request);
        frontright.setControl(request);
        backright.setControl(request);
    }


    public void drive(double left, double right){
            // deadzone adding .2, prevents (joystick) outputs from under 0.2
    if (left > .2 || left < -.2 || right > .2 || right < -.2) {
      frontleft.set((left));
      backleft.set((left));
      frontright.set((right));
      backright.set((right));
        } else {
            //stop motors if no input
      StopMotors();
        }
    }

    public void StopMotors(){
        frontleft.stopMotor();
        backleft.stopMotor();
        frontright.stopMotor();
        backright.stopMotor();
    }

    public void ZeroMotors(){
        frontleft.setPosition(0);
        backleft.setPosition(0);
        frontright.setPosition(0);
        backright.setPosition(0);
    }

    
    public void TurnMotors(double speed){
    //all set to value as to enforce motors inversion
        frontleft.set(speed);
        backleft.set(speed);
        frontright.set(speed);
        backright.set(speed);
    }
}