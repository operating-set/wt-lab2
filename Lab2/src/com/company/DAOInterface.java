package com.company;

import org.w3c.dom.Document;
import javax.xml.xpath.XPathExpressionException;

/**
 * Interface
 * @version 1.0
 * @author Garkun Ivan
 */
public interface DAOInterface {
    /**
     * Method for output list of products from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    void printProducts(Document document) throws XPathExpressionException;
    /**
     * Method for output kettles from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    void printKettles(Document document) throws XPathExpressionException;
    /**
     * Method for output product with minimal cost from XML
     * @param document - source file
     * @throws XPathExpressionException - exception
     */
    void printCheapest(Document document) throws XPathExpressionException;
}
