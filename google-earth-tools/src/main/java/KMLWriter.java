import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.output.XMLOutputter;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.Namespace;

public class KMLWriter {
    
    public KMLWriter(){
        System.out.println("KML Writer Initialized");
    }


    /*
     * 
     */
    public Document modifyPolygonCoordinates(Document KMLdoc, List<Coordinates> coordinates)
    {
        Namespace ns = Namespace.getNamespace("http://www.opengis.net/kml/2.2");
        List<Element> placemark = KMLdoc.getRootElement().getChild("Document", ns).getChildren("Placemark", ns);

        Element coordinatesElement = placemark.get(0).getChild("Polygon", ns).getChild("outerBoundaryIs", ns).getChild("LinearRing", ns).getChild("coordinates", ns);

        String coordinatesAsString = getStringFromCoordinatesList(coordinates);

        coordinatesElement.setText(coordinatesAsString);

        return KMLdoc;
    }

    public boolean saveKmlDocument(String savePath, Document doc) {
        boolean success = false;
    
        try {
            // Create directories if they don't exist
            File parentDir = new File(savePath).getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Serialize the Document object to a .kml file
            File file = new File(savePath);
            FileOutputStream out = new FileOutputStream(file);

            XMLOutputter xml = new XMLOutputter();
            xml.output(doc, out);

            out.close();
    
            // If the code reaches here, the saving was successful
            success = true;

        } catch (IOException e) {
            e.printStackTrace(); 
        }
    
        return success;
    }

        private String getStringFromCoordinatesList(List<Coordinates> coords){
            StringBuffer coordsString = new StringBuffer();
            for(int i = 0; i < coords.size(); i++){
                coordsString.append(coords.get(i).toString());
            }
            return coordsString.toString();
        }
    

}
