package jw795;

/**
 * A record class of the optimization settings.
 */
public class OptSettings {
    boolean reg = false;
    boolean copy = false;
    boolean dce = false;
    boolean lu = false;
    boolean cf = false;

    public void setReg(boolean ifOn) {
        reg = ifOn;
    }

    public void setCopy(boolean ifOn) {
        copy = ifOn;
    }

    public void setDce(boolean ifOn) {
        dce = ifOn;
    }

    public void setLu(boolean ifOn) {
        lu = ifOn;
    }

    public void setCf(boolean ifOn) {
        cf = ifOn;
    }

    public boolean reg() {
        return reg;
    }

    public boolean copy() {
        return reg;
    }

    public boolean dce() {
        return reg;
    }

    public boolean lu() {
        return reg;
    }

    public boolean cf() {
        return reg;
    }


}
