function validateBankName() {
	var bankName = get('bankName').value.trim();
	var spaceRegx = /^[a-zA-Z0-9]+(\s{0,1}[a-zA-Z0-9])*$/;

	if (isEmpty(bankName)) {
		setError(get('bankName'), webMessages.pleaseEnterBankName);
		loadMsgTitleText();
		return false;
	} else if (!spaceRegx.test(bankName)) {
		setError(get('bankName'), webMessages.invalidBankName);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('bankName'), '');
		setLable('confirmBankName', bankName);
		return true;
	}
}

function validContactPersonEmail() {
	var bankEmailId = get('bankEmailId').value.trim();
	var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	if (isEmpty(bankEmailId)) {
		setError(get('bankEmailId'), webMessages.pleaseEnterEmailAddress);
		loadMsgTitleText();
		return false;
	} else if (reg.test(bankEmailId)== false) {
		setError(get('bankEmailId'), webMessages.invalidEmailAddress);
		loadMsgTitleText();
		return false;
	} else{
		if(alpha.indexOf(bankEmailId.charAt(0)) == -1){
			setError(get('bankEmailId'),  webMessages.invalidEmailAddress);
			loadMsgTitleText();
		return false;
		} else {
			setError(get('bankEmailId'), '');
			setLable('confirmbankEmailId', bankEmailId);
			return true;
		}
}
}

function validContactPersonName() {
	var contactName = get('contactName').value.trim();
	var spaceRegx = /^[a-zA-Z0-9]+(\s{0,1}[a-zA-Z0-9])*$/;

	if (isEmpty(contactName)) {
		setError(get('contactName'), webMessages.pleaseEnterPrimaryContactName);
		loadMsgTitleText();
		return false;
	} else if (!spaceRegx.test(contactName)) {
		setError(get('contactName'), webMessages.invalidPrimaryContactName);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('contactName'), '');
		setLable('confirmPrimaryContactName', contactName);
		return true;
	}
}

/*function validBankShortName() {
	var bankShortName = get('bankShortName').value.trim();
	var spaceRegx = /^[a-zA-Z0-9]+(\s{0,1}[a-zA-Z0-9])*$/;

	if (isEmpty(bankShortName)) {
		setError(get('bankShortName'), webMessages.pleaseEnterBankShortName);
		loadMsgTitleText();
		return false;
	} else if (!spaceRegx.test(bankShortName)) {
		setError(get('bankShortName'), webMessages.invalidBankShortName);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('bankShortName'), '');
		setLable('confirmBankShortName', bankShortName);
		return true;
	}

}*/

/*function validAcquirerId() {
	var acquirerId = get('acquirerId').value.trim();
	var spaceRegx = /^[a-zA-Z0-9]+(\s{0,1}[a-zA-Z0-9])*$/;

	if (isEmpty(acquirerId)) {
		setError(get('acquirerId'), webMessages.pleaseEnterAcquirerId);
		loadMsgTitleText();
		return false;
	} else if (!spaceRegx.test(acquirerId)) {
		setError(get('acquirerId'), webMessages.invalidAcquirerId);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('acquirerId'), '');
		setLable('confirmAcquirerId', acquirerId);
		return true;
	}

}*/

function validContactPersonCell() {
	var bankMobile = get('bankMobile').value.trim();
	var spaceRegx = /^[a-zA-Z0-9]+(\s{0,1}[a-zA-Z0-9])*$/;

	if (isEmpty(bankMobile)) {
		setError(get('bankMobile'), webMessages.pleaseEnterContactMobileNumber);
		loadMsgTitleText();
		return false;
	} else if (!spaceRegx.test(bankMobile)) {
		setError(get('bankMobile'), webMessages.invalidContactMobileNumber);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('bankMobile'), '');
		setLable('confirmbankMobile', bankMobile);
		return true;
	}

}

function validContactPersonPhone() {
	var bankPhone = get('bankPhone').value.trim();
	var spaceRegx = /^[a-zA-Z0-9]+(\s{0,1}[a-zA-Z0-9])*$/;

	if (isEmpty(bankPhone)) {
		setError(get('bankPhone'), webMessages.pleaseEnterContactPhoneNumber);
		loadMsgTitleText();
		return false;
	} else if (!spaceRegx.test(bankPhone)) {
		setError(get('bankPhone'), webMessages.invalidContactPhoneNumber);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('bankPhone'), '');
		setLable('confirmbankPhone', bankPhone);
		return true;
	}

}

