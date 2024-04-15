package frc.robot;

public class Constants {
    
    public static final double circumferenceInInches = Math.PI * 6;
    public static final double ratio = 10.71;
    public static double multiplier = 1;

    public static class CANid{
        //Talons CANid
        public static int backLeftMotor;
        public static int frontLeftMotor;
        public static int backRightMotor;
        public static int frontRightMotor;
    }

    public static class OperatorC{

        public static int CoPilot = 0;
        public static int L_Joy = 1;
        public static int R_Joy = 2;
    }
}
