package com.capgemini.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductEntity is a Querydsl query type for ProductEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductEntity extends EntityPathBase<ProductEntity> {

    private static final long serialVersionUID = -267932932L;

    public static final QProductEntity productEntity = new QProductEntity("productEntity");

    public final QAbstractEntity _super = new QAbstractEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Double> margin = createNumber("margin", Double.class);

    public final StringPath name = createString("name");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final ListPath<TransactionsDetailsEntity, QTransactionsDetailsEntity> transactionsDetails = this.<TransactionsDetailsEntity, QTransactionsDetailsEntity>createList("transactionsDetails", TransactionsDetailsEntity.class, QTransactionsDetailsEntity.class, PathInits.DIRECT2);

    public QProductEntity(String variable) {
        super(ProductEntity.class, forVariable(variable));
    }

    public QProductEntity(Path<? extends ProductEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductEntity(PathMetadata metadata) {
        super(ProductEntity.class, metadata);
    }

}

