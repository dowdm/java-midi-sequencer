# **MIDI-Sequencer**

#### By Matt Dowdney

### This is a MIDI sequencer for sequencing external MIDI equipment from a browser. It will rely on Java's own MIDI and sound libraries and create only new classes when necessary.  

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