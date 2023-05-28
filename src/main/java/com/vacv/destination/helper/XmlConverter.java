package com.vacv.destination.helper;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class XmlConverter<T> {

   public T unmarshal(Class<T> clazz, String xmlString) throws JAXBException {
       JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
       Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
       return (T) unmarshaller.unmarshal(new StringReader(xmlString));

   }
}
