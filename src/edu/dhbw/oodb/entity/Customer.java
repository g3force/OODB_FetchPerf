package edu.dhbw.oodb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "C_CUSTKEY", unique = true, nullable = false, precision = 22)
	private long cCustkey;

	@Column(name = "C_ACCTBAL", nullable = false, precision = 15, scale = 2)
	private BigDecimal cAcctbal;

	@Column(name = "C_ADDRESS", nullable = false, length = 40)
	private String cAddress;

	@Column(name = "C_COMMENT", nullable = false, length = 117)
	private String cComment;

	@Column(name = "C_MKTSEGMENT", nullable = false, length = 10)
	private String cMktsegment;

	@Column(name = "C_NAME", nullable = false, length = 25)
	private String cName;

	@Column(name = "C_NATIONKEY", nullable = false, precision = 22)
	private BigDecimal cNationkey;

	@Column(name = "C_PHONE", nullable = false, length = 15)
	private String cPhone;

	public Customer() {
	}

	public long getCCustkey() {
		return this.cCustkey;
	}

	public void setCCustkey(long cCustkey) {
		this.cCustkey = cCustkey;
	}

	public BigDecimal getCAcctbal() {
		return this.cAcctbal;
	}

	public void setCAcctbal(BigDecimal cAcctbal) {
		this.cAcctbal = cAcctbal;
	}

	public String getCAddress() {
		return this.cAddress;
	}

	public void setCAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getCComment() {
		return this.cComment;
	}

	public void setCComment(String cComment) {
		this.cComment = cComment;
	}

	public String getCMktsegment() {
		return this.cMktsegment;
	}

	public void setCMktsegment(String cMktsegment) {
		this.cMktsegment = cMktsegment;
	}

	public String getCName() {
		return this.cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public BigDecimal getCNationkey() {
		return this.cNationkey;
	}

	public void setCNationkey(BigDecimal cNationkey) {
		this.cNationkey = cNationkey;
	}

	public String getCPhone() {
		return this.cPhone;
	}

	public void setCPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	@Override
	public String toString() {
		return "Customer [cCustkey=" + cCustkey + ", cAcctbal=" + cAcctbal
				+ ", cAddress=" + cAddress + ", cComment=" + cComment
				+ ", cMktsegment=" + cMktsegment + ", cName=" + cName
				+ ", cNationkey=" + cNationkey + ", cPhone=" + cPhone + "]";
	}

}