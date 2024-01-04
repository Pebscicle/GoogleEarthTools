public class Coordinates {
    
    private double Longitude; //-180 to 180
    public double X(){return Longitude;}
    private double Latitude; //-90 to 90
    public double Y(){return Latitude;}
    private double Z; 
    public double Z(){return Z;}

    //CONSTANTS
    private static final double MIN_LONG = -180; private static final double MAX_LONG = 180;
    private static final double MIN_LAT = -90; private static final double MAX_LAT = 90;

    public Coordinates(double longit, double latit, double z){
        Longitude = longit;
        Latitude = latit;
        Z = z;
    }

    //Modify Coordinates

    //Modify Longitude
    /**
     * Modifies the longitude by adding the specified value.
     *
     * @param longToAdd The value to add to the longitude.
     */
    public void modifyLongitude(double longToAdd){
        Longitude += longToAdd;
        if(Longitude > MAX_LONG)
        {
            double remainder = Longitude%MAX_LONG;
            Longitude = MIN_LONG+remainder;
        }else if(Longitude < MIN_LONG)
        {
            double remainder = Longitude%MIN_LONG;
            Longitude = MAX_LONG+remainder;
        }
    }

    //Modify Latitude
    /**
     * Modifies the latitude by adding the specified value.
     *
     * @param latToAdd The value to add to the latitude.
     */
    public void modifyLatitude(double latToAdd){
        Latitude += latToAdd;
        if(Latitude > MAX_LAT)
        {
            Latitude = MAX_LAT;
        }else if(Latitude < MIN_LAT)
        {
            Latitude = MIN_LAT;
        }
    }

}
