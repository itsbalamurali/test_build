package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGLegalEntity is a Querydsl query type for PGLegalEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGLegalEntity extends EntityPathBase<PGLegalEntity> {

    private static final long serialVersionUID = 1011267213L;

    public static final QPGLegalEntity pGLegalEntity = new QPGLegalEntity("pGLegalEntity");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final NumberPath<Long> annualCardSale = createNumber("annualCardSale", Long.class);

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final StringPath countryOfCitizenship = createString("countryOfCitizenship");

    public final StringPath countryOfResidence = createString("countryOfResidence");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath dateOfBirth = createString("dateOfBirth");

    public final StringPath firstName = createString("firstName");

    public final StringPath homePhone = createString("homePhone");

    public final StringPath lastName = createString("lastName");

    public final StringPath legalEntityName = createString("legalEntityName");

    public final StringPath legalEntityType = createString("legalEntityType");

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public final StringPath mobilePhone = createString("mobilePhone");

    public final StringPath passportNumber = createString("passportNumber");

    public final NumberPath<Long> pgLegalEntityId = createNumber("pgLegalEntityId", Long.class);

    public final StringPath pin = createString("pin");

    public final StringPath ssn = createString("ssn");

    public final StringPath state = createString("state");

    public final StringPath taxId = createString("taxId");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QPGLegalEntity(String variable) {
        super(PGLegalEntity.class, forVariable(variable));
    }

    public QPGLegalEntity(Path<? extends PGLegalEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGLegalEntity(PathMetadata<?> metadata) {
        super(PGLegalEntity.class, metadata);
    }

}

