package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGReseller is a Querydsl query type for PGReseller
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGReseller extends EntityPathBase<PGReseller> {

    private static final long serialVersionUID = 110226049L;

    public static final QPGReseller pGReseller = new QPGReseller("pGReseller");

    public final NumberPath<Long> accountBalance = createNumber("accountBalance", Long.class);

    public final NumberPath<Long> accountNumber = createNumber("accountNumber", Long.class);

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath city = createString("city");

    public final StringPath contactName = createString("contactName");

    public final StringPath country = createString("country");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath emailId = createString("emailId");

    public final StringPath phone = createString("phone");

    public final NumberPath<Long> resellerId = createNumber("resellerId", Long.class);

    public final StringPath resellerName = createString("resellerName");

    public final StringPath state = createString("state");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath zip = createString("zip");

    public QPGReseller(String variable) {
        super(PGReseller.class, forVariable(variable));
    }

    public QPGReseller(Path<? extends PGReseller> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGReseller(PathMetadata<?> metadata) {
        super(PGReseller.class, metadata);
    }

}

