<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
</head>
<body>
    <g:render template="/common/errors"/>
    <g:form action="updateProfile">
          <fieldset class="form">
              <div class="fieldcontain required">
                  <label for="email">Email:</label>
                  <g:textField name="email" required="required" value="${user.email}"/>
              </div>
          </fieldset>
          <fieldset class="buttons">
              <g:submitButton name="updateProfile" value="Update Profile"/>
          </fieldset>
    </g:form>
</body>
</html>
