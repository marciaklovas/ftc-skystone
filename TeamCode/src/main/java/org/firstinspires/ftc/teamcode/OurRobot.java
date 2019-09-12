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
//
*/


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class OurRobot {

    // list subsystems- public because they are used in TeleOp and Auto
    public OmniDrive omniDrive;
    //public Claw claw;
    //public Launcher launcher;

    public OurRobot(LinearOpMode opmode)
    {
        omniDrive = new OmniDrive(opmode);
        //claw = new Claw(opmode);
        //launcher = new Launcher(opmode);
    }

    public void init() {
        omniDrive.init();
        //claw.init();
    }


}
