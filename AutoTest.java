package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by vmujoo on 9/17/2017.
 */
@Autonomous(name = "AutoTest")
public class AutoTest extends LinearOpMode {
    DcMotor wh1;
    DcMotor wh2;
    @Override
    public void runOpMode () throws InterruptedException {
        double p = 0.1d;
        double in = 0.01d;
        wh1 = hardwareMap.dcMotor.get("left_drive");
        wh2 = hardwareMap.dcMotor.get("right_drive");
        telemetry.addData("", "Press Start to run Motor." );
        telemetry.update();
        wh1.setDirection(DcMotorSimple.Direction.REVERSE);
        wh2.setDirection(DcMotorSimple.Direction.REVERSE);
        resetStartTime();
        waitForStart();
        while(opModeIsActive()){
            if(getRuntime() < 3d){
                p += in;
                Thread.sleep(100);
            }else if(getRuntime() < 6d){
                in = 0.01d;
                p -= in;
                Thread.sleep(100);
            }else{
                p = 0;
            }
            wh1.setPower(p);
            wh2.setPower(p);
        }
        wh1.setPower(0);
        wh2.setPower(0);
        telemetry.addData("", "Done");
        telemetry.update();
    }
}
