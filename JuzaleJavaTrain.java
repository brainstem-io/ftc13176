package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@TeleOp
public class juzalejavatrain extends LinearOpMode {
    private DcMotor rightFrontMotor;
    private DcMotor leftFrontMotor;
    private DcMotor rightBackMotor;
    private DcMotor leftBackMotor;

    private Servo Bucket;
    private CRServo Arm;
    private ColorSensor Eyes;

    @Override
    public void runOpMode(){
        //Initialize
        rightFrontMotor = hardwareMap.dcMotor.get("frontRightMotor");
        leftFrontMotor = hardwareMap.dcMotor.get("frontLeftMotor");
        rightBackMotor = hardwareMap.dcMotor.get("backRightMotor");
        leftBackMotor = hardwareMap.dcMotor.get("backLeftMotor");
         // other 3
        
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        
        
        // Waiting to press "PLAY" 
        waitForStart();
        
        //loop
        while(opModeIsActive()) {
            double gpad_left = gamepad1.left_stick_y;
            double gpad_right = gamepad1.right_stick_y;
            rightFrontMotor.setPower(gpad_right);
            leftFrontMotor.setPower(gpad_left);
            rightBackMotor.setPower(gpad_right);
            leftBackMotor.setPower(gpad_left);
                // rightFrontMotor.setPower(0;
                
        }
    }
    
}
