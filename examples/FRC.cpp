#include <frc/DigitalInput.h>
#include <frc/smartdashboard/SmartDashboard.h>
#include <frc/TimedRobot.h>

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
 *    - Use the Driver Station or SmartDashboard to observe sensor values.
 */

class Robot : public frc::TimedRobot {
private:
    frc::DigitalInput magSense{0}; // Initialize MAGsense on DIO port 0

public:
    void RobotInit() override {
        frc::SmartDashboard::PutString("Sensor Status", "MAGsense Initialized");
    }

    void TeleopPeriodic() override {
        // Read the sensor state (true = no magnet, false = magnet detected)
        bool magnetDetected = !magSense.Get(); // Inverted because LOW = detected

        // Update the dashboard with sensor data
        if (magnetDetected) {
            frc::SmartDashboard::PutString("Magnet Status", "DETECTED");
        } else {
            frc::SmartDashboard::PutString("Magnet Status", "NOT DETECTED");
        }
    }
};

#ifndef RUNNING_FRC_TESTS
int main() {
    return frc::StartRobot<Robot>();
}
#endif
