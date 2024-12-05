package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel; // Import for digital sensors

@com.qualcomm.robotcore.eventloop.opmode.TeleOp

/*
  - This code assumes your robot project is already in a working condition. 
 * STEPS TO SET UP THE MAGsense SENSOR:
 * 1. Wire the sensor to the REV Hub:
 *    - VCC (power) → 3.3V port on the REV Hub.
 *    - GND (ground) → GND port on the REV Hub.
 *    - OUT (signal 1 & 2) → Digital Input port (e.g., "Digital 0").
 * 2. Configure the REV Hub in the Driver Station:
 *    - Open the FTC Robot Controller app.
 *    - Create or edit a configuration.
 *    - Add a Digital Device:
 *        - Assign it to the port where the sensor is connected.
 *        - Name it (e.g., "MAGsense").
 *    - Save the configuration.
 * 3. Deploy this program to test the sensor in action.
*/
  
public class MAGsense extends LinearOpMode {

    // Declare the Hall effect sensor
    private DigitalChannel mag;

    @Override
    public void runOpMode() {
        // Initialize the sensor using the configured name
        mag = hardwareMap.get(DigitalChannel.class, "hall_sensor");

        // Set the mode of the sensor (Input or Output, usually Input)
        mag.setMode(DigitalChannel.Mode.INPUT);

        // Wait for the driver to press "PLAY"
        telemetry.addData("Status", "Waiting for start...");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            // Read the sensor state (HIGH or LOW)
            boolean magnetDetected = !mag.getState(); // typically will use LOW for detection

            // Display the sensor state on the Driver Station telemetry
            if (magnetDetected) {
                telemetry.addData("Magnet", "DETECTED");
            } else {
                telemetry.addData("Magnet", "NOT DETECTED");
            }
            telemetry.update();
        }
    }
}
