<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<section class="field-element-row pm-iso-carprogram-content"
	style="display: none;">
	<fieldset class="col-sm-12">
		<fieldset class="col-sm-3">
			<label data-toggle="tooltip" data-placement="top" title=""><spring:message
					code="merchant.label.associatedto" /><span class="required-field">*</span></label>
			<form:input cssClass="form-control" path="associatedTo"
				id="associatedTo"
				onchange="fetchEntityNameByPmIso(this.value, 'programManagerName');validateEntityType()"
				onblur="validateAssociatedTo()" readonly="true"/>
			<div class="discriptionErrorMsg" data-toggle="tooltip"
				data-placement="top" title="">
				<span id="associatedToEr" class="red-error">&nbsp;</span> <span
					id="associatedToEr" class="green-error">&nbsp;</span>
			</div>
		</fieldset>
	</fieldset>
	<fieldset class="col-sm-12">
		<fieldset class="col-sm-5 multi-select-box">
			<label id="entityType"></label> <select
				class="pm-list form-control left-select-box" multiple="multiple">
					<c:forEach items="${EntityList}" var="entityType">
					<option value="${entityType.value}">${entityType.label}</option>
				</c:forEach>
			</select>
		</fieldset>
		<fieldset class="col-sm-1 multi-select-btn marginT30">
			<span class="left-right-btn form-control"
				onClick="SelectMoveRows(document.getElementsByClassName('pm-list')[0],document.getElementsByClassName('selected-pm')[0],'ADD')">
				&gt; </span> <span class="right-left-btn form-control"
				onClick="SelectMoveRows(document.getElementsByClassName('selected-pm')[0],document.getElementsByClassName('pm-list')[0],'REMOVE')">
				&lt; </span>
		</fieldset>
		<label id="associatedID"></label>
		<fieldset class="col-sm-5 multi-select-box">
			<select id="programManagerNameId"
				class="selected-pm form-control right-select-box" MULTIPLE
				onblur="validateAssociatedToEntityName(this)">
				<c:forEach items="${selectedEntityList}" var="entity">
					
					<c:if test="${ not empty entity.programManagerName}">
				<option value="${entity.id}">${entity.programManagerName}</option>
				<script>
					setEntityId('${entity.id}','${entity.programManagerName}');
				</script>
				</c:if>
				<c:if test="${ not empty entity.isoName}">
				<option value="${entity.id}">${entity.isoName}</option>
				<script>
					setEntityId('${entity.id}','${entity.isoName}');
				</script>
				</c:if>
			</c:forEach>
			</select>
			<div class="discriptionErrorMsg" data-toggle="tooltip"
				data-placement="top" title="">
				<span id="programManagerNameIdEr" class="red-error">&nbsp;</span> 
			</div>
		</fieldset>
	</fieldset>
	<!--Panel Action Button Start -->
	<!-- Search Table Block Start -->
	<c:set var="flageCheck" scope="session" value="yes" />
	<%-- <c:if test="${searchList ne flageCheck }"> --%>
	<div class="search-results-table">
		<!-- Search Table Header End -->
		<!-- Search Table Content Start -->
		<div class="discriptionErrorMsg" data-toggle="tooltip"
			data-placement="top" title="">
			<span id="ambiguityFlag" class="red-error">&nbsp;</span>
		</div>
		<table id="serviceResults"
			class="table table-striped table-bordered table-responsive table-condensed tablesorter marginBM1 common-table">
			<thead>
				<tr>
					<th><spring:message code="admin.PartnerName.message" /></th>
					<th><spring:message code="admin.cardprogramname" /></th>
					<th><spring:message code="admin.iin" /></th>
					<th><spring:message code="merchant.label.partnerCode"/></th>
					<th><spring:message code="admin.iinext"/></th>
					<th style="width: 15%;" id="userType"><spring:message
							code="merchant.label.entityname" /></th>
					<th><spring:message
							code="reports.label.overviewandbalancesheet.currency" /></th>
					<th><spring:message
							code="commission-program-search.label.actiontable" /></th>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${!(fn:length(selectedCardProgramList) eq 0) }">
				<%-- <c:set var="count" value="0" scope="page" /> --%>
					<c:forEach items="${selectedCardProgramList}"
						var="cardProgramDetail">
						<c:if test="${not empty cardProgramDetail.programManagerId }">
						<script>
							setCardProgramId('${cardProgramDetail.cardProgramId}','${cardProgramDetail.cardProgramName}','${cardProgramDetail.programManagerId}');
						</script>
						<tr id="rowId${cardProgramDetail.cardProgramId}">
							<td class="ellipsis" id="15">${cardProgramDetail.partnerName}&nbsp;</td>
							<td class="ellipsis" id="15">${cardProgramDetail.cardProgramName}&nbsp;</td>
							<td>${cardProgramDetail.iin}&nbsp;</td>
							<td>${cardProgramDetail.partnerCode}&nbsp;</td>
							<td>${cardProgramDetail.iinExt}&nbsp;</td>
							<td>${cardProgramDetail.entityName}&nbsp;</td>
							<td>${cardProgramDetail.currency}&nbsp;</td>
							<td><input id="cpId${cardProgramDetail.cardProgramId}${cardProgramDetail.programManagerId}" type="checkbox" checked="checked" onclick="addCardProgram('${cardProgramDetail.cardProgramId}','${cardProgramDetail.cardProgramName}','${cardProgramDetail.entityName}','${cardProgramDetail.programManagerId}')"></td>
						</tr>						
						</c:if>
						<c:if test="${not empty cardProgramDetail.isoId }">
						<script>
							setCardProgramId('${cardProgramDetail.cardProgramId}','${cardProgramDetail.cardProgramName}','${cardProgramDetail.isoId}');
						</script>
						<tr id="rowId${cardProgramDetail.cardProgramId}">
							<td class="ellipsis" id="15">${cardProgramDetail.partnerName}&nbsp;</td>
							<td class="ellipsis" id="15">${cardProgramDetail.cardProgramName}&nbsp;</td>
							<td>${cardProgramDetail.iin}&nbsp;</td>
							<td>${cardProgramDetail.partnerCode}&nbsp;</td>
							<td>${cardProgramDetail.iinExt}&nbsp;</td>
							<td>${cardProgramDetail.entityName}&nbsp;</td>
							<td>${cardProgramDetail.currency}&nbsp;</td>
							<td><input id="cpId${cardProgramDetail.cardProgramId}${cardProgramDetail.isoId}" type="checkbox" checked="checked" onclick="addCardProgram('${cardProgramDetail.cardProgramId}','${cardProgramDetail.cardProgramName}','${cardProgramDetail.entityName}','${cardProgramDetail.isoId}')"></td>
						</tr>						
						</c:if>
						<%-- <c:set var="count" value="${count + 1}" scope="page"/> --%>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
	</div>
	<!-- Search Table Content End -->
	<div class="col-sm-12 button-content">
		<fieldset class="col-sm-7 pull-right">
			<input type="button"
				value='<spring:message code="common.label.continue"/>'
				class="form-control button pull-right pic-next"> <input
				type="button" value='<spring:message code="common.label.previous"/>'
				class="form-control button pull-right marginL10 pic-prev"> <input
				type="button" class="form-control button pull-right marginL10"
				value='<spring:message code="common.label.cancel"/>'
				onclick="openCancelConfirmationPopup()"> <input
				type="button" class="form-control button pull-right marginL10"
				value='<spring:message code="common.label.reset"/>'
				onclick="resetpmIsoCardprogarmErrorMsg()">
		</fieldset>
	</div>
	<!--Panel Action Button End -->
</section>