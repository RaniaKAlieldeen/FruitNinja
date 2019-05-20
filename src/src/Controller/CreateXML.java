package Controller;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CreateXML {
    public static final String filepath="F:\\New folder\\project\\rivercrossing\\xmlfile.xml";
    ArrayList<String> names=new ArrayList<>();
    public void createfile(){
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document=documentBuilder.newDocument();

            //root element
            Element root=document.createElement("GameStates");
            document.appendChild(root);

            //state element
            Element state=document.createElement("Gamestate");
            root.appendChild(state);

            //set an attribute for the element
            Attr attr=document.createAttribute("id");
            attr.setValue(Gamestate.getGamestate().getId());
            state.setAttributeNode(attr);
            //FarmerX element
            Element farmerX=document.createElement("farmerX");
            farmerX.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getFarmerX())));
            state.appendChild(farmerX);

            //FarmerY element
            Element farmerY=document.createElement("farmerY");
            farmerY.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getFarmerY())));
            state.appendChild(farmerY);
            //wolfX element
            Element wolfX=document.createElement("wolfX");
            wolfX.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getWolfX())));
            state.appendChild(wolfX);
            //wolfY element
            Element wolfY=document.createElement("wolfY");
            wolfY.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getWolfY())));
            state.appendChild(wolfY);
            //goatX element
            Element goatX=document.createElement("goatX");
            goatX.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getGoatX())));
            state.appendChild(goatX);
            //goatY element
            Element goatY=document.createElement("goatY");
            goatY.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getGoatY())));
            state.appendChild(goatY);
            //PlantX element
            Element plantX=document.createElement("plantX");
            plantX.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getPlantX())));
            state.appendChild(plantX);
            //plantY element
            Element plantY=document.createElement("plantY");
            plantY.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getPlantY())));
            state.appendChild(plantY);
            //boatX element
            Element boatX=document.createElement("boatX");
            boatX.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getBoatpositionX())));
            state.appendChild(boatX);
            //boatY element
            Element boatY=document.createElement("boatY");
            boatY.appendChild(document.createTextNode(String.valueOf(Gamestate.getGamestate().getBoatpositionY())));
            state.appendChild(boatY);
            //LeftBank
            Element LeftBank=document.createElement("LeftBank");
            Element plant=document.createElement("plant");
            Element farmer=document.createElement("farmer");
            Element goat=document.createElement("goat");
            Element wolf=document.createElement("wolf");
            LeftBank.appendChild(plant);
            LeftBank.appendChild(farmer);
            LeftBank.appendChild(goat);
            LeftBank.appendChild(wolf);
            if(Game.leftbankcrossers.contains(Farmer.getFarmer())) {
                farmer.appendChild(document.createTextNode("true"));
            }
            if(Game.leftbankcrossers.contains(Plant.getplant())){
                plant.appendChild(document.createTextNode("true"));

            }
             if(Game.leftbankcrossers.contains(Wolf.getwolf())){
                wolf.appendChild(document.createTextNode("true"));

            }
              if(Game.leftbankcrossers.contains(Goat.getgoat())){
                goat.appendChild(document.createTextNode("true"));

            }
            state.appendChild(LeftBank);

            //Transform the DOM object to an XML file
            TransformerFactory transformerFactory=TransformerFactory.newInstance();
            Transformer transformer=transformerFactory.newTransformer();
            DOMSource domSource=new DOMSource(document);
            StreamResult streamResult=new StreamResult(new File(filepath));
            transformer.transform(domSource,streamResult);


        }catch(ParserConfigurationException pce){




            System.out.println(pce.getMessage());
        }catch(TransformerException tfe){

            System.out.println(tfe.getMessage());

        }




    }
public void readfile(String id){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document=builder.parse(new File(filepath));
            Element root=document.getDocumentElement();
            NodeList nodeList=document.getElementsByTagName("Gamestate");

            for(int temp=0;temp<nodeList.getLength();temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Node z = nodeList.item(temp).getChildNodes().item(10);
                    for(int i=0;i<z.getChildNodes().getLength();i++){
                        if(z.getChildNodes().item(i).getTextContent().equals("true")){



                        }



                    }



                    }


                }


        }catch(ParserConfigurationException pce){

            System.out.println(pce.getMessage());

        }catch(SAXException se){

            System.out.println(se.getMessage());

        }catch(IOException io){

            System.out.println(io.getMessage());

        }


}

}

