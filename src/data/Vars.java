package data;

/**
 * Created by Sphiinx on 4/14/2016.
 */
public class Vars {

    public static Vars vars;

    public static Vars get() {
        return vars == null ? vars = new Vars() : vars;
    }

    public static void reset() {
        vars = null;
    }

    public String imgurTitle = "";
    public String imgurImage = "";

    public boolean stopProgram;

    public long startTime;

}

