package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantSettlement is a Querydsl query type for PGMerchantSettlement
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantSettlement extends EntityPathBase<PGMerchantSettlement> {

    private static final long serialVersionUID = -1896247968L;

    public static final QPGMerchantSettlement pGMerchantSettlement = new QPGMerchantSettlement("pGMerchantSettlement");

    public final StringPath accountNumber = createString("accountNumber");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final StringPath entityId = createString("entityId");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantCode = createString("merchantCode");

    public final DateTimePath<java.sql.Timestamp> requestedDate = createDateTime("requestedDate", java.sql.Timestamp.class);

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGMerchantSettlement(String variable) {
        super(PGMerchantSettlement.class, forVariable(variable));
    }

    public QPGMerchantSettlement(Path<? extends PGMerchantSettlement> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantSettlement(PathMetadata<?> metadata) {
        super(PGMerchantSettlement.class, metadata);
    }

}

