package com.chatak.pg.acq.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QRecurringContractInfo is a Querydsl query type for RecurringContractInfo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRecurringContractInfo extends EntityPathBase<RecurringContractInfo> {

    private static final long serialVersionUID = 1444306245L;

    public static final QRecurringContractInfo recurringContractInfo = new QRecurringContractInfo("recurringContractInfo");

    public final NumberPath<Long> contractAmount = createNumber("contractAmount", Long.class);

    public final StringPath contractExecution = createString("contractExecution");

    public final StringPath contractExecutionReprocess = createString("contractExecutionReprocess");

    public final StringPath contractId = createString("contractId");

    public final StringPath contractName = createString("contractName");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> endDate = createDateTime("endDate", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> lastBillDate = createDateTime("lastBillDate", java.sql.Timestamp.class);

    public final NumberPath<Long> recurringContractInfoId = createNumber("recurringContractInfoId", Long.class);

    public final NumberPath<Long> recurringPaymentInfoId = createNumber("recurringPaymentInfoId", Long.class);

    public final DateTimePath<java.sql.Timestamp> startDate = createDateTime("startDate", java.sql.Timestamp.class);

    public final StringPath status = createString("status");

    public final NumberPath<Long> tax = createNumber("tax", Long.class);

    public final StringPath transactionApprovedEmail = createString("transactionApprovedEmail");

    public final StringPath transactionDeclinedEmail = createString("transactionDeclinedEmail");

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    public QRecurringContractInfo(String variable) {
        super(RecurringContractInfo.class, forVariable(variable));
    }

    public QRecurringContractInfo(Path<? extends RecurringContractInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecurringContractInfo(PathMetadata<?> metadata) {
        super(RecurringContractInfo.class, metadata);
    }

}

