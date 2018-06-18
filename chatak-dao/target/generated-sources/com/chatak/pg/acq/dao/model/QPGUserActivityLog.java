package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGUserActivityLog is a Querydsl query type for PGUserActivityLog
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGUserActivityLog extends EntityPathBase<PGUserActivityLog> {

    private static final long serialVersionUID = 475572987L;

    public static final QPGUserActivityLog pGUserActivityLog = new QPGUserActivityLog("pGUserActivityLog");

    public final DateTimePath<java.sql.Timestamp> activityDate = createDateTime("activityDate", java.sql.Timestamp.class);

    public final NumberPath<Long> activityLogId = createNumber("activityLogId", Long.class);

    public final StringPath auditEvent = createString("auditEvent");

    public final StringPath auditSection = createString("auditSection");

    public final StringPath auditService = createString("auditService");

    public final StringPath dataChange = createString("dataChange");

    public final StringPath description = createString("description");

    public final StringPath ipAddress = createString("ipAddress");

    public final StringPath loginSessionId = createString("loginSessionId");

    public final StringPath requestData = createString("requestData");

    public final StringPath status = createString("status");

    public final StringPath userId = createString("userId");

    public QPGUserActivityLog(String variable) {
        super(PGUserActivityLog.class, forVariable(variable));
    }

    public QPGUserActivityLog(Path<? extends PGUserActivityLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGUserActivityLog(PathMetadata<?> metadata) {
        super(PGUserActivityLog.class, metadata);
    }

}

