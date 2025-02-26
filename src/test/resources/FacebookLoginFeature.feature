Feature: Login to Facebook.com

  @Simple
  Scenario Outline: : Login on Facebook.com with Valid Username and Password
    Given  User is on gmail log in
    Then  User enter "<username>"
    Then User enter a password "<password>"
    When User clicked on the Login button
    Then User should properly landed on the Home page
    Examples:
      | username                 | password      |
      | Arman.ahmad761@gmail.com | Iqraarman@123 |
      | Arman.ahmad761@gmail.com | Iqraarman@123 |

