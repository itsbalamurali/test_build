package com.chatak.pg.enums;

public enum DE_58_Enum {

  /*
   * The national POS condition code field consists of four sub-elements: 
   * Terminal Class (positions 1-3)  Presentation Type (positions 4-7) 
   * Security Condition Code (position 8) and  Terminal Type (positions 9-10) 
   * Card Data Input Capability (position 11)
   */
  /* Ref:PULSE_ISO_8583_Specifications_Manual_15.1_FINAL_v1.0_101714_REDLINE */

  /* Terminal Class (positions 1-3) */
  TERMINAL_CLASS_ATTENDED("0"),
  TERMINAL_CLASS_UNATTENDED("1"),
  TERMINAL_CLASS_CUSTOMER_OPERATED("0"),
  TERMINAL_CLASS_CARD_HOLDER_OPERATED("1"),
  TERMINAL_CLASS_ON_PRIMISE("0"),
  TERMINAL_CLASS_OFF_PRIMISE("1"),

  /* Presentation Type (positions 4-7) */
  PRESENTATION_TYPE_CUSTOMER_PRESENT("0"),
  PRESENTATION_TYPE_CUSTOMER_NOT_PRESENT("1"),
  PRESENTATION_TYPE_MAIL_OR_ORDER("2"),
  PRESENTATION_TYPE_TELEPHONE("3"),
  PRESENTATION_TYPE_RECURRING_PAYMENT("4"),
  PRESENTATION_TYPE_PRE_AUTH("8"),
  PRESENTATION_TYPE_DEFERRED_BILLING("9"),
  PRESENTATION_TYPE_INSTALLMENT("S"),
  PRESENTATION_TYPE_CARD_PRESENT("0"),
  PRESENTATION_TYPE_CARD_NOT_PRESENET("1"),
  PRESENTATION_TYPE_PRE_AUTH_PURCHASE_POSITION5("8"),
  PRESENTATION_TYPE_DEVICE_NO_RETENTION_CAPABILITY("0"),
  PRESENTATION_TYPE_DEVICE_RETENTION_CAPABILITY("1"),
  PRESENTATION_TYPE_ORIGINAL_PRESENTMENT("0"),
  PRESNETATION_TYPE_FIRST_RE_PRESENTMENT("1"),
  PRESENTATION_TYPE_SECOND_RE_PRESENTMENT("2"),
  PRESENTATION_TYPE_THIRD_RE_PRESNETMENT("3"),
  PRESENTATION_TYPE_PREVIOUSLY_AUTHORIZIED_REQUEST("4"),
  PRESENTATION_TYPE_RE_SUBMISSION("5"),
  PRESENTATION_TYPE_CARD_VALIDATION("8"),

  /* Security Condition Code (position 8) */
  SECURITY_CONDITION_NO_SECRITY_CONCERN("0"),
  SECURITY_CONDITION_SUSPECTED_FRAUD("1"),
  SECURITY_CONDITION_IDENTIFICATION_VERIFIED("2"),
  SECURITY_CONDITION_E_COMMERCE_TXN_WITH_DIGITAL_SIGNATUTE("3"),
  SECURITY_CONDITION_UNKNOWN_SECURITY_E_COMMERCE_TXN("4"),
  SECURITY_CONDITION_SECURE_E_COMMERCE_WITH_CARDHOLDER_CERT("5"),
  SECURITY_CONDITION_SECURE_E_COMMERCE_WITH_OUT_CARDHOLDER_CERT("6"),
  SECURITY_CONDITION_CHANNEL_ENCRYPTED_E_COMMERCE_TXN("7"),
  SECURITY_CONDITION_CHANNLE_CVV_VALIDATED_VALID("8"),
  SECUTITY_CONDITION_CHANNLE_CVV_VALIDATED_INVALIE("9"),
  SECUTIRY_CONDITION_CHANNEL_INTERNET_DEBIT_PIN("A"),

  /* Terminal Type (positions 9-10) */
  TERMINAL_TYPE_ADMINISTRATIVE_TERMINAL("00"),
  TERMINAL_TYPE_POS_TERMINAL("01"),
  TERMINAL_TYPE_ATM("03"),
  TERMINAL_TYPE_HOME_TERMINAL("04"),
  TERMINAL_TYPE_DIAL_TERMINAL("05"),
  TERMINAL_TYPE_TRAVELERS_CHECK_MACHINE("06"),
  TERMINAL_TYPE_FUEL_MACHINE("07"),
  TERMINAL_TYPE_SCRIP_MACHINE("08"),
  TERMINAL_TYPE_COUPON_MACHINE("09"),
  TERMINAL_TYPE_TICKET_MACHINE("10"),
  TERMINAL_TYPE_POINT_OF_BANKING_MACHINE("11"),
  TERMINAL_TYPE_TELLER("12"),
  TERMINAL_TYPE_FRANCHISE_TELLER("13"),
  TERMINAL_TYPE_PERSONAL_BANKING("14"),
  TERMINAL_TYPE_PUBLIC_UTILITY("15"),
  TERMINAL_TYPE_VENDING("16"),
  TERMINAL_TYPE_SELF_SERVICE("17"),
  TERMINAL_TYPE_AUTHORIZATION("18"),
  TERMINAL_TYPE_PAYMENT("19"),
  TERMINAL_TYPE_VRU("20"),
  TERMINAL_TYPE_SMART_PHONE("21"),
  TERMINAL_TYPE_INTERACTIVE_TELEVISION("22"),
  TERMINAL_TYPE_PERSONAL_DIGITAL_ASSISTANT("23"),
  TERMINAL_TYPE_TABLET("24"),
  TERMINAL_TYPE_E_COMMERCE("25"),
  TERMINAL_TYPE_MICR("26"),

  /* Card Data Input Capability (position 11) */
  CARD_DATA_INPUT_CAPABILITY_UNKNOWN("0"),
  CARD_DATA_INPUT_CAPABILITY_MANUAL("1"),
  CARD_DATA_INPUT_CAPABILITY_MAG_STRIPE("2"),
  CARD_DATA_INPUT_CAPABILITY_BAR_CODE("3"),
  CARD_DATA_INPUT_CAPABILITY_OCR("4"),
  CARD_DATA_INPUT_CAPABILITY_ICC("5"),
  CARD_DATA_INPUT_CAPABILITY_KEY_ENTERED("6"),
  CARD_DATA_INPUT_CAPABILITY_FILE("7"),
  CARD_DATA_INPUT_CAPABILITY_CONTACTLESS_MAG_STRIPE_RULES("A"),
  CARD_DATA_INPUT_CAPABILITY_CONTACTLESS_CHIP_RULES("M"),
  CARD_DATA_INPUT_CAPABILITY_MSR_KEY_ENTRY("S"),
  CARD_DATA_INPUT_CAPABILITY_MSR_KEY_ENTRY_ICC_CAPATIBLE_READER("T"),
  CARD_DATA_INPUT_CAPABILITY_MSR_KEY_ICC_CAPATIBLE_READER("U");
  private final String value;

  DE_58_Enum(String v) {
    value = v;
  }

  public String value() {
    return value;
  }

  public static DE_58_Enum fromValue(String v) {
    for(DE_58_Enum c : DE_58_Enum.values()) {
      if(c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

}