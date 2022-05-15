package jw795;

/**
 * A record class of the optimization settings. Default is that everything is on.
 */
public class OptSettings {
    boolean reg = false;
    boolean copy = false;
    boolean dce = false;
    boolean cse = false;
    boolean cf = false;

    boolean optIRInit = false;
    boolean optIRFinal = false;
    boolean optCFGInit = false;
    boolean optCFGFinal = false;

    public void setReg(boolean ifOn) {
        reg = ifOn;
    }

    public void setCopy(boolean ifOn) {
        copy = ifOn;
    }

    public void setDce(boolean ifOn) {
        dce = ifOn;
    }

    public void setCse(boolean ifOn) {
        cse = ifOn;
    }

    public void setCf(boolean ifOn) {
        cf = ifOn;
    }

    public boolean reg() {
        return reg;
    }

    public boolean copy() {
        return copy;
    }

    public boolean dce() {
        return dce;
    }

    public boolean cse() {
        return cse;
    }

    public boolean cf() {
        return cf;
    }

    public void setOptIRInit(boolean ifOn) {
        optIRInit = ifOn;
    }

    public void setOptIRFinal(boolean optIRFinal) {
        this.optIRFinal = optIRFinal;
    }

    public void setOptCFGInit(boolean optCFGInit) {
        this.optCFGInit = optCFGInit;
    }

    public void setOptCFGFinal(boolean optCFGFinal) {
        this.optCFGFinal = optCFGFinal;
    }

    public boolean optIRInit() {
        return optIRInit;
    }

    public boolean optIRFinal() {
        return optIRFinal;
    }

    public boolean optCFGInit() {
        return optCFGInit;
    }

    public boolean optCFGFinal() {
        return optCFGFinal;
    }

    @Override
    public String toString() {
        String str = "";
        str += "reg " + reg + "\n";
        str += "copy " + copy + "\n";
        str += "dce " + dce + "\n";
        str += "cse " + cse + "\n";
        str += "cf " + cf + "\n";
        str += "optir-init " + optIRInit + "\n";
        str += "optir-final " + optIRFinal + "\n";
        str += "optcfg-init " + optCFGInit + "\n";
        str += "optcfg-final " + optCFGFinal + "\n";
        return str;

    }
}
