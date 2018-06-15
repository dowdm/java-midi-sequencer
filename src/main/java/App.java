import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.HashMap;
import java.util.Map;

import static javax.sound.midi.MidiSystem.getMidiDeviceInfo;
import static spark.Spark.*;


public class App {
    public static MidiDevice.Info[] allDevices = getMidiDeviceInfo();
    public static void main(String[] args) {
        staticFileLocation("/public");



        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("devices", allDevices);
            return new ModelAndView(model, "interface.hbs");
        },new HandlebarsTemplateEngine());

    }
}
