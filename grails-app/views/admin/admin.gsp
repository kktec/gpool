<!doctype html>
<html>
<head>
    <meta name="layout" content="gpool"/>
    <asset:stylesheet href="dataTables/css/jquery.dataTables.css"/>
    <asset:stylesheet href="dataTables/css/jquery.dataTables_themeroller.css"/>
    <asset:javascript src="jquery.dataTables.js"/>
</head>
<body>
    <div>
        <br/>
        <h4>Users:</h4>
        <table id="users">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Enabled</th>
                    <th>Roles</th>
                </tr>
            </thead>
            <tbody>
            <g:each var='u' in="${users}">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.username}</td>
                    <td>${u.email}</td>
                    <td>${u.enabled}</td>
                    <td>${u.authorities.join(',')}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
  <br/>
  <div class="nav">
      <ul>
          <li><g:link action="addUser">Add User</g:link></li>
      </ul>
   </div>
    
<g:javascript>
    $(document).ready(function() {
        $('#users').dataTable({
            'jQueryUI': true
        });
    });
</g:javascript>

</body>
</html>
