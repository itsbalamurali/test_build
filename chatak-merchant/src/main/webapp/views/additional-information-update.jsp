<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <section class="field-element-row free-transactions-content"
	style="display: none;">
	<fieldset class="col-sm-12">
		<fieldset class="col-sm-3">
			<label data-toggle="tooltip" data-placement="top" title=""><spring:message
					code="additional-information.label.username" /><span
				class="required-field">*</span></label>
			<form:input cssClass="form-control" path="userName" id="userName"
				maxlength="50" readonly="true" />
			<div class="discriptionErrorMsg" data-toggle="tooltip" data-placement="top" title="">
				<span id="userNameEr" class="red-error">&nbsp;</span> <span
					id="userNamegreenEr" class="green-error">&nbsp;</span>
			</div>
		</fieldset>
	</fieldset>
	<div class="col-sm-12 button-content">
		<fieldset class="col-sm-7 pull-right">
			<input type="button" class="form-control button pull-right free-next"
				value="<spring:message code="sub-merchant-create.label.continue"></spring:message>">
			<input type="button"
				class="form-control button pull-right marginL10 free-prev"
				value="<spring:message code="sub-merchant-create.label.previous"></spring:message>">
			<input type="button" class="form-control button pull-right marginL10"
				value="<spring:message code="sub-merchant-create.label.cancel"></spring:message>"
				onclick="cancelCreateMerchant()">
		</fieldset>
	</div>
	<!--Panel Action Button End -->
</section>
