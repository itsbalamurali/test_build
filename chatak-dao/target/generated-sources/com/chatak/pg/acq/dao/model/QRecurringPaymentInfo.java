package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QRecurringPaymentInfo is a Querydsl query type for RecurringPaymentInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecurringPaymentInfo extends EntityPathBase<RecurringPaymentInfo> {

    private static final long serialVersionUID = -2003064113L;

    public static final QRecurringPaymentInfo recurringPaymentInfo = new QRecurringPaymentInfo("recurringPaymentInfo");

    public final StringPath cardNumber = createString("cardNumber");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath creditCardType = createString("creditCardType");

    public final StringPath expDt = createString("expDt");

    public final StringPath immidateChargeAmount = createString("immidateChargeAmount");

    public final StringPath immidiateCharge = createString("immidiateCharge");

    public final StringPath nameOnCard = createString("nameOnCard");

    public final NumberPath<Long> recurringCustomerInfoId = createNumber("recurringCustomerInfoId", Long.class);

    public final NumberPath<Long> recurringPaymentInfoId = createNumber("recurringPaymentInfoId", Long.class);

    public final StringPath status = createString("status");

    public final StringPath streetAddress = createString("streetAddress");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public final StringPath zipCode = createString("zipCode");

    public QRecurringPaymentInfo(String variable) {
        super(RecurringPaymentInfo.class, forVariable(variable));
    }

    public QRecurringPaymentInfo(Path<? extends RecurringPaymentInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecurringPaymentInfo(PathMetadata<?> metadata) {
        super(RecurringPaymentInfo.class, metadata);
    }

}

