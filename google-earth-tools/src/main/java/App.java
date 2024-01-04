import java.util.List;

import org.jdom2.Document;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        KMLReader kmlReader = new KMLReader();
        KMLWriter kmlWriter = new KMLWriter();
        CoordinatesModifier coordinatesModifier = new CoordinatesModifier();
        String path = System.getProperty("user.dir")+"/google-earth-tools/src/kml/MoverTest.kml";

        Document kmlDocument = kmlReader.GetKMLDocument(path);
        
        List<Coordinates> coordinates = kmlReader.getCoordinatesFromKMLPolygon(kmlDocument);
        

    }
}
