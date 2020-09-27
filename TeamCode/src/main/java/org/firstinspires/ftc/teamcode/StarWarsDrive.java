/*
//  FTC FROGS (#14335) TEAM CODE
//
//  Class StarWarsDrive
//
//  Methods:
//  	constructor
//  	init()
//  	drive()
//      head()
//      left(), right()
//      wheel0, wheel1, wheel2, wheel3
//      playSound()
//      playBeep()
//
//  Revisions
//  	04-24-20	Elijah W. and Kai P.   Original
//      06-19-20    Kai P                  Testing out Android Studio, added head() method
//      09-06-20    Elijah W. and Coach M. Added ability to trigger Star Wars sound on RC phone
//                                         Cleaned up code
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import android.media.ToneGenerator;
import android.media.AudioManager;


public class StarWarsDrive {

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
    private Servo headTurner;

    private double leftPower;
    private double rightPower;
    private double drive;
    private double turn;
    private double targetAngle;

    private double p0;
    private double p1;
    private double p2;
    private double p3;

    private double position;

    // Two ways to play sounds on RC phone: ToneGenerator or MediaPlayer
    private ToneGenerator tone;

    // constructor method
    public StarWarsDrive(LinearOpMode opmode) {
        // hardwaremap
        this.opMode = opmode; // 'this' used for clarity
        wheel0 = opMode.hardwareMap.get(DcMotor.class, "m0");
        wheel1 = opMode.hardwareMap.get(DcMotor.class, "m1");
        wheel2 = opMode.hardwareMap.get(DcMotor.class, "m2");
        wheel3 = opMode.hardwareMap.get(DcMotor.class, "m3");
        headTurner = opMode.hardwareMap.get(Servo.class, "headTurner");
        sensorColor = opMode.hardwareMap.get(ColorSensor.class, "sensor_color_distance");
        imu = opmode.hardwareMap.get(BNO055IMU.class, "imu");

        tone = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);

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

    public void playBeep() {

        tone.startTone(ToneGenerator.TONE_PROP_BEEP);

    }

    public void playSound() {

        tone.startTone(ToneGenerator.TONE_CDMA_KEYPAD_VOLUME_KEY_LITE);

    }

    public void drive() {

        p2 = opMode.gamepad1.left_stick_y - opMode.gamepad1.left_stick_x;
        p3 = opMode.gamepad1.left_stick_y + opMode.gamepad1.left_stick_x;

        wheel2.setPower(p2 / 3);
        wheel1.setPower(p2 / 3);

        wheel3.setPower(p3 / 3);
        wheel0.setPower(p3 / 3);
    }
    public void head() {

      position = ((opMode.gamepad1.right_trigger - opMode.gamepad1.left_trigger)/2) + 0.5;
      headTurner.setPosition(position);
    }

    public void wheel0() {
        wheel0.setPower(0.5);
    }

    public void wheel1() {
        wheel1.setPower(0.5);
    }

    public void wheel2() {
        wheel2.setPower(0.5);
    }

    public void wheel3() {
        wheel3.setPower(0.5);
    }

    public void left() {headTurner.setPosition(0);}

    public void right() {headTurner.setPosition(1);}

}
