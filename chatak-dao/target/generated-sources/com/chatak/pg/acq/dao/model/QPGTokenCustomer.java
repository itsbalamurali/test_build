package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGTokenCustomer is a Querydsl query type for PGTokenCustomer
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGTokenCustomer extends EntityPathBase<PGTokenCustomer> {

    private static final long serialVersionUID = -181770424L;

    public static final QPGTokenCustomer pGTokenCustomer = new QPGTokenCustomer("pGTokenCustomer");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath password = createString("password");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath userId = createString("userId");

    public QPGTokenCustomer(String variable) {
        super(PGTokenCustomer.class, forVariable(variable));
    }

    public QPGTokenCustomer(Path<? extends PGTokenCustomer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGTokenCustomer(PathMetadata<?> metadata) {
        super(PGTokenCustomer.class, metadata);
    }

}

