package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPGAccount is a Querydsl query type for PGAccount
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGAccount extends EntityPathBase<PGAccount> {

    private static final long serialVersionUID = -469717698L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPGAccount pGAccount = new QPGAccount("pGAccount");

    public final StringPath accountDesc = createString("accountDesc");

    public final NumberPath<Long> accountNum = createNumber("accountNum", Long.class);

    public final NumberPath<java.math.BigDecimal> autoPaymentLimit = createNumber("autoPaymentLimit", java.math.BigDecimal.class);

    public final StringPath autoPaymentMethod = createString("autoPaymentMethod");

    public final NumberPath<Integer> autoSettlement = createNumber("autoSettlement", Integer.class);

    public final StringPath autoTransferDay = createString("autoTransferDay");

    public final NumberPath<Long> availableBalance = createNumber("availableBalance", Long.class);

    public final StringPath category = createString("category");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath currency = createString("currency");

    public final NumberPath<Long> currentBalance = createNumber("currentBalance", Long.class);

    public final StringPath entityId = createString("entityId");

    public final StringPath entityType = createString("entityType");

    public final NumberPath<Long> feeBalance = createNumber("feeBalance", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPGMerchantBank pgMerchantBank;

    public final StringPath reason = createString("reason");

    public final StringPath status = createString("status");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGAccount(String variable) {
        this(PGAccount.class, forVariable(variable), INITS);
    }

    public QPGAccount(Path<? extends PGAccount> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGAccount(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPGAccount(PathMetadata<?> metadata, PathInits inits) {
        this(PGAccount.class, metadata, inits);
    }

    public QPGAccount(Class<? extends PGAccount> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pgMerchantBank = inits.isInitialized("pgMerchantBank") ? new QPGMerchantBank(forProperty("pgMerchantBank")) : null;
    }

}

