package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QProgramManagerAccount is a Querydsl query type for ProgramManagerAccount
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QProgramManagerAccount extends EntityPathBase<ProgramManagerAccount> {

    private static final long serialVersionUID = -958519732L;

    public static final QProgramManagerAccount programManagerAccount = new QProgramManagerAccount("programManagerAccount");

    public final NumberPath<Long> accountNumber = createNumber("accountNumber", Long.class);

    public final NumberPath<Long> accountThresholdLimit = createNumber("accountThresholdLimit", Long.class);

    public final StringPath accountType = createString("accountType");

    public final BooleanPath autoReplenish = createBoolean("autoReplenish");

    public final NumberPath<Long> availableBalance = createNumber("availableBalance", Long.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> currentBalance = createNumber("currentBalance", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath nickName = createString("nickName");

    public final NumberPath<Long> programManagerId = createNumber("programManagerId", Long.class);

    public final StringPath sendFundsMode = createString("sendFundsMode");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QProgramManagerAccount(String variable) {
        super(ProgramManagerAccount.class, forVariable(variable));
    }

    public QProgramManagerAccount(Path<? extends ProgramManagerAccount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProgramManagerAccount(PathMetadata<?> metadata) {
        super(ProgramManagerAccount.class, metadata);
    }

}

