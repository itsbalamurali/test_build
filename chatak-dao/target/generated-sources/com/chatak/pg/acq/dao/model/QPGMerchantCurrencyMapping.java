package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantCurrencyMapping is a Querydsl query type for PGMerchantCurrencyMapping
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantCurrencyMapping extends EntityPathBase<PGMerchantCurrencyMapping> {

    private static final long serialVersionUID = -1559707226L;

    public static final QPGMerchantCurrencyMapping pGMerchantCurrencyMapping = new QPGMerchantCurrencyMapping("pGMerchantCurrencyMapping");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currencyCode = createString("currencyCode");

    public final StringPath merchantCode = createString("merchantCode");

    public final NumberPath<Long> pgMerchantCurMapId = createNumber("pgMerchantCurMapId", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGMerchantCurrencyMapping(String variable) {
        super(PGMerchantCurrencyMapping.class, forVariable(variable));
    }

    public QPGMerchantCurrencyMapping(Path<? extends PGMerchantCurrencyMapping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantCurrencyMapping(PathMetadata<?> metadata) {
        super(PGMerchantCurrencyMapping.class, metadata);
    }

}

