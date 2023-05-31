@Regression
Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'israr07@tekschool.us' and password 'Tek@12345'
    And User click on login button
    And User should be logged in into Account

  #@Update
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Ali Omar' and Phone '757-777-9979'
    And User click on Update button
    Then user profile information should be updated

  #@AddPaymentMethod
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 7779991112244444 | Israr      |               9 |           2030 |          123 |
    And User click on Add your card button
    Then a message should be displayed 'Payment Method added successfully'

  #@EditPayment
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1593578521455555 | Afghan     |               6 |           2034 |          707 |
    And user click on Update Your Card button
    Then a message should be displayed 'Payment Method updated Successfully'

  #@RemovePaymentMethod
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed

  #@AddAddress
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country     | fullName | phoneNumber | streetAddress       | apt   | city       | state | zipCode |
      | Afghanistan | Israr    |  7579545345 | 797 Shar-E-Naw road | 777 A | Shar-E-Naw | Kabul |   19078 |
    And User click Add Your Address button
    Then a message should be displayed 'Address Added Successfully'

  #@UpdateAddress
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country     | fullName    | phoneNumber | streetAddress     | apt   | city       | state | zipCode |
      | Afghanistan | Israr Ahmed |  7579545340 | 500 Kabul Kingdom | 500 A | Shar-e-naw | Kabul |   99077 |
    And User click update Your Address button
    Then a message should be displayed 'Address Updated Successfully'

  #@RemoveAddress
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
