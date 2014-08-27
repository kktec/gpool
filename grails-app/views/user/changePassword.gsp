<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
</head>
<body>
    <g:hasErrors>
        <div class="errors">
            <g:eachError><p><g:message error="${it}"/></p></g:eachError>
        </div>
    </g:hasErrors>

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
