/*
 *
 * This file was generated by LLRP Code Generator
 * see http://llrp-toolkit.cvs.sourceforge.net/llrp-toolkit/
 * for more information
 * Generated on: Sun Apr 08 14:14:11 EDT 2012;
 *
 */

/*
 * Copyright 2007 ETH Zurich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 */
package org.llrp.ltk.generated.parameters;

import org.jdom.Content;
import org.jdom.Element;
import org.jdom.Namespace;
import org.llrp.ltk.exceptions.InvalidLLRPMessageException;
import org.llrp.ltk.exceptions.MissingParameterException;
import org.llrp.ltk.generated.LLRPConstants;
import org.llrp.ltk.types.Bit;
import org.llrp.ltk.types.BitList;
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.SignedShort;
import org.llrp.ltk.types.TLVParameter;
import org.llrp.ltk.types.UnsignedShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * This parameter carries a single antenna's properties. The properties include the gain and the connectivity status of the antenna.The antenna gain is the composite gain and includes the loss of the associated cable from the Reader to the antenna. The gain is represented in dBi*100 to allow fractional dBi representation.

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=73&view=fit">LLRP Specification Section 12.2.5</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=141&view=fit">LLRP Specification Section 16.2.6.5</a>}


 */

/**
 * This parameter carries a single antenna's properties. The properties include the gain and the connectivity status of the antenna.The antenna gain is the composite gain and includes the loss of the associated cable from the Reader to the antenna. The gain is represented in dBi*100 to allow fractional dBi representation.

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=73&view=fit">LLRP Specification Section 12.2.5</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=141&view=fit">LLRP Specification Section 16.2.6.5</a>}

      .
 */
public class AntennaProperties extends TLVParameter {
    public static final SignedShort TYPENUM = new SignedShort(221);
    private static final Logger LOGGER = LoggerFactory.getLogger(AntennaProperties.class);
    protected Bit antennaConnected;
    protected BitList reserved0 = new BitList(7);
    protected UnsignedShort antennaID;
    protected SignedShort antennaGain;

    /**
     * empty constructor to create new parameter.
     */
    public AntennaProperties() {
    }

    /**
     * Constructor to create parameter from binary encoded parameter
     * calls decodeBinary to decode parameter.
     * @param list to be decoded
     */
    public AntennaProperties(LLRPBitList list) {
        decodeBinary(list);
    }

    /**
    * Constructor to create parameter from xml encoded parameter
    * calls decodeXML to decode parameter.
    * @param element to be decoded
    */
    public AntennaProperties(Element element)
        throws InvalidLLRPMessageException {
        decodeXML(element);
    }

    /**
    * {@inheritDoc}
    */
    public LLRPBitList encodeBinarySpecific() {
        LLRPBitList resultBits = new LLRPBitList();

        if (antennaConnected == null) {
            LOGGER.warn(" antennaConnected not set");
            throw new MissingParameterException(
                " antennaConnected not set  for Parameter of Type AntennaProperties");
        }

        resultBits.append(antennaConnected.encodeBinary());
        resultBits.append(reserved0.encodeBinary());

        if (antennaID == null) {
            LOGGER.warn(" antennaID not set");
            throw new MissingParameterException(
                " antennaID not set  for Parameter of Type AntennaProperties");
        }

        resultBits.append(antennaID.encodeBinary());

        if (antennaGain == null) {
            LOGGER.warn(" antennaGain not set");
            throw new MissingParameterException(
                " antennaGain not set  for Parameter of Type AntennaProperties");
        }

        resultBits.append(antennaGain.encodeBinary());

        return resultBits;
    }

    /**
    * {@inheritDoc}
    */
    public Content encodeXML(String name, Namespace ns) {
        // element in namespace defined by parent element
        Element element = new Element(name, ns);
        // child element are always in default LLRP namespace
        ns = Namespace.getNamespace("llrp", LLRPConstants.LLRPNAMESPACE);

        if (antennaConnected == null) {
            LOGGER.warn(" antennaConnected not set");
            throw new MissingParameterException(" antennaConnected not set");
        } else {
            element.addContent(antennaConnected.encodeXML("AntennaConnected", ns));
        }

        //element.addContent(reserved0.encodeXML("reserved",ns));
        if (antennaID == null) {
            LOGGER.warn(" antennaID not set");
            throw new MissingParameterException(" antennaID not set");
        } else {
            element.addContent(antennaID.encodeXML("AntennaID", ns));
        }

        if (antennaGain == null) {
            LOGGER.warn(" antennaGain not set");
            throw new MissingParameterException(" antennaGain not set");
        } else {
            element.addContent(antennaGain.encodeXML("AntennaGain", ns));
        }

        //parameters
        return element;
    }

