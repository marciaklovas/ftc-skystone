/*
//  FTC FROGS (#14335) TEAM CODE
//
//  TELEOP
//
//  Class SkystoneTeleOp
//
//  Revisions
//      08-29-19    Marcia L.   Original
//      09-12-19    Elijah W.   Added controls
//
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="SkystoneTeleOp", group="Linear Opmode")
public class SkystoneTeleOp extends LinearOpMode {


    // declare members
    private OurRobot Skystone;
    private ElapsedTime runtime;

    @Override
    public void runOpMode() {
        // 'this' used because opmode is needed to setup hardware
        Skystone = new OurRobot(this);
        runtime = new ElapsedTime(); // not sure how to use this yet

        //Skystone.init();

        sleep(2000);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //////////////// GAMEPAD 1 (A) ///////////////////
            //////////////// OMNI DRIVE //////////////////////

            Skystone.omniDrive.Drive();

            // A held down -> line finding in 4 directions
            if (gamepad1.a) {
                if (gamepad1.dpad_up) {
                    Skystone.omniDrive.bwdToLine();
                }
                if (gamepad1.dpad_down) {
                    Skystone.omniDrive.fwdToLine();
                }
                if (gamepad1.dpad_left) {
                    Skystone.omniDrive.lftToLine();
                }
                if (gamepad1.dpad_right) {
                    Skystone.omniDrive.ritToLine();
                }
            }

            // B held down -> turning in 2 directions
            if (gamepad1.b) {
                if (gamepad1.dpad_left) {
                    Skystone.omniDrive.turnLeft(90);
                }
                if (gamepad1.dpad_right) {
                    Skystone.omniDrive.turnRight(90);
                }
            }

        }

    }

}


