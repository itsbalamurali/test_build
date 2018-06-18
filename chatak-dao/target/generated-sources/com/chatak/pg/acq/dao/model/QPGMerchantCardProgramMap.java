package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantCardProgramMap is a Querydsl query type for PGMerchantCardProgramMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantCardProgramMap extends EntityPathBase<PGMerchantCardProgramMap> {

    private static final long serialVersionUID = 202843167L;

    public static final QPGMerchantCardProgramMap pGMerchantCardProgramMap = new QPGMerchantCardProgramMap("pGMerchantCardProgramMap");

    public final NumberPath<Long> cardProgramId = createNumber("cardProgramId", Long.class);

    public final NumberPath<Long> entityId = createNumber("entityId", Long.class);

    public final StringPath entitytype = createString("entitytype");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public QPGMerchantCardProgramMap(String variable) {
        super(PGMerchantCardProgramMap.class, forVariable(variable));
    }

    public QPGMerchantCardProgramMap(Path<? extends PGMerchantCardProgramMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantCardProgramMap(PathMetadata<?> metadata) {
        super(PGMerchantCardProgramMap.class, metadata);
    }

}

