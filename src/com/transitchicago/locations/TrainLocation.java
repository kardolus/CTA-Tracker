//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.12.17 at 02:12:39 PM EST 
//


package com.transitchicago.locations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tmst" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errCd" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *         &lt;element name="errNm" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="route" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="train" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="rn" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="destSt" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="destNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="trDr" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="nextStaId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="nextStpId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                             &lt;element name="nextStaNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="prdt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="arrT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="isApp" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="isDly" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
 *                             &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="heading" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tmst",
    "errCd",
    "errNm",
    "route"
})
@XmlRootElement(name = "ctatt")
public class TrainLocation {

    @XmlElement(required = true)
    protected String tmst;
    @XmlSchemaType(name = "unsignedByte")
    protected short errCd;
    @XmlElement(required = true)
    protected Object errNm;
    @XmlElement(required = true)
    protected List<TrainLocation.Route> route;

    /**
     * Gets the value of the tmst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTmst() {
        return tmst;
    }

    /**
     * Sets the value of the tmst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTmst(String value) {
        this.tmst = value;
    }

    /**
     * Gets the value of the errCd property.
     * 
     */
    public short getErrCd() {
        return errCd;
    }

    /**
     * Sets the value of the errCd property.
     * 
     */
    public void setErrCd(short value) {
        this.errCd = value;
    }

