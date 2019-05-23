package Controller;
import Player.Player;
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
    public static final String filepath="";
    ArrayList<String> names=new ArrayList<>();
     StreamResult streamResult;       
     TransformerFactory transformerFactory;       
     Transformer transformer;       
    DocumentBuilderFactory documentFactory;
    DocumentBuilder documentBuilder;
    Document document;
    Element root;
     DOMSource domSource;
    public CreateXML() {
    	
        try {
           documentFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentFactory.newDocumentBuilder();
            document=documentBuilder.newDocument();
          streamResult=new StreamResult(new File(filepath));
            //root element
            root=document.createElement("players");
            document.appendChild(root);
          transformerFactory=TransformerFactory.newInstance();
            Transformer transformer=transformerFactory.newTransformer();
           domSource=new DOMSource(document);
            StreamResult streamResult=new StreamResult(new File(filepath));
            transformer.transform(domSource,streamResult);
                 
        }catch(ParserConfigurationException pce){
            System.out.println(pce.getMessage());
        }catch(TransformerException tfe){

            System.out.println(tfe.getMessage());

        }

    	
    	
    	
    }
    public void createfile(){
    	
        try {
         for(int i=0;i<GameEngine.getInstance(GameEngine.Level.EASY,new Player()).players.size();i++){
             System.out.println(GameEngine.getInstance(GameEngine.Level.EASY,new Player()).players.get(i).getName());
             
            Element state=document.createElement("player");
            
            Attr attr=document.createAttribute("id");
            attr.setValue(String.valueOf(i));
            state.setAttributeNode(attr);
            Element g=document.createElement("name");
            g.appendChild(document.createTextNode(String.valueOf(GameEngine.getInstance(GameEngine.Level.EASY,new Player()).players.get(i).getName())));
            state.appendChild(g);
            Element e=document.createElement("Easy");
            e.appendChild(document.createTextNode(String.valueOf(GameEngine.getInstance(GameEngine.Level.EASY,new Player()).players.get(i).getEasyHighScore())));
            state.appendChild(e);
            Element m=document.createElement("Medium");
            m.appendChild(document.createTextNode(String.valueOf(GameEngine.getInstance(GameEngine.Level.EASY,new Player()).players.get(i).getMedHighScore())));
            state.appendChild(m);
            Element h=document.createElement("Hard");
            h.appendChild(document.createTextNode(String.valueOf(GameEngine.getInstance(GameEngine.Level.EASY,new Player()).players.get(i).getHardHighScore())));
            state.appendChild(h);
            root.appendChild(state);
            Element k=document.createElement("arcade");
            k.appendChild(document.createTextNode(String.valueOf(GameEngine.getInstance(GameEngine.Level.EASY,new Player()).players.get(i).getArcadeHighScore())));
            state.appendChild(k);
            root.appendChild(state);
         
            //Transform the DOM object to an XML file
            transformerFactory=TransformerFactory.newInstance();
            transformer=transformerFactory.newTransformer();
            domSource=new DOMSource(document);
            transformer.transform(domSource,streamResult);

         
        }
       
        }catch(TransformerException tfe){

            System.out.println(tfe.getMessage());

        }




    }
public void readfile(){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document=builder.parse(new File(filepath));
            document.getDocumentElement().normalize();
            Element root=document.getDocumentElement();
            NodeList nodeList=document.getElementsByTagName("player");

            for(int temp=0;temp<nodeList.getLength();temp++){
                Node node=nodeList.item(temp);
                if (node.getNodeType()== Node.ELEMENT_NODE){
                   
                    Player player=new Player();
                    player.setName(((Element)node.getChildNodes().item(temp)).getElementsByTagName("name").item(0).getTextContent());
                     player.setEasyHighScore(Integer.parseInt(((Element)node.getChildNodes().item(temp)).getElementsByTagName("Easy").item(0).getTextContent()));
                      player.setMedHighScore(Integer.parseInt(((Element)node.getChildNodes().item(temp)).getElementsByTagName("Medium").item(0).getTextContent()));
                       player.setHardHighScore(Integer.parseInt(((Element)node.getChildNodes().item(temp)).getElementsByTagName("Hard").item(0).getTextContent()));
                        player.setArcadehScore(Integer.parseInt(((Element)node.getChildNodes().item(temp)).getElementsByTagName("arcade").item(0).getTextContent()));
                            
                            GameEngine.getInstance(GameEngine.Level.EASY,new Player()).players.add(player);
                            
                            
                            
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
