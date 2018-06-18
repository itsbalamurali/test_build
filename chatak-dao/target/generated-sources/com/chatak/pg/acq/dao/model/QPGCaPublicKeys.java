package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGCaPublicKeys is a Querydsl query type for PGCaPublicKeys
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGCaPublicKeys extends EntityPathBase<PGCaPublicKeys> {

    private static final long serialVersionUID = 1296016010L;

    public static final QPGCaPublicKeys pGCaPublicKeys = new QPGCaPublicKeys("pGCaPublicKeys");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath expiryDate = createString("expiryDate");

    public final NumberPath<Long> publicKeyExponent = createNumber("publicKeyExponent", Long.class);

    public final NumberPath<Long> publicKeyId = createNumber("publicKeyId", Long.class);

    public final StringPath publicKeyIndex = createString("publicKeyIndex");

    public final StringPath publicKeyModulus = createString("publicKeyModulus");

    public final StringPath publicKeyName = createString("publicKeyName");

    public final StringPath reason = createString("reason");

    public final StringPath rId = createString("rId");

    public final StringPath status = createString("status");

    public QPGCaPublicKeys(String variable) {
        super(PGCaPublicKeys.class, forVariable(variable));
    }

    public QPGCaPublicKeys(Path<? extends PGCaPublicKeys> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGCaPublicKeys(PathMetadata<?> metadata) {
        super(PGCaPublicKeys.class, metadata);
    }

}

