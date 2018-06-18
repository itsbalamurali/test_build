package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPGMerchantUsers is a Querydsl query type for PGMerchantUsers
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPGMerchantUsers extends EntityPathBase<PGMerchantUsers> {

    private static final long serialVersionUID = -1932426383L;

    public static final QPGMerchantUsers pGMerchantUsers = new QPGMerchantUsers("pGMerchantUsers");

    public final StringPath address = createString("address");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath email = createString("email");

    public final StringPath emailToken = createString("emailToken");

    public final NumberPath<Integer> emailVerified = createNumber("emailVerified", Integer.class);

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.sql.Timestamp> lastLogin = createDateTime("lastLogin", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> lastLoginIP = createDateTime("lastLoginIP", java.sql.Timestamp.class);

    public final StringPath lastLonginTime = createString("lastLonginTime");

    public final StringPath lastName = createString("lastName");

    public final DateTimePath<java.sql.Timestamp> lastPassWordChange = createDateTime("lastPassWordChange", java.sql.Timestamp.class);

    public final StringPath merPassword = createString("merPassword");

    public final NumberPath<Integer> passRetryCount = createNumber("passRetryCount", Integer.class);

    public final NumberPath<Long> pgMerchantId = createNumber("pgMerchantId", Long.class);

    public final StringPath phone = createString("phone");

    public final StringPath previousPasswords = createString("previousPasswords");

    public final StringPath reason = createString("reason");

    public final StringPath securityAnswer = createString("securityAnswer");

    public final StringPath securityQuestion = createString("securityQuestion");

    public final NumberPath<Integer> serviceType = createNumber("serviceType", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath userName = createString("userName");

    public final NumberPath<Long> userRoleId = createNumber("userRoleId", Long.class);

    public final StringPath userRoleType = createString("userRoleType");

    public final StringPath userType = createString("userType");

    public QPGMerchantUsers(String variable) {
        super(PGMerchantUsers.class, forVariable(variable));
    }

    public QPGMerchantUsers(Path<? extends PGMerchantUsers> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPGMerchantUsers(PathMetadata<?> metadata) {
        super(PGMerchantUsers.class, metadata);
    }

}

