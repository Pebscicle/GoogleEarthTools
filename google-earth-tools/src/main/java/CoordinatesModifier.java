import java.util.List;

public class CoordinatesModifier {
    
    public CoordinatesModifier(){}

    /*
     * Method used to move a Coordinates object a given amount of Longitude/Latitude.
     */
    public List<Coordinates> movePolygon(List<Coordinates> coordinates, double longitude, double latitude)
    {
        for(int i  = 0; i < coordinates.size(); i++)
        {
            coordinates.get(i).modifyLatitude(latitude);
            coordinates.get(i).modifyLongitude(longitude);
        }
        return coordinates;
    }

}
