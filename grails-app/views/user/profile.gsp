<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
</head>
<body>
  <div>
      <label for="email">Email:</label>
      <input type="text" disabled="disabled" id="email" value="${email}"/>
  </div>
  <br/>
  <div class="nav">
      <ul>
          <li><g:link action="changePassword">Change Password</g:link></li>
          <li><g:link action="changeProfile">Change Profile</g:link></li>
      </ul>
   </div>
</body>
</html>
