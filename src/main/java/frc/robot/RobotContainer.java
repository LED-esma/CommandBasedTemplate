// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.auto;
import frc.robot.subsystems.driveSub;

public class RobotContainer {
  
  private SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  //subsystems
  private driveSub m_DriveSub = new driveSub();

  private CommandJoystick L_Joy = new CommandJoystick(Constants.OperatorC.L_Joy);
  private CommandJoystick R_Joy = new CommandJoystick(Constants.OperatorC.L_Joy);
  
  public RobotContainer() {

    //motor configuration 
    m_DriveSub.motorConfig();

    m_DriveSub.setDefaultCommand(
      new RunCommand(
        () -> m_DriveSub.drive(L_Joy.getY(), R_Joy.getY()), m_DriveSub)
        );
    configureBindings();
    
    //Auton Choices
    m_chooser.addOption("Defualt Auton", auto.defaultAuto(m_DriveSub));
    }

  private void configureBindings() {

//trigger first, then the use of it
    Trigger L_joyButton = L_Joy.button(3);
    Trigger R_joyButton = R_Joy.button(3);

    L_joyButton.onTrue(new InstantCommand(m_DriveSub::LSpeed, m_DriveSub));
    R_joyButton.onTrue(new InstantCommand(m_DriveSub::RSpeed, m_DriveSub));

 
  }

  public Command getAutonomousCommand(){
    return m_chooser.getSelected();
  }

}
