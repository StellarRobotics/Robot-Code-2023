package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DriveTrain {

    private final CANSparkMax driveLeftFront = new CANSparkMax(32, MotorType.kBrushless);
    private final CANSparkMax driveRightFront = new CANSparkMax(30, MotorType.kBrushless);
    private final CANSparkMax driveLeftRear = new CANSparkMax(33, MotorType.kBrushless);
    private final CANSparkMax driveRightRear = new CANSparkMax(31, MotorType.kBrushless);
    // Define Controllers
    private final Joystick driverLeft = new Joystick(0);
    private final Joystick driverRight = new Joystick(1);
    //private final Joystick Operator = new Joystick(2);
  
    double driveRight = 0;
    double driveLeft = 0;
  
    //boolean toggleState = false;
    //boolean toggleLast = false; 

    public void tankDrive(boolean toggleState) {

        double driveRight = 0;
        double driveLeft = 0;
      
        //boolean toggleState = false;
        //boolean toggleLast = false;

                // A small state machine to toggle different drive train speeds.
        double driveSpeedMultiplier = toggleState?0.2:1;
        if (toggleState) {
        if (driverRight.getRawButton(1)) {
            driveLeft = driverRight.getZ() * driveSpeedMultiplier * 0.8;
            driveRight = driverRight.getZ() * driveSpeedMultiplier * 0.8;
        }
        else{
            driveLeft = -driverLeft.getY() * driveSpeedMultiplier;
            driveRight = driverRight.getY() * driveSpeedMultiplier;
        }
        }
        else {
        if (driverRight.getRawButton(1)) {
            driveLeft = driverRight.getZ() * driveSpeedMultiplier * 0.6;
            driveRight = driverRight.getZ() * driveSpeedMultiplier * 0.6;
        }
        else{
            driveLeft = -driverLeft.getY() * driveSpeedMultiplier;
            driveRight = driverRight.getY() * driveSpeedMultiplier;
        }
        }
        /*
        if ( (driverLeft.getRawButton(12) == true) & (!toggleLast) ) {
        toggleState  = !toggleState;
        }

        toggleLast = driverLeft.getRawButton(12);
        */

        // Applying the drive train speed using the raw axis input multiplied by the toggle fraction.
        driveLeftFront.set(driveLeft);
        driveRightFront.set(driveRight);
        driveLeftRear.set(driveLeft);
        driveRightRear.set(driveRight);
    }
}