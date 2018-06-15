package models;


import javax.sound.midi.MidiDevice;
import java.lang.reflect.Array;
import java.util.List;

import static javax.sound.midi.MidiSystem.getMidiDeviceInfo;

public class SystemDevice {

   public static MidiDevice.Info[] allDevices = getMidiDeviceInfo();
    public SystemDevice(){

    }


}