function validBankCode() {
	var bankCode = get('bankCode').value.trim();
	var spaceRegx = /^[a-zA-Z0-9]+(\s{0,1}[a-zA-Z0-9])*$/;

	if (isEmpty(bankCode)) {
		setError(get('bankCode'), webMessages.pleaseEnterBankCode);
		loadMsgTitleText();
		return false;
	} else if (!spaceRegx.test(bankCode)) {
		setError(get('bankCode'), webMessages.invalidBankCode);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('bankCode'), '');
		setLable('confirmBankCode', bankCode);
		return true;
	}

}

/*function validateStatus() {
	var status = get('status').value.trim();
	var statusValue = document.getElementById("status");
	var x = statusValue.options[statusValue.selectedIndex].text;

	if (isEmpty(status)) {
		setError(get('status'), webMessages.pleaseSelectState);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('status'), '');
		setLable('confirmMstatus', x);
		return true;
	}
}*/

function validateAddress1() {
	var address1 = get('address1').value.trim();

	if (isEmpty(address1)) {
		setError(get('address1'), webMessages.pleaseEnterAddress1);
		loadMsgTitleText();
		return false;
	} else if (address1.length < 5) {
		setError(get('address1'), webMessages.invalidAddress1Length);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('address1'), '');
		setLable('confirmMaddress1', address1);
		return true;
	}
}

function validateAddress2() {
	var address2 = get('address2').value.trim();

	setError(get('address2'), '');
	setLable('confirmMaddress2', address2);
	return true;
}

function validateCity() {
	var city = get('city').value.trim();
	var cityRegx = /^[A-Za-z0-9\#\$\&]+(\s{0,1}[a-zA-Z0-9,])*$/;

	if (isEmpty(city)) {
		setError(get('city'), webMessages.pleaseEnterCity);
		loadMsgTitleText();
		return false;
	} else if (!cityRegx.test(city)) {
		setError(get('city'), webMessages.invalidCity);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('city'), '');
		setLable('confirmMcity', city);
		return true;
	}
}

function validateState() {
	var state = get('state').value.trim();

	if (isEmpty(state)) {
		setError(get('state'), webMessages.pleaseSelectState);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('state'), '');
		setLable('confirmMstate', state);
		return true;
	}
}

function validateCountry() {
	var country = get('country').value.trim();

	if (isEmpty(country)) {
		setError(get('country'), webMessages.pleaseSelectCountry);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('country'), '');
		setLable('confirmMcountry', country);
		return true;
	}
}

function validateZip() {
	var zip = getVal('zip');
	if (isEmpty(zip)) {
		setError(get('zip'), webMessages.pleaseEnterZipCode);
		loadMsgTitleText();
		return false;
	} else if ((zip.length < 3) || (zip.length > 7)) {
		setError(get('zip'), webMessages.invalidZipCode);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('zip'), '');
		setLable('confirmMpin', zip);
		return true;
	}
}

function fetchState(countryid, elementId) {
	if (countryid == '') {
		clearState(elementId);
		return;
	}
	getStates(countryid, elementId);
}

function getStates(countryid, elementId) {
	$.ajax({
		type : "GET",
		url : "getStatesByCountryId?countryid=" + countryid,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				// remove the previous option from element
				document.getElementById(elementId).options.length = 0;
				// create select option
				var selectOption = document.createElement("option");
				selectOption.innerHTML = "..:Select:..";
				selectOption.value = "";
				$(("#" + elementId)).append(selectOption);

				if (obj.errorMessage == "SUCCESS") {
					var data = obj.responseList;

					for (var i = 0; i < data.length; i++) {
						var state = data[i].label;

						var newOption = document.createElement("option");
						newOption.value = data[i].value;
						newOption.innerHTML = state;

						$(("#" + elementId)).append(newOption);
					}
				}
			}
		},
		error : function(e) {
		}
	});
}

function clearState(elementId) {
	document.getElementById(elementId).options.length = 0;
	var selectOption = document.createElement("option");
	selectOption.innerHTML = "..:Select:..";
	selectOption.value = "";
	$(("#" + elementId)).append(selectOption);
}

function validCreateBank() {
	if (!validateBankName() | !validBankCode() | !validSettlRoutingNumber() | !validSettlAccountNumber() | !validateAddress1()
			| !validateCity() | !validateCountry() | !validateState() | !validateZip() | !validContactPersonName() | !validContactPersonPhone()
			| !validContactPersonEmail() | !validateCurrency()) {
		return false;
	}
	return true;
}

