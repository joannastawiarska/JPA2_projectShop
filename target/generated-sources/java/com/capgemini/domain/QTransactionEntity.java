package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransactionEntity is a Querydsl query type for TransactionEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTransactionEntity extends EntityPathBase<TransactionEntity> {

    private static final long serialVersionUID = -27226965L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransactionEntity transactionEntity = new QTransactionEntity("transactionEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final QClientEntity client;

    public final DatePath<java.sql.Date> dateOfOrder = createDate("dateOfOrder", java.sql.Date.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final EnumPath<com.capgemini.datatype.TransactionType> status = createEnum("status", com.capgemini.datatype.TransactionType.class);

    public final ListPath<TransactionsDetailsEntity, QTransactionsDetailsEntity> transactionsDetails = this.<TransactionsDetailsEntity, QTransactionsDetailsEntity>createList("transactionsDetails", TransactionsDetailsEntity.class, QTransactionsDetailsEntity.class, PathInits.DIRECT2);

    public QTransactionEntity(String variable) {
        this(TransactionEntity.class, forVariable(variable), INITS);
    }

    public QTransactionEntity(Path<? extends TransactionEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransactionEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransactionEntity(PathMetadata metadata, PathInits inits) {
        this(TransactionEntity.class, metadata, inits);
    }

    public QTransactionEntity(Class<? extends TransactionEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.client = inits.isInitialized("client") ? new QClientEntity(forProperty("client"), inits.get("client")) : null;
    }

}

