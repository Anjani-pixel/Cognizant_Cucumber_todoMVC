Feature: Verify one of the hyperlink title 
  
  @SanityTest
  Scenario: verify title of the link 
    Given user is in todo application page
    When user click on the one of the hyperlink
    Then user should verify the page title