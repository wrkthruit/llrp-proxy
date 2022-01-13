/*
 *
 * This file was generated by LLRP Code Generator
 * see http://llrp-toolkit.cvs.sourceforge.net/llrp-toolkit/
 * for more information
 * Generated on: Sun Apr 08 14:14:12 EDT 2012;
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
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.llrp.ltk.generated.enumerations;

import org.jdom.Content;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.Text;
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.LLRPEnumeration;
import org.llrp.ltk.types.UnsignedShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;

/**
 * CommunicationsStandard is Enumeration of Type UnsignedShort
 */
public class CommunicationsStandard extends UnsignedShort
    implements LLRPEnumeration {
    public static final int Unspecified = 0;
    public static final int US_FCC_Part_15 = 1;
    public static final int ETSI_302_208 = 2;
    public static final int ETSI_300_220 = 3;
    public static final int Australia_LIPD_1W = 4;
    public static final int Australia_LIPD_4W = 5;
    public static final int Japan_ARIB_STD_T89 = 6;
    public static final int Hong_Kong_OFTA_1049 = 7;
    public static final int Taiwan_DGT_LP0002 = 8;
    public static final int Korea_MIC_Article_5_2 = 9;
    Logger logger = LoggerFactory.getLogger(CommunicationsStandard.class);

    public CommunicationsStandard() {
        super(0);
    }

    /**
     * Create new CommunicationsStandard by passing integer value.
     *
     * @throws IllegalArgumentException
     * if the value is not allowed for this enumeration
     * @param value an Integer value allowed - might check first
     * with isValidValue it it is an allowed value
     */
    public CommunicationsStandard(int value) {
        super(value);

        if (!isValidValue(value)) {
            throw new IllegalArgumentException("Value not allowed");
        }
    }

    /**
    * Create new CommunicationsStandard by passing jdom element.
    *
    * @throws IllegalArgumentException
    * if the value found in element is not allowed
    * for this enumeration.
    * @param element - jdom element where the child is a string
    * that is the name for a value of the enumeration.
    */
    public CommunicationsStandard(final Element element) {
        this(element.getText());
    }

    /**
    * Create new CommunicationsStandard by passing a string.
    *
    * @throws IllegalArgumentException
    * if the string does not stand for a valid value.
    */
    public CommunicationsStandard(final String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Name not allowed");
        }

        this.value = getValue(name);
        signed = false;
    }

    /**
     * Create new CommunicationsStandard by passing LLRPBitList.
     *
     * @throws IllegalArgumentException
     * if the value found in the BitList is not allowed
     * for this enumeration.
     * @param list - LLRPBitList
     */
    public CommunicationsStandard(final LLRPBitList list) {
        decodeBinary(list);

        if (!isValidValue(new Integer(toInteger()))) {
            throw new IllegalArgumentException("Value not allowed");
        }
    }

    /**
    * set the current value of this enumeration to the
    * value identified by given string.
    *
    * @throws IllegalArgumentException
    * if the value found for given String is not allowed
    * for this enumeration.
    * @param name set this enumeration to hold one of the allowed values
    */
    public final void set(final String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("name not allowed");
        }

        this.value = getValue(name);
    }

    /**
    * set the current value of this enumeration to the
    * value given.
    *
    * @throws IllegalArgumentException
    * if the value is not allowed
    * for this enumeration.
    * @param value to be set
    */
    public final void set(final int value) {
        if (!isValidValue(value)) {
            throw new IllegalArgumentException("value not allowed");
        }

        this.value = value;
    }

    /**
            * {@inheritDoc}
     */
    public Content encodeXML(final String name, Namespace ns) {
        Element element = new Element(name, ns);
        //Element element = new Element(name, Namespace.getNamespace("llrp",LLRPConstants.LLRPNAMESPACE));
        element.setContent(new Text(toString()));

        return element;
    }

    /**
    * {@inheritDoc}
    */
    public String toString() {
        return getName(toInteger());
    }

    /**
            * {@inheritDoc}
     */
    public boolean isValidValue(final int value) {
        switch (value) {
        case 0:
            return true;

        case 1:
            return true;

        case 2:
            return true;

        case 3:
            return true;

        case 4:
            return true;

        case 5:
            return true;

        case 6:
            return true;

        case 7:
            return true;

        case 8:
            return true;

        case 9:
            return true;

        default:
            return false;
        }
    }

    /**
            * {@inheritDoc}
     */
    public final int getValue(final String name) {
        if (name.equalsIgnoreCase("Unspecified")) {
            return 0;
        }

        if (name.equalsIgnoreCase("US_FCC_Part_15")) {
            return 1;
        }

        if (name.equalsIgnoreCase("ETSI_302_208")) {
            return 2;
        }

        if (name.equalsIgnoreCase("ETSI_300_220")) {
            return 3;
        }

        if (name.equalsIgnoreCase("Australia_LIPD_1W")) {
            return 4;
        }

        if (name.equalsIgnoreCase("Australia_LIPD_4W")) {
            return 5;
        }

        if (name.equalsIgnoreCase("Japan_ARIB_STD_T89")) {
            return 6;
        }

        if (name.equalsIgnoreCase("Hong_Kong_OFTA_1049")) {
            return 7;
        }

        if (name.equalsIgnoreCase("Taiwan_DGT_LP0002")) {
            return 8;
        }

        if (name.equalsIgnoreCase("Korea_MIC_Article_5_2")) {
            return 9;
        }

        return -1;
    }

    /**
             * {@inheritDoc}
     */
    public final String getName(final int value) {
        if (0 == value) {
            return "Unspecified";
        }

        if (1 == value) {
            return "US_FCC_Part_15";
        }

        if (2 == value) {
            return "ETSI_302_208";
        }

        if (3 == value) {
            return "ETSI_300_220";
        }

        if (4 == value) {
            return "Australia_LIPD_1W";
        }

        if (5 == value) {
            return "Australia_LIPD_4W";
        }

        if (6 == value) {
            return "Japan_ARIB_STD_T89";
        }

        if (7 == value) {
            return "Hong_Kong_OFTA_1049";
        }

        if (8 == value) {
            return "Taiwan_DGT_LP0002";
        }

        if (9 == value) {
            return "Korea_MIC_Article_5_2";
        }

        return "";
    }

    /**
             * {@inheritDoc}
     */
    public boolean isValidName(final String name) {
        if (name.equals("Unspecified")) {
            return true;
        }

        if (name.equals("US_FCC_Part_15")) {
            return true;
        }

        if (name.equals("ETSI_302_208")) {
            return true;
        }

        if (name.equals("ETSI_300_220")) {
            return true;
        }

        if (name.equals("Australia_LIPD_1W")) {
            return true;
        }

        if (name.equals("Australia_LIPD_4W")) {
            return true;
        }

        if (name.equals("Japan_ARIB_STD_T89")) {
            return true;
        }

        if (name.equals("Hong_Kong_OFTA_1049")) {
            return true;
        }

        if (name.equals("Taiwan_DGT_LP0002")) {
            return true;
        }

        if (name.equals("Korea_MIC_Article_5_2")) {
            return true;
        }

        return false;
    }

    /**
    * number of bits used to represent this type.
    *
    * @return Integer
    */
    public static int length() {
        return UnsignedShort.length();
    }

    /**
          * wrapper method for UnsignedIntegers that use BigIntegers to store value
    *
    */
    private final String getName(final BigInteger value) {
        logger.warn("CommunicationsStandard must convert BigInteger " + value +
            " to Integer value " + value.intValue());

        return getName(value.intValue());
    }

    /**
    * wrapper method for UnsignedIntegers that use BigIntegers to store value
    *
    */
    private final boolean isValidValue(final BigInteger value) {
        logger.warn("CommunicationsStandard must convert BigInteger " + value +
            " to Integer value " + value.intValue());

        return isValidValue(value.intValue());
    }
}
