<!DOCTYPE html>
<%@page import="com.chatak.pg.util.Constants"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.Calendar"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	int year = Calendar.getInstance().get(Calendar.YEAR);
%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><spring:message code="common.lable.title" /></title>
<!-- Bootstrap -->
<link rel="icon" href="../images/favicon.png" type="image/png">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/jquery.datetimepicker.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/utils.js"></script>
	<script src="../js/common-lib.js"></script>
	<script src="../js/bank.js"></script>
	<!--Body Wrapper block Start -->
	<div id="wrapper">
		<!--Container block Start -->
		<div class="container-fluid">
			<!--Header Block Start -->

			<!--Header Block End -->
			<!--Navigation Block Start -->
			<nav class="col-sm-12 nav-bar" id="main-navigation">
				<%@include file="navigation-panel.jsp"%>
				<%-- <jsp:include
					page="header.jsp" /> --%>
			</nav>
			<!--Navigation Block Start -->
			<!--Article Block Start-->
			<article>
				<div class="col-xs-12 content-wrapper">
					<!-- Breadcrumb start -->
					<div class="breadCrumb">
						<span class="breadcrumb-text"><spring:message
								code="manage.label.manage" /></span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text"><spring:message
								code="bank.label.bank" /></span> <span
							class="glyphicon glyphicon-play icon-font-size"></span> <span
							class="breadcrumb-text"><spring:message
								code="common.label.create" /></span>
					</div>
					<!-- Breadcrumb End -->
					<!-- Tab Buttons Start -->
					<c:if
						test="${fn:contains(existingFeatures,bankView) || fn:contains(existingFeatures,bankEdit) || fn:contains(existingFeatures,bankDelete)||fn:contains(existingFeatures,bankCreate)}">
						<div class="tab-header-container-first">
							<a href="bank-search"><spring:message
									code="common.label.search" /> </a>
						</div>
					</c:if>
					<c:if test="${fn:contains(existingFeatures,bankCreate)}">
						<div class="tab-header-container active-background">
							<a href="#"><spring:message code="common.label.create" /></a>
						</div>
					</c:if>
					<!-- Tab Buttons End -->
					<!-- Content Block Start -->
					<div class="main-content-holder">
						<div class="row">
							<div class="col-sm-12">
								<!--Success and Failure Message Start-->
								<div class="col-xs-12">
									<div class="descriptionMsg" data-toggle="tooltip"
										data-placement="top" title="">
										<span class="red-error">${error}</span> <span
											class="green-error">${sucess}</span>
									</div>
								</div>
								<!--Success and Failure Message End-->
								<!-- Page Form Start -->
								<form:form action="bank-create" commandName="bank" name="bank"
									method="post">
									<input type="hidden" name="CSRFToken" value="${tokenval}">
									<div class="col-sm-12">
										<div class="row">
											<div class="field-element-row">
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="bank.label.bankname" /><span class="required-field">*</span></label>
													<form:input path="bankName" id="bankName"
														cssClass="form-control"
														onblur="this.value=this.value.trim();validateBankName()"
														maxlength="100" />

													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="bankNameEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.bankcode" /><span
														class="required-field">*</span></label>
													<input name="bankCode" id="bankCode"
														class="form-control" onKeyPress="return numbersonly(this, event)" placeholder="<spring:message code="common.label.numericsonly"/>"
														onblur="this.value=this.value.trim();validBankCode()"
														maxlength="<%=Constants.BANK_CODE.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="bankCodeEr">&nbsp;</span>
													</div>
												</fieldset>
												<%-- <fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="bank.label.bankshortname" /><span
														class="required-field">*</span></label>

													<form:input path="bankShortName" id="bankShortName"
														cssClass="form-control"
														onblur="this.value=this.value.trim();validBankShortName()"
														maxlength="50" />

													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="bankShortNameEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="bank.label.acquirerid" /><span
														class="required-field">*</span></label>

													<form:input path="acquirerId" id="acquirerId"
														cssClass="form-control"
														onblur="this.value=this.value.trim();validAcquirerId()"
														maxlength="50" />

													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="acquirerIdEr">&nbsp;</span>
													</div>
												</fieldset> --%>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.settlementroutingnumber" /><span
														class="required-field">*</span></label>
													<input name="settlRoutingNumber" id="settlRoutingNumber"
														class="form-control" onKeyPress="return numbersonly(this, event)" placeholder="<spring:message code="common.label.numericsonly" />"
														onblur="this.value=this.value.trim();validSettlRoutingNumber()" title=""
														maxlength="<%=Constants.ACCOUNT_ROUTING_NUMBER.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="settlRoutingNumberEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.settlementaccountnumber" /><span
														class="required-field">*</span></label>
													<input name="settlAccountNumber" id="settleAccountNo"
														class="form-control" onKeyPress="return numbersonly(this, event)" placeholder="<spring:message code="common.label.numericsonly"/>"
														onblur="this.value=this.value.trim();validSettlAccountNumber()"
														maxlength="<%=Constants.BANK_ACCOUNT_NUMBER.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="settleAccountNoEr">&nbsp;</span>
													</div>
												</fieldset>

												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.address1" /><span
														class="required-field">*</span></label>
													<form:input cssClass="form-control" path="address1"
														id="address1" maxlength="100"
														onblur="this.value=this.value.trim();validateAddress1()" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span id="address1Er" class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.address2" /></label>
													<form:input cssClass="form-control" path="address2"
														id="address2" maxlength="100"
														onblur="this.value=this.value.trim();validateAddress2()" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span id="address2Er" class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.city" /><span class="required-field">*</span></label>
													<form:input cssClass="form-control" path="city" id="city"
														maxlength="100"
														onblur="this.value=this.value.trim();validateCity()" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span id="cityEr" class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.country" /><span
														class="required-field">*</span></label>
													<form:select cssClass="form-control" path="country"
														id="country" onblur="validateCountry()"
														onchange="fetchState(this.value, 'state')">
														<form:option value="">..:<spring:message
																code="reports.option.select" />:..</form:option>
														<c:forEach items="${countryList}" var="country">
															<form:option value="${country.label}">${country.label}</form:option>
														</c:forEach>
													</form:select>
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span id="countryEr" class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.state" /><span class="required-field">*</span></label>
													<form:select cssClass="form-control" path="state"
														id="state" onblur="validateState()">
														<form:option value="">..:<spring:message
																code="reports.option.select" />:..</form:option>
														<c:forEach items="${stateList}" var="item">
															<form:option value="${item.label}">${item.label}</form:option>
														</c:forEach>
													</form:select>
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span id="stateEr" class="red-error">&nbsp;</span>
													</div>
												</fieldset>

												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.zipcode" /><span
														class="required-field">*</span></label>
													<form:input cssClass="form-control" path="zip" id="zip"
														maxlength="7" onkeypress="generalZipCode()"
														onblur="this.value=this.value.trim();return zipCodeNotEmpty(id)" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span id="zipEr" class="red-error">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.primarycontactname" /><span
														class="required-field">*</span></label>
													<form:input path="contactPersonName" id="contactName"
														cssClass="form-control"
														onblur="this.value=this.value.trim();validContactPersonName()"
														maxlength="<%=Constants.CONTACT_PERSON_NAME.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="contactNameEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.contactmobilenumber" /></label>
													<form:input path="contactPersonCell" id="bankMobile"
														cssClass="form-control"
														maxlength="<%=Constants.PHONE.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="bankMobileEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.contactphonenumber" /><span
														class="required-field">*</span></label>
													<form:input path="contactPersonPhone" id="bankPhone"
														cssClass="form-control"
														onblur="this.value=this.value.trim();validContactPersonPhone()"
														maxlength="<%=Constants.PHONE.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="bankPhoneEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.extension" /></label>
													<input name="extension" id="extension"
														onKeyPress="return numbersonly(this, event)" placeholder="<spring:message code="common.label.numericsonly"/>"
														class="form-control"
														maxlength="<%=Constants.EXTENSION.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="extensionEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.fax" /></label>
													<input name="contactPersonFax" id="bankFax"
														onKeyPress="return numbersonly(this, event)" placeholder="<spring:message code="common.label.numericsonly"/>"
														class="form-control"
														maxlength="<%=Constants.FAX.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="bankFaxEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label data-toggle="tooltip" data-placement="top" title=""><spring:message
															code="common.label.emailaddress" /><span
														class="required-field">*</span></label>
													<form:input path="contactPersonEmail" id="bankEmailId"
														cssClass="form-control"
														onblur="this.value=this.value.trim();validContactPersonEmail()"
														maxlength="<%=Constants.EMAIL_ID.toString()%>" />
													<div class="discriptionErrorMsg" data-toggle="tooltip"
														data-placement="top" title="">
														<span class="red-error" id="bankEmailIdEr">&nbsp;</span>
													</div>
												</fieldset>
												<fieldset class="col-sm-3">
													<label><spring:message
															code="merchant.label.localcurrency" /><span
														class="required-field">*</span></label>
													<form:select cssClass="form-control"
														path="currencyCodeAlpha" id="currencyCodeAlpha"
														onblur="return validateCurrency()">
														<form:option value="">..:<spring:message
																code="reports.option.select" />:..</form:option>
														<c:forEach items="${currencyList}" var="currency">
															<form:option value="${currency.value}">${currency.label}</form:option>
														</c:forEach>
													</form:select>
													<div class="discriptionErrorMsg">
														<span id="currencyCodeAlphaEr" class="red-error">&nbsp;</span>
													</div>
												</fieldset>
											</div>
										</div>
										<!--Panel Action Button Start -->
										<div class="col-sm-12 form-action-buttons">
											<div class="col-sm-5"></div>
											<div class="col-sm-7">
												<input type="submit" class="form-control button pull-right"
													value='<spring:message code="common.label.create"/>'
													onclick="return validCreateBank()"> <input
													type="button" class="form-control button pull-right"
													value='<spring:message code="common.label.cancel"/>'
													onclick="openCancelConfirmationPopup()">
											</div>
										</div>
										<!--Panel Action Button End -->
									</div>
								</form:form>
								<!-- Page Form End -->
							</div>
						</div>
					</div>
					<!-- Content Block End -->
				</div>
				<div id="my_popup1" class="popup-void-refund voidResult">
					<span class="glyphicon glyphicon-remove closePopupMes"
						onclick="closeCancelConfirmationPopup()"></span>
					<div class="fw-b-fs15" style="padding: 20px;">
						<spring:message code="cancle.conformation.lable.currency" />
					</div>
					<div class="col-sm-12">

						<input type="button"
							class="form-control button pull-right margin5 close-btn"
							value="<spring:message code="bin.label.no"/>"
							onclick="closeCancelConfirmationPopup()"> <input
							type="submit" class="form-control button pull-right margin5"
							value="<spring:message code="bin.label.yes"/>"
							onclick="cancelCreateOrUpdateBank()">
					</div>
				</div>
			</article>
			<!--Article Block End-->
			<div class="footer-container">
				<jsp:include page="footer.jsp"></jsp:include>
			</div>
		</div>
		<!--Container block End -->
	</div>
	<!--Body Wrapper block End -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/utils.js"></script>
	<script src="../js/jquery.cookie.js"></script>
	<script type="text/javascript" src="../js/backbutton.js"></script>
	<script src="../js/jquery.popupoverlay.js"></script>
	<script type="text/javascript" src="../js/browser-close.js"></script>
	<script>
		function updateHref($this) {
			var href = $($this).attr('href');
			$($this).attr('href',
					href + "?requestType=" + $('#requestType').val());
		}

		$(document).ready(function() {
			$("#navListId6").addClass("active-background");

			if ($('#requestType').val() == 'ADMIN') {
				$('#userType').text('Admin User');
				$('#merchantDivId').hide();
				$('#merchantName').val("");
			} else {
				$('#userType').text('Merchant User');
				$('#merchantDivId').show();
			}
		});
		$('#my_popup1').popup({
			blur : false
		});
	</script>
</body>
</html>