<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
    <title>Sign In</title>
</head>
<body>
      <g:if test="${params.signInError}">
          <ul>
              <li id="signInError" class="errors">Sorry, we cannot find a user with that Username and Password</li>
          </ul>
      </g:if>
      <g:form uri="/security_check" method="POST">
          <fieldset class="form">
              <div class="fieldcontain required">
                  <label for="username">Username:</label>
                  <g:textField name="username" required="required"/>
              </div>
              <div class="fieldcontain required">
                  <label for="password">Password:</label>
                  <g:passwordField name="password" required="required"/>
              </div>
          </fieldset>
          <fieldset class="buttons">
              <g:submitButton name="signIn" value="Sign In"/>
          </fieldset>
      </g:form>
</body>
</html>
