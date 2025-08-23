package com.qiantangnotes.util;

import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Constructor;

public class XMLUtil
{
    public static Object getBean()
    {
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();
            File file = new ClassPathResource("config.xml").getFile();
            Document doc = builder.parse(file);
            NodeList nl = doc.getElementsByTagName("className");
            String cName = nl.item(0).getFirstChild().getNodeValue();
            Class<?> c = Class.forName(cName);
            Constructor<?> declaredConstructor = c.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance();

        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
