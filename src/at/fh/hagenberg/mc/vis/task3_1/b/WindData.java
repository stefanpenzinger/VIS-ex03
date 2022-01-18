package at.fh.hagenberg.mc.vis.task3_1.b;

/**
 * WindData object to parse string.xml file
 *
 * mSpeed = wind speed
 * mDeg = degree of wind
 */
public class WindData {
    private String mSpeed;
    private String mDeg;

    /**
     * Returns wind speed
     * @return String
     */
    public String getmSpeed() {
        return mSpeed;
    }

    /**
     * Sets wind speed
     * @param _mSpeed String
     */
    public void setmSpeed(String _mSpeed) {
        this.mSpeed = _mSpeed;
    }

    /**
     * Get degree
     * @return String
     */
    public String getmDeg() {
        return mDeg;
    }

    /**
     * Sets degree
     * @param _mDeg String
     */
    public void setmDeg(String _mDeg) {
        this.mDeg = _mDeg;
    }

    /**
     * String representation of WindData
     * @return String
     */
    @Override
    public String toString() {
        return "WindData: " + "Speed=" + mSpeed +" Deg=" + mDeg;
    }
}
