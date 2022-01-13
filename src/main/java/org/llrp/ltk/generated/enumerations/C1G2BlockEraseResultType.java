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
import org.llrp.ltk.types.UnsignedByte;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
/**
 * C1G2BlockEraseResultType is Enumeration of Type UnsignedByte
 */
public class C1G2BlockEraseResultType extends UnsignedByte
    implements LLRPEnumeration {
    public static final int Success = 0;
    public static final int Tag_Memory_Overrun_Error = 1;
    public static final int Tag_Memory_Locked_Error = 2;
    public static final int Insufficient_Power = 3;
    public static final int Nonspecific_Tag_Error = 4;
    public static final int No_Response_From_Tag = 5;
    public static final int Nonspecific_Reader_Error = 6;
    Logger logger = LoggerFactory.getLogger(C1G2BlockEraseResultType.class);

    public C1G2BlockEraseResultType() {
        super(0);
    }

    /**
     * Create new C1G2BlockEraseResultType by passing integer value.
     *
     * @throws IllegalArgumentException
     * if the value is not allowed for this enumeration
     * @param value an Integer value allowed - might check first
     * with isValidValue it it is an allowed value
     */
    public C1G2BlockEraseResultType(int value) {
        super(value);

        if (!isValidValue(value)) {
            throw new IllegalArgumentException("Value not allowed");
        }
    }

    /**
    * Create new C1G2BlockEraseResultType by passing jdom element.
    *
    * @throws IllegalArgumentException
    * if the value found in element is not allowed
    * for this enumeration.
    * @param element - jdom element where the child is a string
    * that is the name for a value of the enumeration.
    */
    public C1G2BlockEraseResultType(final Element element) {
        this(element.getText());
    }

    /**
    * Create new C1G2BlockEraseResultType by passing a string.
    *
    * @throws IllegalArgumentException
    * if the string does not stand for a valid value.
    */
    public C1G2BlockEraseResultType(final String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Name not allowed");
        }

        this.value = getValue(name);
        signed = false;
    }

    /**
     * Create new C1G2BlockEraseResultType by passing LLRPBitList.
     *
     * @throws IllegalArgumentException
     * if the value found in the BitList is not allowed
     * for this enumeration.
     * @param list - LLRPBitList
     */
    public C1G2BlockEraseResultType(final LLRPBitList list) {
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

        default:
            return false;
        }
    }

    /**
            * {@inheritDoc}
     */
    public final int getValue(final String name) {
        if (name.equalsIgnoreCase("Success")) {
            return 0;
        }

        if (name.equalsIgnoreCase("Tag_Memory_Overrun_Error")) {
            return 1;
        }

        if (name.equalsIgnoreCase("Tag_Memory_Locked_Error")) {
            return 2;
        }

        if (name.equalsIgnoreCase("Insufficient_Power")) {
            return 3;
        }

        if (name.equalsIgnoreCase("Nonspecific_Tag_Error")) {
            return 4;
        }

        if (name.equalsIgnoreCase("No_Response_From_Tag")) {
            return 5;
        }

        if (name.equalsIgnoreCase("Nonspecific_Reader_Error")) {
            return 6;
        }

        return -1;
    }

    /**
             * {@inheritDoc}
     */
    public final String getName(final int value) {
        if (0 == value) {
            return "Success";
        }

        if (1 == value) {
            return "Tag_Memory_Overrun_Error";
        }

        if (2 == value) {
            return "Tag_Memory_Locked_Error";
        }

        if (3 == value) {
            return "Insufficient_Power";
        }

        if (4 == value) {
            return "Nonspecific_Tag_Error";
        }

        if (5 == value) {
            return "No_Response_From_Tag";
        }

        if (6 == value) {
            return "Nonspecific_Reader_Error";
        }

        return "";
    }

    /**
             * {@inheritDoc}
     */
    public boolean isValidName(final String name) {
        if (name.equals("Success")) {
            return true;
        }

        if (name.equals("Tag_Memory_Overrun_Error")) {
            return true;
        }

        if (name.equals("Tag_Memory_Locked_Error")) {
            return true;
        }

        if (name.equals("Insufficient_Power")) {
            return true;
        }

        if (name.equals("Nonspecific_Tag_Error")) {
            return true;
        }

        if (name.equals("No_Response_From_Tag")) {
            return true;
        }

        if (name.equals("Nonspecific_Reader_Error")) {
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
        return UnsignedByte.length();
    }

    /**
          * wrapper method for UnsignedIntegers that use BigIntegers to store value
    *
    */
    private final String getName(final BigInteger value) {
        logger.warn("C1G2BlockEraseResultType must convert BigInteger " +
            value + " to Integer value " + value.intValue());

        return getName(value.intValue());
    }

    /**
    * wrapper method for UnsignedIntegers that use BigIntegers to store value
    *
    */
    private final boolean isValidValue(final BigInteger value) {
        logger.warn("C1G2BlockEraseResultType must convert BigInteger " +
            value + " to Integer value " + value.intValue());

        return isValidValue(value.intValue());
    }
}
