package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGEntity is a Querydsl query type for PGEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGEntity extends EntityPathBase<PGEntity> {

    private static final long serialVersionUID = 1772591794L;

    public static final QPGEntity pGEntity = new QPGEntity("pGEntity");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QPGEntity(String variable) {
        super(PGEntity.class, forVariable(variable));
    }

    public QPGEntity(Path<? extends PGEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGEntity(PathMetadata<?> metadata) {
        super(PGEntity.class, metadata);
    }

}

