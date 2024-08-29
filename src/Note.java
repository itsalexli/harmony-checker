public class Note {
    private String step;
    private int duration;
    private String type;
    private String voice;
    private String stem;

    public Note(String step, int duration, String type, String voice, String stem) {
        this.step = step;
        this.type = type;
        this.voice = voice;
        this.stem = stem;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getStem() {
        return Stem;
    }

    public void setStem(String stem) {
        Stem = stem;
    }

}