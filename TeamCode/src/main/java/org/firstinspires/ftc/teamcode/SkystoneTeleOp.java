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
//      03-10-20    Elijah W.   Updated calls to Skystone.Drive
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

        Skystone.init();

        sleep(2000);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            //////////////// GAMEPAD 1 (A) ///////////////////

            Skystone.drive();

            Skystone.head();

            if (gamepad1.a) {
                Skystone.spinWheel0();
            }

            if (gamepad1.b) {
                Skystone.spinWheel1();
            }

            if (gamepad1.x) {
                Skystone.spinWheel2();
            }

            if (gamepad1.y) {
                Skystone.spinWheel3();
            }

            if (gamepad1.dpad_left) {Skystone.left();}

            if (gamepad1.dpad_right) {Skystone.right();}

            if (gamepad1.left_bumper) {
                Skystone.playSound();
            }

        }
    }
}


