/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.ThreadberryPi;
/**
 *
 * @author nrladmin
 */
public class TeleopAutoAim extends CommandBase {
    ThreadberryPi pi;
    int distance;
    int offset;
    
    public TeleopAutoAim() {
        // Use requires() here to declare subsystem dependencies
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pi = new ThreadberryPi();
        distance = 0;
        offset = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        distance = pi.getDistance();
        offset = pi.getOffset();
        if(Math.abs(offset) >= 15){
            driveTrain.mecanumDrive(0, 0, offset/240, gyro.getAngle());
        } else if(Math.abs(distance-12000)>= 250){
            driveTrain.mecanumDrive((distance-12000)*Math.cos(gyro.getAngle()),
                                    (distance-12000)*Math.sin(gyro.getAngle()),
                                    0, gyro.getAngle());
        }
            
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Math.abs(offset) <= 15 && Math.abs(distance-12000)<= 250){
            return true;
        } else{
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
