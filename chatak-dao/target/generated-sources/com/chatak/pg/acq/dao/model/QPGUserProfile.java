package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGUserProfile is a Querydsl query type for PGUserProfile
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGUserProfile extends EntityPathBase<PGUserProfile> {

    private static final long serialVersionUID = 358850031L;

    public static final QPGUserProfile pGUserProfile = new QPGUserProfile("pGUserProfile");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath city = createString("city");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> dob = createDateTime("dob", java.sql.Timestamp.class);

    public final StringPath email = createString("email");

    public final StringPath firstName = createString("firstName");

    public final StringPath lastName = createString("lastName");

    public final NumberPath<Long> merchantId = createNumber("merchantId", Long.class);

    public final StringPath middleName = createString("middleName");

    public final StringPath password = createString("password");

    public final NumberPath<Long> phone1 = createNumber("phone1", Long.class);

    public final NumberPath<Long> phone2 = createNumber("phone2", Long.class);

    public final NumberPath<Long> profileId = createNumber("profileId", Long.class);

    public final NumberPath<Integer> roleId = createNumber("roleId", Integer.class);

    public final StringPath ssn = createString("ssn");

    public final StringPath state = createString("state");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Long> storeId = createNumber("storeId", Long.class);

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath zip = createString("zip");

    public QPGUserProfile(String variable) {
        super(PGUserProfile.class, forVariable(variable));
    }

    public QPGUserProfile(Path<? extends PGUserProfile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGUserProfile(PathMetadata<?> metadata) {
        super(PGUserProfile.class, metadata);
    }

}

