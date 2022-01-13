/*
 *
 * This file was generated by LLRP Code Generator
 * see http://llrp-toolkit.cvs.sourceforge.net/llrp-toolkit/
 * for more information
 * Generated on: Sun Apr 08 14:14:10 EDT 2012;
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
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.SignedShort;
import org.llrp.ltk.types.TLVParameter;
import org.llrp.ltk.types.UnsignedIntegerArray;
import org.llrp.ltk.types.UnsignedShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * This parameter carries the fixed frequency list that can be used by the Reader. The one-based position of a frequency in the list is defined as its ChannelIndex (i.e. the first frequency is referred to as ChannelIndex one).

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=50&view=fit">LLRP Specification Section 9.2.4.1.2.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=135&view=fit">LLRP Specification Section 16.2.3.4.1.2.2</a>}


 */

/**
 * This parameter carries the fixed frequency list that can be used by the Reader. The one-based position of a frequency in the list is defined as its ChannelIndex (i.e. the first frequency is referred to as ChannelIndex one).

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=50&view=fit">LLRP Specification Section 9.2.4.1.2.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=135&view=fit">LLRP Specification Section 16.2.3.4.1.2.2</a>}

      .
 */
public class FixedFrequencyTable extends TLVParameter {
    public static final SignedShort TYPENUM = new SignedShort(148);
    private static final Logger LOGGER = LoggerFactory.getLogger(FixedFrequencyTable.class);
    protected UnsignedIntegerArray frequency;

    /**
     * empty constructor to create new parameter.
     */
    public FixedFrequencyTable() {
    }

    /**
     * Constructor to create parameter from binary encoded parameter
     * calls decodeBinary to decode parameter.
     * @param list to be decoded
     */
    public FixedFrequencyTable(LLRPBitList list) {
        decodeBinary(list);
    }

    /**
    * Constructor to create parameter from xml encoded parameter
    * calls decodeXML to decode parameter.
    * @param element to be decoded
    */
    public FixedFrequencyTable(Element element)
        throws InvalidLLRPMessageException {
        decodeXML(element);
    }

    /**
    * {@inheritDoc}
    */
    public LLRPBitList encodeBinarySpecific() {
        LLRPBitList resultBits = new LLRPBitList();

        if (frequency == null) {
            LOGGER.warn(" frequency not set");
            throw new MissingParameterException(
                " frequency not set  for Parameter of Type FixedFrequencyTable");
        }

        resultBits.append(frequency.encodeBinary());

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

        if (frequency == null) {
            LOGGER.warn(" frequency not set");
            throw new MissingParameterException(" frequency not set");
        } else {
            element.addContent(frequency.encodeXML("Frequency", ns));
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
        // array. first 16 bits indicate length of array
        fieldCount = new UnsignedShort(binary.subList(position,
                    UnsignedShort.length())).toShort();
        tempLength = (UnsignedIntegerArray.length() * fieldCount) +
            UnsignedShort.length();
        frequency = new UnsignedIntegerArray(binary.subList(position, tempLength));
        position += tempLength;
        LOGGER.debug("decoding array of type: UnsignedIntegerArray with " +
            tempLength + " length");

        //might need padding
        // must always be blocks of 8 bites, if it is a bitlist, this might not be automatically the case
        if ((tempLength % 8) > 0) {
            position += (8 - (tempLength % 8));
            LOGGER.info("padding needed for frequency ");
        }
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

        temp = element.getChild("Frequency", ns);

        if (temp != null) {
            frequency = new UnsignedIntegerArray(temp);
        }

        element.removeChild("Frequency", ns);

        if (element.getChildren().size() > 0) {
            String message = "FixedFrequencyTable has unknown element " +
                ((Element) element.getChildren().get(0)).getName();
            throw new InvalidLLRPMessageException(message);
        }
    }

    //setters
    /**
    * set   frequency of type UnsignedIntegerArray .
    * @param   frequency to be set
    */
    public void setFrequency(final UnsignedIntegerArray frequency) {
        this.frequency = frequency;
    }

    // end setter

    //getters
    /**
    * get   frequency of type UnsignedIntegerArray.
    * @return   type UnsignedIntegerArray to be set
    */
    public UnsignedIntegerArray getFrequency() {
        return this.frequency;
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
        return "FixedFrequencyTable";
    }

    /**
    * return string representation. All field values but no parameters are included
    * @return String
    */
    public String toString() {
        String result = "FixedFrequencyTable: ";
        result += ", frequency: ";
        result += frequency;
        result = result.replaceFirst(", ", "");

        return result;
    }
}
