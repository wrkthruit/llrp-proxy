/*
*
* This file was generated by LLRP Code Generator
* see http://llrp-toolkit.cvs.sourceforge.net/llrp-toolkit/
* for more information
* Generated on: Sun Apr 08 14:14:08 EDT 2012;
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
package org.llrp.ltk.generated.messages;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.llrp.ltk.exceptions.InvalidLLRPMessageException;
import org.llrp.ltk.exceptions.MissingParameterException;
import org.llrp.ltk.generated.LLRPConstants;
import org.llrp.ltk.generated.interfaces.AirProtocolLLRPCapabilities;
import org.llrp.ltk.generated.parameters.C1G2LLRPCapabilities;
import org.llrp.ltk.generated.parameters.Custom;
import org.llrp.ltk.generated.parameters.GeneralDeviceCapabilities;
import org.llrp.ltk.generated.parameters.LLRPCapabilities;
import org.llrp.ltk.generated.parameters.LLRPStatus;
import org.llrp.ltk.generated.parameters.RegulatoryCapabilities;
import org.llrp.ltk.types.BitList;
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.LLRPMessage;
import org.llrp.ltk.types.SignedShort;
import org.llrp.ltk.types.UnsignedInteger;
import org.llrp.ltk.types.UnsignedShort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;


/**
 * This is the response from the Reader to the GET_READER_CAPABILITIES message. The response contains the LLRPStatus Parameter and the list of parameters for the requested capabilities conveyed via RequestedData in the GET_READER_CAPABILITIES message.

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=44&view=fit">LLRP Specification Section 9.1.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=117&view=fit">LLRP Specification Section 16.1.2</a>}


 */
public class GET_READER_CAPABILITIES_RESPONSE extends LLRPMessage {
    public static final SignedShort TYPENUM = new SignedShort(11);
    private static final Logger LOGGER = LoggerFactory.getLogger(GET_READER_CAPABILITIES_RESPONSE.class);
    public static final String RESPONSETYPE = "";
    protected LLRPStatus lLRPStatus;
    protected GeneralDeviceCapabilities generalDeviceCapabilities;
    protected LLRPCapabilities lLRPCapabilities;
    protected RegulatoryCapabilities regulatoryCapabilities;
    protected AirProtocolLLRPCapabilities airProtocolLLRPCapabilities;
    protected List<Custom> customList = new LinkedList<Custom>();

    /**
     * empty constructor to create new message
     * with LLRP version set to 1.0 (0x1).
     */
    public GET_READER_CAPABILITIES_RESPONSE() {
        setVersion(new BitList(0, 0, 1));
    }

    /**
     * Constructor to create message from binary encoded message
     * calls decodeBinary to decode message.
     * @param list to be decoded
     */
    public GET_READER_CAPABILITIES_RESPONSE(final LLRPBitList list)
        throws InvalidLLRPMessageException {
        decodeBinary(list.toByteArray());
    }

    /**
     * Constructor to create message from binary encoded message
     * calls decodeBinary to decode message.
     * @param byteArray representing message
     */
    public GET_READER_CAPABILITIES_RESPONSE(final byte[] byteArray)
        throws InvalidLLRPMessageException {
        decodeBinary(byteArray);
    }

    /**
    * Constructor to create message from xml encoded message
    * calls decodeXML to decode message.
    * @param document to be decoded
    */
    public GET_READER_CAPABILITIES_RESPONSE(final Document document)
        throws InvalidLLRPMessageException {
        decodeXML(document);
    }

