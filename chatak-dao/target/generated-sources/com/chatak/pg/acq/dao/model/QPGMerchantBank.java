package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantBank is a Querydsl query type for PGMerchantBank
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantBank extends EntityPathBase<PGMerchantBank> {

    private static final long serialVersionUID = 629817267L;

    public static final QPGMerchantBank pGMerchantBank = new QPGMerchantBank("pGMerchantBank");

    public final StringPath accountType = createString("accountType");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath bankAccNum = createString("bankAccNum");

    public final StringPath bankCode = createString("bankCode");

    public final StringPath bankName = createString("bankName");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currencyCode = createString("currencyCode");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath merchantId = createString("merchantId");

    public final StringPath nameOnAccount = createString("nameOnAccount");

    public final StringPath pin = createString("pin");

    public final StringPath routingNumber = createString("routingNumber");

    public final StringPath state = createString("state");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGMerchantBank(String variable) {
        super(PGMerchantBank.class, forVariable(variable));
    }

    public QPGMerchantBank(Path<? extends PGMerchantBank> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantBank(PathMetadata<?> metadata) {
        super(PGMerchantBank.class, metadata);
    }

}

