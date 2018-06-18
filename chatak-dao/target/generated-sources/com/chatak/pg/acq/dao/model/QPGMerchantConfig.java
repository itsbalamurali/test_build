package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantConfig is a Querydsl query type for PGMerchantConfig
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantConfig extends EntityPathBase<PGMerchantConfig> {

    private static final long serialVersionUID = -294438151L;

    public static final QPGMerchantConfig pGMerchantConfig = new QPGMerchantConfig("pGMerchantConfig");

    public final NumberPath<Integer> autoSettlement = createNumber("autoSettlement", Integer.class);

    public final StringPath cancelUrl = createString("cancelUrl");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath feeProgram = createString("feeProgram");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> online = createNumber("online", Integer.class);

    public final StringPath payOutAt = createString("payOutAt");

    public final NumberPath<Integer> payPageConfig = createNumber("payPageConfig", Integer.class);

    public final NumberPath<Integer> posTerminal = createNumber("posTerminal", Integer.class);

    public final StringPath processor = createString("processor");

    public final NumberPath<Integer> refunds = createNumber("refunds", Integer.class);

    public final StringPath returnUrl = createString("returnUrl");

    public final NumberPath<Integer> shippingAmount = createNumber("shippingAmount", Integer.class);

    public final NumberPath<Integer> taxAmount = createNumber("taxAmount", Integer.class);

    public final NumberPath<Integer> tipAmount = createNumber("tipAmount", Integer.class);

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final NumberPath<Integer> virtualTerminal = createNumber("virtualTerminal", Integer.class);

    public final StringPath webSiteAddress = createString("webSiteAddress");

    public QPGMerchantConfig(String variable) {
        super(PGMerchantConfig.class, forVariable(variable));
    }

    public QPGMerchantConfig(Path<? extends PGMerchantConfig> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantConfig(PathMetadata<?> metadata) {
        super(PGMerchantConfig.class, metadata);
    }

}

