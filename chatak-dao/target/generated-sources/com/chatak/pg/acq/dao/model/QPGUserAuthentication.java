package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGUserAuthentication is a Querydsl query type for PGUserAuthentication
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGUserAuthentication extends EntityPathBase<PGUserAuthentication> {

    private static final long serialVersionUID = 1732678514L;

    public static final QPGUserAuthentication pGUserAuthentication = new QPGUserAuthentication("pGUserAuthentication");

    public final StringPath clientIP = createString("clientIP");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> profileId = createNumber("profileId", Long.class);

    public final StringPath token = createString("token");

    public final DateTimePath<java.sql.Timestamp> tokenExpTime = createDateTime("tokenExpTime", java.sql.Timestamp.class);

    public QPGUserAuthentication(String variable) {
        super(PGUserAuthentication.class, forVariable(variable));
    }

    public QPGUserAuthentication(Path<? extends PGUserAuthentication> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGUserAuthentication(PathMetadata<?> metadata) {
        super(PGUserAuthentication.class, metadata);
    }

}

