Feature: Order Page Testing

Background:
Given  I landed on login page



Scenario Outline:
Given login with the <username> and <password>
When  I click on <product> to add to cart 
Then  Click on the cart button and proceed to checkout page for payment
And   product order should be displayed on the order page

Examples:
        |username|password|product|
        |ram03@gmail.com|Abc@1234|ZARA COAT 3|