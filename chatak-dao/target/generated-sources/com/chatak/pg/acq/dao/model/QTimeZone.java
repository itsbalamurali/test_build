package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTimeZone is a Querydsl query type for TimeZone
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTimeZone extends EntityPathBase<TimeZone> {

    private static final long serialVersionUID = 1400337969L;

    public static final QTimeZone timeZone = new QTimeZone("timeZone");

    public final NumberPath<Long> countryId = createNumber("countryId", Long.class);

    public final StringPath dayLightTimeOffset = createString("dayLightTimeOffset");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath standardTimeOffset = createString("standardTimeOffset");

    public QTimeZone(String variable) {
        super(TimeZone.class, forVariable(variable));
    }

    public QTimeZone(Path<? extends TimeZone> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTimeZone(PathMetadata<?> metadata) {
        super(TimeZone.class, metadata);
    }

}

