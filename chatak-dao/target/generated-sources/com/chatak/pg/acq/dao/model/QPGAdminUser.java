package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGAdminUser is a Querydsl query type for PGAdminUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGAdminUser extends EntityPathBase<PGAdminUser> {

    private static final long serialVersionUID = 1421788811L;

    public static final QPGAdminUser pGAdminUser = new QPGAdminUser("pGAdminUser");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final NumberPath<Long> adminUserId = createNumber("adminUserId", Long.class);

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath email = createString("email");

    public final StringPath emailToken = createString("emailToken");

    public final NumberPath<Integer> emailVerified = createNumber("emailVerified", Integer.class);

    public final NumberPath<Long> entityId = createNumber("entityId", Long.class);

    public final StringPath firstName = createString("firstName");

    public final StringPath language = createString("language");

    public final DateTimePath<java.sql.Timestamp> lastLogin = createDateTime("lastLogin", java.sql.Timestamp.class);

    public final StringPath lastLoginIP = createString("lastLoginIP");

    public final StringPath lastLonginTime = createString("lastLonginTime");

    public final StringPath lastName = createString("lastName");

    public final DateTimePath<java.sql.Timestamp> lastPassWordChange = createDateTime("lastPassWordChange", java.sql.Timestamp.class);

    public final NumberPath<Integer> passRetryCount = createNumber("passRetryCount", Integer.class);

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final StringPath previousPasswords = createString("previousPasswords");

    public final StringPath reason = createString("reason");

    public final StringPath securityAnswer = createString("securityAnswer");

    public final StringPath securityQuestion = createString("securityQuestion");

    public final NumberPath<Integer> serviceType = createNumber("serviceType", Integer.class);

    public final StringPath state = createString("state");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath userName = createString("userName");

    public final NumberPath<Long> userRoleId = createNumber("userRoleId", Long.class);

    public final StringPath userRoleType = createString("userRoleType");

    public final StringPath userType = createString("userType");

    public final StringPath zip = createString("zip");

    public QPGAdminUser(String variable) {
        super(PGAdminUser.class, forVariable(variable));
    }

    public QPGAdminUser(Path<? extends PGAdminUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGAdminUser(PathMetadata<?> metadata) {
        super(PGAdminUser.class, metadata);
    }

}

