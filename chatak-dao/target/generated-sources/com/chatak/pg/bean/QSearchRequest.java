package com.chatak.pg.bean;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSearchRequest is a Querydsl query type for SearchRequest
 */
@Generated("com.mysema.query.codegen.EmbeddableSerializer")
public class QSearchRequest extends BeanPath<SearchRequest> {

    private static final long serialVersionUID = 1176627489L;

    public static final QSearchRequest searchRequest = new QSearchRequest("searchRequest");

    public final QResponse _super = new QResponse(this);

    //inherited
    public final NumberPath<Long> agentAccountNumber = _super.agentAccountNumber;

    //inherited
    public final StringPath agentAni = _super.agentAni;

    //inherited
    public final StringPath agentClientId = _super.agentClientId;

    //inherited
    public final ListPath<com.chatak.pg.model.AgentDTO, SimplePath<com.chatak.pg.model.AgentDTO>> agentDTOlist = _super.agentDTOlist;

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    //inherited
    public final StringPath currencyCodeAlpha = _super.currencyCodeAlpha;

    //inherited
    public final StringPath currencyCodeNumeric = _super.currencyCodeNumeric;

    //inherited
    public final NumberPath<Long> currencyId = _super.currencyId;

    public final StringPath dataChange = createString("dataChange");

    //inherited
    public final StringPath deviceTimeZoneOffset = _super.deviceTimeZoneOffset;

    //inherited
    public final StringPath deviceTimeZoneRegion = _super.deviceTimeZoneRegion;

    //inherited
    public final StringPath emv = _super.emv;

    //inherited
    public final StringPath entityType = _super.entityType;

    //inherited
    public final StringPath errorCode = _super.errorCode;

    //inherited
    public final StringPath errorMessage = _super.errorMessage;

    public final BooleanPath isAuditable = createBoolean("isAuditable");

    //inherited
    public final StringPath issuancePartner = _super.issuancePartner;

    //inherited
    public final StringPath issuanceTxnTime = _super.issuanceTxnTime;

    public final NumberPath<Integer> noOfRecords = createNumber("noOfRecords", Integer.class);

    public final NumberPath<Integer> pageIndex = createNumber("pageIndex", Integer.class);

    public final NumberPath<Integer> pageSize = createNumber("pageSize", Integer.class);

    //inherited
    public final NumberPath<Long> parentMerchantId = _super.parentMerchantId;

    //inherited
    public final NumberPath<Long> partnerId = _super.partnerId;

    //inherited
    public final StringPath partnerName = _super.partnerName;

    //inherited
    public final StringPath programManagerName = _super.programManagerName;

    public final StringPath reason = createString("reason");

    public final StringPath timeZoneOffset = createString("timeZoneOffset");

    public final StringPath timeZoneRegion = createString("timeZoneRegion");

    //inherited
    public final NumberPath<Integer> totalNoOfRows = _super.totalNoOfRows;

    //inherited
    public final NumberPath<Long> txnResponseTime = _super.txnResponseTime;

    public final StringPath updatedBy = createString("updatedBy");

    public final DateTimePath<java.sql.Timestamp> updatedDate = createDateTime("updatedDate", java.sql.Timestamp.class);

    //inherited
    public final StringPath upStreamAuthCode = _super.upStreamAuthCode;

    //inherited
    public final StringPath upStreamMessage = _super.upStreamMessage;

    //inherited
    public final StringPath upStreamResponse = _super.upStreamResponse;

    //inherited
    public final NumberPath<Integer> upStreamStatus = _super.upStreamStatus;

    //inherited
    public final StringPath upStreamTxnRefNum = _super.upStreamTxnRefNum;

    public final StringPath userName = createString("userName");

    public QSearchRequest(String variable) {
        super(SearchRequest.class, forVariable(variable));
    }

    public QSearchRequest(Path<? extends SearchRequest> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSearchRequest(PathMetadata<?> metadata) {
        super(SearchRequest.class, metadata);
    }

}

