<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
</head>
<body>
    <g:render template="/common/errors"/>
    <g:form action="createUser">
          <fieldset class="form">
              <div class="fieldcontain required">
                  <label for="username">Username:</label>
                  <g:textField name="username" required="required" value="${user.username}"/>
              </div>
              <div class="fieldcontain required">
                  <label for="email">Email:</label>
                  <g:textField name="email" required="required" value="${user.email}"/>
              </div>
          </fieldset>
          <fieldset class="buttons">
              <g:submitButton name="createUser" value="Create User"/>
          </fieldset>
    </g:form>
</body>
</html>
