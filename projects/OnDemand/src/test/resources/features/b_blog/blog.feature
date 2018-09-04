Feature: Testing Pebble Application

  In order to check Pebble application functionality
  As an Tester
  I want to look up for all passed tests
  

 @PP-3
Scenario: Functionality a new blog
 Given user login to MyBlog site
 When user wants to create a blog called Automation Testing
 Then Automation Testing blog should be displayed

  @PP-4
 Scenario:Publishing the blog

 Given user login to MyBlog site
 When user wants to publish a blog called Automation Testing
 Then Automation Testing blog should be displayed


 @PP-5  
Scenario:Editing the blog

Given user login to MyBlog site
When user wants to 'edit' a blog called Automation Testing
Then Automation Testing blog should be displayed

  @PP-6  
Scenario:Publish the blogs

Given user login to MyBlog site
When user wants to publishBlogEntries a blog called Automation Testing
Then Automation Testing blog should be displayed

  @PP-7  
Scenario:Upload file to the blog

Given user login to MyBlog site
When user wants to Files a blog called Automation Testing
Then BlogContent.txt blog should be displayed

  @PP-8  
Scenario:Removing the blog

Given user login to MyBlog site
When user wants to remove a blog called Automation Testing
Then Automation Testing blog should be displayed

