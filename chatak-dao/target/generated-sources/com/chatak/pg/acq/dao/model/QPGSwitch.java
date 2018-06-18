package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGSwitch is a Querydsl query type for PGSwitch
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGSwitch extends EntityPathBase<PGSwitch> {

    private static final long serialVersionUID = -2113573373L;

    public static final QPGSwitch pGSwitch = new QPGSwitch("pGSwitch");

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> primarySwitchPort = createNumber("primarySwitchPort", Integer.class);

    public final StringPath primarySwitchURL = createString("primarySwitchURL");

    public final NumberPath<Integer> priority = createNumber("priority", Integer.class);

    public final StringPath reason = createString("reason");

    public final NumberPath<Integer> secondarySwitchPort = createNumber("secondarySwitchPort", Integer.class);

    public final StringPath secondarySwitchURL = createString("secondarySwitchURL");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath switchName = createString("switchName");

    public final StringPath switchType = createString("switchType");

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGSwitch(String variable) {
        super(PGSwitch.class, forVariable(variable));
    }

    public QPGSwitch(Path<? extends PGSwitch> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGSwitch(PathMetadata<?> metadata) {
        super(PGSwitch.class, metadata);
    }

}

