package AeroQuad.configurator.messagesdispatcher;

import java.beans.PropertyChangeListener;

/**
 * FAT INTERFACE FAT INTERFACE
 */
public interface IMessageDispatcher
{
    final String CONNECTION_STATE_CHANGE = "CONNECTION_STATE_CHANGE";
    final String COMM_PORT_OPENED = "COMM_PORT_OPENED";
    final String BAUD_RATE = "BAUD_RATE";
    final String RAW_DATA_MESSAGE_RECEIVED = "RAW_DATA_MESSAGE_RECEIVED";
    final String RAW_DATA_MESSAGE_SENT = "RAW_DATA_MESSAGE_SENT";

    final String GPS_PROPERTY_KEY = "GPS_PROPERTY_KEY";
    final String RANGE_DETECTION_PROPERTY_KEY = "RANGE_DETECTION_PROPERTY_KEY";
    final String CAMERA_STABILITY_PROPERTY_KEY = "CAMERA_STABILITY_PROPERTY_KEY";
    final String BATTERY_MONITOR_PROPERTY_KEY = "BATTERY_MONITOR_PROPERTY_KEY";
    final String MAGNETOMETER_PROPERTY_KEY = "MAGNETOMETER_PROPERTY_KEY";
    final String BAROMETER_PROPERTY_KEY = "BAROMETER_PROPERTY_KEY";
    final String ACCELEROMETER_PROPERTY_KEY = "ACCELEROMETER_PROPERTY_KEY";
    final String GYROSCOPE_PROPERTY_KEY = "GYROSCOPE_PROPERTY_KEY";
    final String NB_MOTORS_PROPERTY_KEY = "NB_MOTORS_PROPERTY_KEY";
    final String NB_RECEIVER_CHANNEL_PROPERTY_KEY = "NB_RECEIVER_CHANNEL_PROPERTY_KEY";
    final String FLIGHT_CONFIG_PROPERTY_KEY = "FLIGHT_CONFIG_PROPERTY_KEY";
    final String BOARD_TYPE_PROPERTY_KEY = "BOARD_TYPE_PROPERTY_KEY";
    final String FLIGHT_SOFTWARE_VERSION_PROPERTY_KEY = "FLIGHT_SOFTWARE_VERSION_PROPERTY_KEY";

    final String MOTOR_ARMED_STATE_CHANGED = "MOTOR_ARMED_STATE_CHANGED";
    final String VEHICLE_ATTITUDE_STATE_CHANGE = "VEHICLE_ATTITUDE_STATE_CHANGE";
    final String VEHICLE_ALTITUDE_STATE_CHANGE = "VEHICLE_ALTITUDE_STATE_CHANGE";
    final String VEHICLE_ZVELOCITY_STATE_CHANGE = "VEHICLE_ZVELOCITY_STATE_CHANGE";
    final String VEHICLE_ALTITUDE_HOLD_STATE_CHANGE = "VEHICLE_ALTITUDE_HOLD_STATE_CHANGE";
    final String VEHICLE_VOLTAGE_STATE_CHANGE = "VEHICLE_VOLTAGE_STATE_CHANGE";
    final String VEHICLE_FLIGHT_MODE_STATE_CHANGE = "VEHICLE_FLIGHT_MODE_STATE_CHANGE";
    final String GPS_INFOS_UPDATED = "GPS_INFOS_UPDATED";

    final String SENSOR_GYRO_X_VALUE_CHANGE = "SENSOR_GYRO_X_VALUE_CHANGE";
    final String SENSOR_GYRO_Y_VALUE_CHANGE = "SENSOR_GYRO_Y_VALUE_CHANGE";
    final String SENSOR_GYRO_Z_VALUE_CHANGE = "SENSOR_GYRO_Z_VALUE_CHANGE";
    final String SENSOR_ACCEL_X_VALUE_CHANGE = "SENSOR_ACCEL_X_VALUE_CHANGE";
    final String SENSOR_ACCEL_Y_VALUE_CHANGE = "SENSOR_ACCEL_Y_VALUE_CHANGE";
    final String SENSOR_ACCEL_Z_VALUE_CHANGE = "SENSOR_ACCEL_Z_VALUE_CHANGE";
    final String SENSOR_MAG_X_VALUE_CHANGE = "SENSOR_MAG_X_VALUE_CHANGE";
    final String SENSOR_MAG_Y_VALUE_CHANGE = "SENSOR_MAG_Y_VALUE_CHANGE";
    final String SENSOR_MAG_Z_VALUE_CHANGE = "SENSOR_MAG_Z_VALUE_CHANGE";
    final String SENSOR_BARO_ALTITUDE_VALUE_CHANGE = "SENSOR_BARO_ALTITUDE_VALUE_CHANGE";
    final String SENSOR_Z_VELOCITY_VALUE_CHANGE = "SENSOR_Z_VELOCITY_VALUE_CHANGE";

