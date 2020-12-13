// RobotBuilder Version: 2.0
//
// TDuring competition, the robot approaches the control panel, engages,
// and rotates it at least three rotations, but no more than five.
// 


package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class SpinToCount extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
    private int count = 0;
    private String oldColor = "";
    private String newColor = "";

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public SpinToCount() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.spinner);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        oldColor = Robot.spinner.getColor();
        count = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.spinner.spin( .5 );
        String testColor = Robot.spinner.getColor();
        Robot.lightDrive.setStringColor(4, newColor);
        if (testColor != "Pink") { 
            newColor = testColor;
            if (oldColor != newColor) {
                count += 1;
                oldColor = newColor;
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        boolean success = false;
        if ( count > 24) {
           success = true;
        }
        return success;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.spinner.spin( 0 );
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
