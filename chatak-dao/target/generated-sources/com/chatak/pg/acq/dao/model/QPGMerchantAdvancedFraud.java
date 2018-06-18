package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantAdvancedFraud is a Querydsl query type for PGMerchantAdvancedFraud
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantAdvancedFraud extends EntityPathBase<PGMerchantAdvancedFraud> {

    private static final long serialVersionUID = 197497803L;

    public static final QPGMerchantAdvancedFraud pGMerchantAdvancedFraud = new QPGMerchantAdvancedFraud("pGMerchantAdvancedFraud");

    public final StringPath action = createString("action");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath duration = createString("duration");

    public final StringPath filterOn = createString("filterOn");

    public final StringPath filterType = createString("filterType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath maxLimit = createString("maxLimit");

    public final StringPath merchantCode = createString("merchantCode");

    public final StringPath transactionLimit = createString("transactionLimit");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGMerchantAdvancedFraud(String variable) {
        super(PGMerchantAdvancedFraud.class, forVariable(variable));
    }

    public QPGMerchantAdvancedFraud(Path<? extends PGMerchantAdvancedFraud> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantAdvancedFraud(PathMetadata<?> metadata) {
        super(PGMerchantAdvancedFraud.class, metadata);
    }

}

