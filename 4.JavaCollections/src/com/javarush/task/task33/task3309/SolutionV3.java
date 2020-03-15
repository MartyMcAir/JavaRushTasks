package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Pattern;

// from https://github.com/XFNeo/JavaRushTasks/tree/master/4.JavaCollections/src/com/javarush/task/task33/task3309
public class SolutionV3 {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException, JAXBException {
        System.out.println(toXmlWithComment(new First(), "second", "it's a comment"));
    }

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, TransformerException, ParserConfigurationException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        marshaller.marshal(obj, document);

        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeName().equals(tagName)) {
                node.getParentNode().insertBefore(document.createComment(comment), node);
            }
            replaceTextWithCDATA(node, document);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        ;

        StringWriter result = new StringWriter();

        transformer.transform(new DOMSource(document), new StreamResult(result));

        return result.toString();
    }

    private static void replaceTextWithCDATA(Node node, Document document) {
        if (node.getNodeType() == Node.TEXT_NODE && (Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find())) {
            Node cdataSection = document.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(cdataSection, node);
        }

        NodeList nodeList = node.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            replaceTextWithCDATA(nodeList.item(i), document);
        }
    }

    //////
    @XmlType(name = "first")
    @XmlRootElement
    public static class First {

        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
        @XmlElement(name = "second")
        public String item3 = "";
        @XmlElement(name = "third")
        public String item4;
        @XmlElement(name = "forth")
        public Second[] third = new Second[]{new Second()};
        @XmlElement(name = "fifth")
        public String item5 = "need CDATA because of \"";

    }

    static class Second {
        @XmlElement(name = "second")
        public String item1 = "some string";
        @XmlElement(name = "second")
        public String item2 = "need CDATA because of <second>";
    }
}