    /**
    * {@inheritDoc}
    */
    protected void decodeBinarySpecific(LLRPBitList binary) {
        int position = 0;
        int tempByteLength;
        int tempLength = 0;
        int count;
        SignedShort type;
        int fieldCount;
        Custom custom;
        antennaConnected = new Bit(binary.subList(position, Bit.length()));
        position += Bit.length();
        position += reserved0.length();
        antennaID = new UnsignedShort(binary.subList(position,
                    UnsignedShort.length()));
        position += UnsignedShort.length();
        antennaGain = new SignedShort(binary.subList(position,
                    SignedShort.length()));
        position += SignedShort.length();
    }

    /**
    * {@inheritDoc}
    */
    public void decodeXML(Element element) throws InvalidLLRPMessageException {
        List<Element> tempList = null;
        boolean atLeastOnce = false;
        Custom custom;

        Element temp = null;

        // child element are always in default LLRP namespace
        Namespace ns = Namespace.getNamespace(LLRPConstants.LLRPNAMESPACE);

        temp = element.getChild("AntennaConnected", ns);

        if (temp != null) {
            antennaConnected = new Bit(temp);
        }

        element.removeChild("AntennaConnected", ns);
        temp = element.getChild("AntennaID", ns);

        if (temp != null) {
            antennaID = new UnsignedShort(temp);
        }

        element.removeChild("AntennaID", ns);
        temp = element.getChild("AntennaGain", ns);

        if (temp != null) {
            antennaGain = new SignedShort(temp);
        }

        element.removeChild("AntennaGain", ns);

        if (element.getChildren().size() > 0) {
            String message = "AntennaProperties has unknown element " +
                ((Element) element.getChildren().get(0)).getName();
            throw new InvalidLLRPMessageException(message);
        }
    }

    //setters
    /**
    * set   antennaConnected of type Bit .
    * @param   antennaConnected to be set
    */
    public void setAntennaConnected(final Bit antennaConnected) {
        this.antennaConnected = antennaConnected;
    }

    /**
    * set   antennaID of type UnsignedShort .
    * @param   antennaID to be set
    */
    public void setAntennaID(final UnsignedShort antennaID) {
        this.antennaID = antennaID;
    }

    /**
    * set   antennaGain of type SignedShort .
    * @param   antennaGain to be set
    */
    public void setAntennaGain(final SignedShort antennaGain) {
        this.antennaGain = antennaGain;
    }

    // end setter

    //getters
    /**
    * get   antennaConnected of type Bit.
    * @return   type Bit to be set
    */
    public Bit getAntennaConnected() {
        return this.antennaConnected;
    }

    /**
    * get   antennaID of type UnsignedShort.
    * @return   type UnsignedShort to be set
    */
    public UnsignedShort getAntennaID() {
        return this.antennaID;
    }

    /**
    * get   antennaGain of type SignedShort.
    * @return   type SignedShort to be set
    */
    public SignedShort getAntennaGain() {
        return this.antennaGain;
    }

    // end getters

    //add methods

    // end add

    /**
    * For TLV Parameter length can not be determined at compile time. This method therefore always returns 0.
    * @return Integer always zero
    */
    public static Integer length() {
        return 0;
    }

    /**
    * {@inheritDoc}
    */
    public SignedShort getTypeNum() {
        return TYPENUM;
    }

    /**
    * {@inheritDoc}
    */
    public String getName() {
        return "AntennaProperties";
    }

    /**
    * return string representation. All field values but no parameters are included
    * @return String
    */
    public String toString() {
        String result = "AntennaProperties: ";
        result += ", antennaConnected: ";
        result += antennaConnected;

        result += ", antennaID: ";
        result += antennaID;
        result += ", antennaGain: ";
        result += antennaGain;
        result = result.replaceFirst(", ", "");

        return result;
    }
}
