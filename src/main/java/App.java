import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.info;
import static javax.sound.midi.MidiSystem.getMidiDevice;
import static javax.sound.midi.MidiSystem.getMidiDeviceInfo;
import static spark.Spark.*;


public class App {
    public static MidiDevice.Info[] allDevices = getMidiDeviceInfo();
    public static int installedDevices = allDevices.length;
    public static MidiDevice chosenDevice =;
    public static void main(String[] args) {
        staticFileLocation("/public");



        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            if (installedDevices == 0){
                model.put("devices", null);
            } else{
                model.put("devices",allDevices);
            }
            return new ModelAndView(model, "interface.hbs");
        },new HandlebarsTemplateEngine());

        post("/interface", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            chosenDevice =  getMidiDevice(allDevices[Integer.parseInt(request.queryParams("@index"))]);
            return new ModelAndView(model, "interface.hbs");
        },new HandlebarsTemplateEngine());


    }
}
