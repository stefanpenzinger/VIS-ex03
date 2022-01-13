package task_3_1_b;

/**
 * WindData object to parse string.xml file
 *
 * mSpeed = wind speed
 * mDeg = degree of wind
 */
public class WindData {
    private String mSpeed;
    private String mDeg;

    public String getmSpeed() {
        return mSpeed;
    }

    public void setmSpeed(String _mSpeed) {
        this.mSpeed = _mSpeed;
    }

    public String getmDeg() {
        return mDeg;
    }

    public void setmDeg(String _mDeg) {
        this.mDeg = _mDeg;
    }

    @Override
    public String toString() {
        return "WindData: " + "Speed=" + mSpeed +" Deg=" + mDeg;
    }
}
