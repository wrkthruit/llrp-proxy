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
 * AccessReportTriggerType is Enumeration of Type UnsignedByte
 */
public class AccessReportTriggerType extends UnsignedByte
        implements LLRPEnumeration {
    public static final int Whenever_ROReport_Is_Generated = 0;
    public static final int End_Of_AccessSpec = 1;
    Logger logger = LoggerFactory.getLogger(AccessReportTriggerType.class);

    public AccessReportTriggerType() {
        super(0);
    }

    /**
     * Create new AccessReportTriggerType by passing integer value.
     *
     * @param value an Integer value allowed - might check first
     *              with isValidValue it it is an allowed value
     * @throws IllegalArgumentException if the value is not allowed for this enumeration
     */
    public AccessReportTriggerType(int value) {
        super(value);

        if (!isValidValue(value)) {
            throw new IllegalArgumentException("Value not allowed");
        }
    }

    /**
     * Create new AccessReportTriggerType by passing jdom element.
     *
     * @param element - jdom element where the child is a string
     *                that is the name for a value of the enumeration.
     * @throws IllegalArgumentException if the value found in element is not allowed
     *                                  for this enumeration.
     */
    public AccessReportTriggerType(final Element element) {
        this(element.getText());
    }

    /**
     * Create new AccessReportTriggerType by passing a string.
     *
     * @throws IllegalArgumentException if the string does not stand for a valid value.
     */
    public AccessReportTriggerType(final String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Name not allowed");
        }

        this.value = getValue(name);
        signed = false;
    }

    /**
     * Create new AccessReportTriggerType by passing LLRPBitList.
     *
     * @param list - LLRPBitList
     * @throws IllegalArgumentException if the value found in the BitList is not allowed
     *                                  for this enumeration.
     */
    public AccessReportTriggerType(final LLRPBitList list) {
        decodeBinary(list);

        if (!isValidValue(new Integer(toInteger()))) {
            throw new IllegalArgumentException("Value not allowed");
        }
    }

    /**
     * set the current value of this enumeration to the
     * value identified by given string.
     *
     * @param name set this enumeration to hold one of the allowed values
     * @throws IllegalArgumentException if the value found for given String is not allowed
     *                                  for this enumeration.
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
     * @param value to be set
     * @throws IllegalArgumentException if the value is not allowed
     *                                  for this enumeration.
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

            default:
                return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public final int getValue(final String name) {
        if (name.equalsIgnoreCase("Whenever_ROReport_Is_Generated")) {
            return 0;
        }

        if (name.equalsIgnoreCase("End_Of_AccessSpec")) {
            return 1;
        }

        return -1;
    }

    /**
     * {@inheritDoc}
     */
    public final String getName(final int value) {
        if (0 == value) {
            return "Whenever_ROReport_Is_Generated";
        }

        if (1 == value) {
            return "End_Of_AccessSpec";
        }

        return "";
    }

    /**
     * {@inheritDoc}
     */
    public boolean isValidName(final String name) {
        if (name.equals("Whenever_ROReport_Is_Generated")) {
            return true;
        }

        if (name.equals("End_Of_AccessSpec")) {
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
     */
    private final String getName(final BigInteger value) {
        logger.warn("AccessReportTriggerType must convert BigInteger " + value +
                " to Integer value " + value.intValue());

        return getName(value.intValue());
    }

    /**
     * wrapper method for UnsignedIntegers that use BigIntegers to store value
     */
    private final boolean isValidValue(final BigInteger value) {
        logger.warn("AccessReportTriggerType must convert BigInteger " + value +
                " to Integer value " + value.intValue());

        return isValidValue(value.intValue());
    }
}
