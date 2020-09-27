/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class OurRobot
//
//  Methods:
//  	constructor - instantiates an omniDrive
//  	init()
//
//  Revisions
//  	09-12-19	Elijah W.   Original
//      03-10-20    Elijah W.   Updated to make subsystems private
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class OurRobot {

    private GearedDrive gearedDrive;
    private LinkageDrive linkageDrive;
    private StarWarsDrive starwarsDrive;
    //private Claw claw;
    //private Launcher launcher;

    public OurRobot(LinearOpMode opmode)
    {
        starwarsDrive = new StarWarsDrive(opmode);
        //claw = new Claw(opmode);
        //launcher = new Launcher(opmode);
    }

    public void init() {
        starwarsDrive.init();
        //claw.init();
    }

    public void drive() {
        starwarsDrive.drive();
    }

    public void spinWheel0() {
        starwarsDrive.wheel0();
    }

    public void spinWheel1() {
        starwarsDrive.wheel1();
    }

    public void spinWheel2() {
        starwarsDrive.wheel2();
    }

    public void spinWheel3() {
        starwarsDrive.wheel3();
    }

    public void head() {
        starwarsDrive.head();
    }

    public void left() {starwarsDrive.left();}

    public void right() {starwarsDrive.right();}

    public void playSound() {starwarsDrive.playSound();}
}
