package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGTransfers is a Querydsl query type for PGTransfers
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGTransfers extends EntityPathBase<PGTransfers> {

    private static final long serialVersionUID = -1842419527L;

    public static final QPGTransfers pGTransfers = new QPGTransfers("pGTransfers");

    public final StringPath accountType = createString("accountType");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final StringPath bankRoutingNumber = createString("bankRoutingNumber");

    public final StringPath city = createString("city");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath fromAccount = createString("fromAccount");

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public final StringPath nameOnAccount = createString("nameOnAccount");

    public final NumberPath<Long> pgTransfersId = createNumber("pgTransfersId", Long.class);

    public final StringPath state = createString("state");

    public final StringPath status = createString("status");

    public final StringPath toAccount = createString("toAccount");

    public final StringPath transferMode = createString("transferMode");

    public final StringPath txnDescription = createString("txnDescription");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGTransfers(String variable) {
        super(PGTransfers.class, forVariable(variable));
    }

    public QPGTransfers(Path<? extends PGTransfers> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGTransfers(PathMetadata<?> metadata) {
        super(PGTransfers.class, metadata);
    }

}

