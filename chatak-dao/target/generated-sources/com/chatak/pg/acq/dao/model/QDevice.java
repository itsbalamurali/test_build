package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDevice is a Querydsl query type for Device
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDevice extends EntityPathBase<Device> {

    private static final long serialVersionUID = 1573486190L;

    public static final QDevice device = new QDevice("device");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath deviceMake = createString("deviceMake");

    public final StringPath deviceModel = createString("deviceModel");

    public final NumberPath<Integer> deviceStatus = createNumber("deviceStatus", Integer.class);

    public final StringPath deviceType = createString("deviceType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QDevice(String variable) {
        super(Device.class, forVariable(variable));
    }

    public QDevice(Path<? extends Device> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDevice(PathMetadata<?> metadata) {
        super(Device.class, metadata);
    }

}

