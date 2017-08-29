package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QClientEntity is a Querydsl query type for ClientEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QClientEntity extends EntityPathBase<ClientEntity> {

    private static final long serialVersionUID = 71561476L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QClientEntity clientEntity = new QClientEntity("clientEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    public final com.capgemini.datatype.QAddress address;

    public final DatePath<java.sql.Date> dateOfBirth = createDate("dateOfBirth", java.sql.Date.class);

    public final StringPath email = createString("email");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath surname = createString("surname");

    public final SetPath<TransactionEntity, QTransactionEntity> transactions = this.<TransactionEntity, QTransactionEntity>createSet("transactions", TransactionEntity.class, QTransactionEntity.class, PathInits.DIRECT2);

    public QClientEntity(String variable) {
        this(ClientEntity.class, forVariable(variable), INITS);
    }

    public QClientEntity(Path<? extends ClientEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QClientEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QClientEntity(PathMetadata metadata, PathInits inits) {
        this(ClientEntity.class, metadata, inits);
    }

    public QClientEntity(Class<? extends ClientEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.address = inits.isInitialized("address") ? new com.capgemini.datatype.QAddress(forProperty("address")) : null;
    }

}

