package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.driveSub;

public class auto{

  public static Command defaultAuto(driveSub drive){
    return Commands.sequence(
    new WaitCommand(2),
    new DriveInInches(56, drive)
    );
  }
}