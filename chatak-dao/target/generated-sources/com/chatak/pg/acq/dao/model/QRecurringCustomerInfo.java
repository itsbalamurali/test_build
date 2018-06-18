package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QRecurringCustomerInfo is a Querydsl query type for RecurringCustomerInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecurringCustomerInfo extends EntityPathBase<RecurringCustomerInfo> {

    private static final long serialVersionUID = -547977711L;

    public static final QRecurringCustomerInfo recurringCustomerInfo = new QRecurringCustomerInfo("recurringCustomerInfo");

    public final StringPath address1 = createString("address1");

    public final StringPath address2 = createString("address2");

    public final StringPath address3 = createString("address3");

    public final StringPath area = createString("area");

    public final StringPath businessName = createString("businessName");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath customerId = createString("customerId");

    public final StringPath daytimePhone = createString("daytimePhone");

    public final StringPath department = createString("department");

    public final StringPath emailId = createString("emailId");

    public final StringPath eveningPhone = createString("eveningPhone");

    public final StringPath fax = createString("fax");

    public final StringPath firstName = createString("firstName");

    public final StringPath lastName = createString("lastName");

    public final StringPath merchantId = createString("merchantId");

    public final StringPath mobileNumber = createString("mobileNumber");

    public final NumberPath<Long> recurringCustInfoId = createNumber("recurringCustInfoId", Long.class);

    public final StringPath state = createString("state");

    public final StringPath status = createString("status");

    public final StringPath termsFlag = createString("termsFlag");

    public final StringPath termsVersion = createString("termsVersion");

    public final StringPath title = createString("title");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath zipCode = createString("zipCode");

    public QRecurringCustomerInfo(String variable) {
        super(RecurringCustomerInfo.class, forVariable(variable));
    }

    public QRecurringCustomerInfo(Path<? extends RecurringCustomerInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecurringCustomerInfo(PathMetadata<?> metadata) {
        super(RecurringCustomerInfo.class, metadata);
    }

}