    /**
     * Gets the value of the errNm property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getErrNm() {
        return errNm;
    }

    /**
     * Sets the value of the errNm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setErrNm(Object value) {
        this.errNm = value;
    }

    /**
     * Gets the value of the route property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the route property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ctatt.Route }
     * 
     * 
     */
    public List<TrainLocation.Route> getRoute() {
        if (route == null) {
            route = new ArrayList<TrainLocation.Route>();
        }
        return this.route;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="train" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="rn" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *                   &lt;element name="destSt" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *                   &lt;element name="destNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="trDr" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                   &lt;element name="nextStaId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *                   &lt;element name="nextStpId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *                   &lt;element name="nextStaNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="prdt" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="arrT" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="isApp" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                   &lt;element name="isDly" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
     *                   &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="heading" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "train"
    })
    public static class Route {

        @XmlElement(required = true)
        protected List<TrainLocation.Route.Train> train;
        @XmlAttribute(name = "name", required = true)
        protected String name;

        /**
         * Gets the value of the train property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the train property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTrain().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Ctatt.Route.Train }
         * 
         * 
         */
        public List<TrainLocation.Route.Train> getTrain() {
            if (train == null) {
                train = new ArrayList<TrainLocation.Route.Train>();
            }
            return this.train;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="rn" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
         *         &lt;element name="destSt" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
         *         &lt;element name="destNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="trDr" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *         &lt;element name="nextStaId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
         *         &lt;element name="nextStpId" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
         *         &lt;element name="nextStaNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="prdt" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="arrT" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="isApp" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *         &lt;element name="isDly" type="{http://www.w3.org/2001/XMLSchema}unsignedByte"/>
         *         &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="lat" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="lon" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="heading" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "rn",
            "destSt",
            "destNm",
            "trDr",
            "nextStaId",
            "nextStpId",
            "nextStaNm",
            "prdt",
            "arrT",
            "isApp",
            "isDly",
            "flags",
            "lat",
            "lon",
            "heading"
        })
        public static class Train {

            @XmlSchemaType(name = "unsignedShort")
            protected int rn;
            @XmlSchemaType(name = "unsignedShort")
            protected int destSt;
            @XmlElement(required = true)
            protected String destNm;
            @XmlSchemaType(name = "unsignedByte")
            protected short trDr;
            @XmlSchemaType(name = "unsignedShort")
            protected int nextStaId;
            @XmlSchemaType(name = "unsignedShort")
            protected int nextStpId;
            @XmlElement(required = true)
            protected String nextStaNm;
            @XmlElement(required = true)
            protected String prdt;
            @XmlElement(required = true)
            protected String arrT;
            @XmlSchemaType(name = "unsignedByte")
            protected short isApp;
            @XmlSchemaType(name = "unsignedByte")
            protected short isDly;
            @XmlElement(required = true)
            protected String flags;
            @XmlElement(required = true)
            protected BigDecimal lat;
            @XmlElement(required = true)
            protected BigDecimal lon;
            @XmlSchemaType(name = "unsignedShort")
            protected int heading;

            /**
             * Gets the value of the rn property.
             * 
             */
            public int getRn() {
                return rn;
            }

            /**
             * Sets the value of the rn property.
             * 
             */
            public void setRn(int value) {
                this.rn = value;
            }

            /**
             * Gets the value of the destSt property.
             * 
             */
            public int getDestSt() {
                return destSt;
            }

            /**
             * Sets the value of the destSt property.
             * 
             */
            public void setDestSt(int value) {
                this.destSt = value;
            }

            /**
             * Gets the value of the destNm property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDestNm() {
                return destNm;
            }

            /**
             * Sets the value of the destNm property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDestNm(String value) {
                this.destNm = value;
            }

            /**
             * Gets the value of the trDr property.
             * 
             */
            public short getTrDr() {
                return trDr;
            }

            /**
             * Sets the value of the trDr property.
             * 
             */
            public void setTrDr(short value) {
                this.trDr = value;
            }

            /**
             * Gets the value of the nextStaId property.
             * 
             */
            public int getNextStaId() {
                return nextStaId;
            }

            /**
             * Sets the value of the nextStaId property.
             * 
             */
            public void setNextStaId(int value) {
                this.nextStaId = value;
            }

            /**
             * Gets the value of the nextStpId property.
             * 
             */
            public int getNextStpId() {
                return nextStpId;
            }

            /**
             * Sets the value of the nextStpId property.
             * 
             */
            public void setNextStpId(int value) {
                this.nextStpId = value;
            }

            /**
             * Gets the value of the nextStaNm property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNextStaNm() {
                return nextStaNm;
            }

            /**
             * Sets the value of the nextStaNm property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNextStaNm(String value) {
                this.nextStaNm = value;
            }

            /**
             * Gets the value of the prdt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPrdt() {
                return prdt;
            }

            /**
             * Sets the value of the prdt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPrdt(String value) {
                this.prdt = value;
            }

            /**
             * Gets the value of the arrT property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getArrT() {
                return arrT;
            }

            /**
             * Sets the value of the arrT property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setArrT(String value) {
                this.arrT = value;
            }

            /**
             * Gets the value of the isApp property.
             * 
             */
            public short getIsApp() {
                return isApp;
            }

            /**
             * Sets the value of the isApp property.
             * 
             */
            public void setIsApp(short value) {
                this.isApp = value;
            }

            /**
             * Gets the value of the isDly property.
             * 
             */
            public short getIsDly() {
                return isDly;
            }

            /**
             * Sets the value of the isDly property.
             * 
             */
            public void setIsDly(short value) {
                this.isDly = value;
            }

            /**
             * Gets the value of the flags property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlags() {
                return flags;
            }

            /**
             * Sets the value of the flags property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlags(String value) {
                this.flags = value;
            }

            /**
             * Gets the value of the lat property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getLat() {
                return lat;
            }

            /**
             * Sets the value of the lat property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setLat(BigDecimal value) {
                this.lat = value;
            }

            /**
             * Gets the value of the lon property.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getLon() {
                return lon;
            }

            /**
             * Sets the value of the lon property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setLon(BigDecimal value) {
                this.lon = value;
            }

            /**
             * Gets the value of the heading property.
             * 
             */
            public int getHeading() {
                return heading;
            }

            /**
             * Sets the value of the heading property.
             * 
             */
            public void setHeading(int value) {
                this.heading = value;
            }

        }

    }

}
