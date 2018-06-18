package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantEntityMap is a Querydsl query type for PGMerchantEntityMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantEntityMap extends EntityPathBase<PGMerchantEntityMap> {

    private static final long serialVersionUID = -1219775646L;

    public static final QPGMerchantEntityMap pGMerchantEntityMap = new QPGMerchantEntityMap("pGMerchantEntityMap");

    public final NumberPath<Long> entityId = createNumber("entityId", Long.class);

    public final StringPath entitytype = createString("entitytype");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public QPGMerchantEntityMap(String variable) {
        super(PGMerchantEntityMap.class, forVariable(variable));
    }

    public QPGMerchantEntityMap(Path<? extends PGMerchantEntityMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantEntityMap(PathMetadata<?> metadata) {
        super(PGMerchantEntityMap.class, metadata);
    }

}

