package edu.dhbw.oodb.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the ORDERS database table.
 * 
 */
@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "O_ORDERKEY", unique = true, nullable = false, precision = 22)
	private long oOrderkey;

	@Column(name = "O_CLERK", nullable = false, length = 15)
	private String oClerk;

	@Column(name = "O_COMMENT", nullable = false, length = 79)
	private String oComment;

	@Column(name = "O_CUSTKEY", nullable = false, precision = 22)
	private BigDecimal oCustkey;

	@Temporal(TemporalType.DATE)
	@Column(name = "O_ORDERDATE", nullable = false)
	private Date oOrderdate;

	@Column(name = "O_ORDERPRIORITY", nullable = false, length = 15)
	private String oOrderpriority;

	@Column(name = "O_ORDERSTATUS", nullable = false, length = 1)
	private String oOrderstatus;

	@Column(name = "O_SHIPPRIORITY", nullable = false, precision = 22)
	private BigDecimal oShippriority;

	@Column(name = "O_TOTALPRICE", nullable = false, precision = 15, scale = 2)
	private BigDecimal oTotalprice;

	public Order() {
	}

	public long getOOrderkey() {
		return this.oOrderkey;
	}

	public void setOOrderkey(long oOrderkey) {
		this.oOrderkey = oOrderkey;
	}

	public String getOClerk() {
		return this.oClerk;
	}

	public void setOClerk(String oClerk) {
		this.oClerk = oClerk;
	}

	public String getOComment() {
		return this.oComment;
	}

	public void setOComment(String oComment) {
		this.oComment = oComment;
	}

	public BigDecimal getOCustkey() {
		return this.oCustkey;
	}

	public void setOCustkey(BigDecimal oCustkey) {
		this.oCustkey = oCustkey;
	}

	public Date getOOrderdate() {
		return this.oOrderdate;
	}

	public void setOOrderdate(Date oOrderdate) {
		this.oOrderdate = oOrderdate;
	}

	public String getOOrderpriority() {
		return this.oOrderpriority;
	}

	public void setOOrderpriority(String oOrderpriority) {
		this.oOrderpriority = oOrderpriority;
	}

	public String getOOrderstatus() {
		return this.oOrderstatus;
	}

	public void setOOrderstatus(String oOrderstatus) {
		this.oOrderstatus = oOrderstatus;
	}

	public BigDecimal getOShippriority() {
		return this.oShippriority;
	}

	public void setOShippriority(BigDecimal oShippriority) {
		this.oShippriority = oShippriority;
	}

	public BigDecimal getOTotalprice() {
		return this.oTotalprice;
	}

	public void setOTotalprice(BigDecimal oTotalprice) {
		this.oTotalprice = oTotalprice;
	}

}