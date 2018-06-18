package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantUserAddress is a Querydsl query type for PGMerchantUserAddress
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantUserAddress extends EntityPathBase<PGMerchantUserAddress> {

    private static final long serialVersionUID = 1902575698L;

    public static final QPGMerchantUserAddress pGMerchantUserAddress = new QPGMerchantUserAddress("pGMerchantUserAddress");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantCode = createString("merchantCode");

    public final NumberPath<Long> merchantUserId = createNumber("merchantUserId", Long.class);

    public final StringPath pin = createString("pin");

    public final StringPath state = createString("state");

    public QPGMerchantUserAddress(String variable) {
        super(PGMerchantUserAddress.class, forVariable(variable));
    }

    public QPGMerchantUserAddress(Path<? extends PGMerchantUserAddress> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantUserAddress(PathMetadata<?> metadata) {
        super(PGMerchantUserAddress.class, metadata);
    }

}

