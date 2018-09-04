Feature: Testing Pebble Application
  Narrative:
In order to check Pebble application functionality
As an Tester
I want to look up for all passed tests

  @important
  @PP-1
Scenario: Login to the application
    Given the user is on the MyBlog home page
    When the user enters 'username' and 'password'
    Then result of the test case should be 'pass'

 @important
  @PP-2
Scenario: Wrong User authontication
    Given the user is on the MyBlog home page
    When the user enters 'wrongUsername' and 'WrongPassword'
    Then result of the test case should be 'fail'
