Feature: Login and compose email in Gmail
Scenario: Login
Given User is on Gmail page
When User logs in using username "mrkautomation25@gmail.com" 
And password as "Tester@12345"
Then User sends an email to "mrkautomation25@gmail.com" with body "Automation QA test for Incubyte" and subject "Incubyte"

