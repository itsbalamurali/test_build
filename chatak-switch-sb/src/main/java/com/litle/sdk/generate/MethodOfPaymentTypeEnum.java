//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.17 at 12:43:15 PM EST 
//


package com.litle.sdk.generate;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for methodOfPaymentTypeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="methodOfPaymentTypeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MC"/>
 *     &lt;enumeration value="VI"/>
 *     &lt;enumeration value="AX"/>
 *     &lt;enumeration value="DC"/>
 *     &lt;enumeration value="DI"/>
 *     &lt;enumeration value="PP"/>
 *     &lt;enumeration value="JC"/>
 *     &lt;enumeration value="BL"/>
 *     &lt;enumeration value="EC"/>
 *     &lt;enumeration value="GC"/>
 *     &lt;enumeration value=""/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "methodOfPaymentTypeEnum")
@XmlEnum
public enum MethodOfPaymentTypeEnum {

    MC("MC"),
    VI("VI"),
    AX("AX"),
    DC("DC"),
    DI("DI"),
    PP("PP"),
    JC("JC"),
    BL("BL"),
    EC("EC"),
    GC("GC"),
    ME("ME"),
    IP("IP"),
    @XmlEnumValue("")
    BLANK("");
    private final String value;

    MethodOfPaymentTypeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MethodOfPaymentTypeEnum fromValue(String v) {
        for (MethodOfPaymentTypeEnum c: MethodOfPaymentTypeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
