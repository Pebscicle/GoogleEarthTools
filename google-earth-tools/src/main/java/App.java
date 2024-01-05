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
        String path = System.getProperty("user.dir")+"/google-earth-tools/src/kml/Michigan.kml";

        Document kmlDocument = kmlReader.GetKMLDocument(path);
        
        List<Coordinates> coordinates = kmlReader.getCoordinatesFromKMLPolygon(kmlDocument);

        //Move Polygon
        coordinatesModifier.movePolygon(coordinates, -10, -10);

        kmlWriter.modifyPolygonCoordinates(kmlDocument, coordinates);
        
        String savePath = System.getProperty("user.dir")+"/google-earth-tools/generated/Michigan.kml";
        if(kmlWriter.saveKmlDocument(savePath, kmlDocument)){
            System.out.println("KML file cloned and modified.");
        }

    }
}
