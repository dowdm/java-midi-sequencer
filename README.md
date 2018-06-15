# **MIDI-Sequencer**(not functioning)

#### By Matt Dowdney

### This is a MIDI sequencer for sequencing external MIDI equipment (synthesizers)from a browser. It will rely on Java's own MIDI libraries. 

## TO DO: get app working. after much research, it seems that the following should work:
####
1. Create a MidiSystem Sequencer for Track playback and tempo reception with Midisystem.getSequencer();
2. Set the sequencer to loop infinitely with  myseq.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
3. Have the handlebars tempo variable update the Sequencer tempo with setTempoInBPM(int) method.
4. Create a Track object Sequence.createTrack(); 
5. Update the track object with track.add(MidiEvent). The MidiEvent objects will be a composite "note on" event from the note sliders(note, velocity, channel ). A corresponding "note-off" event will be generated "x" ms later as determined by the value gate slider.
6. Calculating the original Midi-Event timestamps???- I need to figure this out. The math probably isn't very difficult, if using a lower resolution PPQ value.
&. UI needs responsive feedback for variable values. I'm not sure if this is possible within spark alone. May require jquery, but trying to avoid js to keep MIDI timing as reliable as possible.  
  

  

## Specifications

|Specification  | Input | Output |
| ----- | --- | --- |
| Select your MIDI output | Steinberg UR22 | output set to Steinberg UR22 |
| Enter an octave | 2 |  |
| Enter a note | G | G-2 |
| Enter velocity | 127|  |
| Enter gate | 120ms  |  A note on message is sent for g2 with a velocity of 127, 120 ms later a note off message for the same note is sent  |








## Setup/Installation Requirements
* To view project code, visit: https://github.com/dowdm/java-midi-sequencer.git

* To view project from build:
 
1. Have a class compliant MIDI interface installed
2. Clone or download project from https://github.com/dowdm/java-midi-sequencer.git . Install developer dependencies(Spark, Handlebars, JUnit). 
3. Compile the App.java file in a Java compiler or IDE such as IntelliJ. 
4. Run App. 
5. Open a browser to http://localhost:4567 . 
6. Enjoy. 






## Known Bugs

## Technologies Used

* Java 8 
* JUnit 4 
* IntelliJ Community 2018 
* Spark 2.6.0 
* Handlebars Spark Template 2.5.5




## License

* GPL

Matt Dowdney © 2018