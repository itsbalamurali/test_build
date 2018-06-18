package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPartnerAccount is a Querydsl query type for PartnerAccount
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPartnerAccount extends EntityPathBase<PartnerAccount> {

    private static final long serialVersionUID = -357327779L;

    public static final QPartnerAccount partnerAccount = new QPartnerAccount("partnerAccount");

    public final NumberPath<Long> accountNumber = createNumber("accountNumber", Long.class);

    public final NumberPath<Long> accountThresholdLimit = createNumber("accountThresholdLimit", Long.class);

    public final StringPath accountType = createString("accountType");

    public final BooleanPath autoReplenish = createBoolean("autoReplenish");

    public final NumberPath<Long> availableBalance = createNumber("availableBalance", Long.class);

    public final NumberPath<Long> bankId = createNumber("bankId", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> currentBalance = createNumber("currentBalance", Long.class);

    public final StringPath nickName = createString("nickName");

    public final NumberPath<Long> partnerAccountId = createNumber("partnerAccountId", Long.class);

    public final NumberPath<Long> partnerId = createNumber("partnerId", Long.class);

    public final StringPath sendFundsMode = createString("sendFundsMode");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPartnerAccount(String variable) {
        super(PartnerAccount.class, forVariable(variable));
    }

    public QPartnerAccount(Path<? extends PartnerAccount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPartnerAccount(PathMetadata<?> metadata) {
        super(PartnerAccount.class, metadata);
    }

}

