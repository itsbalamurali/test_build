package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGRolesFeatureMapping is a Querydsl query type for PGRolesFeatureMapping
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGRolesFeatureMapping extends EntityPathBase<PGRolesFeatureMapping> {

    private static final long serialVersionUID = -1082625370L;

    public static final QPGRolesFeatureMapping pGRolesFeatureMapping = new QPGRolesFeatureMapping("pGRolesFeatureMapping");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> featureId = createNumber("featureId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGRolesFeatureMapping(String variable) {
        super(PGRolesFeatureMapping.class, forVariable(variable));
    }

    public QPGRolesFeatureMapping(Path<? extends PGRolesFeatureMapping> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGRolesFeatureMapping(PathMetadata<?> metadata) {
        super(PGRolesFeatureMapping.class, metadata);
    }

}

