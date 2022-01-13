package at.fh.hagenberg.mc.vis.task3_1.a;

/**
 * The data container of WGS
 */
public class WGS {
    /**
     * @val float mLatitude
     * The latitude of the WGS
     */
    private float mLatitude;
    /**
     * @val float mLongitude
     * The longitude of the WGS
     */
    private float mLongitude;

    /**
     * The constructor of WSG
     * @param _latitude latitude of the WSG
     * @param _longitude longitude of the WSG
     */
    public WGS(float _latitude, float _longitude) {
        this.mLatitude = _latitude;
        this.mLongitude = _longitude;
    }

    /**
     * Returns the latitude
     * @return float
     */
    public float getLatitude() {
        return mLatitude;
    }

    /**
     * Returns the longitude
     * @return float
     */
    public float getLongitude() {
        return mLongitude;
    }

    /**
     * Returns string representation of the data container
     * @return String
     */
    @Override
    public String toString() {
        return "WGS has " +
                "a latitude of " + mLatitude +
                " and a longitude of " + mLongitude +
                '.';
    }
}