    /**
    * {@inheritDoc}
    */
    protected LLRPBitList encodeBinarySpecific()
        throws InvalidLLRPMessageException {
        LLRPBitList resultBits = new LLRPBitList();

        if (lLRPStatus == null) {
            // single parameter, may not be null
            LOGGER.warn(" lLRPStatus not set");
            throw new InvalidLLRPMessageException(" lLRPStatus not set");
        } else {
            resultBits.append(lLRPStatus.encodeBinary());
        }

        if (generalDeviceCapabilities == null) {
            // optional parameter, may be null
            LOGGER.info(" generalDeviceCapabilities not set");
        } else {
            resultBits.append(generalDeviceCapabilities.encodeBinary());
        }

        if (lLRPCapabilities == null) {
            // optional parameter, may be null
            LOGGER.info(" lLRPCapabilities not set");
        } else {
            resultBits.append(lLRPCapabilities.encodeBinary());
        }

        if (regulatoryCapabilities == null) {
            // optional parameter, may be null
            LOGGER.info(" regulatoryCapabilities not set");
        } else {
            resultBits.append(regulatoryCapabilities.encodeBinary());
        }

        if (airProtocolLLRPCapabilities == null) {
            // optional parameter, may be null
            LOGGER.info(" airProtocolLLRPCapabilities not set");
        } else {
            resultBits.append(airProtocolLLRPCapabilities.encodeBinary());
        }

        if (customList == null) {
            //just warn - it is optional 
            LOGGER.info(" customList not set");
        } else {
            for (Custom field : customList) {
                resultBits.append(field.encodeBinary());
            }
        }

        return resultBits;
    }

