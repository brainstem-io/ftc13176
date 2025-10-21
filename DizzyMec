package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import java.util.Set;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior;

@TeleOp(name = "DizzyMec")
public class DizzyMec extends LinearOpMode{
    DcMotor leftFrontMotor=null;
    DcMotor rightFrontMotor=null;
    DcMotor leftBackMotor=null;
    DcMotor rightBackMotor=null;

    DcMotor intakeMotor=null;
    CRServo lmServo = null;
    CRServo rmServo = null;
    

    Gamepad gpad1=null;
    @Override
    public void runOpMode() {
        leftFrontMotor=hardwareMap.dcMotor.get("leftfront");
        rightFrontMotor=hardwareMap.dcMotor.get("rightfront");
        leftBackMotor=hardwareMap.dcMotor.get("leftback");
        rightBackMotor=hardwareMap.dcMotor.get("rightback");
        
        rightFrontMotor.setDirection(DcMotor.Direction.REVERSE);
        rightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        
        // zero power, brake
        leftFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // run without encoders 
        leftBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftFrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightBackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        
        
        // intake motor
        intakeMotor = hardwareMap.dcMotor.get("intake");
        // intake motor
        lmServo = hardwareMap.crservo.get("LMintake");
        rmServo = hardwareMap.crservo.get("RMintake");
        
    // Waiting to press "PLAY" 
    waitForStart();

    //while loop
    while (opModeIsActive()){
        double forward = gamepad1.left_stick_y;
        double strafe = -gamepad1.left_stick_x;
        double turn = -gamepad1.right_stick_x;
        
        // double leftFrontPower = gpad1.left_stick_y;
        // double rightFrontPower = gpad1.left_stick_y;
        // double leftBackPower = gpad1.left_stick_y;
        // double rightBackPower = gpad1.left_stick_y;
        
        double denominator = 1.1;
        double leftFrontSpeed = ((forward + strafe + turn) / denominator);
        double rightFrontSpeed = ((-forward + strafe + turn) / denominator);
        double leftBackSpeed = ((forward + -strafe + turn) / denominator);
        double rightBackSpeed = ((forward + strafe + -turn) / denominator);
        
        leftFrontSpeed = leftFrontSpeed * (0.30 + 0.70 * gamepad1.right_trigger);
        rightFrontSpeed =rightFrontSpeed *  (0.30 + 0.70 * gamepad1.right_trigger);
        leftBackSpeed = leftBackSpeed * (0.30 + 0.70 * gamepad1.right_trigger);
        rightBackSpeed = rightBackSpeed * (0.30 + 0.70 * gamepad1.right_trigger);


        leftFrontMotor.setPower(leftFrontSpeed);
        rightFrontMotor.setPower(rightFrontSpeed);
        leftBackMotor.setPower(leftBackSpeed);
        rightBackMotor.setPower(rightBackSpeed);
        
        //intake motor
        if (gamepad1.right_bumper) { // if pressed
            intakeMotor.setPower(-0.75);
        } else if (gamepad1.left_bumper)
        { // if pressed
            intakeMotor.setPower(1);
        } else { // if not pressed
            intakeMotor.setPower(0);
        }

        // feeder servos
        if (gamepad1.y) { // if pressed
            lmServo.setPower(1);
            rmServo.setPower(-1);
        } else { // if not pressed
            intakeMotor.setPower(0);
            intakeMotor.setPower(0);
        }

    }
    
    }
    
    // todo: write your code here
}
