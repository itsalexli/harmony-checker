public class Note {
    private String step,type,voice,stem;
    private int staff,octave,duration;

    public Note(int staff, String step, int octave, int duration, String type, String voice, String stem) {
        this.staff = staff;
        this.step = step;
        this.octave = octave;
        this.type = type;
        this.voice = voice;
        this.stem = stem;
        this.staff = staff;
    }

    @Override
    public String toString() {
        return "Note{" +
                "step='" + step + '\'' +
                ", duration=" + duration +
                ", type='" + type + '\'' +
                ", voice='" + voice + '\'' +
                ", stem='" + stem + '\'' +
                ", staff=" + staff +
                ", octave=" + octave +
                '}';
    }
//getter and setters
    public String getStep() {return step;}
    public void setStep(String step) {this.step = step;}

    public int getDuration() {return duration;}
    public void setDuration(int duration) {this.duration = duration;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getVoice() {return voice;}
    public void setVoice(String voice) {this.voice = voice;}

    public String getStem() {return stem;}
    public void setStem(String stem) {this.stem = stem;}

    public int getStaff() {return staff;}
    public void setStaff(int staff) {this.staff = staff;}

    public int getOctave() {return octave;}
    public void setOctave(int octave) {this.octave = octave;}
}