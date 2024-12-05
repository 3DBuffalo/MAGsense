#define HALL_SENSOR_PIN 1  // Set the pin accordingly, This must be set on a DIGITAL enabled pin

void setup() {
  pinMode(HALL_SENSOR_PIN, INPUT);
  Serial.begin(9600);//115200 for Echo MK1
}

void loop() {
  int sensorState = digitalRead(HALL_SENSOR_PIN);
  if (sensorState == HIGH) {
    Serial.println("Magnet Detected");
  } else {
    Serial.println("No Magnet");
  }
  delay(500); // Delay for readability, adjust as needed
}
