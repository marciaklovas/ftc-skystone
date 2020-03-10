/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class LinkageDrive
//
//  Methods:
//  	constructor
//  	init()
//  	Drive()
//  	fwdToLine() - not implemented
//  	bwdToLine() - not implemented
//  	turnLeft() - not implemented
//  	turnRight() - not implemented
//
//  Revisions
//  	02-04-20	Elijah W. and Kai P.   Original
//      02-15-20    Elijah W. and Kai P.   Modified to work with 4 motors
//      03-10-20    Elijah W.              Commented out unused/untested methods
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import com.qualcomm.robotcore.util.Range;

public class LinkageDrive {

    // declare constants
    final static double WHEEL_CIRCUM = 12.2;   // in inches
    final static int TETRIX_MOTOR_1440 = 1440; // 1440 ticks per revolution
    final static double WHITE_THRESHOLD = 400;
    final static boolean FAST = false;
    final static boolean SLOW = true;
    final static boolean FORWARD = false;
    final static boolean BACKWARD = true;

    // declare members
    private DcMotor wheel0;
    private DcMotor wheel1;
    private DcMotor wheel2;
    private DcMotor wheel3;
    private ColorSensor sensorColor;
    private BNO055IMU imu;
    private LinearOpMode opMode;

    private double leftPower;
    private double rightPower;
    private double drive;
    private double turn;
    private double targetAngle;

    private double p0;
    private double p1;
    private double p2;
    private double p3;

    // State used for updating telemetry
    private Orientation angles;
    private Acceleration gravity;

    // constructor method
    public LinkageDrive(LinearOpMode opmode) {
        // hardwaremap
        this.opMode = opmode; // 'this' used for clarity
        wheel0 = opMode.hardwareMap.get(DcMotor.class, "m0");
        wheel1 = opMode.hardwareMap.get(DcMotor.class, "m1");
        wheel2 = opMode.hardwareMap.get(DcMotor.class, "m2");
        wheel3 = opMode.hardwareMap.get(DcMotor.class, "m3");
        sensorColor = opMode.hardwareMap.get(ColorSensor.class, "sensor_color_distance");
        imu = opmode.hardwareMap.get(BNO055IMU.class, "imu");

        // IMU parameters
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        imu.initialize(parameters);

        wheel0.setDirection(DcMotor.Direction.REVERSE);
        wheel3.setDirection(DcMotor.Direction.REVERSE);

    }

    public void init() {
        // Set initial conditions for the motors

    }

    public void fwdToLine() {
        /*
        wheel2.setPower(0.4);
        wheel3.setPower(0.4);
        while (opMode.opModeIsActive() && (sensorColor.alpha() < WHITE_THRESHOLD) && (!opMode.gamepad1.y)) {
            opMode.telemetry.addData("Light Level", sensorColor.alpha());
            opMode.telemetry.update();
        }
        wheel2.setPower(0);
        wheel3.setPower(0); */
    }

    public void bwdToLine() {
        /*
        wheel2.setPower(-0.4);
        wheel3.setPower(-0.4);
        while (opMode.opModeIsActive() && (sensorColor.alpha() < WHITE_THRESHOLD) && (!opMode.gamepad1.y)) {
            opMode.telemetry.addData("Light Level", sensorColor.alpha());
            opMode.telemetry.update();
        }
        wheel2.setPower(0);
        wheel3.setPower(0); */
    }

    public void turnRight(int angle) {
        /*
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        // counterclockwise is positive direction (in degrees)
        targetAngle = angles.firstAngle - angle;

        opMode.telemetry.addData("Current Angle ", (angles.firstAngle));
        opMode.telemetry.addData("Target Angle ", targetAngle);
        opMode.telemetry.update();

        while (angles.firstAngle > targetAngle) {


            wheel2.setPower(-.4);
            wheel3.setPower(.4);

            opMode.telemetry.addData("degs ", angles.firstAngle);
            opMode.telemetry.addData("target ", targetAngle);
            opMode.telemetry.update();

            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        }

        wheel2.setPower(0);
        wheel3.setPower(0);

        opMode.telemetry.addData("Current Angle ", (angles.firstAngle));
        opMode.telemetry.update();

         */

    }

    public void turnLeft(int angle) {
        /*
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        // counterclockwise is positive direction (in degrees)
        targetAngle = angles.firstAngle + angle;

        opMode.telemetry.addData("Current Angle ", (angles.firstAngle));
        opMode.telemetry.addData("Target Angle ", targetAngle);
        opMode.telemetry.update();

        while (angles.firstAngle < targetAngle) {

            wheel2.setPower(.4);
            wheel3.setPower(-.4);

            opMode.telemetry.addData("degs ", angles.firstAngle);
            opMode.telemetry.addData("target ", targetAngle);
            opMode.telemetry.update();

            angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        }

        wheel2.setPower(0);
        wheel3.setPower(0);

        opMode.telemetry.addData("Current Angle ", (angles.firstAngle));
        opMode.telemetry.update();
        */
    }

    public void drive() {

        p2 = opMode.gamepad1.left_stick_y - opMode.gamepad1.left_stick_x;
        p3 = opMode.gamepad1.left_stick_y + opMode.gamepad1.left_stick_x;


        wheel2.setPower(p2 / 3);
        wheel1.setPower(p2 / 3);
        wheel3.setPower(p3 / 3);
        wheel0.setPower(p3 / 3);
    }

    public void wheel1() {
        wheel3.setPower(50);
    }
}
