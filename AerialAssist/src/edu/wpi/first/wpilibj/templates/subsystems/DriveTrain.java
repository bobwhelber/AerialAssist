/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.TankDrive;

/**
 *
 * @author AJ
 */
public class DriveTrain extends Subsystem {

    private Jaguar frontLeft = new Jaguar(0);
    private Jaguar frontRight = new Jaguar(1);
    private Jaguar backLeft = new Jaguar(2);
    private Jaguar backRight = new Jaguar(3);
    private RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, frontLeft);
    
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDrive()); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void mecanumDrive(GenericHID move, Joystick.AxisType rotate) {
        
        drive.mecanumDrive_Cartesian(move.getX(), move.getY(), rotate.value, 0);
        frontLeft.set(10);
        
        
        
    }
}