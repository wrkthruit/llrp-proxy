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
import org.llrp.ltk.generated.interfaces.AccessCommandOpSpec;
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.SignedShort;
import org.llrp.ltk.types.TLVParameter;
import org.llrp.ltk.types.UnsignedInteger;
import org.llrp.ltk.types.UnsignedShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;


/**
 * This parameter contains the definition of the access privilege updates (read/write/permalock) to be performed in various locations of the memory. The five data fields for which we can define access control using the lock command are: Kill Password, Access Password, EPC memory, TID memory and User memory. The access privilege updates are expressed as a list of C1G2LockPayload Parameters, one for each memory location.The Access Password provides the password to enter the secured state.  A Reader can perform a lock operation on a tag only if the tag is in the secured state. The tag enters the secured state only using the Access Password (if a non-zero value).

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=108&view=fit">LLRP Specification Section 15.2.1.3.2.4</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=157&view=fit">LLRP Specification Section 16.3.1.3.2.4</a>}


 */

/**
 * This parameter contains the definition of the access privilege updates (read/write/permalock) to be performed in various locations of the memory. The five data fields for which we can define access control using the lock command are: Kill Password, Access Password, EPC memory, TID memory and User memory. The access privilege updates are expressed as a list of C1G2LockPayload Parameters, one for each memory location.The Access Password provides the password to enter the secured state.  A Reader can perform a lock operation on a tag only if the tag is in the secured state. The tag enters the secured state only using the Access Password (if a non-zero value).

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=108&view=fit">LLRP Specification Section 15.2.1.3.2.4</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=157&view=fit">LLRP Specification Section 16.3.1.3.2.4</a>}

      .
 */
public class C1G2Lock extends TLVParameter implements AccessCommandOpSpec {
    public static final SignedShort TYPENUM = new SignedShort(344);
    private static final Logger LOGGER = LoggerFactory.getLogger(C1G2Lock.class);
    protected UnsignedShort opSpecID;
    protected UnsignedInteger accessPassword;
    protected List<C1G2LockPayload> c1G2LockPayloadList = new LinkedList<C1G2LockPayload>();

    /**
     * empty constructor to create new parameter.
     */
    public C1G2Lock() {
    }

    /**
     * Constructor to create parameter from binary encoded parameter
     * calls decodeBinary to decode parameter.
     * @param list to be decoded
     */
    public C1G2Lock(LLRPBitList list) {
        decodeBinary(list);
    }

    /**
    * Constructor to create parameter from xml encoded parameter
    * calls decodeXML to decode parameter.
    * @param element to be decoded
    */
    public C1G2Lock(Element element) throws InvalidLLRPMessageException {
        decodeXML(element);
    }

