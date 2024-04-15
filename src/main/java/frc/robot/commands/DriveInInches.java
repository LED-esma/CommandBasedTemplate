package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.driveSub;

public class DriveInInches extends Command {
    
private driveSub driveSub_;

private double inches_;

    public DriveInInches(double inches, driveSub drive){
        inches_ = inches;
        driveSub_ = drive;
        addRequirements(driveSub_);
    }

    @Override
    public void initialize(){
        driveSub_.driveininches(inches_);
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
