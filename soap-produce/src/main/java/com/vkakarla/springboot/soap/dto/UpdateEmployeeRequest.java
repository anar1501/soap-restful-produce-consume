package com.vkakarla.springboot.soap.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "employeeInfo",
        "employeeId"
})
@XmlRootElement(name = "updateEmployeeRequest")
public class UpdateEmployeeRequest {
    @XmlElement(required = true)
    protected long employeeId;
    @XmlElement(required = true)
    protected EmployeeInfo employeeInfo;

    /**
     * Gets the value of the employeeInfo property.
     *
     * @return possible object is
     * {@link EmployeeInfo }
     */
    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public long getId() {
        return employeeId;
    }

    public void setId(long id) {
        this.employeeId = id;
    }

    /**
     * Sets the value of the employeeInfo property.
     *
     * @param value allowed object is
     *              {@link EmployeeInfo }
     */
    public void setEmployeeInfo(EmployeeInfo value) {
        this.employeeInfo = value;
    }

}
