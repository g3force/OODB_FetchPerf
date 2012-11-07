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

	@JoinColumn(name="O_CUSTKEY", nullable = false)
	private Customer customer;

	@Id
	@Column(name = "O_ORDERKEY", unique = true, nullable = false, precision = 22)
	private long id;

	@Column(name = "O_CLERK", nullable = false, length = 15)
	private String oClerk;

	@Column(name = "O_COMMENT", nullable = false, length = 79)
	private String oComment;

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
		return this.id;
	}

	public void setOOrderkey(long oOrderkey) {
		this.id = oOrderkey;
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

	public Customer getOCustkey() {
		return this.customer;
	}

	public void setOCustkey(Customer oCustkey) {
		this.customer = oCustkey;
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

	@Override
	public String toString() {
		return "Order [oOrderkey=" + id + ", oClerk=" + oClerk
				+ ", oComment=" + oComment + ", customer=" + customer
				+ ", oOrderdate=" + oOrderdate + ", oOrderpriority="
				+ oOrderpriority + ", oOrderstatus=" + oOrderstatus
				+ ", oShippriority=" + oShippriority + ", oTotalprice="
				+ oTotalprice + "]";
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