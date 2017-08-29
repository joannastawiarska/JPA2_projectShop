package com.capgemini.domain;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capgemini.datatype.TransactionType;

@Entity
@Table(name = "TRANSACTION")
public class TransactionEntity extends AbstractEntity {

	@Enumerated(EnumType.STRING)
	private TransactionType status;
	
	@Column(nullable = false)
    private Date dateOfOrder;

	@ManyToOne
	@JoinColumn
	private ClientEntity client;
	
	@OneToMany(mappedBy = "transaction")
	List<TransactionsDetailsEntity> transactionsDetails;
	
	public TransactionEntity() {
		
	}
	
	public TransactionType getType() {
		return status;
	}

	public void setType(TransactionType status) {
		this.status = status;
	}

	public Date getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}


	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}
	
	
	
}
