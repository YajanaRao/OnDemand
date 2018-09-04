
Feature: Testing Pebble Application
Narrative:
In order to check Pebble application functionality
As an Tester
I want to look up for all passed tests

Scenario:Adding Response to a Blog

Given user is in the Home Pagge
When user clicks on 'Responses'
Then user should see a comment added as 'welcome'


Scenario:Adding Comment to a Blog


Given user is in the Home Pagge
When user clicks on 'Add a comment'
Then user should see a comment added as 'Add a comment'
