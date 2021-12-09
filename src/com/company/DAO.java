package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.*;

/**
 * Class for a data access object.
 * @author  Garkun Ivan
 * @version  1.0
 */
public class DAO implements DAOInterface {
    /**
     * Method for output list of  all products from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    @Override
    public void printProducts(Document document) throws XPathExpressionException {
        System.out.print("Список товаров:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("/products");

        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
    }

    /**
     * Method for output only kettles from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    @Override
    public void printKettles(Document document) throws XPathExpressionException {
        System.out.print("Чайники:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expression = xPath.compile("//product[info/@type='kettle']");

        NodeList nodes = (NodeList) expression.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
        System.out.println();
    }

    /**
     * Method for output product with minimal cost from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    @Override
    public void printCheapest(Document document) throws XPathExpressionException {
        System.out.print("Самые дешёвые товары:");

        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xPath = pathFactory.newXPath();
        XPathExpression expr = xPath.compile("//product[not(price > //product/price)]");

        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.print(node.getTextContent());
        }
    }
}