function validUpdateBank() {
	if (!validateBankName() | !validBankCode() | !validSettlRoutingNumber() | !validSettlAccountNumber() | !validateAddress1()
			| !validateCity() | !validateCountry() | !validateState() | !validateZip() | !validContactPersonName() | !validContactPersonPhone()
			| !validContactPersonEmail() | !validateCurrency()) {
		return false;
	}
	return true;
}

function cancelCreateOrUpdateBank() {
	window.location.href = 'bank-search';
}

function resetBankSearch() {
	return cancelCreateOrUpdateBank();
}
function openCancelConfirmationPopup() {

	if ((isEmpty(get('bankName').value.trim()))
			&& (isEmpty(get('settleAccountNo').value.trim()))
			&& (isEmpty(get('routingNumber').value.trim()))
			&& (isEmpty(get('bankCode').value.trim()))
			&& (isEmpty(get('bankPhone').value.trim()))
			&& (isEmpty(get('bank_Mobile').value.trim()))
			&& (isEmpty(get('contactName').value.trim()))
			&& (isEmpty(get('bankEmailId').value.trim()))
			&& (isEmpty(get('address1').value.trim()))
			&& (isEmpty(get('address2').value.trim()))
			&& (isEmpty(get('city').value.trim()))
			&& (isEmpty(get('state').value.trim()))
			&& (isEmpty(get('zip').value.trim()))) {
		window.location.href = 'bank-search';
	}

	else {
		$('#my_popup1').popup("show");
	}
}

function closeCancelConfirmationPopup() {
	$('#my_popup1').popup("hide");
}

function viewBankInfo(bankName) {
	get('bankViewName').value = bankName;
	document.forms["viewBankForm"].submit();
}

function editBank(bankName) {
	get('editBankName').value = bankName;
	document.forms["editBankForm"].submit();
}

var bankNames;
function confirmDeleteBank(bankName) {
	$('#deletePopup').popup("show");
	bankNames = bankName;
	
}

function deleteData() {
	get('deleteBankName').value = bankNames;
	document.forms["deleteBankForm"].submit();
}

function validateCurrency() {
	var currencyCodeAlpha = getVal('currencyCodeAlpha');
	if (isEmpty(currencyCodeAlpha)) {
		setError(get('currencyCodeAlpha'), webMessages.pleaseSelectLocalCurrency);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('currencyCodeAlpha'), '');
		setLable('confirmCurrencyCodeAlpha', currencyCodeAlpha);
		return true;
	}
}
function validSettlRoutingNumber() {
	var settlRoutingNumber = getVal('settlRoutingNumber');
	if (isEmpty(settlRoutingNumber)) {
		setError(get('settlRoutingNumber'), webMessages.pleaseSelectSettlementRoutingNumber);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('settlRoutingNumber'), '');
		setLable('confirmSettlementRoutingNumber', settlRoutingNumber);
		return true;
	}
}
function validSettlAccountNumber() {
	var settleAccountNo = getVal('settleAccountNo');
	if (isEmpty(settleAccountNo)) {
		setError(get('settleAccountNo'), webMessages.pleaseSelectSettlementAccountNumber);
		loadMsgTitleText();
		return false;
	} else {
		setError(get('settleAccountNo'), '');
		setLable('confirmSettlementAccountNumber', settleAccountNo);
		return true;
	}
}

function fetchPmState(countryid, elementId) {
	if (countryid == '') {
		clearState(elementId);
		return;
	}
	getPmStates(countryid, elementId);
}

function getPmStates(countryid, elementId) {
	$.ajax({
		type : "GET",
		url : "getPMStatesByCountryId?countryid=" + countryid,
		async : false,
		success : function(response) {
			var obj = JSON.parse(response);
			if (obj.errorCode === '00') {
				// remove the previous option from element
				document.getElementById(elementId).options.length = 0;
				// create select option
				var selectOption = document.createElement("option");
				selectOption.innerHTML = "..:Select:..";
				selectOption.value = "";
				$(("#" + elementId)).append(selectOption);

				if (obj.errorMessage == "SUCCESS") {
					var data = obj.responseList;

					for (var i = 0; i < data.length; i++) {
						var state = data[i].label;

						var newOption = document.createElement("option");
						newOption.value = data[i].label;
						newOption.innerHTML = data[i].value;

						$(("#" + elementId)).append(newOption);
					}
				}
			}
		},
		error : function(e) {
		}
	});
}