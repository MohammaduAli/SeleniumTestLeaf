Feature: Login functionality of Leaftaps application


Scenario: TC001_Login with positive credential

Given Enter username as |DemoSalesManager|
And Enter password as |crmsfa|
When Click on login button
Then Home page should be displayed
