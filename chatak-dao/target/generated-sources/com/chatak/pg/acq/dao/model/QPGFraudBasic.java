package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGFraudBasic is a Querydsl query type for PGFraudBasic
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGFraudBasic extends EntityPathBase<PGFraudBasic> {

    private static final long serialVersionUID = -1369452679L;

    public static final QPGFraudBasic pGFraudBasic = new QPGFraudBasic("pGFraudBasic");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath deniedBin = createString("deniedBin");

    public final StringPath deniedCountry = createString("deniedCountry");

    public final StringPath deniedEMail = createString("deniedEMail");

    public final StringPath deniedIP = createString("deniedIP");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGFraudBasic(String variable) {
        super(PGFraudBasic.class, forVariable(variable));
    }

    public QPGFraudBasic(Path<? extends PGFraudBasic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGFraudBasic(PathMetadata<?> metadata) {
        super(PGFraudBasic.class, metadata);
    }

}

