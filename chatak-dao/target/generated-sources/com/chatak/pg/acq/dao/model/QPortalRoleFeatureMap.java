package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPortalRoleFeatureMap is a Querydsl query type for PortalRoleFeatureMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPortalRoleFeatureMap extends EntityPathBase<PortalRoleFeatureMap> {

    private static final long serialVersionUID = -828865216L;

    public static final QPortalRoleFeatureMap portalRoleFeatureMap = new QPortalRoleFeatureMap("portalRoleFeatureMap");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> featureId = createNumber("featureId", Long.class);

    public final NumberPath<Long> roleFeatureMapId = createNumber("roleFeatureMapId", Long.class);

    public final StringPath status = createString("status");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final NumberPath<Long> userRoleId = createNumber("userRoleId", Long.class);

    public QPortalRoleFeatureMap(String variable) {
        super(PortalRoleFeatureMap.class, forVariable(variable));
    }

    public QPortalRoleFeatureMap(Path<? extends PortalRoleFeatureMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPortalRoleFeatureMap(PathMetadata<?> metadata) {
        super(PortalRoleFeatureMap.class, metadata);
    }

}