    /**
    * {@inheritDoc}
    */
    public LLRPBitList encodeBinarySpecific() {
        LLRPBitList resultBits = new LLRPBitList();

        if (opSpecID == null) {
            LOGGER.warn(" opSpecID not set");
            throw new MissingParameterException(
                " opSpecID not set  for Parameter of Type C1G2Lock");
        }

        resultBits.append(opSpecID.encodeBinary());

        if (accessPassword == null) {
            LOGGER.warn(" accessPassword not set");
            throw new MissingParameterException(
                " accessPassword not set  for Parameter of Type C1G2Lock");
        }

        resultBits.append(accessPassword.encodeBinary());

        if (c1G2LockPayloadList == null) {
            LOGGER.warn(" c1G2LockPayloadList not set");

            //parameter has to be set - throw exception
            throw new MissingParameterException(" c1G2LockPayloadList not set");
        } else {
            for (C1G2LockPayload field : c1G2LockPayloadList) {
                resultBits.append(field.encodeBinary());
            }
        }

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

        if (opSpecID == null) {
            LOGGER.warn(" opSpecID not set");
            throw new MissingParameterException(" opSpecID not set");
        } else {
            element.addContent(opSpecID.encodeXML("OpSpecID", ns));
        }

        if (accessPassword == null) {
            LOGGER.warn(" accessPassword not set");
            throw new MissingParameterException(" accessPassword not set");
        } else {
            element.addContent(accessPassword.encodeXML("AccessPassword", ns));
        }

        //parameters
        if (c1G2LockPayloadList == null) {
            LOGGER.warn(" c1G2LockPayloadList not set");
            throw new MissingParameterException("  c1G2LockPayloadList not set");
        }

        for (C1G2LockPayload field : c1G2LockPayloadList) {
            element.addContent(field.encodeXML(field.getClass().getName()
                                                    .replaceAll(field.getClass()
                                                                     .getPackage()
                                                                     .getName() +
                        ".", ""), ns));
        }

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
        opSpecID = new UnsignedShort(binary.subList(position,
                    UnsignedShort.length()));
        position += UnsignedShort.length();
        accessPassword = new UnsignedInteger(binary.subList(position,
                    UnsignedInteger.length()));
        position += UnsignedInteger.length();

        // list of parameters
        c1G2LockPayloadList = new LinkedList<C1G2LockPayload>();
        LOGGER.debug("decoding parameter c1G2LockPayloadList ");

        while (position < binary.length()) {
            // store if one parameter matched
            boolean atLeastOnce = false;

            // look ahead to see type
            if (binary.get(position)) {
                // do not take the first bit as it is always 1
                type = new SignedShort(binary.subList(position + 1, 7));
            } else {
                type = new SignedShort(binary.subList(position +
                            RESERVEDLENGTH, TYPENUMBERLENGTH));
                tempByteLength = new UnsignedShort(binary.subList(position +
                            RESERVEDLENGTH + TYPENUMBERLENGTH,
                            UnsignedShort.length())).toShort();
                tempLength = 8 * tempByteLength;
            }

            //add parameter to list if type number matches
            if ((type != null) && type.equals(C1G2LockPayload.TYPENUM)) {
                if (binary.get(position)) {
                    // length can statically be determined for TV Parameters
                    tempLength = C1G2LockPayload.length();
                }

                c1G2LockPayloadList.add(new C1G2LockPayload(binary.subList(
                            position, tempLength)));
                LOGGER.debug("adding C1G2LockPayload to c1G2LockPayloadList ");
                atLeastOnce = true;
                position += tempLength;
            }

            if (!atLeastOnce) {
                //no parameter matched therefore we jump out of the loop
                break;
            }
        }

        //if list is still empty no parameter matched
        if (c1G2LockPayloadList.isEmpty()) {
            LOGGER.warn(
                "encoded message does not contain parameter for non optional c1G2LockPayloadList");
            throw new MissingParameterException(
                "C1G2Lock misses non optional parameter of type C1G2LockPayload");
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

        temp = element.getChild("OpSpecID", ns);

        if (temp != null) {
            opSpecID = new UnsignedShort(temp);
        }

        element.removeChild("OpSpecID", ns);
        temp = element.getChild("AccessPassword", ns);

        if (temp != null) {
            accessPassword = new UnsignedInteger(temp);
        }

        element.removeChild("AccessPassword", ns);

        //parameter - not choices - no special actions needed
        //we expect a list of parameters
        c1G2LockPayloadList = new LinkedList<C1G2LockPayload>();
        tempList = element.getChildren("C1G2LockPayload", ns);

        if ((tempList == null) || tempList.isEmpty()) {
            LOGGER.warn(
                "C1G2Lock misses non optional parameter of type c1G2LockPayloadList");
            throw new MissingParameterException(
                "C1G2Lock misses non optional parameter of type c1G2LockPayloadList");
        } else {
            for (Element e : tempList) {
                c1G2LockPayloadList.add(new C1G2LockPayload(e));
                LOGGER.debug("adding C1G2LockPayload to c1G2LockPayloadList ");
            }
        }

        element.removeChildren("C1G2LockPayload", ns);

        if (element.getChildren().size() > 0) {
            String message = "C1G2Lock has unknown element " +
                ((Element) element.getChildren().get(0)).getName();
            throw new InvalidLLRPMessageException(message);
        }
    }

    //setters
    /**
    * set   opSpecID of type UnsignedShort .
    * @param   opSpecID to be set
    */
    public void setOpSpecID(final UnsignedShort opSpecID) {
        this.opSpecID = opSpecID;
    }

    /**
    * set   accessPassword of type UnsignedInteger .
    * @param   accessPassword to be set
    */
    public void setAccessPassword(final UnsignedInteger accessPassword) {
        this.accessPassword = accessPassword;
    }

    /**
    * set c1G2LockPayloadList of type  List &lt;C1G2LockPayload>.
    * @param  c1G2LockPayloadList to be set
    */
    public void setC1G2LockPayloadList(
        final List<C1G2LockPayload> c1G2LockPayloadList) {
        this.c1G2LockPayloadList = c1G2LockPayloadList;
    }

    // end setter

    //getters
    /**
    * get   opSpecID of type UnsignedShort.
    * @return   type UnsignedShort to be set
    */
    public UnsignedShort getOpSpecID() {
        return this.opSpecID;
    }

    /**
    * get   accessPassword of type UnsignedInteger.
    * @return   type UnsignedInteger to be set
    */
    public UnsignedInteger getAccessPassword() {
        return this.accessPassword;
    }

    /**
    * get c1G2LockPayloadList of type List &lt;C1G2LockPayload> .
    * @return  List &lt;C1G2LockPayload>
    */
    public List<C1G2LockPayload> getC1G2LockPayloadList() {
        return c1G2LockPayloadList;
    }

    // end getters

    //add methods

    /**
    * add element c1G2LockPayload of type C1G2LockPayload .
    * @param  c1G2LockPayload of type C1G2LockPayload
    */
    public void addToC1G2LockPayloadList(C1G2LockPayload c1G2LockPayload) {
        if (this.c1G2LockPayloadList == null) {
            this.c1G2LockPayloadList = new LinkedList<C1G2LockPayload>();
        }

        this.c1G2LockPayloadList.add(c1G2LockPayload);
    }

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
        return "C1G2Lock";
    }

    /**
    * return string representation. All field values but no parameters are included
    * @return String
    */
    public String toString() {
        String result = "C1G2Lock: ";
        result += ", opSpecID: ";
        result += opSpecID;
        result += ", accessPassword: ";
        result += accessPassword;
        result = result.replaceFirst(", ", "");

        return result;
    }
}