package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput; // Import for digital sensors
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * STEPS TO SET UP THE MAGsense SENSOR FOR FRC:
 * 1. Check the sensor specifications:
 *    - The MAGsense sensor requires 3.3V power input.
 *    - It outputs digital signals (HIGH/LOW) via a 4-pin connector.
 * 2. Modify the wiring to connect the sensor to the roboRIO:
 *    - The MAGsense sensor has 4 pins: 3.3V, GND, SIG1, SIG2.
 *    - The roboRIO’s Digital Input (DIO) ports have 3 pins: 3.3V, GND, and SIG.
 *    - Connect the included 4-pin sensor cable to a custom 3-wire cable:
 *        - 3.3V → 3.3V (red wire on DIO port).
 *        - GND → GND (black wire on DIO port).
 *        - SIG1 → SIG (white wire on DIO port).
 *    - Leave SIG2 unconnected.
 * 3. Plug the modified 3-wire cable into any available DIO port on the roboRIO.
 *    - It doesn’t matter which digital pin is used on the MAGsense sensor, as SIG1 and SIG2 provide identical outputs.
 * 4. Deploy and test:
 *    - Upload the code to the roboRIO.
 *    - Open the SmartDashboard or Shuffleboard to observe sensor values.
 */

public class Robot extends TimedRobot {
    // Declare the MAGsense sensor
    private DigitalInput magSense;

    @Override
    public void robotInit() {
        // Initialize the MAGsense sensor on Digital Input
        magSense = new DigitalInput(0);//port based on your wiring

        // Display a status message on the dashboard
        SmartDashboard.putString("Sensor Status", "MAGsense Initialized");
    }

    @Override
    public void teleopPeriodic() {
        // Read the sensor state (true = no magnet, false = magnet detected)
        boolean magnetDetected = !magSense.get(); // Inverted because LOW = detected (usually)

        // Update the dashboard with sensor data
        if (magnetDetected) {
            SmartDashboard.putString("Magnet Status", "DETECTED");
        } else {
            SmartDashboard.putString("Magnet Status", "NOT DETECTED");
        }
    }
}
