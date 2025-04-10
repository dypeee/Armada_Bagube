abstract class SmartDevice {
    String deviceName;

    SmartDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    abstract void turnOn();
    abstract void turnOff();

    public void showStatus() {
        System.out.println("Device: " + deviceName);
    }
}

class SmartLight extends SmartDevice {
    public SmartLight() {
        super("Smart Light");
    }

    @Override
    void turnOn() {
        System.out.println("Light is now ON");
    }

    @Override
    void turnOff() {
        System.out.println("Light is now OFF");
    }
}

class SmartSpeaker extends SmartDevice {
    public SmartSpeaker() {
        super("Smart Speaker");
    }

    @Override
    void turnOn() {
        System.out.println("Speaker is now playing music");
    }

    @Override
    void turnOff() {
        System.out.println("Speaker is now OFF");
    }
}

public class Main {
    public static void main(String[] args) {
        SmartDevice light = new SmartLight();
        light.turnOn();
        light.showStatus();
        light.turnOff();

        System.out.println();

        SmartDevice speaker = new SmartSpeaker();
        speaker.turnOn();
        speaker.showStatus();
        speaker.turnOff();
    }
}
