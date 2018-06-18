package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QIsoAccount is a Querydsl query type for IsoAccount
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QIsoAccount extends EntityPathBase<IsoAccount> {

    private static final long serialVersionUID = 218918400L;

    public static final QIsoAccount isoAccount = new QIsoAccount("isoAccount");

    public final NumberPath<Long> accountNumber = createNumber("accountNumber", Long.class);

    public final StringPath accountType = createString("accountType");

    public final NumberPath<Long> availableBalance = createNumber("availableBalance", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> currentBalance = createNumber("currentBalance", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> isoId = createNumber("isoId", Long.class);

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QIsoAccount(String variable) {
        super(IsoAccount.class, forVariable(variable));
    }

    public QIsoAccount(Path<? extends IsoAccount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIsoAccount(PathMetadata<?> metadata) {
        super(IsoAccount.class, metadata);
    }

}