    final String COMMUNICATION_USAGE_VALUE_CAHNGED = "COMMUNICATION_USAGE_VALUE_CAHNGED";

    final String RECEIVER_ROLL_STATE_CHANGE = "RECEIVER_ROLL_STATE_CHANGE";
    final String RECEIVER_PITCH_STATE_CHANGE = "RECEIVER_PITCH_STATE_CHANGE";
    final String RECEIVER_YAW_STATE_CHANGE = "RECEIVER_YAW_STATE_CHANGE";
    final String RECEIVER_THROTTLE_STATE_CHANGE = "RECEIVER_THROTTLE_STATE_CHANGE";
    final String RECEIVER_MODE_STATE_CHANGE = "RECEIVER_MODE_STATE_CHANGE";
    final String RECEIVER_AUX1_STATE_CHANGE = "RECEIVER_AUX1_STATE_CHANGE";
    final String RECEIVER_AUX2_STATE_CHANGE = "RECEIVER_AUX2_STATE_CHANGE";
    final String RECEIVER_AUX3_STATE_CHANGE = "RECEIVER_AUX3_STATE_CHANGE";

    final String MOTOR1_THROTTLE_STATE_CHANGE = "MOTOR1_THROTTLE_STATE_CHANGE";
    final String MOTOR2_THROTTLE_STATE_CHANGE = "MOTOR2_THROTTLE_STATE_CHANGE";
    final String MOTOR3_THROTTLE_STATE_CHANGE = "MOTOR3_THROTTLE_STATE_CHANGE";
    final String MOTOR4_THROTTLE_STATE_CHANGE = "MOTOR4_THROTTLE_STATE_CHANGE";
    final String MOTOR5_THROTTLE_STATE_CHANGE = "MOTOR5_THROTTLE_STATE_CHANGE";
    final String MOTOR6_THROTTLE_STATE_CHANGE = "MOTOR6_THROTTLE_STATE_CHANGE";
    final String MOTOR7_THROTTLE_STATE_CHANGE = "MOTOR7_THROTTLE_STATE_CHANGE";
    final String MOTOR8_THROTTLE_STATE_CHANGE = "MOTOR8_THROTTLE_STATE_CHANGE";

    final String ACCRO_PID_DATA_KEY = "ACCRO_PID_DATA_KEY";
    final String ATTITUDE_PID_DATA_KEY = "ATTITUDE_PID_DATA_KEY";
    final String YAW_PID_KEY = "YAW_PID_KEY";
    final String ALTITUDE_HOLD_PID_KEY = "ALTITUDE_HOLD_PID_KEY";
    final String BATTERY_MONITOR_CONFIG_KEY = "BATTERY_MONITOR_CONFIG_KEY";
    final String GPS_PID_KEY = "GPS_PID_KEY";

    final String ACCEL_RAW_DATA_KEY = "ACCEL_RAW_DATA_KEY";
    final String MAG_RAW_DATA_KEY = "MAG_RAW_DATA_KEY";



    void addListener(String propertyName, PropertyChangeListener propertyChangeListener);

    void dispatchMessage(String messageId, Object value);


    //void setHaveGPS(boolean gpsEnabled);
    //void setHaveRangeFinder(boolean rangerEnabled);
    //void setHaveCameraStability(boolean cameraStabilityEnabled);
    //void setHaveBatteryMonitor(boolean batteryMonitorEnabled);
    //void setMagnetometerDectected(boolean magnetometerDetected);
    //void setBarometerDectected(boolean barometerDetected);
    //void setAccelerometerDectected(boolean accelerometerDetected);
    //void setGyroscopeDectected(boolean gyroscopeDetected);
    //void setNbMotors(int nbMotors);
    //void setNbReceiverChannel(int nbReceiverChannel);
    //void setFlightConfig(String data);
    //void setBoardType(String data);
    //void setFlightSoftwareVersion(String data);
    //
    //void setMotorArmed(boolean armed);
    //void setVehicleAttitude(VehicleAttitude vehicleAttitude);
    //void setCurrentAltitude(float altitude);
    //void setAltitudeHoldState(boolean altitudeHoldState);
    //void setCurrentVoltage(float currentVoltage);
    //void setFlightMode(FlightMode flightMode);
    //void setChannelValue(ReceiverChannel channel, String value);
    //void setMotorCommandValue(MotorsIndex motor, String value);


    //void setGyroXValue(String value);
    //void setGyroYValue(String value);
    //void setGyroZValue(String value);
    //void setAccelXValue(String value);
    //void setAccelYValue(String value);
    //void setAccelZValue(String value);
    //void setMagXValue(String value);
    //void setMagYValue(String value);
    //void setMagZValue(String value);
    //
    //void setCommunicationUsage(double value);
}
