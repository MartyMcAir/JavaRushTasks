package com.javarush.task.task33.task3309;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.regex.Pattern;

/*
Комментарий внутри xml
*/
// from https://github.com/Sukora-Stas/JavaRushTasks/blob/master/4.JavaCollections/src/com/javarush/task/task33/task3309/Solution.java
public class Solution {
    public static void main(String[] args) throws JAXBException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 6;
        cat.weight = 4;

        System.out.println(toXmlWithComment(cat, "age", "it's a comment"));
    }

    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller(); // созд маршала для сериализации
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // ставим читабельный вывод (с \n)

            // парсер DOM from XML документов
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            marshaller.marshal(obj, doc); // парсим XML в DOM

            NodeList nodes = doc.getElementsByTagName("*");  // список для DOM

            for (int i = 0; i < nodes.getLength(); i++) { // обход DOM списка
                Node node = nodes.item(i);

                if (node.getNodeName().equals(tagName)) { // если имя ноды совпало с тэгом
                    Comment com = doc.createComment(comment); // создаем коммент
                    // получаем родительскую ноду, и вставляем перед ней коммент и соответств.. ноду
                    node.getParentNode().insertBefore(com, node);
                }
                replaceTextWithCDATA(node, doc);
            }
            // магия транформера..
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            StringWriter sw = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void replaceTextWithCDATA(Node node, Document doc) {
        if ((node.getNodeType() == 3) && (Pattern.compile("[<>&'\"]").matcher(node.getTextContent()).find())) {

            Node cnode = doc.createCDATASection(node.getNodeValue());
            node.getParentNode().replaceChild(cnode, node);
        }

        NodeList list = node.getChildNodes();

        for (int i = 0; i < list.getLength(); i++) {
            replaceTextWithCDATA(list.item(i), doc);
        }
    }

    /////////
    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
        public int age;
        public int weight;

        Cat() {
        }
    }
}
