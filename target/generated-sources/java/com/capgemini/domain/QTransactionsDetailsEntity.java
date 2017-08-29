package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransactionsDetailsEntity is a Querydsl query type for TransactionsDetailsEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTransactionsDetailsEntity extends EntityPathBase<TransactionsDetailsEntity> {

    private static final long serialVersionUID = 675602362L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransactionsDetailsEntity transactionsDetailsEntity = new QTransactionsDetailsEntity("transactionsDetailsEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> large = createNumber("large", Integer.class);

    public final QProductEntity product;

    public final QTransactionEntity transaction;

    public QTransactionsDetailsEntity(String variable) {
        this(TransactionsDetailsEntity.class, forVariable(variable), INITS);
    }

    public QTransactionsDetailsEntity(Path<? extends TransactionsDetailsEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTransactionsDetailsEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTransactionsDetailsEntity(PathMetadata metadata, PathInits inits) {
        this(TransactionsDetailsEntity.class, metadata, inits);
    }

    public QTransactionsDetailsEntity(Class<? extends TransactionsDetailsEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProductEntity(forProperty("product")) : null;
        this.transaction = inits.isInitialized("transaction") ? new QTransactionEntity(forProperty("transaction"), inits.get("transaction")) : null;
    }

}

