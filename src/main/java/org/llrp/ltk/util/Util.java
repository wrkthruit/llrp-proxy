package org.llrp.ltk.util;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.llrp.ltk.exceptions.InvalidLLRPMessageException;
import org.llrp.ltk.generated.LLRPMessageFactory;
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.LLRPMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Util.java provides a number of utility methods such
 * loading a binary message or XML message from a file.
 */


public class Util {


    static final Logger LOGGER = LoggerFactory.getLogger("Util.class");


    /**
     * loads a binary file from the file system and returns a LLRPBitList object
     *
     * @param file
     * @return LLRPBitList containing file contents
     * @throws IOException
     * @throws FileNotFoundException
     */

    public static LLRPBitList loadBinaryFileContent(File file) throws IOException, FileNotFoundException {


        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);


        LLRPBitList bitlist = new LLRPBitList();

        while (bis.available() > 0) {
            byte[] bytes = new byte[bis.available()];
            int length = bis.read(bytes);
            bitlist.append(new LLRPBitList(bytes));
        }

        fis.close();
        bis.close();
        return bitlist;

    }


    /**
     * loads a text file from the file system and returns the contents as a string
     *
     * @param file
     * @return string containing file contents
     * @throws IOException
     * @throws FileNotFoundException
     */

    public static String loadTextFileContent(File file) throws IOException, FileNotFoundException {

        FileReader fis = null;
        BufferedReader bis = null;
        StringBuffer buffer = new StringBuffer();
        String line;

        fis = new FileReader(file);

        // Here BufferedReader is added for fast reading.
        bis = new BufferedReader(fis);
        line = bis.readLine();
        while (line != null) { // co

            // this statement reads the line from the file and print it to
            // the console.
            buffer.append(line);
            line = bis.readLine();
        }

        return buffer.toString();
    }

    /**
     * loads a binary LLRPMessage from the file system and returns an LLRPMessage object
     *
     * @param file
     * @return LLRPMessage
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidLLRPMessageException
     */

    public static LLRPMessage loadBinaryLLRPMessage(File file) throws FileNotFoundException, IOException, InvalidLLRPMessageException {


        LLRPBitList bits = loadBinaryFileContent(file);
        LOGGER.debug("Loaded binary message: " + bits);
        LLRPMessage message = LLRPMessageFactory.createLLRPMessage(bits);

        return message;
    }

    /**
     * loads a LLRPMessage in LTK-XML format from the file system and returns an LLRPMessage object
     *
     * @param file
     * @return LLRPMessage
     * @throws FileNotFoundException
     * @throws IOException
     * @throws InvalidLLRPMessageException
     */

    public static LLRPMessage loadXMLLLRPMessage(File file) throws FileNotFoundException, IOException, JDOMException, InvalidLLRPMessageException {

        Document doc = new org.jdom.input.SAXBuilder().build(new
                FileReader(file));
        XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
        LOGGER.debug("Loaded XML Message: " + outputter.outputString(doc));
        LLRPMessage message = LLRPMessageFactory.createLLRPMessage(doc);

        return message;
    }

    public static LLRPMessage loadXMLLLRPMessage() throws FileNotFoundException, IOException, JDOMException, InvalidLLRPMessageException {


        LLRPMessage message = LLRPMessageFactory.createLLRPMessage(new LLRPBitList("0000010000111111000000000000000000000000001000000000000000000000000000000000010000000000111101100000000000010110000000001000000000000000000011000000000000000101110101011000101111010111000101000011000101100110000000010000000000000000000001100000000000000000"));

        return message;
    }


}