    /**
    * {@inheritDoc}
    */
    public Document encodeXML() throws InvalidLLRPMessageException {
        try {
            Namespace ns = Namespace.getNamespace("llrp",
                    LLRPConstants.LLRPNAMESPACE);

            Element root = new Element("GET_READER_CAPABILITIES_RESPONSE", ns);
            //	Element root = new Element("GET_READER_CAPABILITIES_RESPONSE");
            root.addNamespaceDeclaration(Namespace.getNamespace("llrp",
                    LLRPConstants.LLRPNAMESPACE));

            if (version == null) {
                throw new InvalidLLRPMessageException("Version not set");
            } else {
                root.setAttribute("Version", version.toInteger().toString());
            }

            if (messageID == null) {
                throw new InvalidLLRPMessageException("MessageID not set");
            } else {
                root.setAttribute("MessageID", messageID.toString(10));
            }

            //parameters
            if (lLRPStatus == null) {
                LOGGER.info("lLRPStatus not set");
                throw new MissingParameterException("lLRPStatus not set");
            } else {
                root.addContent(lLRPStatus.encodeXML(lLRPStatus.getClass()
                                                               .getSimpleName(),
                        ns));
            }

            if (generalDeviceCapabilities == null) {
                LOGGER.info("generalDeviceCapabilities not set");
            } else {
                root.addContent(generalDeviceCapabilities.encodeXML(
                        generalDeviceCapabilities.getClass().getSimpleName(), ns));
            }

            if (lLRPCapabilities == null) {
                LOGGER.info("lLRPCapabilities not set");
            } else {
                root.addContent(lLRPCapabilities.encodeXML(
                        lLRPCapabilities.getClass().getSimpleName(), ns));
            }

            if (regulatoryCapabilities == null) {
                LOGGER.info("regulatoryCapabilities not set");
            } else {
                root.addContent(regulatoryCapabilities.encodeXML(
                        regulatoryCapabilities.getClass().getSimpleName(), ns));
            }

            if (airProtocolLLRPCapabilities == null) {
                LOGGER.info("airProtocolLLRPCapabilities not set");
            } else {
                root.addContent(airProtocolLLRPCapabilities.encodeXML(
                        airProtocolLLRPCapabilities.getClass().getSimpleName(),
                        ns));
            }

            if (customList == null) {
                LOGGER.info("customList not set");
            } else {
                for (Custom field : customList) {
                    root.addContent(field.encodeXML(field.getClass().getName()
                                                         .replaceAll(field.getClass()
                                                                          .getPackage()
                                                                          .getName() +
                                ".", ""), ns));
                }
            }

            Document doc = new Document(root);

            if (isValidXMLMessage(doc, LLRPConstants.LLRPMESSAGESCHEMAPATH)) {
                return doc;
            } else {
                return null;
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidLLRPMessageException(e.getMessage());
        } catch (MissingParameterException e) {
            throw new InvalidLLRPMessageException(e.getMessage());
        }
    }

    /**
    * {@inheritDoc}
    */
    protected void decodeBinarySpecific(LLRPBitList binary)
        throws InvalidLLRPMessageException {
        int position = 0;
        int tempByteLength;
        int tempLength = 0;
        int count;
        SignedShort type;
        int fieldCount;
        Custom custom;

        // look ahead to see type
        // may be optional or exactly once
        type = null;
        tempByteLength = 0;
        tempLength = 0;

        try {
            // if first bit is one it is a TV Parameter
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
        } catch (IllegalArgumentException le) {
            // if an IllegalArgumentException is thrown, list was not long enough so the parameter is missing
            LOGGER.warn(
                "GET_READER_CAPABILITIES_RESPONSE misses non optional parameter of type LLRPStatus");
            throw new InvalidLLRPMessageException(
                "GET_READER_CAPABILITIES_RESPONSE misses non optional parameter of type LLRPStatus");
        }

        if (binary.get(position)) {
            // length can statically be determined for TV Parameters
            tempLength = lLRPStatus.length();
        }

        if ((type != null) && type.equals(LLRPStatus.TYPENUM)) {
            lLRPStatus = new LLRPStatus(binary.subList(position, tempLength));
            position += tempLength;
            LOGGER.debug(
                " lLRPStatus is instantiated with LLRPStatus with length" +
                tempLength);
        } else {
            LOGGER.warn(
                "GET_READER_CAPABILITIES_RESPONSE misses non optional parameter of type LLRPStatus");
            throw new InvalidLLRPMessageException(
                "GET_READER_CAPABILITIES_RESPONSE misses non optional parameter of type LLRPStatus");
        }

        // look ahead to see type
        // may be optional or exactly once
        type = null;
        tempByteLength = 0;
        tempLength = 0;

        try {
            // if first bit is one it is a TV Parameter
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
        } catch (IllegalArgumentException le) {
            // if an IllegalArgumentException is thrown, list was not long enough so the parameter is missing
            LOGGER.info(
                "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type GeneralDeviceCapabilities");
        }

        if (binary.get(position)) {
            // length can statically be determined for TV Parameters
            tempLength = generalDeviceCapabilities.length();
        }

        if ((type != null) && type.equals(GeneralDeviceCapabilities.TYPENUM)) {
            generalDeviceCapabilities = new GeneralDeviceCapabilities(binary.subList(
                        position, tempLength));
            position += tempLength;
            LOGGER.debug(
                " generalDeviceCapabilities is instantiated with GeneralDeviceCapabilities with length" +
                tempLength);
        } else {
            LOGGER.info(
                "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type GeneralDeviceCapabilities");
        }

        // look ahead to see type
        // may be optional or exactly once
        type = null;
        tempByteLength = 0;
        tempLength = 0;

        try {
            // if first bit is one it is a TV Parameter
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
        } catch (IllegalArgumentException le) {
            // if an IllegalArgumentException is thrown, list was not long enough so the parameter is missing
            LOGGER.info(
                "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type LLRPCapabilities");
        }

        if (binary.get(position)) {
            // length can statically be determined for TV Parameters
            tempLength = lLRPCapabilities.length();
        }

        if ((type != null) && type.equals(LLRPCapabilities.TYPENUM)) {
            lLRPCapabilities = new LLRPCapabilities(binary.subList(position,
                        tempLength));
            position += tempLength;
            LOGGER.debug(
                " lLRPCapabilities is instantiated with LLRPCapabilities with length" +
                tempLength);
        } else {
            LOGGER.info(
                "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type LLRPCapabilities");
        }

        // look ahead to see type
        // may be optional or exactly once
        type = null;
        tempByteLength = 0;
        tempLength = 0;

        try {
            // if first bit is one it is a TV Parameter
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
        } catch (IllegalArgumentException le) {
            // if an IllegalArgumentException is thrown, list was not long enough so the parameter is missing
            LOGGER.info(
                "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type RegulatoryCapabilities");
        }

        if (binary.get(position)) {
            // length can statically be determined for TV Parameters
            tempLength = regulatoryCapabilities.length();
        }

        if ((type != null) && type.equals(RegulatoryCapabilities.TYPENUM)) {
            regulatoryCapabilities = new RegulatoryCapabilities(binary.subList(
                        position, tempLength));
            position += tempLength;
            LOGGER.debug(
                " regulatoryCapabilities is instantiated with RegulatoryCapabilities with length" +
                tempLength);
        } else {
            LOGGER.info(
                "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type RegulatoryCapabilities");
        }

        // look ahead to see type
        // may be optional or exactly once
        type = null;
        tempByteLength = 0;
        tempLength = 0;

        try {
            // if first bit is one it is a TV Parameter
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
        } catch (IllegalArgumentException le) {
            // if an IllegalArgumentException is thrown, list was not long enough so the parameter is missing
            LOGGER.info(
                "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type AirProtocolLLRPCapabilities");
        }

        boolean found = false;
        LOGGER.debug("decoding choice type AirProtocolLLRPCapabilities ");

        //if first bit is 1 it is a TV Parameter
        if (binary.get(position)) {
            // length can statically be determined for TV Parameters
            tempLength = C1G2LLRPCapabilities.length();
        }

        if ((type != null) && type.equals(C1G2LLRPCapabilities.TYPENUM)) {
            airProtocolLLRPCapabilities = new C1G2LLRPCapabilities(binary.subList(
                        position, tempLength));
            LOGGER.debug(
                " airProtocolLLRPCapabilities instatiated to C1G2LLRPCapabilities with length " +
                tempLength);
            position += tempLength;
            found = true;
        }

        if (!found) {
            LOGGER.info(
                "encoded message misses non optional parameter airProtocolLLRPCapabilities");
        }

        // list of parameters
        customList = new LinkedList<Custom>();
        LOGGER.debug("decoding parameter customList ");

        while (position < binary.length()) {
            // store if one parameter matched
            boolean atLeastOnce = false;

            // look ahead to see type
            // if first bit is one it is a TV Parameter
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

            // custom
            if ((type != null) && type.equals(Custom.TYPENUM)) {
                Custom cus = new Custom(binary.subList(position, tempLength));
                //allowed custom parameters for this parameter	
                //end allowed parameters
                //if none matched continue wasn't called and we add just cus as we found no specific vendor implementation
                customList.add(cus);
                position += tempLength;
                atLeastOnce = true;
            }

            if (!atLeastOnce) {
                //no parameter matched therefore we jump out of the loop
                break;
            }
        }

        //if list is still empty no parameter matched
        if (customList.isEmpty()) {
            LOGGER.info(
                "encoded message does not contain parameter for optional customList");
        }
    }

    /**
    * {@inheritDoc}
    */
    public void decodeXML(final Document document)
        throws InvalidLLRPMessageException {
        Element temp = null;
        Custom custom;

        // child element are always in default LLRP namespace
        Namespace ns = Namespace.getNamespace(LLRPConstants.LLRPNAMESPACE);

        try {
            isValidXMLMessage(document, LLRPConstants.LLRPMESSAGESCHEMAPATH);

            Element root = (Element) document.getRootElement().clone();
            List<Element> tempList = null;

            // the version field is always 3 bit long 
            // if the version attribute is not set in the LTK-XML message,
            // it is set to version 001
            String versionAttribute = root.getAttributeValue("Version");

            if (versionAttribute != null) {
                version = new BitList(3);
                version.setValue(new Integer(versionAttribute));
            } else {
                version = new BitList(0, 0, 1);
            }

            messageID = new UnsignedInteger(root.getAttributeValue("MessageID"));

            //parameter - not choices - no special actions needed
            temp = root.getChild("LLRPStatus", ns);

            if (temp != null) {
                lLRPStatus = new LLRPStatus(temp);
                LOGGER.info(
                    "setting parameter lLRPStatus for parameter GET_READER_CAPABILITIES_RESPONSE");
            } else {
                LOGGER.warn(
                    "GET_READER_CAPABILITIES_RESPONSE misses non optional parameter of type lLRPStatus");
                throw new MissingParameterException(
                    "GET_READER_CAPABILITIES_RESPONSE misses non optional parameter of type lLRPStatus");
            }

            root.removeChild("LLRPStatus", ns);
            //parameter - not choices - no special actions needed
            temp = root.getChild("GeneralDeviceCapabilities", ns);

            if (temp != null) {
                generalDeviceCapabilities = new GeneralDeviceCapabilities(temp);
                LOGGER.info(
                    "setting parameter generalDeviceCapabilities for parameter GET_READER_CAPABILITIES_RESPONSE");
            } else {
                LOGGER.info(
                    "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type generalDeviceCapabilities");
            }

            root.removeChild("GeneralDeviceCapabilities", ns);
            //parameter - not choices - no special actions needed
            temp = root.getChild("LLRPCapabilities", ns);

            if (temp != null) {
                lLRPCapabilities = new LLRPCapabilities(temp);
                LOGGER.info(
                    "setting parameter lLRPCapabilities for parameter GET_READER_CAPABILITIES_RESPONSE");
            } else {
                LOGGER.info(
                    "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type lLRPCapabilities");
            }

            root.removeChild("LLRPCapabilities", ns);
            //parameter - not choices - no special actions needed
            temp = root.getChild("RegulatoryCapabilities", ns);

            if (temp != null) {
                regulatoryCapabilities = new RegulatoryCapabilities(temp);
                LOGGER.info(
                    "setting parameter regulatoryCapabilities for parameter GET_READER_CAPABILITIES_RESPONSE");
            } else {
                LOGGER.info(
                    "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type regulatoryCapabilities");
            }

            root.removeChild("RegulatoryCapabilities", ns);

            //choices - must check all possible subtypes
            boolean found = false;
            LOGGER.debug("decoding choice type AirProtocolLLRPCapabilities ");
            // try to get child for each possible subtype
            temp = root.getChild("C1G2LLRPCapabilities", ns);

            if (temp != null) {
                airProtocolLLRPCapabilities = new C1G2LLRPCapabilities(temp);
                LOGGER.debug(
                    " airProtocolLLRPCapabilities instatiated to C1G2LLRPCapabilities with");
                found = true;
            }

            root.removeChild("C1G2LLRPCapabilities", ns);

            if (!found) {
                LOGGER.info(
                    "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type airProtocolLLRPCapabilitiesList");
            }

            //parameter - not choices - no special actions needed
            //we expect a list of parameters
            customList = new LinkedList<Custom>();
            tempList = root.getChildren("Custom", ns);

            if ((tempList == null) || tempList.isEmpty()) {
                LOGGER.info(
                    "GET_READER_CAPABILITIES_RESPONSE misses optional parameter of type customList");
            } else {
                for (Element e : tempList) {
                    customList.add(new Custom(e));
                    LOGGER.debug("adding Custom to customList ");
                }
            }

            root.removeChildren("Custom", ns);

            //custom parameter
            //end custom
            if (root.getChildren().size() > 0) {
                String message = "GET_READER_CAPABILITIES_RESPONSE has unknown element " +
                    ((Element) root.getChildren().get(0)).getName();
                throw new InvalidLLRPMessageException(message);
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidLLRPMessageException(e.getMessage());
        } catch (MissingParameterException e) {
            throw new InvalidLLRPMessageException(e.getMessage());
        }
    }

    //setters

    /**
    * set lLRPStatus of type LLRPStatus.
    * @param  lLRPStatus to be set
    */
    public void setLLRPStatus(final LLRPStatus lLRPStatus) {
        this.lLRPStatus = lLRPStatus;
    }

    /**
    * set generalDeviceCapabilities of type GeneralDeviceCapabilities.
    * @param  generalDeviceCapabilities to be set
    */
    public void setGeneralDeviceCapabilities(
        final GeneralDeviceCapabilities generalDeviceCapabilities) {
        this.generalDeviceCapabilities = generalDeviceCapabilities;
    }

    /**
    * set lLRPCapabilities of type LLRPCapabilities.
    * @param  lLRPCapabilities to be set
    */
    public void setLLRPCapabilities(final LLRPCapabilities lLRPCapabilities) {
        this.lLRPCapabilities = lLRPCapabilities;
    }

    /**
    * set regulatoryCapabilities of type RegulatoryCapabilities.
    * @param  regulatoryCapabilities to be set
    */
    public void setRegulatoryCapabilities(
        final RegulatoryCapabilities regulatoryCapabilities) {
        this.regulatoryCapabilities = regulatoryCapabilities;
    }

    /**
    * set airProtocolLLRPCapabilities of type AirProtocolLLRPCapabilities.
    * @param  airProtocolLLRPCapabilities to be set
    */
    public void setAirProtocolLLRPCapabilities(
        final AirProtocolLLRPCapabilities airProtocolLLRPCapabilities) {
        this.airProtocolLLRPCapabilities = airProtocolLLRPCapabilities;
    }

    /**
    * set customList of type  List &lt;Custom>.
    * @param  customList to be set
    */
    public void setCustomList(final List<Custom> customList) {
        this.customList = customList;
    }

    // end setter

    //getters

    /**
    * get lLRPStatus of type LLRPStatus .
    * @return  LLRPStatus
    */
    public LLRPStatus getLLRPStatus() {
        return lLRPStatus;
    }

    /**
    * get generalDeviceCapabilities of type GeneralDeviceCapabilities .
    * @return  GeneralDeviceCapabilities
    */
    public GeneralDeviceCapabilities getGeneralDeviceCapabilities() {
        return generalDeviceCapabilities;
    }

    /**
    * get lLRPCapabilities of type LLRPCapabilities .
    * @return  LLRPCapabilities
    */
    public LLRPCapabilities getLLRPCapabilities() {
        return lLRPCapabilities;
    }

    /**
    * get regulatoryCapabilities of type RegulatoryCapabilities .
    * @return  RegulatoryCapabilities
    */
    public RegulatoryCapabilities getRegulatoryCapabilities() {
        return regulatoryCapabilities;
    }

    /**
    * get airProtocolLLRPCapabilities of type AirProtocolLLRPCapabilities .
    * @return  AirProtocolLLRPCapabilities
    */
    public AirProtocolLLRPCapabilities getAirProtocolLLRPCapabilities() {
        return airProtocolLLRPCapabilities;
    }

    /**
    * get customList of type List &lt;Custom> .
    * @return  List &lt;Custom>
    */
    public List<Custom> getCustomList() {
        return customList;
    }

    // end getters

    //add methods

    /**
    * add element custom of type Custom .
    * @param  custom of type Custom
    */
    public void addToCustomList(Custom custom) {
        if (this.customList == null) {
            this.customList = new LinkedList<Custom>();
        }

        this.customList.add(custom);
    }

    // end add
    @Override
    public String getResponseType() {
        return RESPONSETYPE;
    }

    @Override
    public String getName() {
        return "GET_READER_CAPABILITIES_RESPONSE";
    }

    /**
    * return uniuque type number.
    * @return SignedShort holding unique type number
    */
    public SignedShort getTypeNum() {
        return TYPENUM;
    }
}
