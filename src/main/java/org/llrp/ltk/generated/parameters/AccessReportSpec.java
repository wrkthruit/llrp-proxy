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
import org.llrp.ltk.generated.enumerations.AccessReportTriggerType;
import org.llrp.ltk.types.LLRPBitList;
import org.llrp.ltk.types.SignedShort;
import org.llrp.ltk.types.TLVParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * This parameter sets up the triggers for the Reader to send the access results to the Client. In addition, the Client can enable or disable reporting of ROSpec details in the access results.

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=79&view=fit">LLRP Specification Section 13.2.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=143&view=fit">LLRP Specification Section 16.2.7.2</a>}


 */

/**
 * This parameter sets up the triggers for the Reader to send the access results to the Client. In addition, the Client can enable or disable reporting of ROSpec details in the access results.

See also {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=79&view=fit">LLRP Specification Section 13.2.2</a>}
 and {@link <a href="http://www.epcglobalinc.org/standards/llrp/llrp_1_0_1-standard-20070813.pdf#page=143&view=fit">LLRP Specification Section 16.2.7.2</a>}

      .
 */
public class AccessReportSpec extends TLVParameter {
    public static final SignedShort TYPENUM = new SignedShort(239);
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessReportSpec.class);
    protected AccessReportTriggerType accessReportTrigger;

    /**
     * empty constructor to create new parameter.
     */
    public AccessReportSpec() {
    }

    /**
     * Constructor to create parameter from binary encoded parameter
     * calls decodeBinary to decode parameter.
     * @param list to be decoded
     */
    public AccessReportSpec(LLRPBitList list) {
        decodeBinary(list);
    }

    /**
    * Constructor to create parameter from xml encoded parameter
    * calls decodeXML to decode parameter.
    * @param element to be decoded
    */
    public AccessReportSpec(Element element) throws InvalidLLRPMessageException {
        decodeXML(element);
    }

    /**
    * {@inheritDoc}
    */
    public LLRPBitList encodeBinarySpecific() {
        LLRPBitList resultBits = new LLRPBitList();

        if (accessReportTrigger == null) {
            LOGGER.warn(" accessReportTrigger not set");
            throw new MissingParameterException(
                " accessReportTrigger not set  for Parameter of Type AccessReportSpec");
        }

        resultBits.append(accessReportTrigger.encodeBinary());

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

        if (accessReportTrigger == null) {
            LOGGER.warn(" accessReportTrigger not set");
            throw new MissingParameterException(" accessReportTrigger not set");
        } else {
            element.addContent(accessReportTrigger.encodeXML(
                    "AccessReportTrigger", ns));
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
        accessReportTrigger = new AccessReportTriggerType(binary.subList(
                    position, AccessReportTriggerType.length()));
        position += AccessReportTriggerType.length();
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

        temp = element.getChild("AccessReportTrigger", ns);

        if (temp != null) {
            accessReportTrigger = new AccessReportTriggerType(temp);
        }

        element.removeChild("AccessReportTrigger", ns);

        if (element.getChildren().size() > 0) {
            String message = "AccessReportSpec has unknown element " +
                ((Element) element.getChildren().get(0)).getName();
            throw new InvalidLLRPMessageException(message);
        }
    }

    //setters
    /**
    * set accessReportTrigger of type AccessReportTriggerType .
    * @param  accessReportTrigger to be set
    */
    public void setAccessReportTrigger(
        final AccessReportTriggerType accessReportTrigger) {
        this.accessReportTrigger = accessReportTrigger;
    }

    // end setter

    //getters
    /**
    * get accessReportTrigger of type AccessReportTriggerType.
    * @return  AccessReportTriggerType
    */
    public AccessReportTriggerType getAccessReportTrigger() {
        return accessReportTrigger;
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
        return "AccessReportSpec";
    }

    /**
    * return string representation. All field values but no parameters are included
    * @return String
    */
    public String toString() {
        String result = "AccessReportSpec: ";
        result += ", accessReportTrigger: ";
        result += accessReportTrigger;
        result = result.replaceFirst(", ", "");

        return result;
    }
}
