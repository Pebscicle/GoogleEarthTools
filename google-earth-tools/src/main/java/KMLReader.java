import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.input.SAXBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

public class KMLReader {
    

    public Document GetKMLDocument(String path)
    {
        //Get string of XML contents
        String kmlContents = "";
        try {
            kmlContents = Files.readString(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Use XML parser to get XML document from string.
        SAXBuilder XMLbuilder = new SAXBuilder();
        Document kmlDocument = null;
        try {
            kmlDocument = (Document) XMLbuilder.build(new StringReader(kmlContents));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kmlDocument;
    }

    public List<Coordinates> getCoordinatesFromKMLPolygon(Document KMLdoc)
    {
        Namespace ns = Namespace.getNamespace("http://www.opengis.net/kml/2.2");
        List<Element> placemark = KMLdoc.getRootElement().getChild("Document", ns).getChildren("Placemark", ns);

        //Element test =  placemark.get(0).getChild("Polygon", ns).getChild("outerBoundaryIs", ns).getChild("LinearRing", ns).getChild("coordinates", ns);
        String shapeCoordinates = placemark.get(0).getChild("Polygon", ns).getChild("outerBoundaryIs", ns).getChild("LinearRing", ns).getChild("coordinates", ns).getTextTrim();

        return convertStringToCoordinates(shapeCoordinates);
    }

    /*
     * 
     */
    public void movePolygonToNewCoordinates()
    {

    }


        private List<Coordinates> convertStringToCoordinates(String coordsString){
            String[] coordsArray = coordsString.split(","); //Get rid of 0 ... part, then the rest are coordinates.
            List<Coordinates> coordsToReturn = new ArrayList<>();
            for(int i = 0; i < coordsArray.length-1; i+=2)
            {
                double longitude = 0;
                double latitude = 0;
                try{
                    //If the coordinate has the Z value, remove it.
                    String[] splitVal = coordsArray[i].split(" ");
                    if(splitVal.length > 1)
                    {
                        coordsArray[i] = splitVal[1];
                    }
                    //Convert string value to double
                    longitude = Double.parseDouble(coordsArray[i]);
                    latitude = Double.parseDouble(coordsArray[i+1]);
                }
                catch(Exception e){e.printStackTrace();}
                Coordinates newCoordinates = new Coordinates(longitude, latitude, 0);
                coordsToReturn.add(newCoordinates);
            }


            return coordsToReturn;
        }


}
