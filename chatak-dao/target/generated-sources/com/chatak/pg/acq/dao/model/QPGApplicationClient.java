package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGApplicationClient is a Querydsl query type for PGApplicationClient
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGApplicationClient extends EntityPathBase<PGApplicationClient> {

    private static final long serialVersionUID = 247720716L;

    public static final QPGApplicationClient pGApplicationClient = new QPGApplicationClient("pGApplicationClient");

    public final DateTimePath<java.sql.Timestamp> activeFrom = createDateTime("activeFrom", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> activeTill = createDateTime("activeTill", java.sql.Timestamp.class);

    public final StringPath appAdminEmail = createString("appAdminEmail");

    public final StringPath appAuthPass = createString("appAuthPass");

    public final StringPath appAuthUser = createString("appAuthUser");

    public final StringPath appClientAccess = createString("appClientAccess");

    public final StringPath AppClientAddress = createString("AppClientAddress");

    public final StringPath AppClientCity = createString("AppClientCity");

    public final StringPath AppClientCountry = createString("AppClientCountry");

    public final StringPath AppClientEmail = createString("AppClientEmail");

    public final StringPath appClientId = createString("appClientId");

    public final StringPath AppClientName = createString("AppClientName");

    public final StringPath AppClientPhone = createString("AppClientPhone");

    public final StringPath AppClientRole = createString("AppClientRole");

    public final StringPath AppClientZip = createString("AppClientZip");

    public final StringPath appDescription = createString("appDescription");

    public final StringPath appName = createString("appName");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGApplicationClient(String variable) {
        super(PGApplicationClient.class, forVariable(variable));
    }

    public QPGApplicationClient(Path<? extends PGApplicationClient> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGApplicationClient(PathMetadata<?> metadata) {
        super(PGApplicationClient.class, metadata);
    }

}

