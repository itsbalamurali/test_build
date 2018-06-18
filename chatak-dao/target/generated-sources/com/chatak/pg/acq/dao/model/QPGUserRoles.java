package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGUserRoles is a Querydsl query type for PGUserRoles
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGUserRoles extends EntityPathBase<PGUserRoles> {

    private static final long serialVersionUID = 1727265923L;

    public static final QPGUserRoles pGUserRoles = new QPGUserRoles("pGUserRoles");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath description = createString("description");

    public final StringPath reason = createString("reason");

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final StringPath roleName = createString("roleName");

    public final StringPath roleType = createString("roleType");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGUserRoles(String variable) {
        super(PGUserRoles.class, forVariable(variable));
    }

    public QPGUserRoles(Path<? extends PGUserRoles> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGUserRoles(PathMetadata<?> metadata) {
        super(PGUserRoles.class, metadata);
    }

}

