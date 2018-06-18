package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGPaymentScheme is a Querydsl query type for PGPaymentScheme
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGPaymentScheme extends EntityPathBase<PGPaymentScheme> {

    private static final long serialVersionUID = 1714096540L;

    public static final QPGPaymentScheme pGPaymentScheme = new QPGPaymentScheme("pGPaymentScheme");

    public final StringPath contactEmail = createString("contactEmail");

    public final StringPath contactName = createString("contactName");

    public final StringPath contactPhone = createString("contactPhone");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath paymentSchemeName = createString("paymentSchemeName");

    public final StringPath reason = createString("reason");

    public final StringPath rid = createString("rid");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath typeOfCard = createString("typeOfCard");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGPaymentScheme(String variable) {
        super(PGPaymentScheme.class, forVariable(variable));
    }

    public QPGPaymentScheme(Path<? extends PGPaymentScheme> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGPaymentScheme(PathMetadata<?> metadata) {
        super(PGPaymentScheme.class, metadata);
    }

}

