 // RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc4909.RealRobo2.subsystems;
import org.usfirst.frc4909.RealRobo2.RobotMap;
import org.usfirst.frc4909.RealRobo2.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftFront = RobotMap.driveTrainLeftFront;
    SpeedController rightFront = RobotMap.driveTrainRightFront;
    SpeedController leftRear = RobotMap.driveTrainLeftRear;
    SpeedController rightRear = RobotMap.driveTrainRightRear;
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new TankDrive());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double joystickMath(double x){
        double d=.1;
        if (Math.abs(x)<d)
            return 0;
        double i=(Math.abs(x)-d);
        double s=(1-d);
        double sgn;
        if (x>0){
            sgn=1;
        }
        else if (x<0){
            sgn=-1;
        }
        else{
            sgn=0;
        }
        return   sgn*i*i/(s*s);
    }
    public void takeJoystickInputs(Joystick left, Joystick right){
        //System.out.println("Left Joystick="+left.getY());
       // System.out.println("Right Joystick"+right.getY());
        double left_y=joystickMath(left.getY());
        double right_y=joystickMath(right.getY());
        //double right_y=right.getY();
        robotDrive.tankDrive(left_y, right_y);
    }
    public void stop(){
        robotDrive.drive(0,0);
    }
    public void driveStraight(double speed){
        if (speed<0){
            robotDrive.tankDrive(-speed-.0625, -speed);
        }
        else{
            robotDrive.tankDrive(-speed, -speed+.0625);
        }
    }
    public void turnInPlace(double speed){
        robotDrive.tankDrive(speed, -speed);
    }
}
