import javax.sound.midi.*;

//import com.sun.media.sound.MidiOutDeviceProvider;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.info;
import static javax.sound.midi.MidiSystem.getMidiDevice;
import static javax.sound.midi.MidiSystem.getMidiDeviceInfo;
import static javax.sound.midi.Sequence.PPQ;
import static spark.Spark.*;


public class App {
    public static MidiDevice.Info[] allDevices = getMidiDeviceInfo();
    public static int installedDevices = allDevices.length;
    public static MidiDevice chosenDevice;
    public static int sequenceLength;
    public static Sequence runningSequence = new Sequence(Sequence.PPQ, 16);
    public  static Track runningTrack = runningSequence.createTrack();
    public int instrument = 0;
    public static int tempo = 120;
    public static void main(String[] args) {
        staticFileLocation("/public");



        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//            if (installedDevices == 0){
//                model.put("devices", null);
//            } else{
//                model.put("devices",allDevices);
                model.put("chosen", chosenDevice);
                model.put("length", sequenceLength);
                model.put("bpm", tempo);
//            }

            return new ModelAndView(model, "interface.hbs");
        },new HandlebarsTemplateEngine());

        get("/interface/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            if (installedDevices == 0){
                model.put("devices", null);
            } else{
                model.put("devices",allDevices);
                model.put("chosen", chosenDevice);
                model.put("bpm", tempo);
            }
            if (chosenDevice != null){
                chosenDevice.open();
            }
            return new ModelAndView(model, "interface.hbs");
        },new HandlebarsTemplateEngine());


        post("/interface", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            chosenDevice =  getMidiDevice(allDevices[Integer.parseInt(request.queryParams("output"))]);
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        get("/steps/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("chosen", chosenDevice);
            model.put("bpm", tempo);
            model.put("length", sequenceLength);
            return new ModelAndView(model, "steps.hbs");
        },new HandlebarsTemplateEngine());

        post("/steps", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            sequenceLength = Integer.parseInt(request.queryParams("steps"));
            tempo = Integer.parseInt(request.queryParams("bpm"));
            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());

        get("/notes/edit", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("chosen", chosenDevice);
            model.put("length", sequenceLength);
            return new ModelAndView(model, "note.hbs");
        },new HandlebarsTemplateEngine());

        post("/notes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
//
//            MidiEvent midiEvent = new MidiEvent();

            response.redirect("/");
            return null;
        },new HandlebarsTemplateEngine());
    }
}
