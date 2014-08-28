<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
</head>
<body>
    <g:render template="/common/errors"/>
    <g:form action="updatePassword">
          <fieldset class="form">
              <div class="fieldcontain required">
                  <label for="newPassword">New Password:</label>
                  <g:passwordField name="newPassword" required="required" value="${command.newPassword}"/>
              </div>
              <div class="fieldcontain required">
                  <label for="repeatPassword">Repeat New Password:</label>
                  <g:passwordField name="repeatPassword" required="required" value="${command.repeatPassword}"/>
              </div>
          </fieldset>
          <fieldset class="buttons">
              <g:submitButton name="updatePassword" value="Update Password"/>
          </fieldset>
    </g:form>
</body>
</html>
