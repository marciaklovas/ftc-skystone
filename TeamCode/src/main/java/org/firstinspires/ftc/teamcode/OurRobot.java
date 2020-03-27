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
    //private Claw claw;
    //private Launcher launcher;

    public OurRobot(LinearOpMode opmode)
    {
        linkageDrive = new LinkageDrive(opmode);
        //claw = new Claw(opmode);
        //launcher = new Launcher(opmode);
    }

    public void init() {
        linkageDrive.init();
        //claw.init();
    }

    public void drive() {
        linkageDrive.drive();
    }

    public void spinWheel0() {
        linkageDrive.wheel0();
    }

    public void spinWheel1() {
        linkageDrive.wheel1();
    }

    public void spinWheel2() {
        linkageDrive.wheel2();
    }

    public void spinWheel3() {
        linkageDrive.wheel3();
    }
}
