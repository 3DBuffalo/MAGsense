from wpilib import TimedRobot, DigitalInput, SmartDashboard

"""
STEPS TO SET UP THE MAGsense SENSOR FOR FRC:
1. Check the sensor specifications:
   - The MAGsense sensor requires 3.3V power input.
   - It outputs digital signals (HIGH/LOW) via a 4-pin connector.
2. Modify the wiring to connect the sensor to the roboRIO:
   - The MAGsense sensor has 4 pins: 3.3V, GND, SIG1, SIG2.
   - The roboRIO’s Digital Input (DIO) ports have 3 pins: 3.3V, GND, and SIG.
   - Connect the included 4-pin sensor cable to a custom 3-wire cable:
       - 3.3V → 3.3V (red wire on DIO port).
       - GND → GND (black wire on DIO port).
       - SIG1 → SIG (white wire on DIO port).
   - Leave SIG2 unconnected.
3. Plug the modified 3-wire cable into any available DIO port on the roboRIO.
   - It doesn’t matter which digital pin is used on the MAGsense sensor, as SIG1 and SIG2 provide identical outputs.
4. Deploy and test:
   - Upload the code to the roboRIO.
   - Use the Driver Station or SmartDashboard to observe sensor values.
"""

class Robot(TimedRobot):
    def robotInit(self):
        # Initialize MAGsense on DIO port 0
        self.magSense = DigitalInput(0)

        # Display sensor status on the dashboard
        SmartDashboard.putString("Sensor Status", "MAGsense Initialized")

    def teleopPeriodic(self):
        # Read the sensor state (True = no magnet, False = magnet detected)
        magnet_detected = not self.magSense.get()  # Inverted because LOW = detected

        # Update the dashboard with sensor data
        if magnet_detected:
            SmartDashboard.putString("Magnet Status", "DETECTED")
        else:
            SmartDashboard.putString("Magnet Status", "NOT DETECTED")


if __name__ == "__main__":
    from wpilib import run
    run(Robot)
