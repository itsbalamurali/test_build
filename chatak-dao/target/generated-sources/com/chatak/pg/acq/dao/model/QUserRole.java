package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QUserRole is a Querydsl query type for UserRole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserRole extends EntityPathBase<UserRole> {

    private static final long serialVersionUID = -1083982599L;

    public static final QUserRole userRole = new QUserRole("userRole");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath description = createString("description");

    public final StringPath makerCheckerReq = createString("makerCheckerReq");

    public final StringPath reason = createString("reason");

    public final ListPath<PortalRoleFeatureMap, QPortalRoleFeatureMap> roleFeatureMaps = this.<PortalRoleFeatureMap, QPortalRoleFeatureMap>createList("roleFeatureMaps", PortalRoleFeatureMap.class, QPortalRoleFeatureMap.class, PathInits.DIRECT2);

    public final StringPath roleName = createString("roleName");

    public final StringPath roleType = createString("roleType");

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final NumberPath<Long> userRoleId = createNumber("userRoleId", Long.class);

    public QUserRole(String variable) {
        super(UserRole.class, forVariable(variable));
    }

    public QUserRole(Path<? extends UserRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRole(PathMetadata<?> metadata) {
        super(UserRole.class, metadata);
    }

}

